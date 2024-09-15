package com.nirrattner.pitch.core.controllers.state.score;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.Card;
import com.nirrattner.pitch.core.models.Player;

import java.util.List;
import java.util.Optional;

@Singleton
public class CardWinnerCalculator {

  @Inject
  public CardWinnerCalculator() {
  }

  public Optional<Integer> calculate(
      List<Player> players,
      Card card) {
    return players.stream()
        .filter(player -> player.getWinnings().contains(card))
        .map(Player::getId)
        .findFirst();
  }
}
