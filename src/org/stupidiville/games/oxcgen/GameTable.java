package org.stupidiville.games.oxcgen;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * GameTable is the backbone of Ox-C-Gen.  It does the rules processing at its
 * most abstract level, driving all the rest
 * @author Keith Powers
 *
 */
public class GameTable
{
  GameRules m_oRules = null;
  ArrayList<Player> m_alPlayers;
  int m_iNumSeats = 0;
  
  GameTable(final GameRules p_oRules)
  {
    setRules(p_oRules);
  }
  
  public void prepare()
  {
    //m_oRules.
    
  }
  
  public void processRules()
  {
	Iterator<GameRule> iterRules = m_oRules.iterator();
	while(iterRules.hasNext())
	{
      GameRule currentStep = iterRules.next();
      switch(currentStep.getStepType())
      {
        case BID:
          break;
        case TRICK:
          break;
        case DEAL:
          break;
        default:
          break;
      }
	}
  }
  
  // Getters & setters
  public ArrayList <Player> getPlayers() { return m_alPlayers; }  
  public GameRules getRules() { return m_oRules; }
  
  public void setPlayers(ArrayList<Player> p_alPlayers)
  { m_alPlayers = p_alPlayers;
  }
  
  public void setRules(GameRules p_oNewRules)
  { m_oRules = p_oNewRules;
  }
}
