package com.nirrattner.pitch.core.models.events;

public enum EventType {

  GAME_STARTED("New game started!"),
  PLAYER_BID("Player %d bids %s"),
  PLAYER_BID_PASS("Player %d passes"),
  PLAYER_BID_WIN("Player %d wins the bid and leads the trick!"),
  PLAYER_TRICK_PLAY("Player %d plays %s"),
  PLAYER_TRICK_WIN("Player %d wins with card %s -- %s"),
  PLAYER_WIN_HIGH("Player %d wins HIGH with card %s"),
  PLAYER_WIN_LOW("Player %d wins LOW with card %s"),
  PLAYER_WIN_JACK("Player %d wins JACK"),
  PLAYER_WIN_NO_JACK("No player wins JACK"),
  PLAYER_WIN_GAME("Player %d wins GAME with %d game points"),
  PLAYER_WIN_TIE_GAME("Players %s tie GAME with %s game points -- no GAME point won"),
  PLAYER_WON("Player %d won!\n%s"),
  ROUND_STARTED("Round %d: Player %d deals\n%s"),
  ;

  private String format;

  EventType(String format) {
    this.format = format;
  }

  public String getFormat() {
    return format;
  }
}
