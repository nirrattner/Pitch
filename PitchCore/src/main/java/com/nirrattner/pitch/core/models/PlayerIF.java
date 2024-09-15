package com.nirrattner.pitch.core.models;

import com.nirrattner.pitch.core.models.style.ImmutableStyle;
import org.immutables.value.Value;

import java.util.List;
import java.util.Optional;

@ImmutableStyle
@Value.Immutable
public interface PlayerIF {
  int MAX_HAND_SIZE = 6;

  int getId();
  List<Card> getHand();
  List<Card> getWinnings();
  int getScore();
  Optional<BidType> getBid();

  @Value.Derived
  default int getGamePoints() {
    return GamePointsCalculator.calculate(getWinnings());
  }
}
