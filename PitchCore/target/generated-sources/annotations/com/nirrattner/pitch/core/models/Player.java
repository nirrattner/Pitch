package com.nirrattner.pitch.core.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link PlayerIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code Player.builder()}.
 */
@Generated(from = "PlayerIF", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class Player implements PlayerIF {
  private final int id;
  private final List<Card> hand;
  private final List<Card> winnings;
  private final int score;
  private final @Nullable BidType bid;
  private transient final int gamePoints;

  private Player(
      int id,
      List<Card> hand,
      List<Card> winnings,
      int score,
      @Nullable BidType bid) {
    this.id = id;
    this.hand = hand;
    this.winnings = winnings;
    this.score = score;
    this.bid = bid;
    this.gamePoints = PlayerIF.super.getGamePoints();
  }

  /**
   * @return The value of the {@code id} attribute
   */
  @JsonProperty
  @Override
  public int getId() {
    return id;
  }

  /**
   * @return The value of the {@code hand} attribute
   */
  @JsonProperty
  @Override
  public List<Card> getHand() {
    return hand;
  }

  /**
   * @return The value of the {@code winnings} attribute
   */
  @JsonProperty
  @Override
  public List<Card> getWinnings() {
    return winnings;
  }

  /**
   * @return The value of the {@code score} attribute
   */
  @JsonProperty
  @Override
  public int getScore() {
    return score;
  }

  /**
   * @return The value of the {@code bid} attribute
   */
  @JsonProperty
  @Override
  public Optional<BidType> getBid() {
    return Optional.ofNullable(bid);
  }

  /**
   * @return The computed-at-construction value of the {@code gamePoints} attribute
   */
  @JsonProperty
  @Override
  public int getGamePoints() {
    return gamePoints;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PlayerIF#getId() id} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id
   * @return A modified copy of the {@code this} object
   */
  public final Player withId(int value) {
    if (this.id == value) return this;
    return new Player(value, this.hand, this.winnings, this.score, this.bid);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link PlayerIF#getHand() hand}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final Player withHand(Card... elements) {
    List<Card> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new Player(this.id, newValue, this.winnings, this.score, this.bid);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link PlayerIF#getHand() hand}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of hand elements to set
   * @return A modified copy of {@code this} object
   */
  public final Player withHand(Iterable<? extends Card> elements) {
    if (this.hand == elements) return this;
    List<Card> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return new Player(this.id, newValue, this.winnings, this.score, this.bid);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link PlayerIF#getWinnings() winnings}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final Player withWinnings(Card... elements) {
    List<Card> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new Player(this.id, this.hand, newValue, this.score, this.bid);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link PlayerIF#getWinnings() winnings}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of winnings elements to set
   * @return A modified copy of {@code this} object
   */
  public final Player withWinnings(Iterable<? extends Card> elements) {
    if (this.winnings == elements) return this;
    List<Card> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return new Player(this.id, this.hand, newValue, this.score, this.bid);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PlayerIF#getScore() score} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for score
   * @return A modified copy of the {@code this} object
   */
  public final Player withScore(int value) {
    if (this.score == value) return this;
    return new Player(this.id, this.hand, this.winnings, value, this.bid);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link PlayerIF#getBid() bid} attribute.
   * @param value The value for bid, {@code null} is accepted as {@code java.util.Optional.empty()}
   * @return A modified copy of {@code this} object
   */
  public final Player withBid(@Nullable BidType value) {
    @Nullable BidType newValue = value;
    if (this.bid == newValue) return this;
    return new Player(this.id, this.hand, this.winnings, this.score, newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link PlayerIF#getBid() bid} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for bid
   * @return A modified copy of {@code this} object
   */
  @SuppressWarnings("unchecked") // safe covariant cast
  public final Player withBid(Optional<? extends BidType> optional) {
    @Nullable BidType value = optional.orElse(null);
    if (Objects.equals(this.bid, value)) return this;
    return new Player(this.id, this.hand, this.winnings, this.score, value);
  }

  /**
   * This instance is equal to all instances of {@code Player} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof Player
        && equalTo((Player) another);
  }

  private boolean equalTo(Player another) {
    return id == another.id
        && hand.equals(another.hand)
        && winnings.equals(another.winnings)
        && score == another.score
        && Objects.equals(bid, another.bid)
        && gamePoints == another.gamePoints;
  }

  /**
   * Computes a hash code from attributes: {@code id}, {@code hand}, {@code winnings}, {@code score}, {@code bid}, {@code gamePoints}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + id;
    h += (h << 5) + hand.hashCode();
    h += (h << 5) + winnings.hashCode();
    h += (h << 5) + score;
    h += (h << 5) + Objects.hashCode(bid);
    h += (h << 5) + gamePoints;
    return h;
  }

  /**
   * Prints the immutable value {@code Player} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("Player{");
    builder.append("id=").append(id);
    builder.append(", ");
    builder.append("hand=").append(hand);
    builder.append(", ");
    builder.append("winnings=").append(winnings);
    builder.append(", ");
    builder.append("score=").append(score);
    if (bid != null) {
      builder.append(", ");
      builder.append("bid=").append(bid);
    }
    builder.append(", ");
    builder.append("gamePoints=").append(gamePoints);
    return builder.append("}").toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "PlayerIF", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements PlayerIF {
    int id;
    boolean idIsSet;
    @Nullable List<Card> hand = Collections.emptyList();
    @Nullable List<Card> winnings = Collections.emptyList();
    int score;
    boolean scoreIsSet;
    @Nullable Optional<BidType> bid = Optional.empty();
    @JsonProperty
    public void setId(int id) {
      this.id = id;
      this.idIsSet = true;
    }
    @JsonProperty
    public void setHand(List<Card> hand) {
      this.hand = hand;
    }
    @JsonProperty
    public void setWinnings(List<Card> winnings) {
      this.winnings = winnings;
    }
    @JsonProperty
    public void setScore(int score) {
      this.score = score;
      this.scoreIsSet = true;
    }
    @JsonProperty
    public void setBid(Optional<BidType> bid) {
      this.bid = bid;
    }
    @Override
    public int getId() { throw new UnsupportedOperationException(); }
    @Override
    public List<Card> getHand() { throw new UnsupportedOperationException(); }
    @Override
    public List<Card> getWinnings() { throw new UnsupportedOperationException(); }
    @Override
    public int getScore() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<BidType> getBid() { throw new UnsupportedOperationException(); }
    @JsonIgnore
    @Override
    public int getGamePoints() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static Player fromJson(Json json) {
    Player.Builder builder = Player.builder();
    if (json.idIsSet) {
      builder.setId(json.id);
    }
    if (json.hand != null) {
      builder.addAllHand(json.hand);
    }
    if (json.winnings != null) {
      builder.addAllWinnings(json.winnings);
    }
    if (json.scoreIsSet) {
      builder.setScore(json.score);
    }
    if (json.bid != null) {
      builder.setBid(json.bid);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link PlayerIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Player instance
   */
  public static Player copyOf(PlayerIF instance) {
    if (instance instanceof Player) {
      return (Player) instance;
    }
    return Player.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link Player Player}.
   * <pre>
   * Player.builder()
   *    .setId(int) // required {@link PlayerIF#getId() id}
   *    .addHand|addAllHand(com.nirrattner.pitch.core.models.Card) // {@link PlayerIF#getHand() hand} elements
   *    .addWinnings|addAllWinnings(com.nirrattner.pitch.core.models.Card) // {@link PlayerIF#getWinnings() winnings} elements
   *    .setScore(int) // required {@link PlayerIF#getScore() score}
   *    .setBid(com.nirrattner.pitch.core.models.BidType) // optional {@link PlayerIF#getBid() bid}
   *    .build();
   * </pre>
   * @return A new Player builder
   */
  public static Player.Builder builder() {
    return new Player.Builder();
  }

  /**
   * Builds instances of type {@link Player Player}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "PlayerIF", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ID = 0x1L;
    private static final long INIT_BIT_SCORE = 0x2L;
    private long initBits = 0x3L;

    private int id;
    private List<Card> hand = new ArrayList<Card>();
    private List<Card> winnings = new ArrayList<Card>();
    private int score;
    private @Nullable BidType bid;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code PlayerIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(PlayerIF instance) {
      Objects.requireNonNull(instance, "instance");
      setId(instance.getId());
      addAllHand(instance.getHand());
      addAllWinnings(instance.getWinnings());
      setScore(instance.getScore());
      Optional<BidType> bidOptional = instance.getBid();
      if (bidOptional.isPresent()) {
        setBid(bidOptional);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link PlayerIF#getId() id} attribute.
     * @param id The value for id 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setId(int id) {
      this.id = id;
      initBits &= ~INIT_BIT_ID;
      return this;
    }

    /**
     * Adds one element to {@link PlayerIF#getHand() hand} list.
     * @param element A hand element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addHand(Card element) {
      this.hand.add(Objects.requireNonNull(element, "hand element"));
      return this;
    }

    /**
     * Adds elements to {@link PlayerIF#getHand() hand} list.
     * @param elements An array of hand elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addHand(Card... elements) {
      for (Card element : elements) {
        this.hand.add(Objects.requireNonNull(element, "hand element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link PlayerIF#getHand() hand} list.
     * @param elements An iterable of hand elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setHand(Iterable<? extends Card> elements) {
      this.hand.clear();
      return addAllHand(elements);
    }

    /**
     * Adds elements to {@link PlayerIF#getHand() hand} list.
     * @param elements An iterable of hand elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllHand(Iterable<? extends Card> elements) {
      for (Card element : elements) {
        this.hand.add(Objects.requireNonNull(element, "hand element"));
      }
      return this;
    }

    /**
     * Adds one element to {@link PlayerIF#getWinnings() winnings} list.
     * @param element A winnings element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addWinnings(Card element) {
      this.winnings.add(Objects.requireNonNull(element, "winnings element"));
      return this;
    }

    /**
     * Adds elements to {@link PlayerIF#getWinnings() winnings} list.
     * @param elements An array of winnings elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addWinnings(Card... elements) {
      for (Card element : elements) {
        this.winnings.add(Objects.requireNonNull(element, "winnings element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link PlayerIF#getWinnings() winnings} list.
     * @param elements An iterable of winnings elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setWinnings(Iterable<? extends Card> elements) {
      this.winnings.clear();
      return addAllWinnings(elements);
    }

    /**
     * Adds elements to {@link PlayerIF#getWinnings() winnings} list.
     * @param elements An iterable of winnings elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllWinnings(Iterable<? extends Card> elements) {
      for (Card element : elements) {
        this.winnings.add(Objects.requireNonNull(element, "winnings element"));
      }
      return this;
    }

    /**
     * Initializes the value for the {@link PlayerIF#getScore() score} attribute.
     * @param score The value for score 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setScore(int score) {
      this.score = score;
      initBits &= ~INIT_BIT_SCORE;
      return this;
    }

    /**
     * Initializes the optional value {@link PlayerIF#getBid() bid} to bid.
     * @param bid The value for bid, {@code null} is accepted as {@code java.util.Optional.empty()}
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setBid(@Nullable BidType bid) {
      this.bid = bid;
      return this;
    }

    /**
     * Initializes the optional value {@link PlayerIF#getBid() bid} to bid.
     * @param bid The value for bid
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setBid(Optional<? extends BidType> bid) {
      this.bid = bid.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link Player Player}.
     * @return An immutable instance of Player
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public Player build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new Player(id, createUnmodifiableList(true, hand), createUnmodifiableList(true, winnings), score, bid);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      if ((initBits & INIT_BIT_SCORE) != 0) attributes.add("score");
      return "Cannot build Player, some of required attributes are not set " + attributes;
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
