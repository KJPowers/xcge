package org.xcge.cards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This is a stack, or pile of cards. 
 * Examples:
 *  Solitaire: The main building piles start all face down, except the top card which is face up.  The suit piles are
 *  always face-up.
 *  War: The cards in-hand are a stack, all face down.  They are turned one at a time and placed face-up in front of
 *  the player (a separate stack).
 *  
 * Operations on the cards are kept as simple as possible.  Imagine all operations on stacks as happening in 2.5
 * dimensions.  --== OR ==--  All cards are moved N, S, E or W, but they are never rotated or flipped (except via the
 * flip() method).  When dividing stacks of cards, it is always done as if cutting a deck.  It is possible to take a
 * single stateful (face-up or face-down) card or to take another stack of cards that preserves the order and state of
 * all included cards
 */
public class CardStack// implements Iterable<StatefulCard>
{
  private static final long serialVersionUID = -8899315466153998363L;
  
  // TODO Optimize with a Deque, but then I can't use java.util.Collections to do all its neat stuff.
  /**
   * The entry with index = 0 is at the bottom of the stack. 
   */
  private final ArrayList<StatefulCard> m_alCards;
  
  /**
   * 
   * @param p_iCapacity this is a suggestion, not gospel
   */
  public CardStack(int p_iCapacity)
  {
    m_alCards = new ArrayList<StatefulCard>(p_iCapacity);
  }
  
  /**
   * Convenience method
   * @param p_alCards
   */
  private CardStack(final ArrayList<StatefulCard> p_alCards)
  {
    m_alCards = p_alCards;
  }

  /**
   * Turn over the stack of cards.  Reverse their order and flip their states (face-up -> face-down & vice-versa).
   */
  public void flip()
  {
    Collections.reverse(m_alCards);
    for(StatefulCard oCard : m_alCards)
    {
      oCard.flip();
    }
  }
  
  /**
   * Convenience method, there is no trivial translation to a real-life stack of cards.
   */
  public void reverse()
  {
    Collections.reverse(m_alCards);
  }
  
  /**
   * Shuffle.
   */
  public void shuffle()
  {
    Collections.shuffle(m_alCards);
  }
  
  /**
   * Look at the top card but don't remove it.
   * @return
   */
  public StatefulCard peekTop()
  {
    return m_alCards.get(m_alCards.size() - 1);
  }
  
  /**
   * Look at the bottom card but don't remove it.  Cheater.
   * @return
   */
  public StatefulCard peekBottom()
  {
    return m_alCards.get(0);
  }
  
  /**
   * Look at the top x cards, but don't remove them.
   * @param p_iCount
   * @return
   */
  @SuppressWarnings("unchecked")
  public CardStack peekTop(final int p_iCount)
  {
    return new CardStack((ArrayList) m_alCards.subList(m_alCards.size() - p_iCount, m_alCards.size() - 1));
  }
  
  /**
   * Look at the bottom x cards, but don't remove them.  Super cheater.
   * @param p_iCount
   * @return
   */
  @SuppressWarnings("unchecked")
  public CardStack peekBottom(final int p_iCount)
  {
    return p_iCount == 0 ? new CardStack(0) : new CardStack((ArrayList) m_alCards.subList(0, p_iCount - 1));
  }
  
  /**
   * Remove the top card from the stack.
   */
  public StatefulCard takeTop()
  {
    StatefulCard oCard = peekTop();
    m_alCards.remove(m_alCards.size() - 1);
    return oCard;
  }
  
  /**
   * Remove the bottom card from the stack.
   * @return
   */
  public StatefulCard takeBottom()
  {
    StatefulCard oCard = peekBottom();
    m_alCards.remove(0);
    return oCard;
  }
  
  /**
   * Remove the top x cards from the stack.
   * @param p_iCount
   * @return
   */
  public CardStack takeTop(final int p_iCount)
  {
    CardStack oCards = peekTop(p_iCount);
    //m_alCards.removeRange(m_alCards.size() - p_iCount, m_alCards.size() - 1);
    for(int iCount = 0; iCount < p_iCount; iCount++)
    {
      m_alCards.remove(m_alCards.size() - 1);
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
    CardStack oCards = peekBottom(p_iCount);
    //m_alCards.removeRange(0, m_alCards.size() - 1);
    for(int iCount = 0; iCount < p_iCount; iCount++)
    {
      m_alCards.remove(0);
    }
    return oCards;
  }
  
  /**
   * Put a card on top of the stack.
   * @param p_oCard
   */
  public void putTop(final StatefulCard p_oCard)
  {
    m_alCards.add(p_oCard);
  }
  
  /**
   * Put a stack of cards on the top of the stack.
   * @param p_oCards
   */
  public void putTop(CardStack p_oCards)
  {
    m_alCards.addAll(p_oCards.m_alCards);
    p_oCards.m_alCards.clear();
  }
  
  /**
   * Put a card on the bottom of the stack.
   * @param p_oCard
   */
  public void putBottom(final StatefulCard p_oCard)
  {
    m_alCards.add(p_oCard);
    Collections.rotate(m_alCards, 1);
  }
  
  /**
   * Put a stack of cards on the bottom of the stack.
   * @param p_oCards
   */
  public void putBottom(final CardStack p_oCards)
  {
    m_alCards.addAll(p_oCards.m_alCards);
    Collections.rotate(m_alCards, p_oCards.m_alCards.size());
    p_oCards.m_alCards.clear();
  }
  
  /**
   * Get the number of cards in the stack.
   * @return
   */
  public int size()
  {
    return m_alCards.size();
  }

//  @Override
//  public Iterator<StatefulCard> iterator()
//  {
//    return new CardGroupIterator(this);
//  }
//  
//  private class CardGroupIterator implements Iterator<StatefulCard>
//  {
//    CardStack m_oCards;
//    public CardGroupIterator(final CardStack p_oCards)
//    {
//      m_oCards = p_oCards;
//    }
//    
//    @Override
//    public boolean hasNext()
//    {
//      return m_oCards.size() > 0;
//    }
//
//    @Override
//    public StatefulCard next()
//    {
//      return m_oCards.takeTop();
//    }
//
//    @Override
//    public void remove() { }
//    
//  }
}
