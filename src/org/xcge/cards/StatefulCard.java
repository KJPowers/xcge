package org.xcge.cards;

import org.xcge.cards.CardState;

public class StatefulCard
{
  private final Card m_oCard;
  private CardState m_eState;

  public StatefulCard(final Card p_oCard, final CardState p_eState)
  {
    m_oCard = p_oCard;
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

  public Card getCard()
  {
    return m_oCard;
  }

  public CardState getState()
  {
    return m_eState;
  }

  public void setState(final CardState p_eState)
  {
    m_eState = p_eState;
  }
}
