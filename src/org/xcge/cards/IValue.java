package org.xcge.cards;

/**
 * All values implement this interface.  It ensures that we can get a normal and short String representation of the value.
 */
public interface IValue
{
  /**
   * Return a string representation of this value (ie: "2", "10", or "King").
   */
  public String toString();
  
  /**
   * Return a shorter string representation of this value (ie: "2", "10", or "K").
   * Because of the ten, Jack, and Joker, it lets the user decide whether to left-pad the result so things will line up more nicely.
   */
  public String toShortString(final boolean p_bLeftPad);
}

