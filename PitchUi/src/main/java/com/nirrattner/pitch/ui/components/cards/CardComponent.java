package com.nirrattner.pitch.ui.components.cards;

import com.nirrattner.pitch.ui.components.AbstractComponent;

import java.awt.*;

public abstract class CardComponent extends AbstractComponent {

  public static final int BASE_CARD_HEIGHT = 400;
  public static final int BASE_CARD_WIDTH = 276;

  protected abstract Image getImage();

  @Override
  protected void renderComponent(Graphics2D graphics2D) {
    graphics2D.drawImage(getImage(), 0, 0, null);
  }

  @Override
  public int getHeight() {
    return BASE_CARD_HEIGHT;
  }

  @Override
  public int getWidth() {
    return BASE_CARD_WIDTH;
  }
}
