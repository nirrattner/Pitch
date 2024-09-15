package com.nirrattner.pitch.core.models;

import com.google.common.collect.ImmutableMap;

import java.util.List;
import java.util.Map;

public class GamePointsCalculator {

  private static final Map<Integer, Integer> GAME_POINTS = ImmutableMap.of(
      11, 1,
      12, 2,
      13, 3,
      1, 4,
      10, 10);

  public static int calculate(List<Card> cards) {
    return cards.stream()
        .map(Card::getValue)
        .filter(GAME_POINTS::containsKey)
        .map(GAME_POINTS::get)
        .reduce(0, Integer::sum);
  }
}
