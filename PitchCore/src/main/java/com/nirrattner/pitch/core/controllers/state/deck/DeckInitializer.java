package com.nirrattner.pitch.core.controllers.state.deck;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.Card;
import com.nirrattner.pitch.core.models.Suit;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class DeckInitializer {

  @Inject
  public DeckInitializer() {
  }

  public List<Card> initialize() {
    List<Card> deck = new ArrayList<>();
    for (Suit suit : Suit.values()) {
      for (int value = Card.ACE_RAW_VALUE; value < Card.MAX_VALUE + 1; value++) {
        deck.add(
            Card.builder()
                .setSuit(suit)
                .setValue(value)
                .build());
      }
    }
    return deck;
  }
}
