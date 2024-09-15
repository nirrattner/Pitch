package com.nirrattner.pitch.console.loggers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.Card;
import com.nirrattner.pitch.core.models.Game;

import java.util.stream.Collectors;

@Singleton
public class ConsoleStepLogger {

  private static final int HUMAN_PLAYER = 0;

  @Inject
  public ConsoleStepLogger() {
  }

  public void log(Game game) {
    if (game.getPlayerTurn() == HUMAN_PLAYER) {
      String handCards = game.getPlayers()
          .get(HUMAN_PLAYER)
          .getHand()
          .stream()
          .map(Card::getDisplayString)
          .collect(Collectors.joining(", "));
      if (!handCards.isEmpty()) {
        System.out.println("HAND: " + handCards);
      }
      if (!game.getTrickCards().isEmpty()) {
        String trickCards = game.getTrickCards().stream()
            .map(Card::getDisplayString)
            .collect(Collectors.joining(", "));
        System.out.println("TRICK: " + trickCards);
      }
    }
  }
}
