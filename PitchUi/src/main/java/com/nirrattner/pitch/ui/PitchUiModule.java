package com.nirrattner.pitch.ui;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.multibindings.Multibinder;
import com.nirrattner.pitch.console.loggers.ConsoleEventLogger;
import com.nirrattner.pitch.core.PitchCoreModule;
import com.nirrattner.pitch.core.events.EventLogger;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.ui.components.bid.button.ButtonComponent;
import com.nirrattner.pitch.ui.components.bid.button.ButtonComponentFactory;
import com.nirrattner.pitch.ui.components.cards.InputCardFaceComponent;
import com.nirrattner.pitch.ui.components.cards.InputCardFaceComponentFactory;
import com.nirrattner.pitch.ui.components.hands.OpponentHandComponent;
import com.nirrattner.pitch.ui.components.hands.OpponentHandComponentFactory;
import com.nirrattner.pitch.ui.components.players.PlayerInfoComponent;
import com.nirrattner.pitch.ui.components.players.PlayerInfoComponentFactory;
import com.nirrattner.pitch.ui.game.GameProvider;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.image.BufferStrategy;

public class PitchUiModule extends AbstractModule {

  @Override
  public void configure() {
    install(new PitchCoreModule());

    bind(Canvas.class).toInstance(new Canvas());
    bind(JFrame.class).toInstance(new JFrame());
    bind(Game.class).toProvider(GameProvider.class);

    Multibinder<EventLogger> multibinder = Multibinder.newSetBinder(binder(), EventLogger.class);
    multibinder.addBinding().to(ConsoleEventLogger.class).asEagerSingleton();

    install(
        new FactoryModuleBuilder()
            .implement(ButtonComponent.class, ButtonComponent.class)
            .build(ButtonComponentFactory.class));

    install(
        new FactoryModuleBuilder()
            .implement(InputCardFaceComponent.class, InputCardFaceComponent.class)
            .build(InputCardFaceComponentFactory.class));

    install(
        new FactoryModuleBuilder()
            .implement(PlayerInfoComponent.class, PlayerInfoComponent.class)
            .build(PlayerInfoComponentFactory.class));

    install(
        new FactoryModuleBuilder()
            .implement(OpponentHandComponent.class, OpponentHandComponent.class)
            .build(OpponentHandComponentFactory.class));
  }

  @Provides
  public BufferStrategy getBufferStrategy(Canvas canvas) {
    return canvas.getBufferStrategy();
  }
}
