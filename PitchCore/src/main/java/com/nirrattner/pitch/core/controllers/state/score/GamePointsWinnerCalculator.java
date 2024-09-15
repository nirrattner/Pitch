package com.nirrattner.pitch.core.controllers.state.score;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.events.AggregateEventLogger;
import com.nirrattner.pitch.core.models.Player;
import com.nirrattner.pitch.core.models.Suit;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.nirrattner.pitch.core.models.events.EventType.PLAYER_WIN_GAME;
import static com.nirrattner.pitch.core.models.events.EventType.PLAYER_WIN_TIE_GAME;

@Singleton
public class GamePointsWinnerCalculator implements WinnerCalculator {

  private final AggregateEventLogger aggregateEventLogger;

  @Inject
  public GamePointsWinnerCalculator(AggregateEventLogger aggregateEventLogger) {
    this.aggregateEventLogger = aggregateEventLogger;
  }

  @Override
  public Optional<Integer> calculate(
      List<Player> players,
      Suit trumpSuit) {
    int maxGamePoints = players.stream()
        .map(Player::getGamePoints)
        .max(Comparator.naturalOrder())
        .orElse(0);
    List<Player> gameScoreWinners = players.stream()
        .filter(player -> player.getGamePoints() == maxGamePoints)
        .collect(ImmutableList.toImmutableList());
    log(gameScoreWinners, maxGamePoints);
    return gameScoreWinners.stream()
        .findFirst()
        .filter(ignored -> gameScoreWinners.size() == 1)
        .map(Player::getId);
  }

  private void log(
      List<Player> gameScoreWinners,
      int maxGamePoints) {
    if (gameScoreWinners.size() == 1) {
      Player winner = gameScoreWinners.get(0);
      aggregateEventLogger.log(
          PLAYER_WIN_GAME,
          winner.getId() + 1,
          maxGamePoints);
    } else {
      String winners = gameScoreWinners.stream()
          .map(Player::getId)
          .map(id -> id + 1)
          .map(String::valueOf)
          .collect(Collectors.joining(", "));
      aggregateEventLogger.log(
          PLAYER_WIN_TIE_GAME,
          winners,
          maxGamePoints);
    }
  }
}
