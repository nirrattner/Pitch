package com.nirrattner.pitch.core.events;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.events.EventType;

import java.util.Set;

@Singleton
public class AggregateEventLogger implements EventLogger {

  private final Set<EventLogger> eventLoggers;

  @Inject
  public AggregateEventLogger(Set<EventLogger> eventLoggers) {
    this.eventLoggers = eventLoggers;
  }

  @Override
  public void log(EventType eventType, Object... args) {
    eventLoggers.forEach(
        eventLogger -> eventLogger.log(eventType, args));
  }
}
