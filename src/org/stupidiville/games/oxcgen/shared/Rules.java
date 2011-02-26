package org.stupidiville.games.oxcgen.shared;

import java.util.HashMap;
import java.util.Iterator;

public class Rules extends Iterator
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
  HashMap<String, Rule> m_hmRules;
  
  public Rules()
  {
    
  }
  
  public Iterator<Rule> iterator()
  {
	
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
}
