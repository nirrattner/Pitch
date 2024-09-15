package com.nirrattner.pitch.core.controllers.input;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.controllers.state.RoundFinalizer;
import com.nirrattner.pitch.core.controllers.state.TrickFinalizer;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.GameIF;
import com.nirrattner.pitch.core.models.PlayerInput;
import com.nirrattner.pitch.core.models.Suit;

@Singleton
public class AckInputController {

  private final RoundFinalizer roundFinalizer;
  private final TrickFinalizer trickFinalizer;

  @Inject
  public AckInputController(
      RoundFinalizer roundFinalizer,
      TrickFinalizer trickFinalizer) {
    this.trickFinalizer = trickFinalizer;
    this.roundFinalizer = roundFinalizer;
  }

  public Game step(
      Game game,
      PlayerInput playerInput) {
    int nextPlayerTurn = (game.getPlayerTurn() + 1) % Game.NUMBER_OF_PLAYERS;
    game = game.withPlayerTurn(nextPlayerTurn);

    if (nextPlayerTurn == game.getTrickLeader()) {
      if (game.getTrickCards().size() == GameIF.NUMBER_OF_PLAYERS) {
        Preconditions.checkArgument(
            game.getTrickWinner().isPresent(),
            "Trick winner must be present to finalize trick");
        int trickWinner = game.getTrickWinner().get();

        game = trickFinalizer.finalize(
            game,
            trickWinner);
      } else if (game.getPlayers().get(0).getHand().isEmpty()) {
        Preconditions.checkArgument(
            game.getTrumpSuit().isPresent(),
            "Trump suit must be present to finalize round");
        Suit trumpSuit = game.getTrumpSuit().get();

        game = roundFinalizer.finalize(
            game,
            trumpSuit);
      }
    }

    return game;
  }
}
