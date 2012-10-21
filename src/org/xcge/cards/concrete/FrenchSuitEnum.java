package org.xcge.cards.concrete;

import org.xcge.cards.ISuit;

public enum FrenchSuitEnum implements ISuit
{
  SPADES   ("Spades"),
  DIAMONDS ("Diamonds"),
  CLUBS    ("Clubs"),
  HEARTS   ("Hearts");
  
  private final String m_strName;
  private final String m_strShortName;
  
  private FrenchSuitEnum(final String p_strName)
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

