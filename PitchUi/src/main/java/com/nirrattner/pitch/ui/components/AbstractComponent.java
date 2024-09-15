package com.nirrattner.pitch.ui.components;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.util.Collections;
import java.util.List;

public abstract class AbstractComponent implements Component {

  protected int height = 0;
  protected int width = 0;
  protected List<? extends Component> children = Collections.emptyList();
  protected AffineTransform coordinate;
  protected boolean visible = true;

  protected abstract void renderComponent(Graphics2D graphics2D);

  @Override
  public void render(Graphics2D graphics2D) {
    if (isVisible()) {
      this.coordinate = graphics2D.getTransform();
      renderComponent(graphics2D);
    }
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public List<? extends Component> getChildren() {
    return children;
  }

  @Override
  public AffineTransform getCoordinate() {
    return coordinate;
  }

  @Override
  public boolean contains(Point2D point2D) {
    Point2D transformedPoint = new Point2D.Double();
    try {
      transformedPoint = coordinate.inverseTransform(point2D, transformedPoint);
    } catch (NoninvertibleTransformException e) {
      return false;
    }
    return transformedPoint.getX() >= 0
        && transformedPoint.getX() <= getWidth()
        && transformedPoint.getY() >= 0
        && transformedPoint.getY() <= getHeight();
  }

  @Override
  public boolean isVisible() {
    return visible;
  }

  @Override
  public void setVisible(boolean visible) {
    this.visible = visible;
  }
}
