package com.nirrattner.pitch.ui.components.cards;

import com.nirrattner.pitch.core.models.Card;

public interface InputCardFaceComponentFactory {
  InputCardFaceComponent create(Card card, Runnable onClickCallback);
}
