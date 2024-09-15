package com.nirrattner.pitch.ui.components.cards;

import com.google.common.io.Resources;
import com.nirrattner.pitch.core.models.Card;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CardFaceComponent extends CardComponent {

  private final BufferedImage image;

  public CardFaceComponent(Card card) {
    try {
      this.image = ImageIO.read(Resources.getResource(getFilename(card)));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected Image getImage() {
    return image;
  }

  private String getFilename(Card card) {
    return "cards/" + card.getValueString() + card.getSuit().toString().charAt(0) + ".png";
  }
}
