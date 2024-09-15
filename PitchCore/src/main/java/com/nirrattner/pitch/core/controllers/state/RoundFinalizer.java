package com.nirrattner.pitch.core.controllers.state;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.controllers.state.score.ScoreCalculator;
import com.nirrattner.pitch.core.events.AggregateEventLogger;
import com.nirrattner.pitch.core.events.PlayerScoreCalculator;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.Suit;
import com.nirrattner.pitch.core.models.events.EventType;

@Singleton
public class RoundFinalizer {

  private final AggregateEventLogger aggregateEventLogger;
  private final PlayerScoreCalculator playerScoreCalculator;
  private final RoundInitializer roundInitializer;
  private final ScoreCalculator scoreCalculator;

  @Inject
  public RoundFinalizer(
      AggregateEventLogger aggregateEventLogger,
      PlayerScoreCalculator playerScoreCalculator,
      RoundInitializer roundInitializer,
      ScoreCalculator scoreCalculator) {
    this.aggregateEventLogger = aggregateEventLogger;
    this.playerScoreCalculator = playerScoreCalculator;
    this.roundInitializer = roundInitializer;
    this.scoreCalculator = scoreCalculator;
  }

  public Game finalize(
      Game game,
      Suit trumpSuit) {
    game = scoreCalculator.calculate(game, trumpSuit)
        .withRound(game.getRound() + 1);

    String playerScores = playerScoreCalculator.calculate(game.getPlayers());
    game.getPlayerWinner()
        .ifPresent(player -> aggregateEventLogger.log(
            EventType.PLAYER_WON,
            player + 1,
            playerScores));

    return game.getPlayerWinner().isPresent()
        ? game
        : roundInitializer.initialize(game);
  }
}
