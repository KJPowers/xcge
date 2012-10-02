package org.xcge.cards;

import org.xcge.cards.CardState;

public class StatefulCard extends Card
{
  private CardState m_eState;

  public StatefulCard(final Suit p_suit, final Value p_value, final CardState p_eState)
  {
    super(p_suit, p_value);
    m_eState = p_eState;
  }
  
  public StatefulCard(final StatefulCard p_oCard)
  {
    this(p_oCard, p_oCard.getState());
  }
  
  public StatefulCard(final Card p_oCard, final CardState p_eState)
  {
    super(p_oCard);
    m_eState = p_eState;
  }

  public StatefulCard(final Card p_oCard)
  {
    this(p_oCard, CardState.FACE_DOWN);
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

