package com.nirrattner.pitch.core.controllers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.controllers.input.AckInputController;
import com.nirrattner.pitch.core.controllers.input.BidInputController;
import com.nirrattner.pitch.core.controllers.input.TrickInputController;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.PlayerInput;


@Singleton
public class GameInputController {

  private final AckInputController ackInputController;
  private final BidInputController bidInputController;
  private final TrickInputController trickInputController;

  @Inject
  public GameInputController(
      AckInputController ackInputController,
      BidInputController bidInputController,
      TrickInputController trickInputController) {
    this.ackInputController = ackInputController;
    this.bidInputController = bidInputController;
    this.trickInputController = trickInputController;
  }

  public Game step(
      Game game,
      PlayerInput playerInput) {
    switch (game.getInputType()) {
      case ACK:
        return ackInputController.step(game, playerInput);
      case BID:
        return bidInputController.step(game, playerInput);
      case TRICK:
        return trickInputController.step(game, playerInput);
      default:
        throw new AssertionError(
            String.format(
                "Unknown input type: %s",
                playerInput.getInputType()));
    }
  }
}
