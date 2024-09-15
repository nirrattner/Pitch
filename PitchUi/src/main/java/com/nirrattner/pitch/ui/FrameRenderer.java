package com.nirrattner.pitch.ui;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.nirrattner.pitch.ui.components.RootComponent;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import static com.nirrattner.pitch.ui.GraphicsConstants.BACKGROUND_COLOR;

@Singleton
public class FrameRenderer {

  private final Canvas canvas;
  private final Provider<BufferStrategy> bufferStrategyProvider;
  private final JFrame jFrame;
  private final RootComponent rootComponent;

  @Inject
  public FrameRenderer(
      Canvas canvas,
      Provider<BufferStrategy> bufferStrategyProvider,
      JFrame jFrame,
      RootComponent rootComponent) {
    this.canvas = canvas;
    this.bufferStrategyProvider = bufferStrategyProvider;
    this.jFrame = jFrame;
    this.rootComponent = rootComponent;
  }

  public void render() {
    BufferStrategy bufferStrategy = bufferStrategyProvider.get();
    do {
      do {
        Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();

        graphics.setBackground(BACKGROUND_COLOR);
        graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        rootComponent.render(graphics);

        graphics.dispose();
      } while (bufferStrategy.contentsRestored());
      bufferStrategy.show();
    } while (bufferStrategy.contentsLost());

    if (!jFrame.isVisible()) {
      jFrame.setVisible(true);
    }
  }
}
