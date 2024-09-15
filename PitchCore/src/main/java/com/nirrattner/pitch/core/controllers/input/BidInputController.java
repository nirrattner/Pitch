package com.nirrattner.pitch.core.controllers.input;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.events.AggregateEventLogger;
import com.nirrattner.pitch.core.models.*;
import com.nirrattner.pitch.core.models.events.EventType;
import com.nirrattner.pitch.core.util.PlayerUpdater;

import java.util.Optional;

@Singleton
public class BidInputController {

  private final AggregateEventLogger eventLogger;
  private final PlayerUpdater playerUpdater;

  @Inject
  public BidInputController(
      AggregateEventLogger eventLogger,
      PlayerUpdater playerUpdater) {
    this.eventLogger = eventLogger;
    this.playerUpdater = playerUpdater;
  }

  public Game step(
      Game game,
      PlayerInput playerInput) {
    int playerTurn = game.getPlayerTurn();
    Player currentPlayer = game.getPlayers().get(game.getPlayerTurn());
    currentPlayer = currentPlayer
        .withBid(BidType.fromValue(playerInput.getValue()));
    game = game.withPlayers(
        playerUpdater.update(
            game.getPlayers(),
            currentPlayer));

    if (playerInput.getValue() == BidType.PASS.getValue()) {
      eventLogger.log(
          EventType.PLAYER_BID_PASS,
          game.getPlayerTurn() + 1);
    } else {
      game = game
          .withBid(playerInput.getValue())
          .withBidWinner(playerTurn)
          .withTrickLeader(playerTurn);
      eventLogger.log(
          EventType.PLAYER_BID,
          game.getPlayerTurn() + 1,
          game.getBid());
    }

    if (playerTurn == game.getPlayerDealer() ||
        playerInput.getValue() == BidType.FOUR.getValue()) {
      eventLogger.log(
          EventType.PLAYER_BID_WIN,
          game.getBidWinner() + 1);
      int bidWinner = game.getBidWinner();

      game = game.withPlayers(
          playerUpdater.update(
              game.getPlayers(),
              game.getPlayers().stream()
                  .filter(player -> player.getId() != bidWinner)
                  .map(player -> player.withBid(Optional.empty()))
                  .collect(ImmutableList.toImmutableList())));
      return game
          .withInputType(InputType.TRICK)
          .withPlayerTurn(game.getBidWinner())
          .withTrickLeader(game.getBidWinner());
    }
    return game
        .withPlayerTurn((playerTurn + 1) % Game.NUMBER_OF_PLAYERS);
  }
}
