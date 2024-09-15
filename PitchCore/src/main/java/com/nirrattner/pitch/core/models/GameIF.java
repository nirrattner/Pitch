package com.nirrattner.pitch.core.models;

import com.google.common.base.Preconditions;
import com.nirrattner.pitch.core.models.style.ImmutableStyle;
import org.immutables.value.Value;

import java.util.List;
import java.util.Optional;

@ImmutableStyle
@Value.Immutable
public interface GameIF {

  int NUMBER_OF_PLAYERS = 4;
  int WINNING_SCORE = 11;

  int getBid();
  int getBidWinner();
  InputType getInputType();
  List<Player> getPlayers();
  int getPlayerDealer();
  int getPlayerTurn();
  Optional<Integer> getPlayerWinner();
  int getRound();
  List<Card> getTrickCards();
  int getTrickLeader();
  Optional<Suit> getTrumpSuit();
  Optional<Integer> getTrickWinner();

  @Value.Derived
  default Optional<Suit> getTrickSuit() {
    return getTrickCards().stream()
        .findFirst()
        .map(Card::getSuit);
  }

  @Value.Check
  default void check() {
    if (getInputType() == InputType.TRICK) {
      PlayerValueChecker.check(getPlayerDealer(), "player dealer");
      PlayerValueChecker.check(getPlayerTurn(), "player turn");
      PlayerValueChecker.check(getTrickLeader(), "trick leader");
    }

    getTrickCards().size();
    Preconditions.checkState(
        getTrickCards().size() <= NUMBER_OF_PLAYERS,
        "trick card number out of bounds: %s",
        getTrickCards());
    Preconditions.checkState(
        getPlayers().size() == NUMBER_OF_PLAYERS,
        "Invalid number of players %d",
        getPlayers().size());
  }
}
