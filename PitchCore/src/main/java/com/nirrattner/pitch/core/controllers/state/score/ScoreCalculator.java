package com.nirrattner.pitch.core.controllers.state.score;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Streams;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.Player;
import com.nirrattner.pitch.core.models.ScoreType;
import com.nirrattner.pitch.core.models.Suit;
import com.nirrattner.pitch.core.util.PlayerUpdater;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class ScoreCalculator {

  private final Map<ScoreType, WinnerCalculator> winnerCalculators;
  private final PlayerUpdater playerUpdater;

  @Inject
  public ScoreCalculator(
      Map<ScoreType, WinnerCalculator> winnerCalculators,
      PlayerUpdater playerUpdater) {
    this.winnerCalculators = winnerCalculators;
    this.playerUpdater = playerUpdater;
  }

  public Game calculate(
      Game game,
      Suit trumpSuit) {
    Map<ScoreType, Optional<Integer>> scores = winnerCalculators.entrySet().stream()
        .collect(
            ImmutableMap.toImmutableMap(
                Map.Entry::getKey,
                entry -> entry.getValue().calculate(game.getPlayers(), trumpSuit)));
    List<Integer> scoreWinners = scores.entrySet().stream()
        .sorted(Comparator.comparing(Map.Entry::getKey))
        .map(Map.Entry::getValue)
        .flatMap(Streams::stream)
        .collect(ImmutableList.toImmutableList());

    List<Player> players = game.getPlayers();
    ImmutableList.Builder<Integer> gameWinnersBuilder = ImmutableList.builder();
    for (int scoreWinner : scoreWinners) {
      players = updatePlayerScore(players, scoreWinner);
      if (players.get(scoreWinner).getScore() >= Game.WINNING_SCORE) {
        gameWinnersBuilder.add(scoreWinner);
      }
    }
    List<Integer> gameWinners = gameWinnersBuilder.build();

    int bidWinnerScoreWinnings = (int) scoreWinners.stream()
        .filter(winner -> winner == game.getBidWinner())
        .count();
    if (bidWinnerScoreWinnings < game.getBid()) {
      Player bidWinnerPlayer = game.getPlayers().get(game.getBidWinner());
      players = playerUpdater.update(
          players,
          bidWinnerPlayer.withScore(bidWinnerPlayer.getScore() - game.getBid()));
      gameWinners = gameWinners.stream()
          .filter(winner -> winner != game.getBidWinner())
          .collect(ImmutableList.toImmutableList());
    }

    return game
        .withPlayers(players)
        .withPlayerWinner(gameWinners.stream().findFirst());
  }

  private List<Player> updatePlayerScore(
      List<Player> players,
      int winner) {
    return players.stream()
        .map(player -> player.getId() == winner
            ? player.withScore(player.getScore() + 1)
            : player)
        .collect(ImmutableList.toImmutableList());
  }
}
