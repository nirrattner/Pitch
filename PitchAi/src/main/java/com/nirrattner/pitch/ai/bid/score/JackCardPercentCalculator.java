package com.nirrattner.pitch.ai.bid.score;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.Card;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Singleton
public class JackCardPercentCalculator {

  private static final int LESS_THAN_JACK = -1;
  private static final int EQUALS_JACK = 0;
  private static final int GREATER_THAN_JACK = 1;

  @Inject
  public JackCardPercentCalculator() {
  }

  public double calculate(List<Card> cards) {
    Map<Integer, List<Integer>> jackNormalizedValues = cards.stream()
        .map(Card::getEffectiveValue)
        .collect(Collectors.groupingBy(
            value -> Comparator.<Integer>naturalOrder()
                .compare(value, Card.JACK_VALUE)));

    boolean hasJack = jackNormalizedValues.containsKey(EQUALS_JACK);
    int greaterThanJackCount = jackNormalizedValues.getOrDefault(
        GREATER_THAN_JACK,
        Collections.emptyList())
        .size();
    int lessThanJackCount = jackNormalizedValues.getOrDefault(
        LESS_THAN_JACK,
        Collections.emptyList())
        .size();

    return 0;
  }


}
