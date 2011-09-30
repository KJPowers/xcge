package org.xcge.cards;

import javax.swing.Icon;

import org.xcge.cards.CardState;

public class StatefulCard extends Card
{
  private CardState m_eState;

  public StatefulCard(final Icon p_iconFront, final Icon p_iconBack)
  {
    this(p_iconFront, p_iconBack, CardState.FACE_DOWN);
  }

  public StatefulCard(final Icon p_iconFront, final Icon p_iconBack, final CardState p_eState)
  {
    super(p_iconFront, p_iconBack);
    m_eState = p_eState;
  }

  public StatefulCard(final Suit p_suit, final Value p_value, final Icon p_iconFront, final Icon p_iconBack, final CardState p_eState)
  {
    super(p_suit, p_value, p_iconFront, p_iconBack);
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
  
  public Icon getIcon()
  {
    switch(m_eState)
    {
      case FACE_UP:
        return getIconFront();
      case FACE_DOWN:
      default:
        return getIconBack();
    }
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
    { return super.toString();
    } else
    { return toString();
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

  public String toShortString(final boolean p_bForceFaceUp, final boolean p_bPad)
  {
    if(p_bForceFaceUp)
    { return super.toShortString(p_bPad);
    } else
    { return toShortString(p_bPad);
    }
  }
}
