package org.xcge.cards.concrete;

import org.xcge.cards.CardStack;
import org.xcge.cards.CardState;
import org.xcge.cards.IDeckFactory;
import org.xcge.cards.IRank;
import org.xcge.cards.ISuit;
import org.xcge.cards.StatefulCard;

public class FrenchDeckFactory implements IDeckFactory
{
  public enum Variant {STANDARD52, STANDARD54, PINOCHLE}
  
  public CardStack getNewDeck()
  {
    return getNewDeck(Variant.STANDARD52);
  }
  
  public CardStack getNewDeck(Variant p_deckType)
  {
    final CardStack oCards = new CardStack();
    switch(p_deckType)
    {
      case STANDARD54:
        oCards.putTop(new StatefulCard(null, RankEnum.JOKER, CardState.FACE_DOWN));
        for(ISuit suit : SuitEnum.values())
        {
          for(IRank rank : RankEnum.values())
          {
            if(rank != RankEnum.JOKER)
            {
              oCards.putTop(new StatefulCard(suit, rank, CardState.FACE_DOWN));
            }
          }
        }
        oCards.putTop(new StatefulCard(null, RankEnum.JOKER, CardState.FACE_DOWN));
        break;
        
      case PINOCHLE:
        for(ISuit suit : SuitEnum.values())
        {
          for(IRank rank : RankEnum.values())
          {
            if(rank == RankEnum.NINE  ||
               rank == RankEnum.TEN   ||
               rank == RankEnum.JACK  ||
               rank == RankEnum.QUEEN ||
               rank == RankEnum.KING  ||
               rank == RankEnum.ACE)
            {
              oCards.putTop(new StatefulCard(suit, rank, CardState.FACE_DOWN));
            }
          }
        }
        oCards.putTop(oCards);
        break;
        
      case STANDARD52:
      default:
        for(SuitEnum suit : SuitEnum.values())
        {
          for(RankEnum rank : RankEnum.values())
          {
            if(rank != RankEnum.JOKER)
            {
              oCards.putTop(new StatefulCard(suit, rank, CardState.FACE_DOWN));
            }
          }
        }        
        break;
    }
    return oCards;
  }
  
  /**
   * The Suits
   */
  public enum SuitEnum implements ISuit
  {
    SPADES   ("Spades"),
    DIAMONDS ("Diamonds"),
    CLUBS    ("Clubs"),
    HEARTS   ("Hearts");
    
    private final String m_strName;
    private final String m_strShortName;
    
    private SuitEnum(final String p_strName)
    {
      m_strName = p_strName;
      m_strShortName = p_strName.substring(0, 1);
    }
    
    public String toString()
    {
      return m_strName;
    }
    
    public String toShortString()
    {
      return m_strShortName;
    }
  }
  
  /**
   * The ranks
   */
  public enum RankEnum implements IRank
  {
    TWO   ("2"),
    THREE ("3"),
    FOUR  ("4"),
    FIVE  ("5"),
    SIX   ("6"),
    SEVEN ("7"),
    EIGHT ("8"),
    NINE  ("9"),
    TEN   ("10"),
    JACK  ("Jack"),
    QUEEN ("Queen"), 
    KING  ("King"),
    ACE   ("Ace"),
    JOKER ("Joker");
    
    private final String m_strName;
    private final String m_strShortName;
    
    private RankEnum(final String p_strName)
    {
      m_strName = p_strName;
      m_strShortName = p_strName.substring(0, Math.min(2, p_strName.length()));
    }
    
    public String toString()
    {
      return m_strName;
    }
    
    public String toShortString(final boolean p_bLeftPad)
    {
      if(p_bLeftPad && m_strShortName.length() < 2)
      {
        return " " + m_strShortName;
      }
      return m_strShortName;
    }
  }
}
