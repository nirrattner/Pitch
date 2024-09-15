package com.nirrattner.pitch.console.loggers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.events.EventLogger;
import com.nirrattner.pitch.core.models.events.EventType;

@Singleton
public class ConsoleEventLogger implements EventLogger {

  @Inject
  public ConsoleEventLogger() {
  }

  @Override
  public void log(EventType eventType, Object... args) {
    System.out.println(
        String.format(
            eventType.getFormat(),
            args));
  }
}
