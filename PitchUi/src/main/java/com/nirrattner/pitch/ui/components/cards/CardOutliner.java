package com.nirrattner.pitch.ui.components.cards;

import com.nirrattner.pitch.ui.components.transform.GraphicsTransform;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class CardOutliner {

  private static final int ARC_RADIUS = 10;
  private static final int OUTLINE_SIZE = 50;

  public void render(
      Graphics2D graphics,
      Color startColor,
      Color endColor) {
    AffineTransform contentTranslation = AffineTransform.getTranslateInstance(
        ARC_RADIUS - OUTLINE_SIZE,
        ARC_RADIUS - OUTLINE_SIZE);

    int outlineHeight = CardComponent.BASE_CARD_HEIGHT+ 2 * (OUTLINE_SIZE - ARC_RADIUS);
    int outlineWidth = CardComponent.BASE_CARD_WIDTH + 2 * (OUTLINE_SIZE - ARC_RADIUS);

    try (GraphicsTransform transform = new GraphicsTransform(graphics, contentTranslation)) {
      // Left
      graphics.setPaint(
          new GradientPaint(
              0,
              OUTLINE_SIZE,
              endColor,
              OUTLINE_SIZE,
              OUTLINE_SIZE,
              startColor));
      graphics.fillRect(
          0,
          OUTLINE_SIZE,
          OUTLINE_SIZE,
          outlineHeight - OUTLINE_SIZE - OUTLINE_SIZE);

      // Right
      graphics.setPaint(
          new GradientPaint(
              outlineWidth - OUTLINE_SIZE,
              OUTLINE_SIZE,
              startColor,
              outlineWidth,
              OUTLINE_SIZE,
              endColor));
      graphics.fillRect(
          outlineWidth - OUTLINE_SIZE,
          OUTLINE_SIZE,
          OUTLINE_SIZE,
          outlineHeight - OUTLINE_SIZE - OUTLINE_SIZE);

      // Top
      graphics.setPaint(
          new GradientPaint(
              OUTLINE_SIZE, 0,
              endColor,
              OUTLINE_SIZE, OUTLINE_SIZE,
              startColor));
      graphics.fillRect(
          OUTLINE_SIZE,
          0,
          outlineWidth - OUTLINE_SIZE - OUTLINE_SIZE,
          OUTLINE_SIZE);

      // Bottom
      graphics.setPaint
          (new GradientPaint(
              OUTLINE_SIZE,
              outlineHeight - OUTLINE_SIZE,
              startColor,
              OUTLINE_SIZE,
              outlineHeight,
              endColor));
      graphics.fillRect(
          OUTLINE_SIZE,
          outlineHeight - OUTLINE_SIZE,
          outlineWidth - OUTLINE_SIZE - OUTLINE_SIZE,
          OUTLINE_SIZE);

      // Top Left
      graphics.setPaint(
          new RadialGradientPaint(
              new Rectangle2D.Double(
                  0,
                  0,
                  OUTLINE_SIZE + OUTLINE_SIZE,
                  OUTLINE_SIZE + OUTLINE_SIZE),
              new float[]{0, 1},
              new Color[]{startColor, endColor},
              MultipleGradientPaint.CycleMethod.NO_CYCLE));
      graphics.fillRect(
          0,
          0,
          OUTLINE_SIZE,
          OUTLINE_SIZE);

      // Top Right
      graphics.setPaint(
          new RadialGradientPaint(
              new Rectangle2D.Double(
                  outlineWidth - OUTLINE_SIZE - OUTLINE_SIZE,
                  0,
                  OUTLINE_SIZE + OUTLINE_SIZE,
                  OUTLINE_SIZE + OUTLINE_SIZE),
              new float[]{0, 1},
              new Color[]{startColor, endColor},
              MultipleGradientPaint.CycleMethod.NO_CYCLE));
      graphics.fillRect(
          outlineWidth - OUTLINE_SIZE,
          0,
          OUTLINE_SIZE,
          OUTLINE_SIZE);

      // Bottom Left
      graphics.setPaint(
          new RadialGradientPaint(
              new Rectangle2D.Double(
                  0,
                  outlineHeight - OUTLINE_SIZE - OUTLINE_SIZE,
                  OUTLINE_SIZE + OUTLINE_SIZE,
                  OUTLINE_SIZE + OUTLINE_SIZE),
              new float[]{0, 1},
              new Color[]{startColor, endColor},
              MultipleGradientPaint.CycleMethod.NO_CYCLE));
      graphics.fillRect(
          0,
          outlineHeight - OUTLINE_SIZE,
          OUTLINE_SIZE,
          OUTLINE_SIZE);

      // Bottom Right
      graphics.setPaint(
          new RadialGradientPaint(
              new Rectangle2D.Double(
                  outlineWidth - OUTLINE_SIZE - OUTLINE_SIZE,
                  outlineHeight - OUTLINE_SIZE - OUTLINE_SIZE,
                  OUTLINE_SIZE + OUTLINE_SIZE,
                  OUTLINE_SIZE + OUTLINE_SIZE),
              new float[]{0, 1},
              new Color[]{startColor, endColor},
              MultipleGradientPaint.CycleMethod.NO_CYCLE));
      graphics.fillRect(
          outlineWidth - OUTLINE_SIZE,
          outlineHeight - OUTLINE_SIZE,
          OUTLINE_SIZE,
          OUTLINE_SIZE);
    }
  }
}
