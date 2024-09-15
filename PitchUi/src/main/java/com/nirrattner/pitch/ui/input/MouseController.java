package com.nirrattner.pitch.ui.input;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.controllers.GameInputController;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.InputType;
import com.nirrattner.pitch.core.models.PlayerInput;
import com.nirrattner.pitch.ui.components.Component;
import com.nirrattner.pitch.ui.components.RootComponent;
import com.nirrattner.pitch.ui.game.GameProvider;

import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Singleton
public class MouseController implements MouseInputListener {

  private boolean isPressed;
  private Point2D position;
  private Optional<MouseInputComponent> mousePressedComponent;
  private Optional<MouseInputComponent> mouseOverComponent;

  private final GameProvider gameProvider;
  private final GameInputController gameInputController;
  private final RootComponent rootComponent;

  @Inject
  public MouseController(
      GameProvider gameProvider,
      GameInputController gameInputController,
      RootComponent rootComponent) {
    this.gameProvider = gameProvider;
    this.gameInputController = gameInputController;
    this.rootComponent = rootComponent;
    this.isPressed = false;
    this.position = new Point2D.Double();
    this.mouseOverComponent = Optional.empty();
  }

  public boolean isPressed() {
    return isPressed;
  }

  public Point2D getPosition() {
    return position;
  }

  @Override
  public void mouseClicked(MouseEvent event) {
  }

  @Override
  public void mousePressed(MouseEvent event) {
    isPressed = true;

    Game game = gameProvider.get();
    if (game.getInputType() == InputType.ACK) {
      gameProvider.set(
          gameInputController.step(
              game,
              PlayerInput.builder()
                  .setInputType(InputType.ACK)
                  .setValue(0)
                  .build()));
      return;
    }

    mouseOverComponent.ifPresent(
        component -> component.onMouseOver(false));
    mouseOverComponent = Optional.empty();

    mousePressedComponent = getEventComponents(rootComponent, event.getPoint())
        .stream()
        .max(Comparator.comparing(MouseInputComponent::getPriority));
    mousePressedComponent.ifPresent(MouseInputComponent::onMousePressed);
  }

  @Override
  public void mouseReleased(MouseEvent event) {
    isPressed = false;
    mousePressedComponent.ifPresent(
        component ->
            component.onMouseRelease(
                component.contains(event.getPoint())));
    mousePressedComponent = Optional.empty();
    updatePosition(event.getPoint());
  }

  @Override
  public void mouseEntered(MouseEvent event) {
    updatePosition(event.getPoint());
  }

  @Override
  public void mouseExited(MouseEvent event) {
    updatePosition(event.getPoint());
  }

  @Override
  public void mouseDragged(MouseEvent event) {
    updatePosition(event.getPoint());
  }

  @Override
  public void mouseMoved(MouseEvent event) {
    updatePosition(event.getPoint());
  }

  private void updatePosition(Point2D position) {
    this.position = position;
    if (!isPressed) {
      Optional<MouseInputComponent> eventComponent = getEventComponents(rootComponent, position)
          .stream()
          .max(Comparator.comparing(MouseInputComponent::getPriority));
      if (!eventComponent.equals(mouseOverComponent)) {
        eventComponent.ifPresent(
            component -> component.onMouseOver(true));
        mouseOverComponent.ifPresent(
            component -> component.onMouseOver(false));
        mouseOverComponent = eventComponent;
      }
    }
  }

  private List<MouseInputComponent> getEventComponents(
      Component component,
      Point2D point) {
    if (component.isVisible()) {
      if (component instanceof MouseInputComponent
          && component.contains(point)) {
        return Collections.singletonList((MouseInputComponent) component);
      } else {
        return component.getChildren().stream()
            .map(child -> getEventComponents(child, point))
            .flatMap(List::stream)
            .collect(ImmutableList.toImmutableList());
      }
    }
    return Collections.emptyList();
  }
}
