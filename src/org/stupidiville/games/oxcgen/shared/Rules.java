package org.stupidiville.games.oxcgen.shared;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class Rules implements Iterator
{
  public enum Asdf
  {
    //PLAYER_INFO,
    PI_I_MIN_PLAYERS,
    PI_I_MAX_PLAYERS,
    PI_I_TEAM_SIZE,
    PI_B_TEAM_DOUBLES,
    
    //DECK_TYPE,
    DT_STANDARD,
    DT_PINOCHLE
  }
  
  boolean m_bDoublesAllowed;
  int m_iMinPlayers = -1;
  int m_iMaxPlayers = -1;
  int m_iTeamSize = -1;
  String m_sName = "";
  //HashMap<String, Rule> m_hmRules;
  protected DOMParser parser;
  
  public Rules()
  {
    parser = new DOMParser();
    Document document = null;//new Document();
  }
  
  /*public Iterator iterator()
  {
    
  }*/
  
  public void readRulesFromFile(final String p_sFileName) 
  {
    try
    {
      parser.parse(p_sFileName);
    } catch (SAXException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  // Getters
  public boolean getDoublesAllowed() { return m_bDoublesAllowed; }
  public int getMinPlayers()         { return m_iMinPlayers; }
  public int getMaxPlayers()         { return m_iMaxPlayers; }
  public int getTeamSize()           { return m_iTeamSize; }
  public String getName()            { return m_sName; }
  
  // Setters
  public void setDoublesAllowed(final boolean p_bDoublesAllowed)
  { m_bDoublesAllowed = p_bDoublesAllowed;
  }
  public void setMinPlayers(final int p_iMinPlayers)
  { m_iMinPlayers = p_iMinPlayers;
  }
  public void setMaxPlayers(final int p_iMaxPlayers)
  { m_iMaxPlayers = p_iMaxPlayers;
  }
  public void setTeamSize (final int p_iTeamSize)
  { m_iTeamSize = p_iTeamSize ;
  }
  public void setName (final String p_sName)
  { m_sName = p_sName;
  }

  @Override
  public boolean hasNext()
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Object next()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void remove()
  {
    // TODO Auto-generated method stub
    
  }
}
