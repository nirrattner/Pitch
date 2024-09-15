package com.nirrattner.pitch.ui.components.winnings;

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

@Singleton
public class WinningsComponent extends AbstractComponent {

  private static final Color COLOR = new Color(230, 230, 230);
  private static final int ARC_SIZE = 10;
  private static final int PADDING = 30;
  private static final int CONTENT_MARGIN = 20;
  private static final int SHADOW_LENGTH = 400;
  private static final int SHADOW_INTENSITY = 50;
  private static final Color SHADOW_START = new Color(SHADOW_INTENSITY, SHADOW_INTENSITY, SHADOW_INTENSITY, 255);
  private static final Color SHADOW_END = new Color(SHADOW_INTENSITY, SHADOW_INTENSITY, SHADOW_INTENSITY, 0);

  private int height;
  private int width;

  @Inject
  public WinningsComponent() {
  }

  @Override
  protected void renderComponent(Graphics2D graphics) {
    AffineTransform paddingTranslation = AffineTransform.getTranslateInstance(PADDING, PADDING);
    try (GraphicsTransform transform = new GraphicsTransform(graphics, paddingTranslation)) {
      renderShadow(graphics);

      graphics.setColor(COLOR);
      graphics.fillRoundRect(
          0,
          0,
          width - 2 * PADDING,
          height - 2 * PADDING,
          ARC_SIZE,
          ARC_SIZE);

      // AffineTransform contentTranslation = AffineTransform.getTranslateInstance(CONTENT_MARGIN, CONTENT_MARGIN);
      // try (GraphicsTransform transform = new GraphicsTransform(graphics, contentTranslation)) {
      //
      // }
    }
  }

  public void setSize(int height, int width) {
    this.height = height;
    this.width = width;
  }

  private void renderShadow(Graphics2D graphics) {
    graphics.setPaint(
        new RadialGradientPaint(
            new Rectangle2D.Float(
                -SHADOW_LENGTH,
                -SHADOW_LENGTH,
                width + 2 * SHADOW_LENGTH,
                height + 2 * SHADOW_LENGTH),
            new float[]{0.05f, 0.95f},
            new Color[]{SHADOW_START, SHADOW_END},
            MultipleGradientPaint.CycleMethod.NO_CYCLE));
    graphics.fillOval(
        -SHADOW_LENGTH,
        -SHADOW_LENGTH,
        width + 2 * SHADOW_LENGTH,
        height + 2 * SHADOW_LENGTH);
  }
}
