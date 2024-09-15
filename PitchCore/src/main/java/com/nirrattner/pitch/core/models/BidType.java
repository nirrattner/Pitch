package com.nirrattner.pitch.core.models;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

public enum BidType {
  PASS(0),
  TWO(2),
  THREE(3),
  FOUR(4),
  ;

  private static final Map<Integer, BidType> BY_VALUE = Arrays.stream(BidType.values())
      .collect(ImmutableMap.toImmutableMap(
          BidType::getValue,
          Function.identity()));

  int value;

  BidType(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static BidType fromValue(int value) {
    return BY_VALUE.get(value);
  }
}
