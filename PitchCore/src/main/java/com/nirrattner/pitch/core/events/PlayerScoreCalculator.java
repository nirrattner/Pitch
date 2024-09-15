package com.nirrattner.pitch.core.events;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.Player;

import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class PlayerScoreCalculator {

  @Inject
  public PlayerScoreCalculator() {
  }

  public String calculate(List<Player> players) {
    return players.stream()
        .map(player ->
            String.format("Player %d: %d points",
                player.getId() + 1,
                player.getScore()))
        .collect(Collectors.joining("\n"));
  }
}
