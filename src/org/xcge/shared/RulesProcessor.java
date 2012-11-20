package org.xcge.shared;

import org.xcge.exceptions.IllegalActionException;
import org.xcge.shared.engine.action.IAction;
import org.xcge.shared.engine.rules.GameState;
import org.xcge.shared.engine.rules.Rules;


/**
 * @author Keith Powers
 */
public class RulesProcessor
{
  private Rules m_oCurrentRule;
  private GameState m_oState;
  
  RulesProcessor()
  {
  }
  
  public void doAction(final IAction p_oAction) throws IllegalActionException
  {
    GameState tempState = m_oState.clone();
    try
    {
      
      m_oCurrentRule = m_oCurrentRule.apply(p_oAction, m_oState);
    }
    catch()
  }
  
  public void setRules(final Rules p_oRules)
  {
    m_oRules = p_oRules;
  }
  
  public void reset()
  {
    m_oRules.reset();
    m_oState.initialize(m_oRules);
  }
}
