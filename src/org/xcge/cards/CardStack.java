package org.xcge.cards;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

/**
 * This is a stack, or pile of cards. 
 * Examples:
 *  Solitaire: The main building piles start all face down, except the top card which is face up.  The suit piles are
 *  always face-up.
 *  War: The cards in-hand are a stack, all face down.  They are turned one at a time and placed face-up in front of
 *  the player (a separate stack).
 */
public class CardStack implements Iterable<StatefulCard>
{
  @SuppressWarnings("unused")
  private static final long serialVersionUID = -8899315466153998363L;
  
  // TODO Optimize with a Deque, but then I can't use java.util.Collections to do all its neat stuff.
  /**
   * The entry with index = 0 is at the bottom of the stack. 
   */
  private final List<StatefulCard> m_colCards;
  
  /**
   * 
   */
  public CardStack()
  {
    m_colCards = new LinkedList<StatefulCard>();
  }
  
  /**
   * Convenience method
   * @param p_alCards
   */
  protected CardStack(final List<StatefulCard> p_qCards)
  {
    m_colCards = p_qCards;
  }

  /**
   * Turn over the stack of cards.  Reverse their order and flip their states (face-up -> face-down & vice-versa).
   */
  public void flip()
  {
    Collections.reverse(m_colCards);
    for(StatefulCard oCard : m_colCards)
    {
      oCard.flip();
    }
  }

  /**
   * Print the deck top-to-bottom
   */
  public void printStack(final boolean p_bForceFaceUp)
  {
    reverse();
    for(StatefulCard oCard : m_colCards)
    {
      System.out.println(oCard.toString(p_bForceFaceUp));
    }
    reverse();
  }

  /**
   * Print the deck top-to-bottom
   */
  public void printStackShort(final boolean p_bForceFaceUp)
  {
    reverse();
    for(StatefulCard oCard : m_colCards)
    {
      System.out.println(oCard.toShortString(p_bForceFaceUp));
    }
    reverse();
  }

  /**
   * Set every card to p_eState
   * @param p_eState
   */
  public void setState(final CardStateEnum p_eState)
  {
    for(StatefulCard oCard : m_colCards)
    {
      if(oCard.getState() != p_eState) oCard.setState(p_eState);
    }
  }
  
  /**
   * Convenience method, there is no trivial translation to a real-life stack of cards.
   */
  public void reverse()
  {
    Collections.reverse(m_colCards);
  }
  
  /**
   * Shuffle.
   */
  public void shuffle()
  {
    Collections.shuffle(m_colCards);
  }
  
  /**
   * Look at the top card but don't remove it.
   * @return
   */
  public StatefulCard peekTop()
  {
    return m_colCards.get(m_colCards.size() - 1);
  }
  
  /**
   * Look at the bottom card but don't remove it.  Cheater.
   * @return
   */
  public StatefulCard peekBottom()
  {
    return m_colCards.get(0);
  }
  
  /**
   * Remove the top card from the stack.
   */
  public StatefulCard takeTop()
  {
    StatefulCard oCard = peekTop();
    m_colCards.remove(m_colCards.size() - 1);
    return oCard;
  }
  
  /**
   * Remove the bottom card from the stack.
   * @return
   */
  public StatefulCard takeBottom()
  {
    StatefulCard oCard = peekBottom();
    m_colCards.remove(0);
    return oCard;
  }
  
  /**
   * Remove the top x cards from the stack.
   * @param p_iCount
   * @return
   */
  public CardStack takeTop(final int p_iCount)
  {
    CardStack oCards = new CardStack();
    for(int iCount = 0; iCount < p_iCount; iCount++)
    {
      oCards.putBottom(takeTop());
    }
    return oCards;
  }
  
  /**
   * Remove the bottom x cards from the stack.
   * @param p_iCount
   * @return
   */
  public CardStack takeBottom(final int p_iCount)
  {
    CardStack oCards = new CardStack();
    //m_colCards.removeRange(0, m_colCards.size() - 1);
    for(int iCount = 0; iCount < p_iCount; iCount++)
    {
      oCards.putTop(takeBottom());
    }
    return oCards;
  }
  
  /**
   * Put a card on top of the stack.
   * @param p_oCard
   */
  public void putTop(final StatefulCard p_oCard)
  {
    m_colCards.add(p_oCard);
  }
  
  /**
   * Put a stack of cards on the top of the stack.
   * @param p_oCards
   */
  public void putTop(CardStack p_oCards)
  {
    m_colCards.addAll(p_oCards.m_colCards);
    p_oCards.m_colCards.clear();
  }
  
  /**
   * Put a card on the bottom of the stack.
   * @param p_oCard
   */
  public void putBottom(final StatefulCard p_oCard)
  {
    m_colCards.add(p_oCard);
    Collections.rotate(m_colCards, 1);
  }
  
  /**
   * Put a stack of cards on the bottom of the stack.
   * @param p_oCards
   */
  public void putBottom(final CardStack p_oCards)
  {
    m_colCards.addAll(p_oCards.m_colCards);
    Collections.rotate(m_colCards, p_oCards.m_colCards.size());
    p_oCards.m_colCards.clear();
  }
  
  /**
   * Get the number of cards in the stack.
   * @return
   */
  public int size()
  {
    return m_colCards.size();
  }

  @Override
  public Iterator<StatefulCard> iterator()
  {
    return m_colCards.iterator();
  }
}
