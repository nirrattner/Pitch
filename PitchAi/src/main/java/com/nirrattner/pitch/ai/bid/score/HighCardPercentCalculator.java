package com.nirrattner.pitch.ai.bid.score;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.Card;

import java.util.Comparator;
import java.util.List;

@Singleton
public class HighCardPercentCalculator {

  @Inject
  public HighCardPercentCalculator() {
  }

  public double calculate(List<Card> cards) {
    int highValue = cards.stream()
        .map(Card::getEffectiveValue)
        .max(Comparator.naturalOrder())
        .orElse(Card.ACE_RAW_VALUE);
    switch (highValue) {
      case Card.ACE_EFFECTIVE_VALUE:
        return 1.0;
      case Card.KING_VALUE:
        return 1.0 - ProbabilityConstants.ONE_CARD_DEALT;
      case Card.QUEEN_VALUE:
        return 1.0 - ProbabilityConstants.ANY_OF_TWO_CARDS_DEALT;
      case Card.JACK_VALUE:
        return 1.0 - ProbabilityConstants.ANY_OF_THREE_CARDS_DEALT;
      default:
        return 0.0;
    }
  }
}
