package org.xcge.engine.rules.concrete;

import org.xcge.engine.rules.IStep;
import org.xcge.engine.state.GameState;


public class Loop implements IStep
{
  final boolean m_bEvaluateConditionalBeforeLoop;
  public Loop(final boolean p_bEvaluateConditionalBeforeLoop)
  {
    m_bEvaluateConditionalBeforeLoop = p_bEvaluateConditionalBeforeLoop;
  }

  @Override
  public IStep doAction(GameState p_gameState)
  {
    // TODO Auto-generated method stub
    return null;
  }
}
