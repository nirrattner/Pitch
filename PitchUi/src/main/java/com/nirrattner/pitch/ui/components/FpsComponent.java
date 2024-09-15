package com.nirrattner.pitch.ui.components;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.ui.FpsCalculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

@Singleton
public class FpsComponent extends AbstractComponent {

  private static final Font FONT = new Font("Card Characters", Font.BOLD, 12);
  private static final String FORMAT = "FPS: %s";

  private final FpsCalculator fpsCalculator;

  @Inject
  public FpsComponent(FpsCalculator fpsCalculator) {
    this.fpsCalculator = fpsCalculator;
  }

  @Override
  protected void renderComponent(Graphics2D graphics) {
    String text = String.format(FORMAT, fpsCalculator.getFps());
    FontMetrics fontMetrics = graphics.getFontMetrics(FONT);
    Rectangle2D stringBounds = fontMetrics.getStringBounds(text, graphics);

    graphics.setFont(FONT);
    graphics.setColor(Color.BLACK);
    graphics.drawString(
        text,
        0,
        fontMetrics.getAscent());

    height = (int) stringBounds.getHeight();
    width = (int) stringBounds.getWidth();
  }
}
