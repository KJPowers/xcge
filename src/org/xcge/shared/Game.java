package org.xcge.shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.String;

import org.xcge.shared.GameState;

public class Game
{
  private String m_strName;
  // I'm doing it this way because I don't have a reference Google to find out how to do pointers in Java, and I don't remember at 2am.
  // FIXME later
  private ArrayList<String> m_colTags;
  private HashMap<String, GameState> m_hmStates;

  public void Game(final String p_strName, final ArrayList<String> p_colTags, final HashMap<String, GameState> p_hmStates)
  {
    m_strName = p_strName;
    m_colTags = p_colTags;
    m_hmStates = p_hmStates;
  }

  public void Game(final String p_strName, final ArrayList<String> p_colTags)
  {
    Game(p_strName, p_colTags, null);
  }

  public void Game(final String p_strName)
  {
    Game(p_strName, null, null);
  }

  // getters / setters
  public String getName() { return m_strName; }
  public void setName(final String p_strName) { m_strName = p_strName; }

  public ArrayList<String> getTags() { return m_colTags; }
  public void setTags(final ArrayList<String> p_colTags) { m_colTags = p_colTags; }
  public void addTag(final String p_strTag)
  {
    if(m_colTags == null) { m_colTags = new ArrayList<String>(); }
    m_colTags.add(p_strTag);
  }
  public void removeTag(final String p_strTag)
  {
    if(m_colTags != null) { m_colTags.remove(p_strTag); }
  }

  public HashMap<String, GameState> getStates() { return m_hmStates; }
  public void setStates(final HashMap<String, GameState> p_hmStates) { m_hmStates = p_hmStates; }
  public void addState(final String p_strKey, final GameState p_State)
  {
    if(m_hmStates == null) { m_hmStates = new HashMap<String, GameState>(); }
    if(!m_hmStates.containsKey(p_strKey) || m_hmStates.get(p_strKey) != null) { m_hmStates.put(p_strKey, p_State); }
  }
  public void removeState(final String p_strKey)
  {
    if(m_hmStates != null) { m_hmStates.remove(p_strKey); }
  }
}

