package com.nirrattner.pitch.ui;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class FpsCalculator {

  private static final long SECOND_MILLIS = 1000L;

  private int fps;
  private int frames;
  private long startTime;

  @Inject
  public FpsCalculator() {
    this.fps = 0;
    this.frames = 0;
    this.startTime = 0;
  }

  public void setFrame() {
    long now = System.currentTimeMillis();
    if (now - startTime > SECOND_MILLIS) {
      this.startTime = now;
      this.fps = this.frames;
      this.frames = 0;
    }
    frames++;
  }

  public int getFps() {
    return this.fps;
  }
}
