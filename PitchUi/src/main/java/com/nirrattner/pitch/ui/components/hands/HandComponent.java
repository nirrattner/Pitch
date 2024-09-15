package com.nirrattner.pitch.ui.components.hands;

import com.nirrattner.pitch.ui.components.AbstractComponent;
import com.nirrattner.pitch.ui.components.Component;
import com.nirrattner.pitch.ui.components.cards.CardComponent;
import com.nirrattner.pitch.ui.components.transform.GraphicsTransform;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import static com.nirrattner.pitch.ui.GraphicsConstants.CARD_SCALE;

public abstract class HandComponent extends AbstractComponent {

  protected static final int ANGLE_POSITION_OFFSET_Y = 800;
  protected static final double CARD_ANGLE = Math.PI / 12;

  protected abstract int getSize();

  @Override
  protected void renderComponent(Graphics2D graphics) {
    AffineTransform baseTransform = getBaseTransform();

    int index = 0;
    for (Component cardComponent : getChildren()) {
      renderCard(
          graphics,
          cardComponent,
          baseTransform,
          index);
      index++;
    }
  }

  @Override
  public int getHeight() {
    // TODO: Calculate correctly?
    return (int) (CARD_SCALE * CardComponent.BASE_CARD_HEIGHT);
  }

  @Override
  public int getWidth() {
    double angle = -getCardAngle(0);
    return (int) ((Math.sin(angle) * ANGLE_POSITION_OFFSET_Y
        + Math.cos(angle) * CardComponent.BASE_CARD_WIDTH / 2)
        * CARD_SCALE * 2);
  }

  protected AffineTransform getBaseTransform() {
    AffineTransform translateScaleTransform = AffineTransform.getTranslateInstance(
        (getWidth() - CARD_SCALE * CardComponent.BASE_CARD_WIDTH) / 2,
        0);
    translateScaleTransform.concatenate(
        AffineTransform.getScaleInstance(
            CARD_SCALE,
            CARD_SCALE));
    return translateScaleTransform;
  }

  protected void renderCard(
      Graphics2D graphics,
      Component cardComponent,
      AffineTransform baseTransform,
      int index) {
    AffineTransform cardTransform = AffineTransform.getRotateInstance(
        getCardAngle(index),
        CardComponent.BASE_CARD_WIDTH / 2,
        ANGLE_POSITION_OFFSET_Y);
    cardTransform.preConcatenate(baseTransform);
    try (GraphicsTransform transform = new GraphicsTransform(graphics, cardTransform)) {
      cardComponent.render(graphics);
    }
  }

  private double getCardAngle(int index) {
    return (-CARD_ANGLE * 0.5f * (getSize() - 1)) + (CARD_ANGLE * index);
  }
}
