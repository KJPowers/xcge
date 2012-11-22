package org.xcge.shared.engine.rules;

import org.xcge.shared.engine.GameState;
import org.xcge.shared.engine.action.IAction;

/**
 * The object that gets generated from parsing a rule specification document.
 * The parsing / rule generation is done in a factory (TODO reference the
 * factory).
 * 
 * This class keeps track of the current step, validates player input, and
 * manipulates the game state.
 * 
 * @author Keith Powers (K.J.Powers@gmail.com)
 * @see TODO
 */
class Rules
{
  protected int    m_iMinPlayers = -1;
  protected int    m_iMaxPlayers = -1;
  protected String m_sName       = "";

  private IStep    m_oCurrentStep;

  public Rules()
  {
  }

  public void pump(final IAction p_oAction, final GameState p_oState) throws IllegalArgumentException
  {
    
  }

  // Getters
  public int getMinPlayers()
  {
    return m_iMinPlayers;
  }

  public int getMaxPlayers()
  {
    return m_iMaxPlayers;
  }

  public String getName()
  {
    return m_sName;
  }

  // Setters
  public void setMinPlayers(final int p_iMinPlayers)
  {
    m_iMinPlayers = p_iMinPlayers;
  }

  public void setMaxPlayers(final int p_iMaxPlayers)
  {
    m_iMaxPlayers = p_iMaxPlayers;
  }

  public void setName(final String p_sName)
  {
    m_sName = p_sName;
  }
}
