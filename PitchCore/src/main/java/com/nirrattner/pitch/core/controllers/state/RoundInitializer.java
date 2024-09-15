package com.nirrattner.pitch.core.controllers.state;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.controllers.GameInitializer;
import com.nirrattner.pitch.core.controllers.state.deck.DeckDrawer;
import com.nirrattner.pitch.core.controllers.state.deck.DeckInitializer;
import com.nirrattner.pitch.core.events.AggregateEventLogger;
import com.nirrattner.pitch.core.events.PlayerScoreCalculator;
import com.nirrattner.pitch.core.models.*;
import com.nirrattner.pitch.core.models.events.EventType;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static com.nirrattner.pitch.core.models.GameIF.NUMBER_OF_PLAYERS;

@Singleton
public class RoundInitializer {

  private final AggregateEventLogger eventLogger;
  private final DeckDrawer deckDrawer;
  private final DeckInitializer deckInitializer;
  private final PlayerScoreCalculator playerScoreCalculator;

  @Inject
  public RoundInitializer(
      AggregateEventLogger eventLogger,
      DeckDrawer deckDrawer,
      DeckInitializer deckInitializer,
      PlayerScoreCalculator playerScoreCalculator) {
    this.eventLogger = eventLogger;
    this.deckInitializer = deckInitializer;
    this.deckDrawer = deckDrawer;
    this.playerScoreCalculator = playerScoreCalculator;
  }

  public Game initialize(Game game) {
    List<Card> deck = deckInitializer.initialize();
    List<Player> players = game.getPlayers().stream()
        .map(player -> drawHand(player, deck))
        .collect(ImmutableList.toImmutableList());
    int playerDealer = (game.getPlayerDealer() + 1) % NUMBER_OF_PLAYERS;

    String scores = playerScoreCalculator.calculate(game.getPlayers());
    eventLogger.log(
        EventType.ROUND_STARTED,
        game.getRound() + 1,
        playerDealer + 1,
        scores);

    return game
        .withBidWinner(GameInitializer.INITIAL_PLAYER)
        .withBid(BidType.PASS.getValue())
        .withInputType(InputType.BID)
        .withPlayers(players)
        .withPlayerDealer(playerDealer)
        .withPlayerTurn((playerDealer + 1) % NUMBER_OF_PLAYERS)
        .withTrumpSuit(Optional.empty())
        .withTrickCards(Collections.emptyList())
        .withTrickWinner(Optional.empty());
  }

  private Player drawHand(
      Player player,
      List<Card> deck) {
    List<Card> hand = IntStream.range(0, Player.MAX_HAND_SIZE)
        .boxed()
        .map(i -> deckDrawer.draw(deck))
        .sorted()
        .collect(ImmutableList.toImmutableList());
    return player
        .withHand(hand)
        .withBid(Optional.empty())
        .withWinnings(Collections.emptyList());
  }
}
