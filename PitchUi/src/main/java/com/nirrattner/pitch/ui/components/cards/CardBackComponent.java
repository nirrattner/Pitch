package com.nirrattner.pitch.ui.components.cards;

import com.google.common.io.Resources;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CardBackComponent extends CardComponent {

  private static final String FILENAME = "cards/back.png";

  private static final BufferedImage BUFFERED_IMAGE;
  static {
    try {
      BUFFERED_IMAGE = ImageIO.read(Resources.getResource(FILENAME));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public CardBackComponent() {
  }

  @Override
  protected Image getImage() {
    return BUFFERED_IMAGE;
  }
}
