package com.nirrattner.pitch.core.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * Immutable implementation of {@link PlayerInputIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code PlayerInput.builder()}.
 */
@Generated(from = "PlayerInputIF", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class PlayerInput implements PlayerInputIF {
  private final InputType inputType;
  private final int value;

  private PlayerInput(InputType inputType, int value) {
    this.inputType = inputType;
    this.value = value;
  }

  /**
   * @return The value of the {@code inputType} attribute
   */
  @JsonProperty
  @Override
  public InputType getInputType() {
    return inputType;
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
   * Copy the current immutable object by setting a value for the {@link PlayerInputIF#getInputType() inputType} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for inputType
   * @return A modified copy of the {@code this} object
   */
  public final PlayerInput withInputType(InputType value) {
    if (this.inputType == value) return this;
    InputType newValue = Objects.requireNonNull(value, "inputType");
    if (this.inputType.equals(newValue)) return this;
    return new PlayerInput(newValue, this.value);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PlayerInputIF#getValue() value} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for value
   * @return A modified copy of the {@code this} object
   */
  public final PlayerInput withValue(int value) {
    if (this.value == value) return this;
    return new PlayerInput(this.inputType, value);
  }

  /**
   * This instance is equal to all instances of {@code PlayerInput} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof PlayerInput
        && equalTo((PlayerInput) another);
  }

  private boolean equalTo(PlayerInput another) {
    return inputType.equals(another.inputType)
        && value == another.value;
  }

  /**
   * Computes a hash code from attributes: {@code inputType}, {@code value}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + inputType.hashCode();
    h += (h << 5) + value;
    return h;
  }

  /**
   * Prints the immutable value {@code PlayerInput} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "PlayerInput{"
        + "inputType=" + inputType
        + ", value=" + value
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "PlayerInputIF", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements PlayerInputIF {
    @Nullable InputType inputType;
    int value;
    boolean valueIsSet;
    @JsonProperty
    public void setInputType(InputType inputType) {
      this.inputType = inputType;
    }
    @JsonProperty
    public void setValue(int value) {
      this.value = value;
      this.valueIsSet = true;
    }
    @Override
    public InputType getInputType() { throw new UnsupportedOperationException(); }
    @Override
    public int getValue() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static PlayerInput fromJson(Json json) {
    PlayerInput.Builder builder = PlayerInput.builder();
    if (json.inputType != null) {
      builder.setInputType(json.inputType);
    }
    if (json.valueIsSet) {
      builder.setValue(json.value);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link PlayerInputIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable PlayerInput instance
   */
  public static PlayerInput copyOf(PlayerInputIF instance) {
    if (instance instanceof PlayerInput) {
      return (PlayerInput) instance;
    }
    return PlayerInput.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link PlayerInput PlayerInput}.
   * <pre>
   * PlayerInput.builder()
   *    .setInputType(com.nirrattner.pitch.core.models.InputType) // required {@link PlayerInputIF#getInputType() inputType}
   *    .setValue(int) // required {@link PlayerInputIF#getValue() value}
   *    .build();
   * </pre>
   * @return A new PlayerInput builder
   */
  public static PlayerInput.Builder builder() {
    return new PlayerInput.Builder();
  }

  /**
   * Builds instances of type {@link PlayerInput PlayerInput}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "PlayerInputIF", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_INPUT_TYPE = 0x1L;
    private static final long INIT_BIT_VALUE = 0x2L;
    private long initBits = 0x3L;

    private @Nullable InputType inputType;
    private int value;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code PlayerInputIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(PlayerInputIF instance) {
      Objects.requireNonNull(instance, "instance");
      setInputType(instance.getInputType());
      setValue(instance.getValue());
      return this;
    }

    /**
     * Initializes the value for the {@link PlayerInputIF#getInputType() inputType} attribute.
     * @param inputType The value for inputType 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setInputType(InputType inputType) {
      this.inputType = Objects.requireNonNull(inputType, "inputType");
      initBits &= ~INIT_BIT_INPUT_TYPE;
      return this;
    }

    /**
     * Initializes the value for the {@link PlayerInputIF#getValue() value} attribute.
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
     * Builds a new {@link PlayerInput PlayerInput}.
     * @return An immutable instance of PlayerInput
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public PlayerInput build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new PlayerInput(inputType, value);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_INPUT_TYPE) != 0) attributes.add("inputType");
      if ((initBits & INIT_BIT_VALUE) != 0) attributes.add("value");
      return "Cannot build PlayerInput, some of required attributes are not set " + attributes;
    }
  }
}
