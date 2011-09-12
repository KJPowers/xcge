package org.xcge.shared;

import java.util.ArrayList;

import org.xcge.cards.Stack;

public class GameState
{
  private ArrayList<Player> m_alPlayers = new ArrayList<Player>();
  private int m_iCurrentPlayerIndex = 0;
  
  private Cards m_oCards;
  
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
  private class Cards
  {
    private ArrayList<ArrayList<Stack>> m_alCards;// = new ArrayList<ArrayList<Stack>>();
    private int m_iNumTableStacks = 0;
    private int m_iNumPlayers = 0;
    private int m_iNumPlayerStacks = 0;
    
    public Cards(final int p_iNumTableStacks, final int p_iNumPlayers, final int p_iNumPlayerStacks)
    {
      m_iNumTableStacks = p_iNumTableStacks;
      m_iNumPlayers = p_iNumPlayers;
      m_iNumPlayerStacks = p_iNumPlayerStacks;
      
      m_alCards = new ArrayList<ArrayList<Stack>>(m_iNumPlayers + 1);
      
      m_alCards.add(new ArrayList<Stack>(m_iNumTableStacks));
      for(int iPlayerIndex = 1; iPlayerIndex <= p_iNumPlayers; iPlayerIndex++)
      {
        m_alCards.add(new ArrayList<Stack>(m_iNumPlayerStacks));
      }
    }
    
    public Stack getStack(final int p_iPlayerIndex, final int p_iStackIndex)
    {
      return m_alCards.get(p_iPlayerIndex).get(p_iStackIndex);
    }
  }
}
