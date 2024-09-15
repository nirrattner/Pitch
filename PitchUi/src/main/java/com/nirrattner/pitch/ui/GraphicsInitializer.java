package com.nirrattner.pitch.ui;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.ui.input.MouseController;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Canvas;

@Singleton
public class GraphicsInitializer {

  private static final int NUMBER_OF_BUFFERS = 2;

  private final Canvas canvas;
  private final JFrame jFrame;
  private final MouseController mouseController;

  @Inject
  public GraphicsInitializer(
      Canvas canvas,
      JFrame jFrame,
      MouseController mouseController) {
    this.canvas = canvas;
    this.jFrame = jFrame;
    this.mouseController = mouseController;
  }

  public void initialize() {
    canvas.setIgnoreRepaint(true);
    canvas.setSize(GraphicsConstants.APP_WIDTH, GraphicsConstants.APP_HEIGHT);

    jFrame.setIgnoreRepaint(true);
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    jFrame.add(canvas);
    jFrame.pack();
    jFrame.setLocationRelativeTo(null);

    canvas.createBufferStrategy(NUMBER_OF_BUFFERS);
    canvas.addMouseListener(mouseController);
    canvas.addMouseMotionListener(mouseController);
  }
}
