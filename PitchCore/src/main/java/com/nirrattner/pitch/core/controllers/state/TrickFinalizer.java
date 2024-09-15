package com.nirrattner.pitch.core.controllers.state;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.Card;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.InputType;
import com.nirrattner.pitch.core.models.Player;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Singleton
public class TrickFinalizer {

  @Inject
  public TrickFinalizer() {
  }

  public Game finalize(
      Game game,
      int trickWinner) {
    List<Card> trickCards = game.getTrickCards();
    List<Player> players = game.getPlayers().stream()
        .map(player -> player.getId() == trickWinner
            ? Player.builder()
            .from(player)
            .addAllWinnings(trickCards)
            .build()
            : player)
        .collect(ImmutableList.toImmutableList());
    game = game
        .withPlayers(players);
    InputType nextInputType = players.get(0).getHand().isEmpty()
        ? InputType.ACK
        : InputType.TRICK;
    return game
        .withInputType(nextInputType)
        .withPlayerTurn(trickWinner)
        .withTrickCards(Collections.emptyList())
        .withTrickLeader(trickWinner)
        .withTrickWinner(Optional.empty());
  }
}
