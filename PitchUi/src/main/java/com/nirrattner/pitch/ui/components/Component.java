package com.nirrattner.pitch.ui.components;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.List;

public interface Component {
  void render(Graphics2D graphics);

  int getHeight();

  int getWidth();

  List<? extends Component> getChildren();

  AffineTransform getCoordinate();

  boolean contains(Point2D point2D);

  boolean isVisible();

  void setVisible(boolean visible);
}
