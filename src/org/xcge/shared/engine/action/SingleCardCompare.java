package org.xcge.shared.engine.action;

import java.util.ArrayList;
import org.xcge.shared.GameState;

import org.xcge.cards.Card;

public class SingleCardCompare implements IAction<SingleCardCompare>
{
  private static SingleCardCompare m_oInstance = null;
  @Override
  public SingleCardCompare getInstance()
  { if(m_oInstance ==  null) m_oInstance = new SingleCardCompare();
    return m_oInstance;
  }

  private static Ranking m_eRanking;
  private static ArrayList<Card> m_colRank;

  public enum Ranking
  {
    ACE_HIGH,               // 2...10, Jack, Queen, King, Ace.  No Jokers allowed
    ACE_LOW,                // Ace, 2...10, Jack, Queen, King.  No Jokers allowed
    ACE_HIGH_JOKER_LOW,     // Joker, 2...10, Jack, Queen, King, Ace.
    ACE_HIGH_JOKER_HIGHER,  // 2...10, Jack, Queen, King, Ace, Joker.
    ACE_LOW_JOKER_LOWER,    // Joker, Ace, 2...10, Jack, Queen, King.
    ACE_LOW_JOKER_HIGH,     // Ace, 2...10, Jack, Queen, King, Joker.
    CUSTOM;                 // 
  }

  public enum Result
  {
    P1,
    P2,
    TIE;
  }

  public SingleCardCompare()
  {
    this(Ranking.ACE_HIGH);
  }

  public SingleCardCompare(final Ranking p_eRanking)
  {
    m_oInstance = this;
    m_eRanking = p_eRanking;
  }

  public Result doAction(final Card p_oCard1, final Card p_oCard2)
  {
    if(p_oCard1.getValue() == p_oCard2.getValue())
    {
      return Result.TIE;
    }
    return Result.TIE;
  }

  @Override
  public void doAction(GameState p_oGameState, ActionCriteria p_oAC)
  {
    ;
  }
}

