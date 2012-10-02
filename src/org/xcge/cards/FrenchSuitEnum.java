package org.xcge.cards;

public enum FrenchSuitEnum
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

