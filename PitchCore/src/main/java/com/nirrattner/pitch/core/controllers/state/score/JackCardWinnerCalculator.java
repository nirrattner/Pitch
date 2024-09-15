package com.nirrattner.pitch.core.controllers.state.score;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.events.AggregateEventLogger;
import com.nirrattner.pitch.core.models.Card;
import com.nirrattner.pitch.core.models.Player;
import com.nirrattner.pitch.core.models.Suit;
import com.nirrattner.pitch.core.models.events.EventType;

import java.util.List;
import java.util.Optional;

@Singleton
public class JackCardWinnerCalculator implements WinnerCalculator {

  private final AggregateEventLogger aggregateEventLogger;
  private final CardWinnerCalculator cardWinnerCalculator;

  @Inject
  public JackCardWinnerCalculator(
      AggregateEventLogger aggregateEventLogger,
      CardWinnerCalculator cardWinnerCalculator) {
    this.aggregateEventLogger = aggregateEventLogger;
    this.cardWinnerCalculator = cardWinnerCalculator;
  }

  @Override
  public Optional<Integer> calculate(
      List<Player> players,
      Suit trumpSuit) {
    Optional<Integer> winnerMaybe = cardWinnerCalculator.calculate(
        players,
        Card.builder()
            .setSuit(trumpSuit)
            .setValue(Card.JACK_VALUE)
            .build());

    if (winnerMaybe.isPresent()) {
      aggregateEventLogger.log(
          EventType.PLAYER_WIN_JACK,
          winnerMaybe.get() + 1);
    } else {
      aggregateEventLogger.log(EventType.PLAYER_WIN_NO_JACK);
    }

    return winnerMaybe;
  }
}
