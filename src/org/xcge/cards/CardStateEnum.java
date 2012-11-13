package org.xcge.cards;

public enum CardStateEnum
{
  FACE_DOWN (true),
  FACE_UP   (true),
  OPPOSITE  (false);
  
  private final boolean m_bValidInitialState;
  
  CardStateEnum(final boolean p_bValidInitialState)
  {
    m_bValidInitialState = p_bValidInitialState;
  }
  
  public boolean isValidInitialState()
  {
    return m_bValidInitialState;
  }
}
