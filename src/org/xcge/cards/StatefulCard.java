package org.xcge.cards;

import org.xcge.cards.CardState;

public class StatefulCard extends BaseCard
{
  private CardState m_eState;

  public StatefulCard(final ISuit p_suit, final IRank p_rank, final CardState p_eState)
  {
    super(p_suit, p_rank);
    m_eState = p_eState;
  }
  
  public StatefulCard(final StatefulCard p_oCard)
  {
    this(p_oCard, p_oCard.getState());
  }
  
  public StatefulCard(final ICard p_iCard, final CardState p_eState)
  {
    super(p_iCard);
    m_eState = p_eState;
  }

  public StatefulCard(final ICard p_iCard)
  {
    this(p_iCard, CardState.FACE_DOWN);
  }
  
  public void flip()
  {
    switch(m_eState)
    {
      case FACE_UP:
        m_eState = CardState.FACE_DOWN;
        break;
      default:
        m_eState = CardState.FACE_UP;
        break;
    }
  }

  public CardState getState()
  {
    return m_eState;
  }

  public void setState(final CardState p_eState)
  {
    m_eState = p_eState;
  }
  
  @Override
  public String toString()
  {
    switch(m_eState)
    {
      case FACE_UP:
        return super.toString();
      case FACE_DOWN:
      default:
        return "Face-down card";
    }
  }

  public String toString(final boolean p_bForceFaceUp)
  {
    if(p_bForceFaceUp)
    {
      return super.toString();
    } else
    {
      return toString();
    }
  }
  
  @Override
  public String toShortString(final boolean p_bPad)
  {
    switch(m_eState)
    {
      case FACE_UP:
        return super.toShortString(p_bPad);
      case FACE_DOWN:
      default:
        return "A Card";
    }
  }
}

