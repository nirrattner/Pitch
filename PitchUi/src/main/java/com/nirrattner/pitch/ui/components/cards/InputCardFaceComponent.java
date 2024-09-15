package com.nirrattner.pitch.ui.components.cards;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import com.nirrattner.pitch.core.models.Card;
import com.nirrattner.pitch.ui.input.MouseInputComponent;
import com.nirrattner.pitch.ui.input.MouseInputState;

import java.awt.*;

public class InputCardFaceComponent extends CardFaceComponent implements MouseInputComponent {

  private static final Color IDLE_COLOR_START = new Color(255, 255, 0, 255);
  private static final Color IDLE_COLOR_END = new Color(255, 255, 0, 10);
  private static final Color OUTLINE_COLOR_START = new Color(255, 147, 0, 255);
  private static final Color OUTLINE_COLOR_END = new Color(255, 147, 0, 10);
  private static final Color CLICK_COLOR_START = new Color(0, 147, 255, 255);
  private static final Color CLICK_COLOR_END = new Color(0, 147, 255, 10);

  private int priority;
  private MouseInputState state;
  private final Runnable onClickCallback;
  private final CardOutliner cardOutliner;

  // TODO: Remove assisted inject?
  @AssistedInject
  public InputCardFaceComponent(
      CardOutliner cardOutliner,
      @Assisted Card card,
      @Assisted Runnable onClickCallback) {
    super(card);
    this.onClickCallback = onClickCallback;
    this.cardOutliner = cardOutliner;
    state = MouseInputState.IDLE;
  }

  @Override
  protected void renderComponent(Graphics2D graphics2D) {
    if (state == MouseInputState.IDLE){
      cardOutliner.render(
          graphics2D,
          IDLE_COLOR_START,
          IDLE_COLOR_END);
    } else if (state == MouseInputState.MOUSE_OVER) {
      cardOutliner.render(
          graphics2D,
          OUTLINE_COLOR_START,
          OUTLINE_COLOR_END);
    } else if (state == MouseInputState.CLICKED) {
      cardOutliner.render(
          graphics2D,
          CLICK_COLOR_START,
          CLICK_COLOR_END);
    }

    super.renderComponent(graphics2D);
  }

  @Override
  public int getPriority() {
    return priority;
  }

  @Override
  public MouseInputState getState() {
    return state;
  }

  @Override
  public void setState(MouseInputState state) {
    this.state = state;
  }

  @Override
  public void onClick() {
    if (state != MouseInputState.DISABLED) {
      onClickCallback.run();
    }
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }
}
