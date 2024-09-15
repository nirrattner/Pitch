package com.nirrattner.pitch.core.models;

import com.google.common.base.Preconditions;

import static com.nirrattner.pitch.core.models.GameIF.NUMBER_OF_PLAYERS;

public class PlayerValueChecker {
  public static void check(int value, String name) {
    Preconditions.checkState(
        value >= 0 && value < NUMBER_OF_PLAYERS,
        "%s value %s out of bounds",
        name,
        value);
  }
}
