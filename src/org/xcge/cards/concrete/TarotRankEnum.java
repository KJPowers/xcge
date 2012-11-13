package org.xcge.cards.concrete;

import org.xcge.cards.IRank;

public enum TarotRankEnum implements IRank
{
  ONE    ("1"),
  TWO    ("2"),
  THREE  ("3"),
  FOUR   ("4"),
  FIVE   ("5"),
  SIX    ("6"),
  SEVEN  ("7"),
  EIGHT  ("8"),
  NINE   ("9"),
  TEN    ("10"),
  PAGE   ("Page"),
  KNIGHT ("Knight"), 
  QUEEN  ("Queen"),
  KING   ("King");
  
  private final String m_strName;
  private final String m_strShortName;
  
  private TarotRankEnum(final String p_strName)
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

