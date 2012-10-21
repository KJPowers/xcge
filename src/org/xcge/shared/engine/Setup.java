package org.xcge.shared.engine;

import org.xcge.cards.FrenchDeck;

public class Setup
{
  private int m_iMinPlayers;
  private int m_iMaxPlayers;
  private FrenchDeck.FrenchDeckFactory m_oDeckType;
  
  Setup(final int p_iMinPlayers, final int p_iMaxPlayers, final Variant.Type p_oDeckType)
  {
    m_iMinPlayers = p_iMinPlayers;
    m_iMaxPlayers = p_iMaxPlayers;
    m_oDeckType = p_oDeckType;
  }
  
  
}
