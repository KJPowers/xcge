package org.stupidiville.games.cards;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Deck
{
  public enum Type {STD, STANDARD, STD_JOKERS, STANDARD_WITH_JOKERS, PINOCLE}
  
  private int m_iJoker = 0;
  private ArrayList<Icon> m_cardIcons;
  private Icon m_backIcon;
  private Icon m_blankIcon;
  private ArrayList<Card> m_cards;
  private Iterator<Card> m_iter;
  
  private String m_cardsFile = System.getProperty("user.dir") + File.separator + "img" + File.separator + "cards.png";
  private String m_backFile = System.getProperty("user.dir") + File.separator + "img" + File.separator + "back.png";
  private String m_blankFile = System.getProperty("user.dir") + File.separator + "img" + File.separator + "blank.png";
  
  public Deck()
  {
    this(Type.STD);
  }
  
  public Deck(Type p_deckType)
  {
    int index;
    
    loadIcons();
    
    switch(p_deckType)
    {
      case STANDARD_WITH_JOKERS:
      case STD_JOKERS:
        m_cards = new ArrayList<Card>(54);
        m_cards.add(new Card(getIcon(null, Card.Value.JOKER), m_backIcon));
        for(Card.Suit suit : Card.Suit.values())
        {
          for(Card.Value value : Card.Value.values())
          {
            if(value != Card.Value.JOKER)
            {
              m_cards.add(new Card(suit, value, getIcon(suit, value), m_backIcon));
            }
          }
        }
        m_cards.add(new Card(getIcon(null, Card.Value.JOKER), m_backIcon));
        break;
        
      case PINOCLE:
        m_cards = new ArrayList<Card>(48);
        for(Card.Suit suit : Card.Suit.values())
        {
          for(Card.Value value : Card.Value.values())
          {
            if(value == Card.Value.NINE  ||
               value == Card.Value.TEN   ||
               value == Card.Value.JACK  ||
               value == Card.Value.QUEEN ||
               value == Card.Value.KING  ||
               value == Card.Value.ACE)
            {
              m_cards.add(new Card(suit, value, getIcon(suit, value), m_backIcon));
            }
          }
        }
        for(index = 0; index < 24; index++)
        {
          m_cards.add(new Card(m_cards.get(index)));
        }
        break;
        
      case STANDARD:
      case STD:
      default:
        m_cards = new ArrayList<Card>(52);
        for(Card.Suit suit : Card.Suit.values())
        {
          for(Card.Value value : Card.Value.values())
          {
            if(value != Card.Value.JOKER)
            {
              m_cards.add(new Card(suit, value, getIcon(suit, value), m_backIcon));
            }
          }
        }        
        break;
    }
    
    m_iter = m_cards.iterator();
  }
  
  public void shuffle()
  {
    int index, iTemp;
    Card cardTemp;
    Random generator = new Random();
    
    for(index = 0; index < m_cards.size(); index++)
    {
      iTemp = generator.nextInt(m_cards.size());
      cardTemp = m_cards.get(iTemp);
      m_cards.set(iTemp, m_cards.get(index));
      m_cards.set(index, cardTemp);
    }
    m_iter = m_cards.iterator();
  }
  
  public Boolean hasNext()
  {
    return m_iter.hasNext();
  }
  
  public Card next()
  {
    return m_iter.next();
  }
  
  private Icon getIcon(Card.Suit p_suit, Card.Value p_value)
  {
    if(p_value == Card.Value.JOKER)
    {
      m_iJoker  = 1 - m_iJoker;               // Toggle between 0 & 1...
      return m_cardIcons.get(53 - m_iJoker);  // ... so that alternate joker images are retrieved
    }
    // TODO: find out if the switch statement is faster than:  
    // return m_cardIcons.get(p_suit.ordinal() * 13 + p_value.ordinal());
    switch(p_suit)
    {
      case SPADES:
        return m_cardIcons.get(p_value.ordinal());
      case DIAMONDS:
        return m_cardIcons.get(13 + p_value.ordinal());
      case CLUBS:
        return m_cardIcons.get(26 + p_value.ordinal());
      case HEARTS:
        return m_cardIcons.get(39 + p_value.ordinal());
      default:
        //throw new Exception("OMG TEH ERRORS!");
        return null;
    }
  }
  
  public Icon getBackIcon()
  {
    return m_backIcon;
  }
  
  public Icon getBlankIcon()
  {
    return m_blankIcon;
  }
  
  private void loadIcons()
  {
    int x, y;
    File file;
    BufferedImage image;
    
    m_cardIcons = new ArrayList<Icon>(54);
    
    try
    {
      // Load the blank space image
      file = new File(m_blankFile);
      m_backIcon = new ImageIcon(ImageIO.read(file));
      
      // Now get the main images file
      file = new File(m_cardsFile);
      image = ImageIO.read(file);
      
      for(y = 0; y < 4; y++)
      {
        for(x = 0; x < 13; x++)
        {
          m_cardIcons.add(new ImageIcon(image.getSubimage((73 * x) + 1, (98 * y) + 1, 71, 96)));
        }
      }
      // Joker images
      // TODO: verify image contains jokers (probably by size), else load <blanks?>
      m_cardIcons.add(new ImageIcon(image.getSubimage(1, 393, 71, 96)));
      m_cardIcons.add(new ImageIcon(image.getSubimage(74, 393, 71, 96)));
      
      // Now get the card back image
      file = new File(m_backFile);
      m_backIcon = new ImageIcon(ImageIO.read(file));
    }
    catch(IOException ex)
    {
      System.out.println(ex.getMessage());
    }
  }
}
