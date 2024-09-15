package com.nirrattner.pitch.core.validators;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.InputType;
import com.nirrattner.pitch.core.models.PlayerInput;

import java.util.Collections;
import java.util.List;

@Singleton
public class AckInputValidator {

  private static final int ACK_INPUT = 0;

  @Inject
  public AckInputValidator() {
  }

  public List<PlayerInput> getValidInputs(Game game) {
    return Collections.singletonList(
        PlayerInput.builder()
            .setInputType(InputType.ACK)
            .setValue(ACK_INPUT)
            .build());
  }
}