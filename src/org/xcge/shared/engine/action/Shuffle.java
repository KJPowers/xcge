package org.xcge.shared.engine.action;

import java.util.Random;

import org.xcge.cards.CardGroup;
import org.xcge.shared.engine.action.IAction;

public class Shuffle implements IAction<Shuffle>
{
  private static Shuffle m_oInstance = null;
  
  Shuffle() { this(); }
  
  public Shuffle getInstance()
  {
    if(m_oInstance ==  null) m_oInstance = new Shuffle();
    return m_oInstance;
  }
  
  @Override
  public static void doAction(GameState p_oGameState, final ActionCriteria p_oAC)
  {
    Random oRandom = new Random(System.nanoTime());
    CardGroup oCards = p_oGameState.getCards(p_oAC.getCardGroup());
    for(int iIndex=0; iIndex < oCards.size() ; iIndex++)
    {
      oCards.;
    }
    
  }
}
