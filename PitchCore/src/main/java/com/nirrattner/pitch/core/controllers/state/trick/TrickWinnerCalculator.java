package com.nirrattner.pitch.core.controllers.state.trick;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.events.AggregateEventLogger;
import com.nirrattner.pitch.core.models.Card;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.Suit;
import com.nirrattner.pitch.core.models.events.EventType;

import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class TrickWinnerCalculator {

  private final AggregateEventLogger aggregateEventLogger;

  @Inject
  public TrickWinnerCalculator(AggregateEventLogger aggregateEventLogger) {
    this.aggregateEventLogger = aggregateEventLogger;
  }

  public int calculate(
      Game game,
      Suit trumpSuit) {
    List<Card> cards = game.getTrickCards();
    Preconditions.checkArgument(
        cards.size() > 0,
        "Unable to calculate for empty trick",
        cards.size());
    int winningCardIndex = 0;
    Card winningCard = cards.get(0);
    Suit trickSuit = winningCard.getSuit();
    for (int i = 1; i < cards.size(); i++) {
      Card currentCard = cards.get(i);
      if (isCurrentCardWinning(
          winningCard,
          currentCard,
          trickSuit,
          trumpSuit)) {
        winningCardIndex = i;
        winningCard = currentCard;
      }
    }

    int winner = (game.getTrickLeader() + winningCardIndex) % Game.NUMBER_OF_PLAYERS;
    String winnings = game.getTrickCards().stream()
        .map(Card::getDisplayString)
        .collect(Collectors.joining(", "));
    aggregateEventLogger.log(
        EventType.PLAYER_TRICK_WIN,
        winner + 1,
        winningCard.getDisplayString(),
        winnings);
    return winner;
  }

  private boolean isCurrentCardWinning(
      Card winningCard,
      Card currentCard,
      Suit trickSuit,
      Suit trumpSuit) {
    if (currentCard.getSuit() == trumpSuit) {
      return winningCard.getSuit() != trumpSuit
          || winningCard.getEffectiveValue() < currentCard.getEffectiveValue();
    }
    if (currentCard.getSuit() == trickSuit) {
      return winningCard.getSuit() != trumpSuit
          && winningCard.getEffectiveValue() < currentCard.getEffectiveValue();
    }
    return false;
  }
}
