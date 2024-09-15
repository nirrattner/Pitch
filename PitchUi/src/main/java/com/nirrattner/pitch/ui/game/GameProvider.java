package com.nirrattner.pitch.ui.game;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.Game;

@Singleton
public class GameProvider implements Provider<Game> {

  private Game game;

  @Inject
  public GameProvider() {
  }

  @Override
  public Game get() {
    return game;
  }

  public void set(Game game) {
    this.game = game;
  }
}
