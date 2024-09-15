package com.nirrattner.pitch.console;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ConsolePitchMain {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new PitchConsoleModule());
    ConsolePitch consolePitch = injector.getInstance(ConsolePitch.class);
    consolePitch.run();
  }
}
