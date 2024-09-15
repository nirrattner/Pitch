package com.nirrattner.pitch.core;

import com.google.inject.AbstractModule;
import com.nirrattner.pitch.core.controllers.state.score.PitchScoreModule;

public class PitchCoreModule extends AbstractModule {
  @Override
  protected void configure() {
    install(new PitchScoreModule());
  }
}
