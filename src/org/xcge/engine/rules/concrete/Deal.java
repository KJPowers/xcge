package org.xcge.engine.rules.concrete;

import org.xcge.cards.CardStack;
import org.xcge.engine.rules.IStep;
import org.xcge.engine.state.GameState;
import org.xcge.engine.state.StackDescriptor;
import org.xcge.engine.table.Seat;

public class Deal extends SimpleStep
{
  public static final int ALL = -1;
  
  private final StackDescriptor m_oFromStack;
  private final int             m_iNum;
  private final String          m_strStackName;
  
  public Deal(final StackDescriptor p_oFromStack,
              final int p_iNum,
              final String p_strStackName) // will eventually want to be able to deal asymmetrically among players, to certain stacks for each player, face up/down, to the table, etc
  {
    m_oFromStack = p_oFromStack;
    m_iNum = p_iNum;
    m_strStackName = p_strStackName;
  }

  @Override
  public IStep doAction(GameState p_gameState)
  {
    final CardStack oFromStack = p_gameState.getStack(m_oFromStack);
    
    int iCount = p_gameState.getSeats().size() * m_iNum;
    if(m_iNum == ALL)
      iCount = oFromStack.size();
    else if(iCount > oFromStack.size())
      iCount = oFromStack.size();
    
    OUTER_LOOP:
    while(true)
    {
      for(final Seat oSeat : p_gameState.getSeats())
      {
        MoveCards.getInstance().doAction(p_gameState.getStack(m_oFromStack), oSeat.getStack(m_strStackName));
        if(0 == --iCount)
          break OUTER_LOOP;
      }
    }
    return getNextStep();
  }

}
