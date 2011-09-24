package org.xcge.cards;

import java.util.ArrayList;

/**
 * This is a stack, group, or pile of cards.
 * Examples:
 *  Solitaire: The main building piles start all face down, except the top card which is face up.  The suit piles are always face-up.
 *  War: The cards in-hand are a stack, all face down.  They are turned one at a time and placed face-up in front of the player (a separate stack).
 */
public class CardGroup extends ArrayList<StatefulCard>
{
  private static final int UNLIMITED = 0;
  private static final long serialVersionUID = 1L;
  private int m_iCapacity;
  private ArrayList<StatefulCard> m_alCards;
  
  /**
   * 
   * @param p_iCapacity: -1 means unbounded
   */
  public CardGroup(final int p_iCapacity)
  {
    m_iCapacity = p_iCapacity;
    m_alCards = new ArrayList<StatefulCard>(m_iCapacity);
  }
  
  public CardGroup()
  {
    this(UNLIMITED);
  }
  
//  public StatefulCard getTop()
//  {
//    return 
//  }
  
  // Overrides
  @Override
  public int size()
  {
    return m_alCards.size();
  }
  
  @Override
  public boolean isEmpty()
  {
    return m_alCards.isEmpty();
  }
  
  @Override
  public StatefulCard get(final int p_iIndex)
  {
    return m_alCards.get(p_iIndex);
  }
}
