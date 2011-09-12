package org.xcge.shared;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * GameTable is the backbone of Ox-C-Gen.  It does the rules processing at its
 * most abstract level, driving all the rest
 * @author Keith Powers
 *
 */
public class RulesProcessor
{
  // The rules processing engine, this contains the rules of the game being played at this table
    // MVC Role: Controller
  private Rules m_oRules;
  // The seats (player API)
  private ArrayList<Player> m_alSeats;
  private final GameState m_oState;
  
  RulesProcessor(final Rules p_oRules)
  {
    m_oRules = p_oRules;
    m_oState = new GameState();
  }
  
  private void setUpInitialGameState()
  {
    m_oState.
  }

  public void begin()
  {
    setUpInitialGameState();
  }
  
  public void processRules()
  {
  	/*Iterator<Rule> iterRules = m_oRules.iterator();
	  while(iterRules.hasNext())
	  {
      Rule currentStep = iterRules.next();
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
	  }*/
  }
  
  // Getters & setters
  //public ArrayList <Player> getPlayers() { return m_alPlayers; }  
  //public Rules getRules() { return m_oRules; }
  
  public void setSeats(ArrayList<Player> p_alSeats)
  { m_alSeats = p_alSeats;
  }
  
  public void setRules(Rules p_oNewRules)
  {
  } 
}
