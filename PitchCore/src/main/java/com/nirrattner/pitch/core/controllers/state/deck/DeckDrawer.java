package com.nirrattner.pitch.core.controllers.state.deck;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.Card;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Singleton
public class DeckDrawer {

  @Inject
  public DeckDrawer() {
  }

  public Card draw(List<Card> cards) {
    int index = ThreadLocalRandom.current().nextInt(cards.size());
    return cards.remove(index);
  }
}
