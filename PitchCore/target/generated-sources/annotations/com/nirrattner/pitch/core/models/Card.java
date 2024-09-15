package com.nirrattner.pitch.core.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link AbstractCard}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code Card.builder()}.
 */
@Generated(from = "AbstractCard", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class Card extends AbstractCard {
  private final Suit suit;
  private final int value;
  private transient final int effectiveValue;
  private transient final String valueString;
  private transient final String displayString;

  private Card(Suit suit, int value) {
    this.suit = suit;
    this.value = value;
    this.effectiveValue = initShim.getEffectiveValue();
    this.valueString = initShim.getValueString();
    this.displayString = initShim.getDisplayString();
    this.initShim = null;
  }

  private static final byte STAGE_INITIALIZING = -1;
  private static final byte STAGE_UNINITIALIZED = 0;
  private static final byte STAGE_INITIALIZED = 1;
  @SuppressWarnings("Immutable")
  private transient volatile InitShim initShim = new InitShim();

  @Generated(from = "AbstractCard", generator = "Immutables")
  private final class InitShim {
    private byte effectiveValueBuildStage = STAGE_UNINITIALIZED;
    private int effectiveValue;

    int getEffectiveValue() {
      if (effectiveValueBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (effectiveValueBuildStage == STAGE_UNINITIALIZED) {
        effectiveValueBuildStage = STAGE_INITIALIZING;
        this.effectiveValue = Card.super.getEffectiveValue();
        effectiveValueBuildStage = STAGE_INITIALIZED;
      }
      return this.effectiveValue;
    }

    private byte valueStringBuildStage = STAGE_UNINITIALIZED;
    private String valueString;

    String getValueString() {
      if (valueStringBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (valueStringBuildStage == STAGE_UNINITIALIZED) {
        valueStringBuildStage = STAGE_INITIALIZING;
        this.valueString = Objects.requireNonNull(Card.super.getValueString(), "valueString");
        valueStringBuildStage = STAGE_INITIALIZED;
      }
      return this.valueString;
    }

    private byte displayStringBuildStage = STAGE_UNINITIALIZED;
    private String displayString;

    String getDisplayString() {
      if (displayStringBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (displayStringBuildStage == STAGE_UNINITIALIZED) {
        displayStringBuildStage = STAGE_INITIALIZING;
        this.displayString = Objects.requireNonNull(Card.super.getDisplayString(), "displayString");
        displayStringBuildStage = STAGE_INITIALIZED;
      }
      return this.displayString;
    }

    private String formatInitCycleMessage() {
      List<String> attributes = new ArrayList<>();
      if (effectiveValueBuildStage == STAGE_INITIALIZING) attributes.add("effectiveValue");
      if (valueStringBuildStage == STAGE_INITIALIZING) attributes.add("valueString");
      if (displayStringBuildStage == STAGE_INITIALIZING) attributes.add("displayString");
      return "Cannot build Card, attribute initializers form cycle " + attributes;
    }
  }

  /**
   * @return The value of the {@code suit} attribute
   */
  @JsonProperty
  @Override
  public Suit getSuit() {
    return suit;
  }

  /**
   * @return The value of the {@code value} attribute
   */
  @JsonProperty
  @Override
  public int getValue() {
    return value;
  }

  /**
   * @return The computed-at-construction value of the {@code effectiveValue} attribute
   */
  @JsonProperty
  @Override
  public int getEffectiveValue() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.getEffectiveValue()
        : this.effectiveValue;
  }

  /**
   * @return The computed-at-construction value of the {@code valueString} attribute
   */
  @JsonProperty
  @Override
  public String getValueString() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.getValueString()
        : this.valueString;
  }

  /**
   * @return The computed-at-construction value of the {@code displayString} attribute
   */
  @JsonProperty
  @Override
  public String getDisplayString() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.getDisplayString()
        : this.displayString;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractCard#getSuit() suit} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for suit
   * @return A modified copy of the {@code this} object
   */
  public final Card withSuit(Suit value) {
    if (this.suit == value) return this;
    Suit newValue = Objects.requireNonNull(value, "suit");
    if (this.suit.equals(newValue)) return this;
    return validate(new Card(newValue, this.value));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractCard#getValue() value} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for value
   * @return A modified copy of the {@code this} object
   */
  public final Card withValue(int value) {
    if (this.value == value) return this;
    return validate(new Card(this.suit, value));
  }

  /**
   * This instance is equal to all instances of {@code Card} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof Card
        && equalTo((Card) another);
  }

  private boolean equalTo(Card another) {
    return suit.equals(another.suit)
        && value == another.value
        && effectiveValue == another.effectiveValue
        && valueString.equals(another.valueString)
        && displayString.equals(another.displayString);
  }

  /**
   * Computes a hash code from attributes: {@code suit}, {@code value}, {@code effectiveValue}, {@code valueString}, {@code displayString}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + suit.hashCode();
    h += (h << 5) + value;
    h += (h << 5) + effectiveValue;
    h += (h << 5) + valueString.hashCode();
    h += (h << 5) + displayString.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Card} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Card{"
        + "suit=" + suit
        + ", value=" + value
        + ", effectiveValue=" + effectiveValue
        + ", valueString=" + valueString
        + ", displayString=" + displayString
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "AbstractCard", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends AbstractCard {
    @Nullable Suit suit;
    int value;
    boolean valueIsSet;
    @JsonProperty
    public void setSuit(Suit suit) {
      this.suit = suit;
    }
    @JsonProperty
    public void setValue(int value) {
      this.value = value;
      this.valueIsSet = true;
    }
    @Override
    public Suit getSuit() { throw new UnsupportedOperationException(); }
    @Override
    public int getValue() { throw new UnsupportedOperationException(); }
    @JsonIgnore
    @Override
    public int getEffectiveValue() { throw new UnsupportedOperationException(); }
    @JsonIgnore
    @Override
    public String getValueString() { throw new UnsupportedOperationException(); }
    @JsonIgnore
    @Override
    public String getDisplayString() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static Card fromJson(Json json) {
    Card.Builder builder = Card.builder();
    if (json.suit != null) {
      builder.setSuit(json.suit);
    }
    if (json.valueIsSet) {
      builder.setValue(json.value);
    }
    return builder.build();
  }

  private static Card validate(Card instance) {
    instance.check();
    return instance;
  }

  /**
   * Creates an immutable copy of a {@link AbstractCard} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Card instance
   */
  public static Card copyOf(AbstractCard instance) {
    if (instance instanceof Card) {
      return (Card) instance;
    }
    return Card.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link Card Card}.
   * <pre>
   * Card.builder()
   *    .setSuit(com.nirrattner.pitch.core.models.Suit) // required {@link AbstractCard#getSuit() suit}
   *    .setValue(int) // required {@link AbstractCard#getValue() value}
   *    .build();
   * </pre>
   * @return A new Card builder
   */
  public static Card.Builder builder() {
    return new Card.Builder();
  }

  /**
   * Builds instances of type {@link Card Card}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "AbstractCard", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_SUIT = 0x1L;
    private static final long INIT_BIT_VALUE = 0x2L;
    private long initBits = 0x3L;

    private @Nullable Suit suit;
    private int value;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AbstractCard} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(AbstractCard instance) {
      Objects.requireNonNull(instance, "instance");
      setSuit(instance.getSuit());
      setValue(instance.getValue());
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractCard#getSuit() suit} attribute.
     * @param suit The value for suit 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setSuit(Suit suit) {
      this.suit = Objects.requireNonNull(suit, "suit");
      initBits &= ~INIT_BIT_SUIT;
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractCard#getValue() value} attribute.
     * @param value The value for value 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setValue(int value) {
      this.value = value;
      initBits &= ~INIT_BIT_VALUE;
      return this;
    }

    /**
     * Builds a new {@link Card Card}.
     * @return An immutable instance of Card
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public Card build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return Card.validate(new Card(suit, value));
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_SUIT) != 0) attributes.add("suit");
      if ((initBits & INIT_BIT_VALUE) != 0) attributes.add("value");
      return "Cannot build Card, some of required attributes are not set " + attributes;
    }
  }
}
