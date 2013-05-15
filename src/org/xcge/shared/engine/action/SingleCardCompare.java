package org.xcge.shared.engine.action;

import java.util.ArrayList;

import org.xcge.cards.ICard;

public class SingleCardCompare //implements ICompare<FrenchDeck>
{
//  private static SingleCardCompare m_oInstance = null;
//  @Override
//  public SingleCardCompare getInstance()
//  { if(m_oInstance ==  null) m_oInstance = new SingleCardCompare();
//    return m_oInstance;
//  }
//
//  private static Ranking m_eRanking;
//  private static ArrayList<ICard.Value> m_colRank;
//
//  public enum Ranking
//  {
//    ACE_HIGH              (ICard.Value.TWO,
//                           ICard.Value.THREE,
//                           ICard.Value.FOUR,
//                           ICard.Value.FIVE,
//                           ICard.Value.SIX,
//                           ICard.Value.SEVEN,
//                           ICard.Value.EIGHT,
//                           ICard.Value.NINE,
//                           ICard.Value.TEN,
//                           ICard.Value.JACK,
//                           ICard.Value.QUEEN,
//                           ICard.Value.KING,
//                           ICard.Value.ACE),
//    ACE_LOW,                // Ace, 2...10, Jack, Queen, King.  No Jokers allowed
//    ACE_HIGH_JOKER_LOW,     // Joker, 2...10, Jack, Queen, King, Ace.
//    ACE_HIGH_JOKER_HIGHER,  // 2...10, Jack, Queen, King, Ace, Joker.
//    ACE_LOW_JOKER_LOWER,    // Joker, Ace, 2...10, Jack, Queen, King.
//    ACE_LOW_JOKER_HIGH,     // Ace, 2...10, Jack, Queen, King, Joker.
//    CUSTOM;                 // 
//
//    private final ArrayList<Card.Value> m_colRank = new ArrayList<Card.Value>();
//
//    Ranking(final Card.Value... p_eValues)
//    {
//      for(Card.Value eVal : p_eValues)
//      {
//        m_colRank.add(eVal);
//      }
//    }
//
//    public ArrayList<Card.Value> getRank()
//    {
//      return m_colRank;
//    }
//  }
//
//  public enum Result
//  {
//    P1,
//    P2,
//    TIE;
//  }
//
//  public SingleCardCompare()
//  {
//    this(Ranking.ACE_HIGH);
//  }
//
//  public SingleCardCompare(final Ranking p_eRanking)
//  {
//    m_oInstance = this;
//    m_eRanking = p_eRanking;
//    m_colRank = m_eRanking.getRank();
//  }
//
//  public Result doAction(final Card p_oCard1, final Card p_oCard2, final Card.Suit p_eTrump)
//  {
//    // Check trump suit first
//    if(p_eTrump != null && p_oCard1.getSuit() != p_oCard2.getSuit())
//    {
//      if(p_oCard1.getSuit() == p_eTrump) return Result.P1;
//      if(p_oCard2.getSuit() == p_eTrump) return Result.P2;
//    }
//
//    if(m_colRank.indexOf(p_oCard1.getValue()) == -1 ||
//       m_colRank.indexOf(p_oCard2.getValue()) == -1)
//    {
//      return null;
//    }
//    else if(m_colRank.indexOf(p_oCard1.getValue()) > m_colRank.indexOf(p_oCard2.getValue()))
//    {
//      return Result.P1;
//    }
//    else if(m_colRank.indexOf(p_oCard2.getValue()) > m_colRank.indexOf(p_oCard1.getValue()))
//    {
//      return Result.P2;
//    }
//    else if(m_colRank.indexOf(p_oCard1.getValue()) == m_colRank.indexOf(p_oCard2.getValue()))
//    {
//      return Result.TIE;
//    }
//    return null;
//  }
//
//  @Override
//  public void doAction(Table p_oGameState, ActionCriteria p_oAC)
//  {
//    ;
//  }
}

