package org.xcge.cards;

/**
 * All values implement this interface.  It ensures that we can get a normal and short String representation of the suit.
 */
public interface ISuit
{
  /**
   * Return a string representation of this value (ie: "Spade", "Diamond", or "Club").
   */
  public String toString();
  
  /**
   * Return a shorter string representation of this value (ie: "S", "D", or "C").
   */
  public String toShortString();
}

