package com.nirrattner.pitch.console.inputs;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.models.*;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Singleton
public class ConsoleInputParser {

  private static final String BID_INPUT = "bid";
  private static final String BID_WINNER_INPUT = "bid-winner";
  private static final String SCORE_INPUT = "score";
  private static final String TRUMP_INPUT = "trump";
  private static final String WINNINGS_INPUT = "winnings";
  private static final String NONE = "none";

  @Inject
  public ConsoleInputParser() {
  }

  public Optional<PlayerInput> parse(
      String input,
      Game game,
      List<PlayerInput> playerInputs) {
    if (input.equals(BID_INPUT)) {
      System.out.println(String.format("Bid: %d", game.getBid()));
      return Optional.empty();
    }

    if (input.equals(BID_WINNER_INPUT)) {
      System.out.println(
          String.format(
              "Bid winner: Player %d",
              game.getBidWinner() + 1));
      return Optional.empty();
    }

    if (input.equals(SCORE_INPUT)) {
      game.getPlayers()
          .forEach(player -> System.out.println(
              String.format(
                  "Player %d: %d points",
                  player.getId() + 1,
                  player.getScore())));
      return Optional.empty();
    }

    if (input.equals(TRUMP_INPUT)) {
      System.out.println(String.format(
          "Trump suit: %s",
          game.getTrumpSuit()
              .map(Suit::getSymbol)
              .orElse(NONE)));
      return Optional.empty();
    }

    if (input.equals(WINNINGS_INPUT)) {
      game.getPlayers()
          .forEach(player -> System.out.println(
              String.format(
                  "Player %d winnings: %s",
                  player.getId() + 1,
                  player.getWinnings().stream()
                      .map(Card::getDisplayString)
                      .collect(Collectors.joining(", ")))));
      return Optional.empty();
    }

    if (game.getInputType() == InputType.ACK) {
      return Optional.of(playerInputs.get(0));
    }

    if (Pattern.matches(
        String.format("[0-%d]", playerInputs.size() - 1),
        input)) {
      return Optional.of(playerInputs.get(Integer.parseInt(input)));
    }

    System.out.println(String.format("Unknown input \"%s\"", input));
    return Optional.empty();
  }
}
