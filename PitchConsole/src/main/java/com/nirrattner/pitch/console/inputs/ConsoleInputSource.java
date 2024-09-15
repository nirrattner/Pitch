package com.nirrattner.pitch.console.inputs;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nirrattner.pitch.core.inputs.InputSource;
import com.nirrattner.pitch.core.models.Game;
import com.nirrattner.pitch.core.models.PlayerInput;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Singleton
public class ConsoleInputSource implements InputSource {

  private final ConsoleInputParser consoleInputParser;
  private final InputDisplayer inputDisplayer;

  @Inject
  public ConsoleInputSource(
      ConsoleInputParser consoleInputParser,
      InputDisplayer inputDisplayer) {
    this.consoleInputParser = consoleInputParser;
    this.inputDisplayer = inputDisplayer;
  }

  @Override
  public PlayerInput getInput(
      Game game,
      List<PlayerInput> playerInputs) {
    inputDisplayer.display(game, playerInputs);
    Scanner scanner = new Scanner(System.in);
    Optional<PlayerInput> playerInput = Optional.empty();
    while (!playerInput.isPresent()) {
      playerInput = consoleInputParser.parse(
          scanner.nextLine(),
          game,
          playerInputs);
    }
    return playerInput.get();
  }
}
