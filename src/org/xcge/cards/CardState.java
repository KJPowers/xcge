package org.xcge.cards;

public enum CardState
{
  FACE_DOWN (true),
  FACE_UP   (true),
  OPPOSITE  (false);
  
  private final boolean m_bValidInitialState;
  
  CardState(final boolean p_bValidInitialState)
  { m_bValidInitialState = p_bValidInitialState;
  }
  
  public boolean isValidInitialState()
  { return m_bValidInitialState;
  }
}
