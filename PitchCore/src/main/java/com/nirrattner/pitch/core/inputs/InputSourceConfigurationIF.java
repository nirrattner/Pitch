package com.nirrattner.pitch.core.inputs;

import com.nirrattner.pitch.core.models.style.ImmutableStyle;
import org.immutables.value.Value;

import java.util.List;

@ImmutableStyle
@Value.Immutable
public interface InputSourceConfigurationIF {
  List<InputSource> getInputSources();
}
