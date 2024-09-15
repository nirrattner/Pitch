package com.nirrattner.pitch.ui.components.transform;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class GraphicsTransform implements AutoCloseable {

  private final Graphics2D graphics2D;
  private final AffineTransform stashedTransform;

  public GraphicsTransform(
      Graphics2D graphics2D,
      AffineTransform affineTransform) {
    this.graphics2D = graphics2D;
    this.stashedTransform = graphics2D.getTransform();

    graphics2D.transform(affineTransform);
  }

  @Override
  public void close() {
    graphics2D.setTransform(stashedTransform);
  }
}
