package org.xcge.shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.xcge.cards.CardStack;
import org.xcge.table.Tracker;

/**
 * The GameState class keeps track of - you guessed it - the game state.  This
 * includes the location of all the cards (by extending/implementing CardTracker), the score,
 * whose turn it is, ...?.
 * 
 * 
 * @author Keith Powers - K.J.Powers@gmail.com
 *
 */
public class GameState
{
  private final List<Seat> m_alSeats;
  private int m_iCurrentPlayerIndex = 0;
  private CardTracker m_oCardTracker;
  
  public GameState(final int p_iNumSeats)
  {
    m_alSeats = new ArrayList<Seat>(p_iNumSeats);
  }
  
  //
  
//  // Getters / setters
//  public Player getCurrentPlayer()
//  {
//    return m_alPlayers.get(m_iCurrentPlayerIndex);
//  }
//  
//  protected ArrayList<Player> getPlayers()
//  {
//    return m_alPlayers;
//  }
//  
//  public void setPlayers(ArrayList<Player> p_alPlayers)
//  {
//    m_alPlayers = p_alPlayers;
//  }
  
  // Container class to keep track of who has what cards
  private class CardTracker
  {
    private Tracker m_oCardManager = new Tracker(
                                                   new ArrayList<HashMap<Object, CardStack>>(), 0, 0, 0);

    public CardTracker(final int p_iNumTableGroups, final int p_iNumPlayers, final int p_iNumPlayerGroups)
    {
      m_oCardManager.m_iNumTableGroups = p_iNumTableGroups;
      m_oCardManager.m_iNumPlayers = p_iNumPlayers;
      m_oCardManager.m_iNumPlayerGroups = p_iNumPlayerGroups;
      
      m_oCardManager.m_hmTableCards = new HashMap<Object, CardStack>(m_oCardManager.m_iNumTableGroups);
      m_oCardManager.m_alPlayerCards = new ArrayList<HashMap<Object, CardStack>>(m_oCardManager.m_iNumPlayers);
      
      for(int iPlayerIndex = 1; iPlayerIndex <= p_iNumPlayers; iPlayerIndex++)
      {
        m_oCardManager.m_alPlayerCards.add(new HashMap<Object, CardStack>(m_oCardManager.m_iNumPlayerGroups));
      }
    }
    
    public CardStack getTableGroup(final int p_iGroupIndex)
    {
      validateIndex(p_iGroupIndex, m_oCardManager.m_iNumTableGroups, "Table Group");
      return m_oCardManager.m_hmTableCards.get(p_iGroupIndex);
    }
    
    public CardStack getGroupForPlayer(final int p_iPlayerIndex, final int p_iGroupIndex)
    {
      validateIndex(p_iPlayerIndex, m_oCardManager.m_iNumPlayers, "Player");
      validateIndex(p_iGroupIndex, m_oCardManager.m_iNumPlayerGroups, "Player Group");
      return m_oCardManager.m_alPlayerCards.get(p_iPlayerIndex).get(p_iGroupIndex);
    }
    
    private void validateIndex(final int iIndex, final int p_iReference, final String p_strSource)
    {
      if(iIndex < 0)            throw new IllegalArgumentException(p_strSource + " index cannot be negative.");
      if(iIndex > p_iReference) throw new IllegalArgumentException(p_strSource + " index cannot be larger than capacity (" + p_iReference + ".");
    }
  }
}
