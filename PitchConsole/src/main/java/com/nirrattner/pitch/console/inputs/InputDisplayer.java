package com.nirrattner.pitch.console.inputs;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.BidType;
import com.nirrattner.pitch.core.models.Card;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.PlayerInput;
import sun.jvm.hotspot.utilities.AssertionFailure;

import java.util.List;

@Singleton
public class InputDisplayer {

  private static final String ACK_DISPLAY = "Press ENTER to continue";

  @Inject
  public InputDisplayer() {
  }

  public void display(
      Game game,
      List<PlayerInput> playerInputs) {
    for (int i = 0; i < playerInputs.size(); i++) {
      System.out.println(getInputDisplay(
          game,
          playerInputs.get(i),
          i));
    }
  }

  private String getInputDisplay(
      Game game,
      PlayerInput playerInput,
      int index) {
    switch (playerInput.getInputType()) {
      case ACK:
        return ACK_DISPLAY;
      case BID:
        return getBidDisplay(
            playerInput.getValue(),
            index);
      case TRICK:
        return getTrickDisplay(
            game,
            playerInput.getValue(),
            index);
      default:
        throw new AssertionFailure(
            String.format(
                "Invalid bid type: %s",
                playerInput.getInputType()));
    }
  }

  private String getBidDisplay(
      int value,
      int index) {
    return value == BidType.PASS.getValue()
        ? String.format("%d: PASS", index)
        : String.format("%d: BID %d", index, value);
  }

  private String getTrickDisplay(
      Game game,
      int value,
      int index) {
    Card card = game.getPlayers()
        .get(game.getPlayerTurn())
        .getHand()
        .get(value);
    return String.format(
        "%d: %s",
        index,
        card.getDisplayString());
  }
}
