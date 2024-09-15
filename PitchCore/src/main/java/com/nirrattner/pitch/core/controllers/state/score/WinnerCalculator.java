package com.nirrattner.pitch.core.controllers.state.score;

import com.nirrattner.pitch.core.models.Player;
import com.nirrattner.pitch.core.models.Suit;

import java.util.List;
import java.util.Optional;

public interface WinnerCalculator {
  Optional<Integer> calculate(List<Player> players, Suit trumpSuit);
}
