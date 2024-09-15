package com.nirrattner.pitch.core.validators;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.Card;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.InputType;
import com.nirrattner.pitch.core.models.PlayerInput;
import com.nirrattner.pitch.core.models.Suit;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Singleton
public class TrickInputValidator {

  @Inject
  public TrickInputValidator() {
  }

  public List<PlayerInput> getValidInputs(Game game) {
    List<Card> hand = game.getPlayers()
        .get(game.getPlayerTurn())
        .getHand();
    IntStream validCardIndexes = game.getTrickSuit()
        .filter(trickSuit -> hand.stream()
            .map(Card::getSuit)
            .anyMatch(trickSuit::equals))
        .map(trickSuit -> getValidCardsForTrickSuit(hand, trickSuit, game))
        .orElseGet(() -> IntStream.range(0, hand.size()));
    return validCardIndexes
        .mapToObj(index ->
            PlayerInput.builder()
                .setInputType(InputType.TRICK)
                .setValue(index)
                .build())
        .collect(ImmutableList.toImmutableList());
  }

  private IntStream getValidCardsForTrickSuit(
      List<Card> hand,
      Suit trickSuit,
      Game game) {
    Suit trumpSuit = game.getTrumpSuit().orElseThrow(
        () -> new AssertionError("Trump suit must be present during trick"));
    return IntStream.range(0, hand.size())
        .filter(i -> hand.get(i).getSuit() == trickSuit || hand.get(i).getSuit() == trumpSuit);
  }
}
