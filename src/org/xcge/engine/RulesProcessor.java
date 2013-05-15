package org.xcge.engine;

import org.xcge.engine.rules.Rules;
import org.xcge.engine.state.GameState;
import org.xcge.exceptions.IllegalActionException;
import org.xcge.shared.engine.action.IAction;


/**
 * @author Keith Powers
 */
public class RulesProcessor
{
  private Rules m_oRules;
  private GameState m_oState;
  
  RulesProcessor()
  {
  }
  
  public void doAction(final IAction p_oAction) throws IllegalActionException
  {
//    GameState tempState = m_oState.clone();
//    try
//    {
//      
//      m_oCurrentRule = m_oCurrentRule.apply(p_oAction, m_oState);
//    }
//    catch()
  }
  
//  public void setRules(final Rules p_oRules)
//  {
//    m_oRules = p_oRules;
//  }
//  
//  public void reset()
//  {
//    m_oRules.reset();
//    m_oState.initialize(m_oRules);
//  }
}
