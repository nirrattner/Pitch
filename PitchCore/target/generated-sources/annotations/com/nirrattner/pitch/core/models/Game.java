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
 * Immutable implementation of {@link GameIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code Game.builder()}.
 */
@Generated(from = "GameIF", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class Game implements GameIF {
  private final int bid;
  private final int bidWinner;
  private final InputType inputType;
  private final List<Player> players;
  private final int playerDealer;
  private final int playerTurn;
  private final @Nullable Integer playerWinner;
  private final int round;
  private final List<Card> trickCards;
  private final int trickLeader;
  private final @Nullable Suit trumpSuit;
  private final @Nullable Integer trickWinner;
  private transient final Optional<Suit> trickSuit;

  private Game(
      int bid,
      int bidWinner,
      InputType inputType,
      List<Player> players,
      int playerDealer,
      int playerTurn,
      @Nullable Integer playerWinner,
      int round,
      List<Card> trickCards,
      int trickLeader,
      @Nullable Suit trumpSuit,
      @Nullable Integer trickWinner) {
    this.bid = bid;
    this.bidWinner = bidWinner;
    this.inputType = inputType;
    this.players = players;
    this.playerDealer = playerDealer;
    this.playerTurn = playerTurn;
    this.playerWinner = playerWinner;
    this.round = round;
    this.trickCards = trickCards;
    this.trickLeader = trickLeader;
    this.trumpSuit = trumpSuit;
    this.trickWinner = trickWinner;
    this.trickSuit = Objects.requireNonNull(GameIF.super.getTrickSuit(), "trickSuit");
  }

  /**
   * @return The value of the {@code bid} attribute
   */
  @JsonProperty
  @Override
  public int getBid() {
    return bid;
  }

  /**
   * @return The value of the {@code bidWinner} attribute
   */
  @JsonProperty
  @Override
  public int getBidWinner() {
    return bidWinner;
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
   * @return The value of the {@code players} attribute
   */
  @JsonProperty
  @Override
  public List<Player> getPlayers() {
    return players;
  }

  /**
   * @return The value of the {@code playerDealer} attribute
   */
  @JsonProperty
  @Override
  public int getPlayerDealer() {
    return playerDealer;
  }

  /**
   * @return The value of the {@code playerTurn} attribute
   */
  @JsonProperty
  @Override
  public int getPlayerTurn() {
    return playerTurn;
  }

  /**
   * @return The value of the {@code playerWinner} attribute
   */
  @JsonProperty
  @Override
  public Optional<Integer> getPlayerWinner() {
    return Optional.ofNullable(playerWinner);
  }

  /**
   * @return The value of the {@code round} attribute
   */
  @JsonProperty
  @Override
  public int getRound() {
    return round;
  }

  /**
   * @return The value of the {@code trickCards} attribute
   */
  @JsonProperty
  @Override
  public List<Card> getTrickCards() {
    return trickCards;
  }

  /**
   * @return The value of the {@code trickLeader} attribute
   */
  @JsonProperty
  @Override
  public int getTrickLeader() {
    return trickLeader;
  }

  /**
   * @return The value of the {@code trumpSuit} attribute
   */
  @JsonProperty
  @Override
  public Optional<Suit> getTrumpSuit() {
    return Optional.ofNullable(trumpSuit);
  }

  /**
   * @return The value of the {@code trickWinner} attribute
   */
  @JsonProperty
  @Override
  public Optional<Integer> getTrickWinner() {
    return Optional.ofNullable(trickWinner);
  }

  /**
   * @return The computed-at-construction value of the {@code trickSuit} attribute
   */
  @JsonProperty
  @Override
  public Optional<Suit> getTrickSuit() {
    return trickSuit;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link GameIF#getBid() bid} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for bid
   * @return A modified copy of the {@code this} object
   */
  public final Game withBid(int value) {
    if (this.bid == value) return this;
    return validate(new Game(
        value,
        this.bidWinner,
        this.inputType,
        this.players,
        this.playerDealer,
        this.playerTurn,
        this.playerWinner,
        this.round,
        this.trickCards,
        this.trickLeader,
        this.trumpSuit,
        this.trickWinner));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link GameIF#getBidWinner() bidWinner} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for bidWinner
   * @return A modified copy of the {@code this} object
   */
  public final Game withBidWinner(int value) {
    if (this.bidWinner == value) return this;
    return validate(new Game(
        this.bid,
        value,
        this.inputType,
        this.players,
        this.playerDealer,
        this.playerTurn,
        this.playerWinner,
        this.round,
        this.trickCards,
        this.trickLeader,
        this.trumpSuit,
        this.trickWinner));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link GameIF#getInputType() inputType} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for inputType
   * @return A modified copy of the {@code this} object
   */
  public final Game withInputType(InputType value) {
    if (this.inputType == value) return this;
    InputType newValue = Objects.requireNonNull(value, "inputType");
    if (this.inputType.equals(newValue)) return this;
    return validate(new Game(
        this.bid,
        this.bidWinner,
        newValue,
        this.players,
        this.playerDealer,
        this.playerTurn,
        this.playerWinner,
        this.round,
        this.trickCards,
        this.trickLeader,
        this.trumpSuit,
        this.trickWinner));
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link GameIF#getPlayers() players}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final Game withPlayers(Player... elements) {
    List<Player> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return validate(new Game(
        this.bid,
        this.bidWinner,
        this.inputType,
        newValue,
        this.playerDealer,
        this.playerTurn,
        this.playerWinner,
        this.round,
        this.trickCards,
        this.trickLeader,
        this.trumpSuit,
        this.trickWinner));
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link GameIF#getPlayers() players}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of players elements to set
   * @return A modified copy of {@code this} object
   */
  public final Game withPlayers(Iterable<? extends Player> elements) {
    if (this.players == elements) return this;
    List<Player> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return validate(new Game(
        this.bid,
        this.bidWinner,
        this.inputType,
        newValue,
        this.playerDealer,
        this.playerTurn,
        this.playerWinner,
        this.round,
        this.trickCards,
        this.trickLeader,
        this.trumpSuit,
        this.trickWinner));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link GameIF#getPlayerDealer() playerDealer} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for playerDealer
   * @return A modified copy of the {@code this} object
   */
  public final Game withPlayerDealer(int value) {
    if (this.playerDealer == value) return this;
    return validate(new Game(
        this.bid,
        this.bidWinner,
        this.inputType,
        this.players,
        value,
        this.playerTurn,
        this.playerWinner,
        this.round,
        this.trickCards,
        this.trickLeader,
        this.trumpSuit,
        this.trickWinner));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link GameIF#getPlayerTurn() playerTurn} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for playerTurn
   * @return A modified copy of the {@code this} object
   */
  public final Game withPlayerTurn(int value) {
    if (this.playerTurn == value) return this;
    return validate(new Game(
        this.bid,
        this.bidWinner,
        this.inputType,
        this.players,
        this.playerDealer,
        value,
        this.playerWinner,
        this.round,
        this.trickCards,
        this.trickLeader,
        this.trumpSuit,
        this.trickWinner));
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link GameIF#getPlayerWinner() playerWinner} attribute.
   * @param value The value for playerWinner, {@code null} is accepted as {@code java.util.Optional.empty()}
   * @return A modified copy of {@code this} object
   */
  public final Game withPlayerWinner(@Nullable Integer value) {
    @Nullable Integer newValue = value;
    if (Objects.equals(this.playerWinner, newValue)) return this;
    return validate(new Game(
        this.bid,
        this.bidWinner,
        this.inputType,
        this.players,
        this.playerDealer,
        this.playerTurn,
        newValue,
        this.round,
        this.trickCards,
        this.trickLeader,
        this.trumpSuit,
        this.trickWinner));
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link GameIF#getPlayerWinner() playerWinner} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for playerWinner
   * @return A modified copy of {@code this} object
   */
  public final Game withPlayerWinner(Optional<Integer> optional) {
    @Nullable Integer value = optional.orElse(null);
    if (Objects.equals(this.playerWinner, value)) return this;
    return validate(new Game(
        this.bid,
        this.bidWinner,
        this.inputType,
        this.players,
        this.playerDealer,
        this.playerTurn,
        value,
        this.round,
        this.trickCards,
        this.trickLeader,
        this.trumpSuit,
        this.trickWinner));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link GameIF#getRound() round} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for round
   * @return A modified copy of the {@code this} object
   */
  public final Game withRound(int value) {
    if (this.round == value) return this;
    return validate(new Game(
        this.bid,
        this.bidWinner,
        this.inputType,
        this.players,
        this.playerDealer,
        this.playerTurn,
        this.playerWinner,
        value,
        this.trickCards,
        this.trickLeader,
        this.trumpSuit,
        this.trickWinner));
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link GameIF#getTrickCards() trickCards}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final Game withTrickCards(Card... elements) {
    List<Card> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return validate(new Game(
        this.bid,
        this.bidWinner,
        this.inputType,
        this.players,
        this.playerDealer,
        this.playerTurn,
        this.playerWinner,
        this.round,
        newValue,
        this.trickLeader,
        this.trumpSuit,
        this.trickWinner));
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link GameIF#getTrickCards() trickCards}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of trickCards elements to set
   * @return A modified copy of {@code this} object
   */
  public final Game withTrickCards(Iterable<? extends Card> elements) {
    if (this.trickCards == elements) return this;
    List<Card> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return validate(new Game(
        this.bid,
        this.bidWinner,
        this.inputType,
        this.players,
        this.playerDealer,
        this.playerTurn,
        this.playerWinner,
        this.round,
        newValue,
        this.trickLeader,
        this.trumpSuit,
        this.trickWinner));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link GameIF#getTrickLeader() trickLeader} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for trickLeader
   * @return A modified copy of the {@code this} object
   */
  public final Game withTrickLeader(int value) {
    if (this.trickLeader == value) return this;
    return validate(new Game(
        this.bid,
        this.bidWinner,
        this.inputType,
        this.players,
        this.playerDealer,
        this.playerTurn,
        this.playerWinner,
        this.round,
        this.trickCards,
        value,
        this.trumpSuit,
        this.trickWinner));
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link GameIF#getTrumpSuit() trumpSuit} attribute.
   * @param value The value for trumpSuit, {@code null} is accepted as {@code java.util.Optional.empty()}
   * @return A modified copy of {@code this} object
   */
  public final Game withTrumpSuit(@Nullable Suit value) {
    @Nullable Suit newValue = value;
    if (this.trumpSuit == newValue) return this;
    return validate(new Game(
        this.bid,
        this.bidWinner,
        this.inputType,
        this.players,
        this.playerDealer,
        this.playerTurn,
        this.playerWinner,
        this.round,
        this.trickCards,
        this.trickLeader,
        newValue,
        this.trickWinner));
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link GameIF#getTrumpSuit() trumpSuit} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for trumpSuit
   * @return A modified copy of {@code this} object
   */
  @SuppressWarnings("unchecked") // safe covariant cast
  public final Game withTrumpSuit(Optional<? extends Suit> optional) {
    @Nullable Suit value = optional.orElse(null);
    if (Objects.equals(this.trumpSuit, value)) return this;
    return validate(new Game(
        this.bid,
        this.bidWinner,
        this.inputType,
        this.players,
        this.playerDealer,
        this.playerTurn,
        this.playerWinner,
        this.round,
        this.trickCards,
        this.trickLeader,
        value,
        this.trickWinner));
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link GameIF#getTrickWinner() trickWinner} attribute.
   * @param value The value for trickWinner, {@code null} is accepted as {@code java.util.Optional.empty()}
   * @return A modified copy of {@code this} object
   */
  public final Game withTrickWinner(@Nullable Integer value) {
    @Nullable Integer newValue = value;
    if (Objects.equals(this.trickWinner, newValue)) return this;
    return validate(new Game(
        this.bid,
        this.bidWinner,
        this.inputType,
        this.players,
        this.playerDealer,
        this.playerTurn,
        this.playerWinner,
        this.round,
        this.trickCards,
        this.trickLeader,
        this.trumpSuit,
        newValue));
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link GameIF#getTrickWinner() trickWinner} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for trickWinner
   * @return A modified copy of {@code this} object
   */
  public final Game withTrickWinner(Optional<Integer> optional) {
    @Nullable Integer value = optional.orElse(null);
    if (Objects.equals(this.trickWinner, value)) return this;
    return validate(new Game(
        this.bid,
        this.bidWinner,
        this.inputType,
        this.players,
        this.playerDealer,
        this.playerTurn,
        this.playerWinner,
        this.round,
        this.trickCards,
        this.trickLeader,
        this.trumpSuit,
        value));
  }

  /**
   * This instance is equal to all instances of {@code Game} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof Game
        && equalTo((Game) another);
  }

  private boolean equalTo(Game another) {
    return bid == another.bid
        && bidWinner == another.bidWinner
        && inputType.equals(another.inputType)
        && players.equals(another.players)
        && playerDealer == another.playerDealer
        && playerTurn == another.playerTurn
        && Objects.equals(playerWinner, another.playerWinner)
        && round == another.round
        && trickCards.equals(another.trickCards)
        && trickLeader == another.trickLeader
        && Objects.equals(trumpSuit, another.trumpSuit)
        && Objects.equals(trickWinner, another.trickWinner)
        && trickSuit.equals(another.trickSuit);
  }

  /**
   * Computes a hash code from attributes: {@code bid}, {@code bidWinner}, {@code inputType}, {@code players}, {@code playerDealer}, {@code playerTurn}, {@code playerWinner}, {@code round}, {@code trickCards}, {@code trickLeader}, {@code trumpSuit}, {@code trickWinner}, {@code trickSuit}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + bid;
    h += (h << 5) + bidWinner;
    h += (h << 5) + inputType.hashCode();
    h += (h << 5) + players.hashCode();
    h += (h << 5) + playerDealer;
    h += (h << 5) + playerTurn;
    h += (h << 5) + Objects.hashCode(playerWinner);
    h += (h << 5) + round;
    h += (h << 5) + trickCards.hashCode();
    h += (h << 5) + trickLeader;
    h += (h << 5) + Objects.hashCode(trumpSuit);
    h += (h << 5) + Objects.hashCode(trickWinner);
    h += (h << 5) + trickSuit.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Game} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("Game{");
    builder.append("bid=").append(bid);
    builder.append(", ");
    builder.append("bidWinner=").append(bidWinner);
    builder.append(", ");
    builder.append("inputType=").append(inputType);
    builder.append(", ");
    builder.append("players=").append(players);
    builder.append(", ");
    builder.append("playerDealer=").append(playerDealer);
    builder.append(", ");
    builder.append("playerTurn=").append(playerTurn);
    if (playerWinner != null) {
      builder.append(", ");
      builder.append("playerWinner=").append(playerWinner);
    }
    builder.append(", ");
    builder.append("round=").append(round);
    builder.append(", ");
    builder.append("trickCards=").append(trickCards);
    builder.append(", ");
    builder.append("trickLeader=").append(trickLeader);
    if (trumpSuit != null) {
      builder.append(", ");
      builder.append("trumpSuit=").append(trumpSuit);
    }
    if (trickWinner != null) {
      builder.append(", ");
      builder.append("trickWinner=").append(trickWinner);
    }
    builder.append(", ");
    builder.append("trickSuit=").append(trickSuit);
    return builder.append("}").toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "GameIF", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements GameIF {
    int bid;
    boolean bidIsSet;
    int bidWinner;
    boolean bidWinnerIsSet;
    @Nullable InputType inputType;
    @Nullable List<Player> players = Collections.emptyList();
    int playerDealer;
    boolean playerDealerIsSet;
    int playerTurn;
    boolean playerTurnIsSet;
    @Nullable Optional<Integer> playerWinner = Optional.empty();
    int round;
    boolean roundIsSet;
    @Nullable List<Card> trickCards = Collections.emptyList();
    int trickLeader;
    boolean trickLeaderIsSet;
    @Nullable Optional<Suit> trumpSuit = Optional.empty();
    @Nullable Optional<Integer> trickWinner = Optional.empty();
    @JsonProperty
    public void setBid(int bid) {
      this.bid = bid;
      this.bidIsSet = true;
    }
    @JsonProperty
    public void setBidWinner(int bidWinner) {
      this.bidWinner = bidWinner;
      this.bidWinnerIsSet = true;
    }
    @JsonProperty
    public void setInputType(InputType inputType) {
      this.inputType = inputType;
    }
    @JsonProperty
    public void setPlayers(List<Player> players) {
      this.players = players;
    }
    @JsonProperty
    public void setPlayerDealer(int playerDealer) {
      this.playerDealer = playerDealer;
      this.playerDealerIsSet = true;
    }
    @JsonProperty
    public void setPlayerTurn(int playerTurn) {
      this.playerTurn = playerTurn;
      this.playerTurnIsSet = true;
    }
    @JsonProperty
    public void setPlayerWinner(Optional<Integer> playerWinner) {
      this.playerWinner = playerWinner;
    }
    @JsonProperty
    public void setRound(int round) {
      this.round = round;
      this.roundIsSet = true;
    }
    @JsonProperty
    public void setTrickCards(List<Card> trickCards) {
      this.trickCards = trickCards;
    }
    @JsonProperty
    public void setTrickLeader(int trickLeader) {
      this.trickLeader = trickLeader;
      this.trickLeaderIsSet = true;
    }
    @JsonProperty
    public void setTrumpSuit(Optional<Suit> trumpSuit) {
      this.trumpSuit = trumpSuit;
    }
    @JsonProperty
    public void setTrickWinner(Optional<Integer> trickWinner) {
      this.trickWinner = trickWinner;
    }
    @Override
    public int getBid() { throw new UnsupportedOperationException(); }
    @Override
    public int getBidWinner() { throw new UnsupportedOperationException(); }
    @Override
    public InputType getInputType() { throw new UnsupportedOperationException(); }
    @Override
    public List<Player> getPlayers() { throw new UnsupportedOperationException(); }
    @Override
    public int getPlayerDealer() { throw new UnsupportedOperationException(); }
    @Override
    public int getPlayerTurn() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<Integer> getPlayerWinner() { throw new UnsupportedOperationException(); }
    @Override
    public int getRound() { throw new UnsupportedOperationException(); }
    @Override
    public List<Card> getTrickCards() { throw new UnsupportedOperationException(); }
    @Override
    public int getTrickLeader() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<Suit> getTrumpSuit() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<Integer> getTrickWinner() { throw new UnsupportedOperationException(); }
    @JsonIgnore
    @Override
    public Optional<Suit> getTrickSuit() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static Game fromJson(Json json) {
    Game.Builder builder = Game.builder();
    if (json.bidIsSet) {
      builder.setBid(json.bid);
    }
    if (json.bidWinnerIsSet) {
      builder.setBidWinner(json.bidWinner);
    }
    if (json.inputType != null) {
      builder.setInputType(json.inputType);
    }
    if (json.players != null) {
      builder.addAllPlayers(json.players);
    }
    if (json.playerDealerIsSet) {
      builder.setPlayerDealer(json.playerDealer);
    }
    if (json.playerTurnIsSet) {
      builder.setPlayerTurn(json.playerTurn);
    }
    if (json.playerWinner != null) {
      builder.setPlayerWinner(json.playerWinner);
    }
    if (json.roundIsSet) {
      builder.setRound(json.round);
    }
    if (json.trickCards != null) {
      builder.addAllTrickCards(json.trickCards);
    }
    if (json.trickLeaderIsSet) {
      builder.setTrickLeader(json.trickLeader);
    }
    if (json.trumpSuit != null) {
      builder.setTrumpSuit(json.trumpSuit);
    }
    if (json.trickWinner != null) {
      builder.setTrickWinner(json.trickWinner);
    }
    return builder.build();
  }

  private static Game validate(Game instance) {
    instance.check();
    return instance;
  }

  /**
   * Creates an immutable copy of a {@link GameIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Game instance
   */
  public static Game copyOf(GameIF instance) {
    if (instance instanceof Game) {
      return (Game) instance;
    }
    return Game.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link Game Game}.
   * <pre>
   * Game.builder()
   *    .setBid(int) // required {@link GameIF#getBid() bid}
   *    .setBidWinner(int) // required {@link GameIF#getBidWinner() bidWinner}
   *    .setInputType(com.nirrattner.pitch.core.models.InputType) // required {@link GameIF#getInputType() inputType}
   *    .addPlayers|addAllPlayers(com.nirrattner.pitch.core.models.Player) // {@link GameIF#getPlayers() players} elements
   *    .setPlayerDealer(int) // required {@link GameIF#getPlayerDealer() playerDealer}
   *    .setPlayerTurn(int) // required {@link GameIF#getPlayerTurn() playerTurn}
   *    .setPlayerWinner(Integer) // optional {@link GameIF#getPlayerWinner() playerWinner}
   *    .setRound(int) // required {@link GameIF#getRound() round}
   *    .addTrickCards|addAllTrickCards(com.nirrattner.pitch.core.models.Card) // {@link GameIF#getTrickCards() trickCards} elements
   *    .setTrickLeader(int) // required {@link GameIF#getTrickLeader() trickLeader}
   *    .setTrumpSuit(com.nirrattner.pitch.core.models.Suit) // optional {@link GameIF#getTrumpSuit() trumpSuit}
   *    .setTrickWinner(Integer) // optional {@link GameIF#getTrickWinner() trickWinner}
   *    .build();
   * </pre>
   * @return A new Game builder
   */
  public static Game.Builder builder() {
    return new Game.Builder();
  }

  /**
   * Builds instances of type {@link Game Game}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "GameIF", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_BID = 0x1L;
    private static final long INIT_BIT_BID_WINNER = 0x2L;
    private static final long INIT_BIT_INPUT_TYPE = 0x4L;
    private static final long INIT_BIT_PLAYER_DEALER = 0x8L;
    private static final long INIT_BIT_PLAYER_TURN = 0x10L;
    private static final long INIT_BIT_ROUND = 0x20L;
    private static final long INIT_BIT_TRICK_LEADER = 0x40L;
    private long initBits = 0x7fL;

    private int bid;
    private int bidWinner;
    private @Nullable InputType inputType;
    private List<Player> players = new ArrayList<Player>();
    private int playerDealer;
    private int playerTurn;
    private @Nullable Integer playerWinner;
    private int round;
    private List<Card> trickCards = new ArrayList<Card>();
    private int trickLeader;
    private @Nullable Suit trumpSuit;
    private @Nullable Integer trickWinner;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code GameIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(GameIF instance) {
      Objects.requireNonNull(instance, "instance");
      setBid(instance.getBid());
      setBidWinner(instance.getBidWinner());
      setInputType(instance.getInputType());
      addAllPlayers(instance.getPlayers());
      setPlayerDealer(instance.getPlayerDealer());
      setPlayerTurn(instance.getPlayerTurn());
      Optional<Integer> playerWinnerOptional = instance.getPlayerWinner();
      if (playerWinnerOptional.isPresent()) {
        setPlayerWinner(playerWinnerOptional);
      }
      setRound(instance.getRound());
      addAllTrickCards(instance.getTrickCards());
      setTrickLeader(instance.getTrickLeader());
      Optional<Suit> trumpSuitOptional = instance.getTrumpSuit();
      if (trumpSuitOptional.isPresent()) {
        setTrumpSuit(trumpSuitOptional);
      }
      Optional<Integer> trickWinnerOptional = instance.getTrickWinner();
      if (trickWinnerOptional.isPresent()) {
        setTrickWinner(trickWinnerOptional);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link GameIF#getBid() bid} attribute.
     * @param bid The value for bid 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setBid(int bid) {
      this.bid = bid;
      initBits &= ~INIT_BIT_BID;
      return this;
    }

    /**
     * Initializes the value for the {@link GameIF#getBidWinner() bidWinner} attribute.
     * @param bidWinner The value for bidWinner 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setBidWinner(int bidWinner) {
      this.bidWinner = bidWinner;
      initBits &= ~INIT_BIT_BID_WINNER;
      return this;
    }

    /**
     * Initializes the value for the {@link GameIF#getInputType() inputType} attribute.
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
     * Adds one element to {@link GameIF#getPlayers() players} list.
     * @param element A players element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addPlayers(Player element) {
      this.players.add(Objects.requireNonNull(element, "players element"));
      return this;
    }

    /**
     * Adds elements to {@link GameIF#getPlayers() players} list.
     * @param elements An array of players elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addPlayers(Player... elements) {
      for (Player element : elements) {
        this.players.add(Objects.requireNonNull(element, "players element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link GameIF#getPlayers() players} list.
     * @param elements An iterable of players elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setPlayers(Iterable<? extends Player> elements) {
      this.players.clear();
      return addAllPlayers(elements);
    }

    /**
     * Adds elements to {@link GameIF#getPlayers() players} list.
     * @param elements An iterable of players elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllPlayers(Iterable<? extends Player> elements) {
      for (Player element : elements) {
        this.players.add(Objects.requireNonNull(element, "players element"));
      }
      return this;
    }

    /**
     * Initializes the value for the {@link GameIF#getPlayerDealer() playerDealer} attribute.
     * @param playerDealer The value for playerDealer 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setPlayerDealer(int playerDealer) {
      this.playerDealer = playerDealer;
      initBits &= ~INIT_BIT_PLAYER_DEALER;
      return this;
    }

    /**
     * Initializes the value for the {@link GameIF#getPlayerTurn() playerTurn} attribute.
     * @param playerTurn The value for playerTurn 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setPlayerTurn(int playerTurn) {
      this.playerTurn = playerTurn;
      initBits &= ~INIT_BIT_PLAYER_TURN;
      return this;
    }

    /**
     * Initializes the optional value {@link GameIF#getPlayerWinner() playerWinner} to playerWinner.
     * @param playerWinner The value for playerWinner, {@code null} is accepted as {@code java.util.Optional.empty()}
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setPlayerWinner(@Nullable Integer playerWinner) {
      this.playerWinner = playerWinner;
      return this;
    }

    /**
     * Initializes the optional value {@link GameIF#getPlayerWinner() playerWinner} to playerWinner.
     * @param playerWinner The value for playerWinner
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setPlayerWinner(Optional<Integer> playerWinner) {
      this.playerWinner = playerWinner.orElse(null);
      return this;
    }

    /**
     * Initializes the value for the {@link GameIF#getRound() round} attribute.
     * @param round The value for round 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setRound(int round) {
      this.round = round;
      initBits &= ~INIT_BIT_ROUND;
      return this;
    }

    /**
     * Adds one element to {@link GameIF#getTrickCards() trickCards} list.
     * @param element A trickCards element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addTrickCards(Card element) {
      this.trickCards.add(Objects.requireNonNull(element, "trickCards element"));
      return this;
    }

    /**
     * Adds elements to {@link GameIF#getTrickCards() trickCards} list.
     * @param elements An array of trickCards elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addTrickCards(Card... elements) {
      for (Card element : elements) {
        this.trickCards.add(Objects.requireNonNull(element, "trickCards element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link GameIF#getTrickCards() trickCards} list.
     * @param elements An iterable of trickCards elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setTrickCards(Iterable<? extends Card> elements) {
      this.trickCards.clear();
      return addAllTrickCards(elements);
    }

    /**
     * Adds elements to {@link GameIF#getTrickCards() trickCards} list.
     * @param elements An iterable of trickCards elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllTrickCards(Iterable<? extends Card> elements) {
      for (Card element : elements) {
        this.trickCards.add(Objects.requireNonNull(element, "trickCards element"));
      }
      return this;
    }

    /**
     * Initializes the value for the {@link GameIF#getTrickLeader() trickLeader} attribute.
     * @param trickLeader The value for trickLeader 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setTrickLeader(int trickLeader) {
      this.trickLeader = trickLeader;
      initBits &= ~INIT_BIT_TRICK_LEADER;
      return this;
    }

    /**
     * Initializes the optional value {@link GameIF#getTrumpSuit() trumpSuit} to trumpSuit.
     * @param trumpSuit The value for trumpSuit, {@code null} is accepted as {@code java.util.Optional.empty()}
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setTrumpSuit(@Nullable Suit trumpSuit) {
      this.trumpSuit = trumpSuit;
      return this;
    }

    /**
     * Initializes the optional value {@link GameIF#getTrumpSuit() trumpSuit} to trumpSuit.
     * @param trumpSuit The value for trumpSuit
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setTrumpSuit(Optional<? extends Suit> trumpSuit) {
      this.trumpSuit = trumpSuit.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link GameIF#getTrickWinner() trickWinner} to trickWinner.
     * @param trickWinner The value for trickWinner, {@code null} is accepted as {@code java.util.Optional.empty()}
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setTrickWinner(@Nullable Integer trickWinner) {
      this.trickWinner = trickWinner;
      return this;
    }

    /**
     * Initializes the optional value {@link GameIF#getTrickWinner() trickWinner} to trickWinner.
     * @param trickWinner The value for trickWinner
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder setTrickWinner(Optional<Integer> trickWinner) {
      this.trickWinner = trickWinner.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link Game Game}.
     * @return An immutable instance of Game
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public Game build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return Game.validate(new Game(
          bid,
          bidWinner,
          inputType,
          createUnmodifiableList(true, players),
          playerDealer,
          playerTurn,
          playerWinner,
          round,
          createUnmodifiableList(true, trickCards),
          trickLeader,
          trumpSuit,
          trickWinner));
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_BID) != 0) attributes.add("bid");
      if ((initBits & INIT_BIT_BID_WINNER) != 0) attributes.add("bidWinner");
      if ((initBits & INIT_BIT_INPUT_TYPE) != 0) attributes.add("inputType");
      if ((initBits & INIT_BIT_PLAYER_DEALER) != 0) attributes.add("playerDealer");
      if ((initBits & INIT_BIT_PLAYER_TURN) != 0) attributes.add("playerTurn");
      if ((initBits & INIT_BIT_ROUND) != 0) attributes.add("round");
      if ((initBits & INIT_BIT_TRICK_LEADER) != 0) attributes.add("trickLeader");
      return "Cannot build Game, some of required attributes are not set " + attributes;
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
