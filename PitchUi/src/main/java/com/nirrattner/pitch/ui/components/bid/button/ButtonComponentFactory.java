package com.nirrattner.pitch.ui.components.bid.button;

public interface ButtonComponentFactory {
  ButtonComponent create(String buttonText, Runnable onClickCallback);
}
