package com.nirrattner.pitch.ui.components.bid;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.ui.components.AbstractComponent;
import com.nirrattner.pitch.ui.components.transform.GraphicsTransform;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Collections;

@Singleton
public class BidContentComponent extends AbstractComponent {

  private static final Font TITLE_FONT = new Font("Futura", Font.BOLD, 20);
  private static final String TITLE_TEXT = "Bid Points for Round";
  private static final int BUTTON_ROW_PADDING = 30;

  private final BidButtonRowComponent bidButtonRowComponent;

  @Inject
  public BidContentComponent(BidButtonRowComponent bidButtonRowComponent) {
    this.bidButtonRowComponent = bidButtonRowComponent;

    this.children = Collections.singletonList(bidButtonRowComponent);
  }

  @Override
  protected void renderComponent(Graphics2D graphics) {
    FontMetrics fontMetrics = graphics.getFontMetrics(TITLE_FONT);
    Rectangle2D titleStringBounds = fontMetrics.getStringBounds(TITLE_TEXT, graphics);

    graphics.setColor(Color.BLACK);
    graphics.setFont(TITLE_FONT);
    graphics.drawString(
        TITLE_TEXT,
        0,
        fontMetrics.getAscent());

    AffineTransform buttonRowTranslation = AffineTransform.getTranslateInstance(
        0,
        titleStringBounds.getHeight() + BUTTON_ROW_PADDING);
    try (GraphicsTransform transform = new GraphicsTransform(graphics, buttonRowTranslation)) {
      bidButtonRowComponent.render(graphics);
    }

    height = (int) titleStringBounds.getHeight() + BUTTON_ROW_PADDING + bidButtonRowComponent.getHeight();
    width = bidButtonRowComponent.getWidth();
  }
}
