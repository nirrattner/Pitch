package com.nirrattner.pitch.console;

import com.google.inject.Inject;
import com.nirrattner.pitch.console.loggers.ConsoleStepLogger;
import com.nirrattner.pitch.core.controllers.GameInitializer;
import com.nirrattner.pitch.core.controllers.GameInputController;
import com.nirrattner.pitch.core.inputs.InputSourceConfiguration;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.PlayerInput;
import com.nirrattner.pitch.core.validators.InputValidator;

import java.util.List;

public class ConsolePitch {

  private final ConsoleStepLogger consoleStepLogger;
  private final GameInitializer gameInitializer;
  private final GameInputController gameInputController;
  private final InputSourceConfiguration inputSourceConfiguration;
  private final InputValidator inputValidator;

  @Inject
  public ConsolePitch(
      ConsoleStepLogger consoleStepLogger,
      GameInitializer gameInitializer,
      GameInputController gameInputController,
      InputSourceConfiguration inputSourceConfiguration,
      InputValidator inputValidator) {
    this.consoleStepLogger = consoleStepLogger;
    this.gameInitializer = gameInitializer;
    this.gameInputController = gameInputController;
    this.inputSourceConfiguration = inputSourceConfiguration;
    this.inputValidator = inputValidator;
  }

  public void run() {
    Game game = gameInitializer.initialize();
    while (!game.getPlayerWinner().isPresent() && game.getRound() < 100) {
      try {
        consoleStepLogger.log(game);
        List<PlayerInput> playerInputs = inputValidator.getValidInputs(game);
        int playerTurn = game.getPlayerTurn();
        PlayerInput playerInput = inputSourceConfiguration.getInputSources()
            .get(playerTurn)
            .getInput(game, playerInputs);
        game = gameInputController.step(game, playerInput);
      } catch (Exception e) {
        throw new RuntimeException(
            String.format("Game state: %s", game),
            e);
      }
    }
  }
}
