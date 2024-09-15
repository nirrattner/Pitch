package com.nirrattner.pitch.ui.input;

import com.nirrattner.pitch.ui.components.Component;

public interface MouseInputComponent extends Component {
  int getPriority();

  MouseInputState getState();

  void setState(MouseInputState state);

  void onClick();

  default void onMousePressed() {
    if (getState() != MouseInputState.DISABLED) {
      setState(MouseInputState.CLICKED);
    }
  }

  default void onMouseRelease(boolean isClick) {
    if (isClick) {
      onClick();
    }
    setState(MouseInputState.IDLE);
  }

  default void onMouseOver(boolean isMouseOver) {
    if (getState() == MouseInputState.IDLE
        && isMouseOver) {
      setState(MouseInputState.MOUSE_OVER);
    }
    if (getState() == MouseInputState.MOUSE_OVER
        && !isMouseOver) {
      setState(MouseInputState.IDLE);
    }
  }
}
