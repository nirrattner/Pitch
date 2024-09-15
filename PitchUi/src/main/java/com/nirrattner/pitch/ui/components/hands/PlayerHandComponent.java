package com.nirrattner.pitch.ui.components.hands;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.controllers.GameInputController;
import com.nirrattner.pitch.core.models.Card;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.InputType;
import com.nirrattner.pitch.core.models.PlayerInput;
import com.nirrattner.pitch.core.validators.TrickInputValidator;
import com.nirrattner.pitch.ui.components.cards.InputCardFaceComponent;
import com.nirrattner.pitch.ui.components.cards.InputCardFaceComponentFactory;
import com.nirrattner.pitch.ui.game.GameProvider;
import com.nirrattner.pitch.ui.input.MouseInputState;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Singleton
public class PlayerHandComponent extends HandComponent {

  private static final int DISABLED_PRIORITY = 0;
  private static final int INITIAL_PRIORITY = 1;

  private List<InputCardFaceComponent> cardComponents;
  private List<Card> hand;

  private final InputCardFaceComponentFactory inputCardFaceComponentFactory;
  private final GameProvider gameProvider;
  private final GameInputController gameInputController;
  private final TrickInputValidator trickInputValidator;

  @Inject
  public PlayerHandComponent(
      InputCardFaceComponentFactory inputCardFaceComponentFactory,
      GameProvider gameProvider,
      GameInputController gameInputController,
      TrickInputValidator trickInputValidator) {
    this.inputCardFaceComponentFactory = inputCardFaceComponentFactory;
    this.gameProvider = gameProvider;
    this.gameInputController = gameInputController;
    this.trickInputValidator = trickInputValidator;
    this.hand = Collections.emptyList();

    setHand();
  }

  @Override
  protected void renderComponent(Graphics2D graphics) {
    AffineTransform baseTransform = getBaseTransform();

    setHand();
    validateInputs();

    Optional<Integer> mouseEventIndex = Optional.empty();
    int index = 0;
    for (InputCardFaceComponent cardComponent : cardComponents) {
      if (cardComponent.getState() == MouseInputState.CLICKED
          || cardComponent.getState() == MouseInputState.MOUSE_OVER) {
        mouseEventIndex = Optional.of(index);
      } else {
        renderCard(
            graphics,
            cardComponent,
            baseTransform,
            index);
      }
      index++;
    }
    mouseEventIndex
        .ifPresent(cardIndex -> renderCard(
            graphics,
            cardComponents.get(cardIndex),
            baseTransform,
            cardIndex));
  }

  @Override
  protected int getSize() {
    return children.size();
  }

  private void validateInputs() {
    Game game = gameProvider.get();
    if (game.getInputType() == InputType.TRICK) {
      int index = 0;
      Set<Integer> validInputs = trickInputValidator.getValidInputs(game).stream()
          .map(PlayerInput::getValue)
          .collect(ImmutableSet.toImmutableSet());
      for (InputCardFaceComponent cardComponent : cardComponents) {
        if (validInputs.contains(index)) {
          if (cardComponent.getState() == MouseInputState.DISABLED) {
            cardComponent.setState(MouseInputState.IDLE);
          }
          cardComponent.setPriority(INITIAL_PRIORITY + index);
        } else {
          cardComponent.setState(MouseInputState.DISABLED);
          cardComponent.setPriority(DISABLED_PRIORITY);
        }
        index++;
      }
    } else {
      cardComponents.forEach(
          cardComponent -> cardComponent.setState(MouseInputState.DISABLED));
    }
  }

  private void setHand() {
    List<Card> newHand = gameProvider.get().getPlayers().get(0).getHand();
    if (!newHand.equals(hand)) {
      this.hand = gameProvider.get().getPlayers().get(0).getHand();

      ImmutableList.Builder<InputCardFaceComponent> builder = ImmutableList.builder();
      int index = 0;
      for (Card card : hand) {
        int value = index;
        builder.add(inputCardFaceComponentFactory.create(
            card,
            () -> onClick(value)));
        index++;
      }
      this.cardComponents = builder.build();
      this.children = cardComponents;
    }
  }

  private void onClick(int index) {
    Game game = gameInputController.step(
        gameProvider.get(),
        PlayerInput.builder()
            .setInputType(InputType.TRICK)
            .setValue(index)
            .build());
    gameProvider.set(game);
  }
}
