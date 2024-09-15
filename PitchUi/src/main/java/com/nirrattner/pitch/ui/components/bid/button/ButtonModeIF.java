package com.nirrattner.pitch.ui.components.bid.button;

import com.nirrattner.pitch.core.models.style.ImmutableStyle;
import org.immutables.value.Value;

import java.awt.Color;
import java.util.Optional;

@ImmutableStyle
@Value.Immutable
public interface ButtonModeIF {
  Color getFontColor();
  Optional<Color> getBorderColor();
  Optional<Color> getFillColor();
}
