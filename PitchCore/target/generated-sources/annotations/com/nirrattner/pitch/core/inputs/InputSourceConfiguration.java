package com.nirrattner.pitch.core.inputs;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link InputSourceConfigurationIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code InputSourceConfiguration.builder()}.
 */
@Generated(from = "InputSourceConfigurationIF", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class InputSourceConfiguration
    implements InputSourceConfigurationIF {
  private final List<InputSource> inputSources;

  private InputSourceConfiguration(List<InputSource> inputSources) {
    this.inputSources = inputSources;
  }

  /**
   * @return The value of the {@code inputSources} attribute
   */
  @JsonProperty
  @Override
  public List<InputSource> getInputSources() {
    return inputSources;
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link InputSourceConfigurationIF#getInputSources() inputSources}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final InputSourceConfiguration withInputSources(InputSource... elements) {
    List<InputSource> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new InputSourceConfiguration(newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link InputSourceConfigurationIF#getInputSources() inputSources}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of inputSources elements to set
   * @return A modified copy of {@code this} object
   */
  public final InputSourceConfiguration withInputSources(Iterable<? extends InputSource> elements) {
    if (this.inputSources == elements) return this;
    List<InputSource> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return new InputSourceConfiguration(newValue);
  }

  /**
   * This instance is equal to all instances of {@code InputSourceConfiguration} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof InputSourceConfiguration
        && equalTo((InputSourceConfiguration) another);
  }

  private boolean equalTo(InputSourceConfiguration another) {
    return inputSources.equals(another.inputSources);
  }

  /**
   * Computes a hash code from attributes: {@code inputSources}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + inputSources.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code InputSourceConfiguration} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "InputSourceConfiguration{"
        + "inputSources=" + inputSources
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "InputSourceConfigurationIF", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements InputSourceConfigurationIF {
    @Nullable List<InputSource> inputSources = Collections.emptyList();
    @JsonProperty
    public void setInputSources(List<InputSource> inputSources) {
      this.inputSources = inputSources;
    }
    @Override
    public List<InputSource> getInputSources() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static InputSourceConfiguration fromJson(Json json) {
    InputSourceConfiguration.Builder builder = InputSourceConfiguration.builder();
    if (json.inputSources != null) {
      builder.addAllInputSources(json.inputSources);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link InputSourceConfigurationIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable InputSourceConfiguration instance
   */
  public static InputSourceConfiguration copyOf(InputSourceConfigurationIF instance) {
    if (instance instanceof InputSourceConfiguration) {
      return (InputSourceConfiguration) instance;
    }
    return InputSourceConfiguration.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link InputSourceConfiguration InputSourceConfiguration}.
   * <pre>
   * InputSourceConfiguration.builder()
   *    .addInputSources|addAllInputSources(com.nirrattner.pitch.core.inputs.InputSource) // {@link InputSourceConfigurationIF#getInputSources() inputSources} elements
   *    .build();
   * </pre>
   * @return A new InputSourceConfiguration builder
   */
  public static InputSourceConfiguration.Builder builder() {
    return new InputSourceConfiguration.Builder();
  }

  /**
   * Builds instances of type {@link InputSourceConfiguration InputSourceConfiguration}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "InputSourceConfigurationIF", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private List<InputSource> inputSources = new ArrayList<InputSource>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code InputSourceConfigurationIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(InputSourceConfigurationIF instance) {
      Objects.requireNonNull(instance, "instance");
      addAllInputSources(instance.getInputSources());
      return this;
    }

    /**
     * Adds one element to {@link InputSourceConfigurationIF#getInputSources() inputSources} list.
     * @param element A inputSources element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addInputSources(InputSource element) {
      this.inputSources.add(Objects.requireNonNull(element, "inputSources element"));
      return this;
    }

    /**
     * Adds elements to {@link InputSourceConfigurationIF#getInputSources() inputSources} list.
     * @param elements An array of inputSources elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addInputSources(InputSource... elements) {
      for (InputSource element : elements) {
        this.inputSources.add(Objects.requireNonNull(element, "inputSources element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link InputSourceConfigurationIF#getInputSources() inputSources} list.
     * @param elements An iterable of inputSources elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setInputSources(Iterable<? extends InputSource> elements) {
      this.inputSources.clear();
      return addAllInputSources(elements);
    }

    /**
     * Adds elements to {@link InputSourceConfigurationIF#getInputSources() inputSources} list.
     * @param elements An iterable of inputSources elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllInputSources(Iterable<? extends InputSource> elements) {
      for (InputSource element : elements) {
        this.inputSources.add(Objects.requireNonNull(element, "inputSources element"));
      }
      return this;
    }

    /**
     * Builds a new {@link InputSourceConfiguration InputSourceConfiguration}.
     * @return An immutable instance of InputSourceConfiguration
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public InputSourceConfiguration build() {
      return new InputSourceConfiguration(createUnmodifiableList(true, inputSources));
    }
  }

  private static <T> List<T> createSafeList(Iterable<? extends T> iterable, boolean checkNulls, boolean skipNulls) {
    ArrayList<T> list;
    if (iterable instanceof Collection<?>) {
      int size = ((Collection<?>) iterable).size();
      if (size == 0) return Collections.emptyList();
      list = new ArrayList<>();
    } else {
      list = new ArrayList<>();
    }
    for (T element : iterable) {
      if (skipNulls && element == null) continue;
      if (checkNulls) Objects.requireNonNull(element, "element");
      list.add(element);
    }
    return list;
  }

  private static <T> List<T> createUnmodifiableList(boolean clone, List<T> list) {
    switch(list.size()) {
    case 0: return Collections.emptyList();
    case 1: return Collections.singletonList(list.get(0));
    default:
      if (clone) {
        return Collections.unmodifiableList(new ArrayList<>(list));
      } else {
        if (list instanceof ArrayList<?>) {
          ((ArrayList<?>) list).trimToSize();
        }
        return Collections.unmodifiableList(list);
      }
    }
  }
}
