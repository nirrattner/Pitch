package com.nirrattner.pitch.ui.components;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.InputType;
import com.nirrattner.pitch.ui.components.bid.BidComponent;
import com.nirrattner.pitch.ui.components.hands.OpponentHandComponent;
import com.nirrattner.pitch.ui.components.hands.OpponentHandComponentFactory;
import com.nirrattner.pitch.ui.components.hands.PlayerHandComponent;
import com.nirrattner.pitch.ui.components.players.PlayerInfoComponent;
import com.nirrattner.pitch.ui.components.players.PlayerInfoComponentFactory;
import com.nirrattner.pitch.ui.components.transform.GraphicsTransform;
import com.nirrattner.pitch.ui.components.trick.TrickComponent;
import com.nirrattner.pitch.ui.components.trump.TrumpComponent;
import com.nirrattner.pitch.ui.components.winnings.WinningsComponent;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

@Singleton
public class RootComponent extends AbstractComponent {

  private static final int FPS_POSITION_X = 10;
  private static final int FPS_POSITION_Y = 10;

  private static final int TRUMP_POSITION_X = 10;
  private static final int TRUMP_POSITION_Y = 10;

  private static final int PLAYER_INFO_0_OFFSET_X = -418;
  private static final int PLAYER_INFO_0_OFFSET_Y = -70;
  private static final int PLAYER_INFO_1_OFFSET_X = 100;
  private static final int PLAYER_INFO_1_OFFSET_Y = -298;
  private static final int PLAYER_INFO_2_OFFSET_X = 318;
  private static final int PLAYER_INFO_2_OFFSET_Y = 60;
  private static final int PLAYER_INFO_3_OFFSET_X = -140;
  private static final int PLAYER_INFO_3_OFFSET_Y = 298;

  private final BidComponent bidComponent;
  private final Canvas canvas;
  private final FpsComponent fpsComponent;
  private final PlayerHandComponent playerHandComponent;
  private final OpponentHandComponent opponentHandComponent1;
  private final OpponentHandComponent opponentHandComponent2;
  private final OpponentHandComponent opponentHandComponent3;
  private final PlayerInfoComponent playerInfo0;
  private final PlayerInfoComponent playerInfo1;
  private final PlayerInfoComponent playerInfo2;
  private final PlayerInfoComponent playerInfo3;
  private final TrickComponent trickComponent;
  private final TrumpComponent trumpComponent;
  private final WinningsComponent winningsComponent;
  private final Provider<Game> gameProvider;

  @Inject
  public RootComponent(
      BidComponent bidComponent,
      Canvas canvas,
      FpsComponent fpsComponent,
      PlayerHandComponent playerHandComponent,
      OpponentHandComponentFactory opponentHandComponentFactory,
      PlayerInfoComponentFactory playerInfoComponentFactory,
      TrickComponent trickComponent,
      TrumpComponent trumpComponent,
      WinningsComponent winningsComponent,
      Provider<Game> gameProvider) {
    this.bidComponent = bidComponent;
    this.canvas = canvas;
    this.fpsComponent = fpsComponent;
    this.playerHandComponent = playerHandComponent;
    this.opponentHandComponent1 = opponentHandComponentFactory.create(1);
    this.opponentHandComponent2 = opponentHandComponentFactory.create(2);
    this.opponentHandComponent3 = opponentHandComponentFactory.create(3);
    this.playerInfo0 = playerInfoComponentFactory.create(0);
    this.playerInfo1 = playerInfoComponentFactory.create(1);
    this.playerInfo2 = playerInfoComponentFactory.create(2);
    this.playerInfo3 = playerInfoComponentFactory.create(3);
    this.trickComponent = trickComponent;
    this.trumpComponent = trumpComponent;
    this.winningsComponent = winningsComponent;
    this.gameProvider = gameProvider;

    this.children = ImmutableList.of(
        bidComponent,
        fpsComponent,
        playerHandComponent,
        opponentHandComponent1,
        opponentHandComponent2,
        opponentHandComponent3,
        playerInfo0,
        playerInfo1,
        playerInfo2,
        playerInfo3);
  }

  @Override
  protected void renderComponent(Graphics2D graphics) {
    renderBid(graphics);
    renderTrick(graphics);
    renderTrump(graphics);
    renderPlayerHand(graphics);
    renderOpponentHand1(graphics);
    renderOpponentHand2(graphics);
    renderOpponentHand3(graphics);
    // renderWinnings(graphics);

    renderFps(graphics);
  }

  private void renderTrump(Graphics2D graphics) {
    AffineTransform trumpTranslation = AffineTransform.getTranslateInstance(
        TRUMP_POSITION_X,
        TRUMP_POSITION_Y);
    try (GraphicsTransform transform = new GraphicsTransform(graphics, trumpTranslation)) {
      trumpComponent.render(graphics);
    }
  }

  @Override
  public int getHeight() {
    return canvas.getHeight();
  }

  @Override
  public int getWidth() {
    return canvas.getWidth();
  }

  private void renderBid(Graphics2D graphics) {
    bidComponent.setVisible(gameProvider.get().getInputType() == InputType.BID);

    int positionX = (canvas.getWidth() - bidComponent.getWidth()) / 2;
    int positionY = (canvas.getHeight() - bidComponent.getHeight()) / 2;
    AffineTransform bidTranslation = AffineTransform.getTranslateInstance(
        positionX,
        positionY);
    try (GraphicsTransform transform = new GraphicsTransform(graphics, bidTranslation)) {
      bidComponent.render(graphics);
    }
  }

