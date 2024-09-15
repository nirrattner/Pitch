package com.nirrattner.pitch.ui.components.bid;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.ui.components.AbstractComponent;
import com.nirrattner.pitch.ui.components.transform.GraphicsTransform;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.MultipleGradientPaint;
import java.awt.RadialGradientPaint;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Collections;

@Singleton
public class BidComponent extends AbstractComponent {

  private static final int CONTENT_MARGIN = 20;
  private static final Color COLOR = new Color(230, 230, 230);
  private static final int HEIGHT = 150;
  private static final int WIDTH = 400;
  private static final int ARC_SIZE = 10;
  private static final int SHADOW_LENGTH = 150;
  private static final int SHADOW_INTENSITY = 90;
  private static final Color SHADOW_START = new Color(SHADOW_INTENSITY, SHADOW_INTENSITY, SHADOW_INTENSITY, 255);
  private static final Color SHADOW_END = new Color(SHADOW_INTENSITY, SHADOW_INTENSITY, SHADOW_INTENSITY, 0);

  private final BidContentComponent bidContentComponent;

  @Inject
  public BidComponent(BidContentComponent bidContentComponent) {
    this.bidContentComponent = bidContentComponent;

    this.children = Collections.singletonList(bidContentComponent);
  }

  @Override
  protected void renderComponent(Graphics2D graphics) {
    renderShadow(graphics);

    graphics.setColor(COLOR);
    graphics.fillRoundRect(0, 0, WIDTH, HEIGHT, ARC_SIZE, ARC_SIZE);

    AffineTransform contentTranslation = AffineTransform.getTranslateInstance(CONTENT_MARGIN, CONTENT_MARGIN);
    try (GraphicsTransform transform = new GraphicsTransform(graphics, contentTranslation)) {
      bidContentComponent.render(graphics);
    }
  }

  @Override
  public int getHeight() {
    return HEIGHT;
  }

  @Override
  public int getWidth() {
    return WIDTH;
  }

  private void renderShadow(Graphics2D graphics) {
    graphics.setPaint(
        new RadialGradientPaint(
            new Rectangle2D.Float(
                -SHADOW_LENGTH,
                -SHADOW_LENGTH,
                WIDTH + 2 * SHADOW_LENGTH,
                HEIGHT + 2 * SHADOW_LENGTH),
            new float[]{0.05f, 0.95f},
            new Color[]{SHADOW_START, SHADOW_END},
            MultipleGradientPaint.CycleMethod.NO_CYCLE));
    graphics.fillOval(
        -SHADOW_LENGTH,
        -SHADOW_LENGTH,
        WIDTH + 2 * SHADOW_LENGTH,
        HEIGHT + 2 * SHADOW_LENGTH);
  }
}
