package com.nirrattner.pitch.core.events;

import com.nirrattner.pitch.core.models.events.EventType;

public interface EventLogger {
  void log(EventType eventType, Object... args);
}
