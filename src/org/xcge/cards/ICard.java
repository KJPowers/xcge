package org.xcge.cards;

/**
 * All cards implement this interface.  It lets you do the basic stuff like get a card's value and print a string of its value.
 */
public interface ICard
{
  /**
   * The default constructor.  Cards can't change their values over time so we must know the suit and value here, and there is no method to set them later.
   */
  public ICard(final SuitEnum p_eSuit, final ValueEnum);
  
  /**
   * Return the suit of this card.
   */
  public SuitEnum getSuit()
  
  /**
   * Return the value of this card.
   */
  public ValueEnum getValue();
  
  /**
   * Return a string representation of this card (ie: "10 of Clubs", "Ace of Spades", or "Jack of Diamonds").
   */
  public String toString();
  
  /**
   * Return a shorter string representation of this card (ie: "10 of C", "A of S", or "J of D").
   * Because of the ten, it lets the user decide whether to left-pad the result so things will line up more nicely.
   */
  public String toShortString(final boolean p_bLeftPad);
}

