package org.xcge.cards;

/**
 * The Card class is a representation of a basic playing card.  It is extensible for the purpose of, for example, storing an image.
 */
public class Card
{
  private ValueEnum m_eValue;
  private SuitEnum  m_eSuit;

  /**
   *  The default constructor takes as parameters the suit and rank of the card.
   */  
  final Card(final SuitEnum p_eSuit, final ValueEnum p_eValue)
  {
    m_eSuit = p_eSuit;
    m_eValue = p_eValue;
  }
  
  final Card(final Card p_oCard)
  {
    m_eValue = p_oCard.m_eValue;
    m_eSuit = p_oCard.m_eSuit;
  }
  
  /**
   * Get the card's suit
   */
  public final SuitEnum getSuit()
  {
    return m_eSuit;
  }
  
  /**
   * Get the card's rank.
   */
  public final ValueEnum getValue()
  {
    return m_eValue;
  }
  
  /**
   * Get a String representation of this card.
   */
  public String toString()
  {
    return new StringBuffer(m_eValue.toString())
                    .append(" of ")
                    .append(m_eSuit.toString()).toString();
  }
  
  /**
   * Get a short, normalized String representation of this card.
   */
  public String toShortString(final boolean p_bPad)
  {
    return new StringBuffer(m_eValue.toShortString(p_bPad))
                    .append(" of ")
                    .append(m_eSuit.toShortString());
  }
}
