package org.xcge.shared;

import java.util.ArrayList;
import java.util.HashMap;

import org.xcge.cards.CardGroup;

public class GameState
{
  private ArrayList<Player> m_alPlayers = new ArrayList<Player>();
  private int m_iCurrentPlayerIndex = 0;
  private CardTracker m_oCardTracker;
  
  public GameState()
  { }
  
  // 
  public int addPlayer(Player p_oPlayer)
  {
    m_alPlayers.add(p_oPlayer);
    return m_alPlayers.size();
  }
  
  public void removePlayer(int p_iPlayerIndex)
  {
    if(p_iPlayerIndex < m_alPlayers.size())
    {
      m_alPlayers.remove(p_iPlayerIndex);
    }
  }
  
  // Getters / setters
  public Player getCurrentPlayer()
  {
    return m_alPlayers.get(m_iCurrentPlayerIndex);
  }
  
  protected ArrayList<Player> getPlayers()
  {
    return m_alPlayers;
  }
  
  public void setPlayers(ArrayList<Player> p_alPlayers)
  {
    m_alPlayers = p_alPlayers;
  }
  
  // Container class to keep track of who has what cards
  private class CardTracker
  {
    private HashMap<Object, CardGroup> m_hmTableCards;
    private ArrayList<HashMap<Object, CardGroup>> m_alPlayerCards = new ArrayList<HashMap<Object, CardGroup>>();
    private int m_iNumTableGroups = 0;
    private int m_iNumPlayers = 0;
    private int m_iNumPlayerGroups = 0;
    
    public CardTracker(final int p_iNumTableGroups, final int p_iNumPlayers, final int p_iNumPlayerGroups)
    {
      m_iNumTableGroups = p_iNumTableGroups;
      m_iNumPlayers = p_iNumPlayers;
      m_iNumPlayerGroups = p_iNumPlayerGroups;
      
      m_hmTableCards = new HashMap<Object, CardGroup>(m_iNumTableGroups);
      m_alPlayerCards = new ArrayList<HashMap<Object, CardGroup>>(m_iNumPlayers);
      
      for(int iPlayerIndex = 1; iPlayerIndex <= p_iNumPlayers; iPlayerIndex++)
      {
        m_alPlayerCards.add(new HashMap<Object, CardGroup>(m_iNumPlayerGroups));
      }
    }
    
    public CardGroup getTableGroup(final int p_iGroupIndex)
    {
      validateIndex(p_iGroupIndex, m_iNumTableGroups, "Table Group");
      return m_hmTableCards.get(p_iGroupIndex);
    }
    
    public CardGroup getGroupForPlayer(final int p_iPlayerIndex, final int p_iGroupIndex)
    {
      validateIndex(p_iPlayerIndex, m_iNumPlayers, "Player");
      validateIndex(p_iGroupIndex, m_iNumPlayerGroups, "Player Group");
      return m_alPlayerCards.get(p_iPlayerIndex).get(p_iGroupIndex);
    }
    
    private void validateIndex(final int iIndex, final int p_iReference, final String p_strSource)
    {
      if(iIndex < 0)            throw new IllegalArgumentException(p_strSource + " index cannot be negative.");
      if(iIndex > p_iReference) throw new IllegalArgumentException(p_strSource + " index cannot be larger than capacity (" + p_iReference + ".");
    }
  }
}
