package com.nirrattner.pitch.core.util;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.Player;

import java.util.List;

@Singleton
public class PlayerUpdater {

  @Inject
  public PlayerUpdater() {
  }

  public List<Player> update(
      List<Player> players,
      Player updatedPlayer) {
    return players.stream()
        .map(player -> player.getId() == updatedPlayer.getId()
            ? updatedPlayer
            : player)
        .collect(ImmutableList.toImmutableList());
  }

  public List<Player> update(
      List<Player> players,
      List<Player> updatedPlayers) {
    for (Player updatedPlayer : updatedPlayers) {
      players = update(players, updatedPlayer);
    }
    return players;
  }
}
