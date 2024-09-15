package com.nirrattner.pitch.ui.components.hands;

import com.google.common.collect.ImmutableList;
import com.google.inject.Provider;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.Player;
import com.nirrattner.pitch.ui.components.Component;
import com.nirrattner.pitch.ui.components.cards.CardBackComponent;

import java.util.List;
import java.util.stream.IntStream;

public class OpponentHandComponent extends HandComponent {

  private int size;

  private final Provider<Game> gameProvider;
  private final int playerIndex;

  @AssistedInject
  public OpponentHandComponent(
      Provider<Game> gameProvider,
      @Assisted int playerIndex) {
    this.gameProvider = gameProvider;
    this.playerIndex = playerIndex;

    this.children = IntStream.range(0, Player.MAX_HAND_SIZE)
        .mapToObj(i -> new CardBackComponent())
        .collect(ImmutableList.toImmutableList());
    this.size = Player.MAX_HAND_SIZE;
  }

  @Override
  public List<Component> getChildren() {
    size = gameProvider.get()
        .getPlayers()
        .get(playerIndex)
        .getHand()
        .size();
    return children.stream()
        .limit(size)
        .collect(ImmutableList.toImmutableList());
  }

  protected int getSize() {
    return size;
  }
}
