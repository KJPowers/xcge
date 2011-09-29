package org.xcge.shared.engine.action;

import org.xcge.cards.CardStack;
import org.xcge.shared.GameState;

public class MoveCards implements IAction<MoveCards>
{
  // Static class stuff?
  private static MoveCards m_oInstance = null;
  public MoveCards() { m_oInstance = this; }
  @Override
  public MoveCards getInstance()
  { if(m_oInstance == null) m_oInstance = new MoveCards();
    return m_oInstance;
  }
  
  public enum FromTo
  {
    TT(true, true),
    TB(true, false),
    BT(false, true),
    BB(false, false);
    
    final boolean m_bFromTop;
    final boolean m_bToTop;
    
    /**
     * Top    (of stack of cards) = First (Deque)
     * Bottom (of stack of cards) = Last  (Deque)
     * @param p_bFromTop
     * @param p_bFromBottom
     */
    private FromTo(final boolean p_bFromTop, final boolean p_bToTop)
    {
      m_bFromTop = p_bFromTop;
      m_bToTop = p_bToTop;
    }
    
    public boolean isFromTop()
    {
      return m_bFromTop;
    }
    
    public boolean isToTop()
    {
      return m_bToTop;
    }
  }

  public void doAction(CardStack p_oGroupFrom, CardStack p_oGroupTo)
  {
    doAction(p_oGroupFrom, p_oGroupTo, 1, FromTo.TT, true);
  }

  public void doAction(CardStack p_oGroupFrom, CardStack p_oGroupTo, final int p_iCount, final boolean p_bAsGroup)
  {
    doAction(p_oGroupFrom, p_oGroupTo, p_iCount, FromTo.TT, p_bAsGroup);
  }

  public void doAction(CardStack p_oGroupFrom, CardStack p_oGroupTo, final FromTo p_eFromTo)
  {
    doAction(p_oGroupFrom, p_oGroupTo, 1, p_eFromTo, true);
  }

  public void doAction(CardStack p_oGroupFrom, CardStack p_oGroupTo, final int p_iCount, final FromTo p_eFromTo, final boolean p_bAsGroup)
  {
    final CardStack oCards = (CardStack) (p_eFromTo.isFromTop() ? p_oGroupFrom.takeTop(p_iCount) : p_oGroupFrom.takeBottom());
    
    // If moving TT or BB, it matters if it's as a group.  Reverse when necessary.
    // If moving TB or BT, it doesn't matter if it's as a group.  Don't waste time reversing.
    if(!p_bAsGroup && (p_eFromTo == FromTo.TT || p_eFromTo == FromTo.BB))
      oCards.reverse();
    
    if(p_eFromTo.isToTop())
      p_oGroupTo.putTop(oCards);
    else
      p_oGroupTo.putBottom(oCards);
  }

  @Override
  public void doAction(GameState p_oGameState, ActionCriteria p_oAC)
  {
    ;
  }
}
