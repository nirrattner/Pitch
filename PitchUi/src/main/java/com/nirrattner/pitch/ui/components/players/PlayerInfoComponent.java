package com.nirrattner.pitch.ui.components.players;

import com.google.inject.Provider;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import com.nirrattner.pitch.core.models.BidType;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.Player;
import com.nirrattner.pitch.ui.components.AbstractComponent;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class PlayerInfoComponent extends AbstractComponent {

  private static final Font FONT = new Font("Futura", Font.PLAIN, 16);
  private static final String POINTS_FORMAT = "Points: %d";
  private static final String BID_FORMAT = "Bid: %s";

  private final Provider<Game> gameProvider;
  private final int playerIndex;

  @AssistedInject
  public PlayerInfoComponent(
      Provider<Game> gameProvider,
      @Assisted int playerIndex) {
    this.gameProvider = gameProvider;
    this.playerIndex = playerIndex;
  }

  @Override
  protected void renderComponent(Graphics2D graphics) {
    Game game = gameProvider.get();
    Player player = game.getPlayers().get(playerIndex);
    FontMetrics fontMetrics = graphics.getFontMetrics(FONT);

    graphics.setFont(FONT);
    graphics.setColor(Color.BLACK);
    graphics.drawString(
        String.format(POINTS_FORMAT, player.getScore()),
        0,
        fontMetrics.getAscent());

    player.getBid()
        .ifPresent(bid -> {
          String bidText = String.format(
              BID_FORMAT,
              bid == BidType.PASS ?
                  "Pass"
                  : bid.getValue());
          graphics.drawString(bidText,
              0,
              2 * fontMetrics.getAscent());
        });
  }
}
