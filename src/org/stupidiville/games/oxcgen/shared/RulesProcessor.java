package org.stupidiville.games.oxcgen.shared;

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
  Rules m_oRules;
  // The seats (player API)
  ArrayList<Player> m_alSeats;
  
  RulesProcessor(final Rules p_oRules)
  {
    setRules(p_oRules);
  }
  
  public void prepare()
  {
    //m_oRules.
    
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
  public Rules getRules() { return m_oRules; }
  
  public void setSeats(ArrayList<Player> p_alSeats)
  { m_alSeats = p_alSeats;
  }
  
  public void setRules(Rules p_oNewRules)
  { m_oRules = p_oNewRules;
  } 
}
