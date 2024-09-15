package com.nirrattner.pitch.core.validators;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.BidType;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.InputType;
import com.nirrattner.pitch.core.models.PlayerInput;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class BidInputValidator {

  @Inject
  public BidInputValidator() {
  }

  public List<PlayerInput> getValidInputs(Game game) {
    List<BidType> bidTypes = EnumSet.allOf(BidType.class).stream()
        .filter(bidType -> bidType.getValue() > game.getBid() ||
            bidType == BidType.PASS)
        .collect(ImmutableList.toImmutableList());
    if (game.getBid() == BidType.PASS.getValue() &&
        game.getPlayerTurn() == game.getPlayerDealer()) {
      bidTypes = bidTypes.stream()
          .filter(input -> input.getValue() > BidType.PASS.getValue())
          .collect(ImmutableList.toImmutableList());
    }
    return bidTypes.stream()
        .map(this::toInput)
        .collect(ImmutableList.toImmutableList());
  }

  private PlayerInput toInput(BidType bidType) {
    return PlayerInput.builder()
        .setInputType(InputType.BID)
        .setValue(bidType.getValue())
        .build();
  }
}
