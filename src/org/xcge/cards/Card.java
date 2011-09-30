package org.xcge.cards;

import javax.swing.Icon;

public class Card
{
  public enum Value {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE, JOKER}
  
  public enum Suit {SPADES, DIAMONDS, CLUBS, HEARTS}
  
  // member variables
  private Value m_value;
  private Suit m_suit;
  private Icon m_iconBack;
  private Icon m_iconFront;
  
  Card(final Icon p_iconFront, final Icon p_iconBack)
  {
    this(null, Value.JOKER, p_iconFront, p_iconBack);
  }
  
  Card(final Card p_card)
  {
    this(p_card.m_suit, p_card.m_value, p_card.m_iconBack, p_card.m_iconFront);
  }
  
  Card(final Suit p_suit, final Value p_value)
  {
    m_suit = p_suit;
    m_value = p_value;
    m_iconBack = null;
    m_iconFront = null;
  }
  
  Card(final Suit p_suit, final Value p_value, final Icon p_iconFront, final Icon p_iconBack)
  {
    m_suit = p_suit;
    m_value = p_value;
    m_iconBack = p_iconBack;
    m_iconFront = p_iconFront;
  }
  
  public void setIconBack(final Icon p_icon)
  {
    m_iconBack = p_icon;
  }
  
  public void setIconFront(final Icon p_icon)
  {
    m_iconFront = p_icon;
  }
  
  public Icon getIconBack()
  {
    return m_iconBack;
  }
  
  public Icon getIconFront()
  {
    return m_iconFront;
  }
  
  public Suit getSuit()
  {
    return m_suit;
  }
  
  public Value getValue()
  {
    return m_value;
  }
  
  public String toString()
  {
    StringBuffer strRetVal = new StringBuffer();
    Object o = new Object();
    o.toString();    
    switch(m_value)
    {
      case JOKER:
        return "Joker";
      case TWO:
        strRetVal = new StringBuffer("2");
        break;
      case THREE:
        strRetVal = new StringBuffer("3");
        break;
      case FOUR:
        strRetVal = new StringBuffer("4");
        break;
      case FIVE:
        strRetVal = new StringBuffer("5");
        break;
      case SIX:
        strRetVal = new StringBuffer("6");
        break;
      case SEVEN:
        strRetVal = new StringBuffer("7");
        break;
      case EIGHT:
        strRetVal = new StringBuffer("8");
        break;
      case NINE:
        strRetVal = new StringBuffer("9");
        break;
      case TEN:
        strRetVal = new StringBuffer("10");
        break;
      case JACK:
        strRetVal = new StringBuffer("Jack");
        break;
      case QUEEN:
        strRetVal = new StringBuffer("Queen");
        break;
      case KING:
        strRetVal = new StringBuffer("King");
        break;
      case ACE:
        strRetVal = new StringBuffer("Ace");
        break;
    }
    strRetVal.append(" of ");
    switch(m_suit)
    {
      case SPADES:
        strRetVal.append("Spades");
        break;
      case DIAMONDS:
        strRetVal.append("Diamonds");
        break;
      case CLUBS:
        strRetVal.append("Clubs");
        break;
      case HEARTS:
        strRetVal.append("Hearts");
        break;
    }
    return strRetVal.toString();
  }
  
  public String toShortString(final boolean p_bPad)
  {
    StringBuffer strRetVal = new StringBuffer();
    Object o = new Object();
    o.toString();
    String strPad = p_bPad ? " " : "";
    switch(m_value)
    {
      case JOKER:
        return "Joker!";
      case TWO:
        strRetVal = new StringBuffer(strPad).append("2");
        break;
      case THREE:
        strRetVal = new StringBuffer(strPad).append("3");
        break;
      case FOUR:
        strRetVal = new StringBuffer(strPad).append("4");
        break;
      case FIVE:
        strRetVal = new StringBuffer(strPad).append("5");
        break;
      case SIX:
        strRetVal = new StringBuffer(strPad).append("6");
        break;
      case SEVEN:
        strRetVal = new StringBuffer(strPad).append("7");
        break;
      case EIGHT:
        strRetVal = new StringBuffer(strPad).append("8");
        break;
      case NINE:
        strRetVal = new StringBuffer(strPad).append("9");
        break;
      case TEN:
        strRetVal = new StringBuffer("10");
        break;
      case JACK:
        strRetVal = new StringBuffer(strPad).append("J");
        break;
      case QUEEN:
        strRetVal = new StringBuffer(strPad).append("Q");
        break;
      case KING:
        strRetVal = new StringBuffer(strPad).append("K");
        break;
      case ACE:
        strRetVal = new StringBuffer(strPad).append("A");
        break;
    }
    strRetVal.append(" of ");
    switch(m_suit)
    {
      case SPADES:
        strRetVal.append("S");
        break;
      case DIAMONDS:
        strRetVal.append("D");
        break;
      case CLUBS:
        strRetVal.append("C");
        break;
      case HEARTS:
        strRetVal.append("H");
        break;
    }
    return strRetVal.toString();
  }
}
