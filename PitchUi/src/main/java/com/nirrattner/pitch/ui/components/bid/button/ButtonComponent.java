package com.nirrattner.pitch.ui.components.bid.button;

import com.google.common.collect.ImmutableMap;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import com.nirrattner.pitch.ui.components.AbstractComponent;
import com.nirrattner.pitch.ui.input.MouseInputComponent;
import com.nirrattner.pitch.ui.input.MouseInputState;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Map;

public class ButtonComponent extends AbstractComponent implements MouseInputComponent {

  private static final int CLICK_PRIORITY = 0;
  private static final Font FONT = new Font("Futura", Font.PLAIN, 18);
  private static final int PADDING = 10;
  private static final int ARC_SIZE = 10;
  private static final Map<MouseInputState, ButtonMode> BUTTON_MODES = ImmutableMap.of(
      MouseInputState.CLICKED,
      ButtonMode.builder()
          .setFontColor(Color.WHITE)
          .setFillColor(Color.DARK_GRAY)
          .build(),
      MouseInputState.DISABLED,
      ButtonMode.builder()
          .setFontColor(Color.LIGHT_GRAY.darker())
          .setBorderColor(Color.LIGHT_GRAY.darker())
          .build(),
      MouseInputState.IDLE,
      ButtonMode.builder()
          .setFontColor(Color.BLACK)
          .setBorderColor(Color.BLACK)
          .build(),
      MouseInputState.MOUSE_OVER,
      ButtonMode.builder()
          .setFontColor(Color.BLACK)
          .setBorderColor(Color.BLACK)
          .setFillColor(Color.LIGHT_GRAY)
          .build());

  private final String buttonText;
  private final Runnable onClickCallback;

  private MouseInputState state;

  // TODO: Remove assisted inject?
  @AssistedInject
  public ButtonComponent(
      @Assisted String buttonText,
      @Assisted Runnable onClickCallback) {
    this.onClickCallback = onClickCallback;
    this.buttonText = buttonText;
    this.state = MouseInputState.IDLE;
  }

  @Override
  protected void renderComponent(Graphics2D graphics) {
    graphics.setFont(FONT);
    FontMetrics fontMetrics = graphics.getFontMetrics(FONT);
    Rectangle2D stringBounds = fontMetrics.getStringBounds(buttonText, graphics);
    ButtonMode buttonMode = BUTTON_MODES.get(state);

    height = (int) stringBounds.getHeight() + 2 * PADDING;
    width = (int) stringBounds.getWidth() + 2 * PADDING;

    buttonMode.getFillColor()
        .ifPresent(color -> {
          graphics.setColor(color);
          graphics.fillRoundRect(
              0,
              0,
              width,
              height,
              ARC_SIZE,
              ARC_SIZE);
        });
    buttonMode.getBorderColor()
        .ifPresent(color -> {
          graphics.setColor(color);
          graphics.drawRoundRect(
              0,
              0,
              width,
              height,
              ARC_SIZE,
              ARC_SIZE);
        });
    graphics.setColor(buttonMode.getFontColor());
    graphics.drawString(
        buttonText,
        PADDING,
        PADDING + fontMetrics.getAscent());
  }

  @Override
  public int getPriority() {
    return CLICK_PRIORITY;
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
}
