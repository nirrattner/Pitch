package com.nirrattner.pitch.core.models;

public enum Suit {
  CLUBS("♣"),
  DIAMONDS("♦"),
  HEARTS("♥"),
  SPADES("♠"),
  ;

  private String symbol;

  Suit(String symbol) {
    this.symbol = symbol;
  }

  public String getSymbol() {
    return symbol;
  }
}
