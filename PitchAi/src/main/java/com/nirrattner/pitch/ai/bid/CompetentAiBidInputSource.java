package com.nirrattner.pitch.ai.bid;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.PlayerInput;

import java.util.List;

@Singleton
public class CompetentAiBidInputSource {

  @Inject
  public CompetentAiBidInputSource() {
  }

  public PlayerInput getInput(
      Game game,
      List<PlayerInput> playerInputs) {
    return null;
  }
}
