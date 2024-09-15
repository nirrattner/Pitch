package com.nirrattner.pitch.core.controllers.state.score;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.events.AggregateEventLogger;
import com.nirrattner.pitch.core.models.Card;
import com.nirrattner.pitch.core.models.Player;
import com.nirrattner.pitch.core.models.Suit;
import com.nirrattner.pitch.core.models.events.EventType;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Singleton
public class HighCardWinnerCalculator implements WinnerCalculator {

  private final AggregateEventLogger aggregateEventLogger;
  private final CardWinnerCalculator cardWinnerCalculator;

  @Inject
  public HighCardWinnerCalculator(
      AggregateEventLogger aggregateEventLogger,
      CardWinnerCalculator cardWinnerCalculator) {
    this.aggregateEventLogger = aggregateEventLogger;
    this.cardWinnerCalculator = cardWinnerCalculator;
  }

  @Override
  public Optional<Integer> calculate(
      List<Player> players,
      Suit trumpSuit) {
    Card highCard = players.stream()
        .map(Player::getWinnings)
        .flatMap(List::stream)
        .filter(card -> card.getSuit() == trumpSuit)
        .max(Comparator.naturalOrder())
        .orElseThrow(() -> new NoSuchElementException("Unable to find high card"));
    int winner = cardWinnerCalculator.calculate(
        players,
        highCard)
        .orElseThrow(() -> new NoSuchElementException(
            String.format("Unable to find card %s", highCard)));

    aggregateEventLogger.log(
        EventType.PLAYER_WIN_HIGH,
        winner + 1,
        highCard.getDisplayString());

    return Optional.of(winner);
  }
}
