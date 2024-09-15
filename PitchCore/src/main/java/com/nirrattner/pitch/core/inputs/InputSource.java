package com.nirrattner.pitch.core.inputs;

import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.PlayerInput;

import java.util.List;

public interface InputSource {
  PlayerInput getInput(Game game, List<PlayerInput> playerInputList);
}
