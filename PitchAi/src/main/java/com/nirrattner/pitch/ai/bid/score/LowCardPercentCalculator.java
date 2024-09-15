package com.nirrattner.pitch.ai.bid.score;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.Card;

import java.util.List;

@Singleton
public class LowCardPercentCalculator {

  @Inject
  public LowCardPercentCalculator() {
  }

  public double calculate(List<Card> cards) {
    return 0.0;
  }
}
