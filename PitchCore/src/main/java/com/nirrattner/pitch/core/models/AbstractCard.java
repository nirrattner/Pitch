package com.nirrattner.pitch.core.models;

import com.google.common.base.Preconditions;
import com.nirrattner.pitch.core.models.style.ImmutableStyle;
import org.immutables.value.Value;

import java.util.Comparator;

@ImmutableStyle
@Value.Immutable
public abstract class AbstractCard implements Comparable<AbstractCard> {

  public static final int ACE_RAW_VALUE = 1;
  public static final int JACK_VALUE = 11;
  public static final int QUEEN_VALUE = 12;
  public static final int KING_VALUE = 13;
  public static final int MAX_VALUE = 13;
  public static final int ACE_EFFECTIVE_VALUE = 14;
  private static final Comparator<AbstractCard> COMPARATOR = Comparator
      .comparing(AbstractCard::getSuit)
      .thenComparing(AbstractCard::getEffectiveValue);

  public abstract Suit getSuit();

  public abstract int getValue();

  @Value.Derived
  public int getEffectiveValue() {
    return getValue() == ACE_RAW_VALUE
        ? ACE_EFFECTIVE_VALUE
        : getValue();
  }

  @Value.Derived
  public String getValueString() {
    switch (getValue()) {
      case ACE_RAW_VALUE:
        return "A";
      case JACK_VALUE:
        return "J";
      case QUEEN_VALUE:
        return "Q";
      case KING_VALUE:
        return "K";
      default:
        return String.valueOf(getEffectiveValue());
    }
  }

  @Value.Derived
  public String getDisplayString() {
    return getValueString() + getSuit().getSymbol();
  }

  @Override
  public int compareTo(AbstractCard other) {
    return COMPARATOR.compare(this, other);
  }

  @Value.Check
  public void check() {
    Preconditions.checkState(
        getValue() >= ACE_RAW_VALUE && getValue() <= MAX_VALUE,
        "Value %s out of bounds",
        getValue());
  }
}
