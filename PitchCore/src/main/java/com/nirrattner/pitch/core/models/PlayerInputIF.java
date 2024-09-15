package com.nirrattner.pitch.core.models;

import com.nirrattner.pitch.core.models.style.ImmutableStyle;
import org.immutables.value.Value;

@ImmutableStyle
@Value.Immutable
public interface PlayerInputIF {
  InputType getInputType();
  int getValue();
}
