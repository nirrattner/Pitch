package com.nirrattner.pitch.ui;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.nirrattner.pitch.core.controllers.GameInitializer;
import com.nirrattner.pitch.ui.game.GameProvider;

public class PitchUiMain {

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new PitchUiModule());

    GameInitializer gameInitializer = injector.getInstance(GameInitializer.class);
    GameProvider gameProvider = injector.getInstance(GameProvider.class);

    gameProvider.set(gameInitializer.initialize());

    GraphicsInitializer graphicsInitializer = injector.getInstance(GraphicsInitializer.class);
    LoopExecutor loopExecutor = injector.getInstance(LoopExecutor.class);

    graphicsInitializer.initialize();
    loopExecutor.loop();
  }
}
