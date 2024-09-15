package com.nirrattner.pitch.console;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.multibindings.Multibinder;
import com.nirrattner.pitch.console.loggers.ConsoleEventLogger;
import com.nirrattner.pitch.core.PitchCoreModule;
import com.nirrattner.pitch.core.events.EventLogger;
import com.nirrattner.pitch.core.inputs.InputSourceConfiguration;
import com.nirrattner.pitch.ai.RandomAiInputSource;
import com.nirrattner.pitch.console.inputs.ConsoleInputSource;

public class PitchConsoleModule extends AbstractModule {
  @Override
  protected void configure() {
    install(new PitchCoreModule());

    Multibinder<EventLogger> multibinder = Multibinder.newSetBinder(binder(), EventLogger.class);
    multibinder.addBinding().to(ConsoleEventLogger.class).asEagerSingleton();
  }

  @Provides
  public InputSourceConfiguration provideInputSourceConfiguration(
      ConsoleInputSource consoleInputSource,
      RandomAiInputSource randomAiInputSource) {
    return InputSourceConfiguration.builder()
        .addInputSources(
            consoleInputSource,
            randomAiInputSource,
            randomAiInputSource,
            randomAiInputSource)
        .build();
  }
}
