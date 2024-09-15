package com.nirrattner.pitch.ui.components.trick;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.Card;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.ui.components.AbstractComponent;
import com.nirrattner.pitch.ui.components.cards.CardFaceComponent;
import com.nirrattner.pitch.ui.components.cards.CardOutliner;
import com.nirrattner.pitch.ui.components.transform.GraphicsTransform;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.nirrattner.pitch.core.models.GameIF.NUMBER_OF_PLAYERS;
import static com.nirrattner.pitch.ui.GraphicsConstants.CARD_SCALE;
import static com.nirrattner.pitch.ui.components.cards.CardComponent.BASE_CARD_HEIGHT;
import static com.nirrattner.pitch.ui.components.cards.CardComponent.BASE_CARD_WIDTH;

@Singleton
public class TrickComponent extends AbstractComponent {

  private static final int OFFSET = 10;
  private static final Color OUTLINE_COLOR_START = new Color(255, 147, 0, 255);
  private static final Color OUTLINE_COLOR_END = new Color(255, 147, 0, 10);

  private final Provider<Game> gameProvider;

  private int trickLeader;
  private List<Card> trick;
  private List<CardFaceComponent> cardFaceComponents;
  private final CardOutliner cardOutliner;

  @Inject
  public TrickComponent(
      Provider<Game> gameProvider,
      CardOutliner cardOutliner) {
    this.gameProvider = gameProvider;
    this.cardOutliner = cardOutliner;
    this.trickLeader = 0;
    this.cardFaceComponents = Collections.emptyList();
    this.trick = Collections.emptyList();
  }

  @Override
  protected void renderComponent(Graphics2D graphics) {
    setCards();

    AffineTransform centerTransform = AffineTransform.getTranslateInstance(
        getWidth() / 2,
        getHeight() / 2);

    int player = trickLeader;
    for (CardFaceComponent cardComponent : cardFaceComponents) {
      AffineTransform cardTransform = AffineTransform
          .getRotateInstance(player * Math.PI / 2);
      cardTransform.preConcatenate(centerTransform);
      cardTransform.translate(0, OFFSET);
      cardTransform.scale(CARD_SCALE, CARD_SCALE);
      cardTransform.translate(-BASE_CARD_WIDTH / 2, 0);
      try (GraphicsTransform transform = new GraphicsTransform(graphics, cardTransform)) {
        Optional<Integer> trickWinner = gameProvider.get().getTrickWinner();
        if (trickWinner.isPresent()
            && trickWinner.get().equals(player)) {
          cardOutliner.render(
              graphics,
              OUTLINE_COLOR_START,
              OUTLINE_COLOR_END);
        }
        cardComponent.render(graphics);
      }
      player = (player + 1) % NUMBER_OF_PLAYERS;
    }
  }

  @Override
  public int getHeight() {
    return (int) (CARD_SCALE * BASE_CARD_HEIGHT + 2 * OFFSET);
  }

  @Override
  public int getWidth() {
    return (int) (CARD_SCALE * BASE_CARD_HEIGHT + 2 * OFFSET);
  }

  private void setCards() {
    List<Card> newTrick = gameProvider.get().getTrickCards();
    if (!newTrick.equals(trick)) {
      this.trickLeader = gameProvider.get().getTrickLeader();
      this.trick = newTrick;

      this.cardFaceComponents = gameProvider.get().getTrickCards().stream()
          .map(CardFaceComponent::new)
          .collect(ImmutableList.toImmutableList());
      this.children = cardFaceComponents;
    }
  }
}
