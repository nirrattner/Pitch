package com.nirrattner.pitch.core.controllers;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.controllers.state.RoundInitializer;
import com.nirrattner.pitch.core.events.AggregateEventLogger;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.InputType;
import com.nirrattner.pitch.core.models.Player;
import com.nirrattner.pitch.core.models.events.EventType;

import java.util.List;
import java.util.stream.IntStream;

@Singleton
public class GameInitializer {

  public static final int INITIAL_PLAYER = -1;
  private static final int INITIAL_BID = 0;
  private static final int INITIAL_ROUND = 0;
  private static final int INITIAL_SCORE = 0;

  private final AggregateEventLogger eventLogger;
  private final RoundInitializer roundInitializer;

  @Inject
  public GameInitializer(
      AggregateEventLogger eventLogger,
      RoundInitializer roundInitializer) {
    this.eventLogger = eventLogger;
    this.roundInitializer = roundInitializer;
  }

  public Game initialize() {
    List<Player> players = IntStream.range(0, Game.NUMBER_OF_PLAYERS)
        .boxed()
        .map(this::initializePlayer)
        .collect(ImmutableList.toImmutableList());
    Game game = Game.builder()
        .setBid(INITIAL_BID)
        .setBidWinner(INITIAL_PLAYER)
        .setInputType(InputType.BID)
        .setPlayers(players)
        .setPlayerDealer(INITIAL_PLAYER)
        .setPlayerTurn(INITIAL_PLAYER)
        .setTrickLeader(INITIAL_PLAYER)
        .setRound(INITIAL_ROUND)
        .build();
    eventLogger.log(EventType.GAME_STARTED);
    return roundInitializer.initialize(game);
  }

  private Player initializePlayer(int id) {
    return Player.builder()
        .setId(id)
        .setScore(INITIAL_SCORE)
        .build();
  }
}
