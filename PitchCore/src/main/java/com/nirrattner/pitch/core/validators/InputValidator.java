package com.nirrattner.pitch.core.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.PlayerInput;

import java.util.List;

@Singleton
public class InputValidator {

  private final AckInputValidator ackInputValidator;
  private final BidInputValidator bidInputController;
  private final TrickInputValidator trickInputValidator;

  @Inject
  public InputValidator(
      AckInputValidator ackInputValidator,
      BidInputValidator bidInputController,
      TrickInputValidator trickInputValidator) {
    this.ackInputValidator = ackInputValidator;
    this.bidInputController = bidInputController;
    this.trickInputValidator = trickInputValidator;
  }

  public List<PlayerInput> getValidInputs(Game game) {
    switch (game.getInputType()) {
      case ACK:
        return ackInputValidator.getValidInputs(game);
      case BID:
        return bidInputController.getValidInputs(game);
      case TRICK:
        return trickInputValidator.getValidInputs(game);
      default:
        throw new AssertionError(
            String.format("Unknown getInput type %s", game.getInputType()));
    }
  }
}