  private void renderTrick(Graphics2D graphics) {
    trickComponent.setVisible(
        gameProvider.get().getInputType() == InputType.ACK
            || gameProvider.get().getInputType() == InputType.TRICK);

    int positionX = (canvas.getWidth() - trickComponent.getWidth()) / 2;
    int positionY = (canvas.getHeight() - trickComponent.getHeight()) / 2;
    AffineTransform trickTranslation = AffineTransform.getTranslateInstance(
        positionX,
        positionY);
    try (GraphicsTransform transform = new GraphicsTransform(graphics, trickTranslation)) {
      trickComponent.render(graphics);
    }
  }

  private void renderPlayerHand(Graphics2D graphics) {
    int positionX = (canvas.getWidth() - playerHandComponent.getWidth()) / 2;
    int positionY = canvas.getHeight() - 3 * playerHandComponent.getHeight() / 4;
    AffineTransform playerHandTranslation = AffineTransform.getTranslateInstance(
        positionX,
        positionY);
    try (GraphicsTransform transform = new GraphicsTransform(graphics, playerHandTranslation)) {
      playerHandComponent.render(graphics);
    }

    // 182, 730
    AffineTransform playerInfoTranslation = AffineTransform.getTranslateInstance(
        (canvas.getWidth() / 2) + PLAYER_INFO_0_OFFSET_X,
        canvas.getHeight() + PLAYER_INFO_0_OFFSET_Y);
    try (GraphicsTransform transform = new GraphicsTransform(graphics, playerInfoTranslation)) {
      playerInfo0.render(graphics);
    }
  }

  private void renderOpponentHand1(Graphics2D graphics) {
    int positionX = 3 * opponentHandComponent1.getHeight() / 4;
    int positionY = (canvas.getHeight() - opponentHandComponent1.getWidth()) / 2;
    AffineTransform opponentHandTransform = AffineTransform.getTranslateInstance(
        positionX,
        positionY);
    opponentHandTransform.concatenate(
        AffineTransform.getRotateInstance(
            Math.PI / 2));
    try (GraphicsTransform transform = new GraphicsTransform(graphics, opponentHandTransform)) {
      opponentHandComponent1.render(graphics);
    }

    // 100, 102
    AffineTransform playerInfoTranslation = AffineTransform.getTranslateInstance(
        PLAYER_INFO_1_OFFSET_X,
        (canvas.getHeight() / 2) + PLAYER_INFO_1_OFFSET_Y);
    try (GraphicsTransform transform = new GraphicsTransform(graphics, playerInfoTranslation)) {
      playerInfo1.render(graphics);
    }
  }

  private void renderOpponentHand2(Graphics2D graphics) {
    int positionX = (canvas.getWidth() - opponentHandComponent2.getWidth()) / 2;
    int positionY = -opponentHandComponent2.getHeight() / 4;
    AffineTransform opponentHandTransform = AffineTransform.getTranslateInstance(
        positionX,
        positionY);
    opponentHandTransform.concatenate(
        AffineTransform.getRotateInstance(
            Math.PI,
            opponentHandComponent2.getWidth() / 2,
            opponentHandComponent2.getHeight() / 2));
    try (GraphicsTransform transform = new GraphicsTransform(graphics, opponentHandTransform)) {
      opponentHandComponent2.render(graphics);
    }

    // 918, 60
    AffineTransform playerInfoTranslation = AffineTransform.getTranslateInstance(
        (canvas.getWidth() / 2) + PLAYER_INFO_2_OFFSET_X,
        PLAYER_INFO_2_OFFSET_Y);
    try (GraphicsTransform transform = new GraphicsTransform(graphics, playerInfoTranslation)) {
      playerInfo2.render(graphics);
    }
  }

  private void renderOpponentHand3(Graphics2D graphics) {
    int positionX = canvas.getWidth() - 3 * opponentHandComponent3.getHeight() / 4;
    int positionY = (canvas.getHeight() + opponentHandComponent3.getWidth()) / 2;
    AffineTransform opponentHandTransform = AffineTransform.getTranslateInstance(
        positionX,
        positionY);
    opponentHandTransform.concatenate(
        AffineTransform.getRotateInstance(
            3 * Math.PI / 2));
    try (GraphicsTransform transform = new GraphicsTransform(graphics, opponentHandTransform)) {
      opponentHandComponent3.render(graphics);
    }

    // 1060, 698
    AffineTransform playerInfoTranslation = AffineTransform.getTranslateInstance(
        canvas.getWidth() + PLAYER_INFO_3_OFFSET_X,
        (canvas.getHeight() / 2) + PLAYER_INFO_3_OFFSET_Y);
    try (GraphicsTransform transform = new GraphicsTransform(graphics, playerInfoTranslation)) {
      playerInfo3.render(graphics);
    }
  }

  private void renderWinnings(Graphics2D graphics) {
    winningsComponent.setSize(getHeight(), getWidth());
    winningsComponent.render(graphics);
  }

  private void renderFps(Graphics2D graphics) {
    AffineTransform fpsTranslation = AffineTransform.getTranslateInstance(
        FPS_POSITION_X,
        FPS_POSITION_Y);
    try (GraphicsTransform transform = new GraphicsTransform(graphics, fpsTranslation)) {
      fpsComponent.render(graphics);
    }
  }
}
