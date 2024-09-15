package com.nirrattner.pitch.ui.components.bid;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.controllers.GameInputController;
import com.nirrattner.pitch.core.models.BidType;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.InputType;
import com.nirrattner.pitch.core.models.PlayerInput;
import com.nirrattner.pitch.core.validators.BidInputValidator;
import com.nirrattner.pitch.ui.components.AbstractComponent;
import com.nirrattner.pitch.ui.components.Component;
import com.nirrattner.pitch.ui.components.bid.button.ButtonComponent;
import com.nirrattner.pitch.ui.components.bid.button.ButtonComponentFactory;
import com.nirrattner.pitch.ui.components.transform.GraphicsTransform;
import com.nirrattner.pitch.ui.game.GameProvider;
import com.nirrattner.pitch.ui.input.MouseInputState;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Singleton
public class BidButtonRowComponent extends AbstractComponent {

  private static final int BUTTON_MARGIN = 20;

  private final ButtonComponent noneButton;
  private final ButtonComponent twoButton;
  private final ButtonComponent threeButton;
  private final ButtonComponent fourButton;
  private final List<ButtonComponent> buttonComponents;
  private final BidInputValidator bidInputValidator;
  private final GameInputController gameInputController;
  private final GameProvider gameProvider;

  @Inject
  public BidButtonRowComponent(
      ButtonComponentFactory buttonComponentFactory,
      BidInputValidator bidInputValidator,
      GameInputController gameInputController,
      GameProvider gameProvider) {
    noneButton = buttonComponentFactory.create(
        "Pass",
        () -> onClick(BidType.PASS));
    twoButton = buttonComponentFactory.create(
        "Two",
        () -> onClick(BidType.TWO));
    threeButton = buttonComponentFactory.create(
        "Three",
        () -> onClick(BidType.THREE));
    fourButton = buttonComponentFactory.create(
        "Four",
        () -> onClick(BidType.FOUR));
    this.bidInputValidator = bidInputValidator;
    this.gameInputController = gameInputController;
    this.gameProvider = gameProvider;

    this.buttonComponents = ImmutableList.of(noneButton, twoButton, threeButton, fourButton);
    this.children = buttonComponents;
  }

  @Override
  protected void renderComponent(Graphics2D graphics) {
    validateInputs();

    noneButton.render(graphics);

    AffineTransform buttonRowTranslation = AffineTransform.getTranslateInstance(
        BUTTON_MARGIN + noneButton.getWidth(),
        0);
    try (GraphicsTransform transform = new GraphicsTransform(graphics, buttonRowTranslation)) {
      twoButton.render(graphics);

      graphics.translate(BUTTON_MARGIN + twoButton.getWidth(), 0);
      threeButton.render(graphics);

      graphics.translate(BUTTON_MARGIN + threeButton.getWidth(), 0);
      fourButton.render(graphics);
    }
  }

  @Override
  public int getHeight() {
    return buttonComponents.stream()
        .map(Component::getHeight)
        .max(Comparator.naturalOrder())
        .orElse(0);
  }

  @Override
  public int getWidth() {
    int margins = BUTTON_MARGIN * (children.size() - 1);
    return children.stream()
        .map(Component::getWidth)
        .reduce(margins, Integer::sum);
  }

  private void validateInputs() {
    Set<Integer> validInputs = bidInputValidator.getValidInputs(gameProvider.get()).stream()
        .map(PlayerInput::getValue)
        .collect(ImmutableSet.toImmutableSet());

    int index = 0;
    for (ButtonComponent component : buttonComponents) {
      if (validInputs.contains(BidType.values()[index].getValue())) {
        if (component.getState() == MouseInputState.DISABLED) {
          component.setState(MouseInputState.IDLE);
        }
      } else {
        component.setState(MouseInputState.DISABLED);
      }
      index++;
    }
  }

  private void onClick(BidType bidType) {
    Game game = gameInputController.step(
        gameProvider.get(),
        PlayerInput.builder()
            .setInputType(InputType.BID)
            .setValue(bidType.getValue())
            .build());
    gameProvider.set(game);
  }
}
