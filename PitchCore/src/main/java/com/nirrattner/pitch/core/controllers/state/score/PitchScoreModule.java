package com.nirrattner.pitch.core.controllers.state.score;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import com.nirrattner.pitch.core.models.ScoreType;

public class PitchScoreModule extends AbstractModule {
  @Override
  protected void configure() {
    MapBinder<ScoreType, WinnerCalculator> binder = MapBinder.newMapBinder(
        binder(),
        ScoreType.class,
        WinnerCalculator.class);
    binder.addBinding(ScoreType.HIGH)
        .to(HighCardWinnerCalculator.class)
        .asEagerSingleton();
    binder.addBinding(ScoreType.LOW)
        .to(LowCardWinnerCalculator.class)
        .asEagerSingleton();
    binder.addBinding(ScoreType.JACK)
        .to(JackCardWinnerCalculator.class)
        .asEagerSingleton();
    binder.addBinding(ScoreType.GAME)
        .to(GamePointsWinnerCalculator.class)
        .asEagerSingleton();
  }
}
