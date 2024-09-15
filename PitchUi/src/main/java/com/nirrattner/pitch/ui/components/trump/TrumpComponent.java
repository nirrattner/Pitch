package com.nirrattner.pitch.ui.components.trump;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.Suit;
import com.nirrattner.pitch.ui.components.AbstractComponent;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

@Singleton
public class TrumpComponent extends AbstractComponent {

  private static final Font FONT = new Font("Futura", Font.PLAIN, 16);
  private static final String TRUMP_LABEL = "Trump: ";
  private static final int ARC_SIZE = 10;
  private static final Color COLOR = new Color(230, 230, 230);
  private static final int PADDING = 10;

  private final Provider<Game> gameProvider;

  @Inject
  public TrumpComponent(Provider<Game> gameProvider) {
    this.gameProvider = gameProvider;
  }

  @Override
  protected void renderComponent(Graphics2D graphics) {

    gameProvider.get().getTrumpSuit()
        .ifPresent(
            suit -> {
              FontMetrics fontMetrics = graphics.getFontMetrics(FONT);

              renderBackground(
                  graphics,
                  fontMetrics,
                  suit);

              graphics.setFont(FONT);
              graphics.setColor(Color.BLACK);
              graphics.drawString(
                  TRUMP_LABEL,
                  PADDING,
                  PADDING + fontMetrics.getAscent());

              if (suit == Suit.DIAMONDS || suit == Suit.HEARTS) {
                graphics.setColor(Color.RED);
              }

              graphics.drawString(
                  suit.getSymbol(),
                  PADDING + fontMetrics.stringWidth(TRUMP_LABEL),
                  PADDING + fontMetrics.getAscent());
            });
  }

  private void renderBackground(
      Graphics2D graphics,
      FontMetrics fontMetrics,
      Suit suit) {
    graphics.setColor(COLOR);
    graphics.fillRoundRect(
        0,
        0,
        fontMetrics.stringWidth(TRUMP_LABEL + suit.getSymbol()) + 2 * PADDING,
        fontMetrics.getHeight() + 2 * PADDING,
        ARC_SIZE,
        ARC_SIZE);

    graphics.setColor(Color.BLACK);
    graphics.drawRoundRect(
        0,
        0,
        fontMetrics.stringWidth(TRUMP_LABEL + suit.getSymbol()) + 2 * PADDING,
        fontMetrics.getHeight() + 2 * PADDING,
        ARC_SIZE,
        ARC_SIZE);
  }
}
