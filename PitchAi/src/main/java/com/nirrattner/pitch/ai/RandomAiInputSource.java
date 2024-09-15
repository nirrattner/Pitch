package com.nirrattner.pitch.ai;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.inputs.InputSource;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.PlayerInput;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Singleton
public class RandomAiInputSource implements InputSource {

  @Inject
  public RandomAiInputSource() {
  }

  @Override
  public PlayerInput getInput(
      Game game,
      List<PlayerInput> playerInputs) {
    return playerInputs.get(
        ThreadLocalRandom.current().nextInt(playerInputs.size()));
  }
}
