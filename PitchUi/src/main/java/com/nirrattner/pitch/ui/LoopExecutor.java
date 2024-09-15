package com.nirrattner.pitch.ui;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.ai.RandomAiInputSource;
import com.nirrattner.pitch.console.loggers.ConsoleStepLogger;
import com.nirrattner.pitch.core.controllers.GameInputController;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.PlayerInput;
import com.nirrattner.pitch.core.validators.InputValidator;
import com.nirrattner.pitch.ui.game.GameProvider;

@Singleton
public class LoopExecutor {

  private static final int FRAMES_PER_SECOND = 30;
  private static final int MILLIS_PER_FRAME = 1000 / FRAMES_PER_SECOND;

  private final InputValidator inputValidator;
  private final FrameRenderer frameRenderer;
  private final FpsCalculator fpsCalculator;
  private final GameInputController gameInputController;
  private final GameProvider gameProvider;
  private final RandomAiInputSource randomAiInputSource;
  private final ConsoleStepLogger consoleStepLogger;

  @Inject
  public LoopExecutor(
      InputValidator inputValidator,
      FrameRenderer frameRenderer,
      FpsCalculator fpsCalculator,
      GameInputController gameInputController,
      GameProvider gameProvider,
      RandomAiInputSource randomAiInputSource,
      ConsoleStepLogger consoleStepLogger) {
    this.inputValidator = inputValidator;
    this.frameRenderer = frameRenderer;
    this.fpsCalculator = fpsCalculator;
    this.gameInputController = gameInputController;
    this.gameProvider = gameProvider;
    this.randomAiInputSource = randomAiInputSource;
    this.consoleStepLogger = consoleStepLogger;
  }

  public void loop() {
    long last_frame_timestamp;
    while (true) {
      last_frame_timestamp = System.currentTimeMillis();
      fpsCalculator.setFrame();
      updateGame();
      frameRenderer.render();

      long sleepTimeMillis = last_frame_timestamp + MILLIS_PER_FRAME - System.currentTimeMillis();
      if (sleepTimeMillis > 0) {
        try {
          Thread.sleep(sleepTimeMillis);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

  private void updateGame() {
    Game game = gameProvider.get();
    while (game.getPlayerTurn() != 0) {
      consoleStepLogger.log(game);

      PlayerInput playerInput = randomAiInputSource.getInput(
          game,
          inputValidator.getValidInputs(game));
      game = gameInputController.step(game, playerInput);
      gameProvider.set(game);
    }
  }
}
