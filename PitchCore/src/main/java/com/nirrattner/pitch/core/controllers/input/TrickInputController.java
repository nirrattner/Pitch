package com.nirrattner.pitch.core.controllers.input;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.controllers.state.trick.TrickWinnerCalculator;
import com.nirrattner.pitch.core.events.AggregateEventLogger;
import com.nirrattner.pitch.core.models.*;
import com.nirrattner.pitch.core.models.events.EventType;
import com.nirrattner.pitch.core.util.ListRemover;
import com.nirrattner.pitch.core.util.PlayerUpdater;

import java.util.List;

@Singleton
public class TrickInputController {

  private final AggregateEventLogger aggregateEventLogger;
  private final ListRemover listRemover;
  private final PlayerUpdater playerUpdater;
  private final TrickWinnerCalculator trickWinnerCalculator;

  @Inject
  public TrickInputController(
      AggregateEventLogger aggregateEventLogger,
      ListRemover listRemover,
      PlayerUpdater playerUpdater,
      TrickWinnerCalculator trickWinnerCalculator) {
    this.aggregateEventLogger = aggregateEventLogger;
    this.listRemover = listRemover;
    this.playerUpdater = playerUpdater;
    this.trickWinnerCalculator = trickWinnerCalculator;
  }

  public Game step(
      Game game,
      PlayerInput playerInput) {
    Player player = game.getPlayers()
        .get(game.getPlayerTurn());
    Card card = player
        .getHand()
        .get(playerInput.getValue());

    aggregateEventLogger.log(
        EventType.PLAYER_TRICK_PLAY,
        game.getPlayerTurn() + 1,
        card.getDisplayString());

    List<Player> players = playerUpdater.update(
        game.getPlayers(),
        removeCard(player, card));
    game = Game.builder()
        .from(game)
        .addTrickCards(card)
        .build();
    Suit trumpSuit = game.getTrumpSuit()
        .orElse(card.getSuit());

    int nextPlayerTurn = (game.getPlayerTurn() + 1) % Game.NUMBER_OF_PLAYERS;
    game = game
        .withPlayers(players)
        .withPlayerTurn(nextPlayerTurn)
        .withTrumpSuit(trumpSuit);
    if (nextPlayerTurn == game.getTrickLeader()) {
      game = game
          .withInputType(InputType.ACK)
          .withTrickWinner(trickWinnerCalculator.calculate(game, trumpSuit));
    }
    return game;
  }

  private Player removeCard(
      Player player,
      Card card) {
    List<Card> hand = listRemover.remove(player.getHand(), card);
    return player.withHand(hand);
  }
}
