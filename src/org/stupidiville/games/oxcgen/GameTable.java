package org.stupidiville.games.oxcgen;

/**
 * GameTable is the backbone of Ox-C-Gen.  It does the rules processing at its most abstract level, driving all the rest
 * @author Keith Powers
 *
 */
public class GameTable
{
  GameRules m_oRules = null;
  int m_iNumSeats = 0;
  
  GameTable(final GameRules p_oRules)
  {
    setRules(p_oRules);
  }
  
  public void prepare()
  {
    //m_oRules.
    
  }
  
  // Getters
  public GameRules getRules() { return m_oRules; }
  
  // Setters
  public void setRules(GameRules p_oNewRules)
  { m_oRules = p_oNewRules;
  }
}
