package org.xcge.cards;

/**
 * The Card class is a representation of a basic playing card.  It is extensible for the purpose of, for example, storing an image.
 */
public class BaseCard implements ICard
{
  private ISuit m_iSuit;
  private IRank m_iRank;

  /**
   *  The default constructor takes as parameters the suit and rank of the card.
   */  
  public BaseCard(final ISuit p_iSuit, final IRank p_iRank)
  {
    m_iSuit = p_iSuit;
    m_iRank = p_iRank;
  }
  
  public BaseCard(final ICard p_iCard)
  {
    m_iSuit = p_iCard.getSuit();
    m_iRank = p_iCard.getRank();
  }
  
  /**
   * Get the card's suit
   */
  @Override
  public final ISuit getSuit()
  {
    return m_iSuit;
  }
  
  /**
   * Get the card's rank.
   */
  @Override
  public final IRank getRank()
  {
    return m_iRank;
  }
  
  /**
   * Get a String representation of this card.
   */
  @Override
  public String toString()
  {
    return new StringBuffer(m_iRank.toString())
                    .append(" of ")
                    .append(m_iSuit.toString()).toString();
  }
  
  /**
   * Get a short, normalized String representation of this card.
   */
  @Override
  public String toShortString(final boolean p_bPad)
  {
    return new StringBuffer(m_iRank.toShortString(p_bPad))
                    .append(" of ")
                    .append(m_iSuit.toShortString()).toString();
  }
}
