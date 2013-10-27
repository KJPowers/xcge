package org.xcge.engine.rules;

import java.util.Set;

import org.xcge.engine.rules.action.IAction;
import org.xcge.engine.state.GameState;

/**
 * The object that gets generated from parsing a rule specification document.
 * The parsing / rule generation is done in a factory (TODO reference the
 * factory).
 *
 * This class keeps track of the current step, validates player input, and
 * manipulates the game state. It DOES NOT, however, store state - that is done
 * in {@link GameState}, which you will see passed around in the methods in this
 * class.
 *
 * Internally, it is a directional graph of {@link IStep} objects
 *
 * @author Keith Powers (K.J.Powers@gmail.com)
 * @see TODO
 */
public class Rules implements IRules
{
  private IStep m_rootStep;
  private IStep m_currentStep;

  public Rules(final IStep p_oRootStep)
  {

  }

  public void pump(final IAction p_oAction, final GameState p_oState) throws IllegalArgumentException
  {

  }

  // --== Getters ==--
  // Get info about seats and stacks
  public Set<String> getTableStacks()
  {
    ;
  }

  @Override
  public int getMinNumPlayers()
  {
    return m_minNumPlayers;
  }

  @Override
  public int getMaxNumPlayers()
  {
    return m_maxNumPlayers;
  }

  public String getName()
  {
    return m_gameName;
  }

  // Setters
  public void setMinPlayers(final int p_iMinPlayers)
  {
    m_minNumPlayers = p_iMinPlayers;
  }

  public void setMaxPlayers(final int p_iMaxPlayers)
  {
    m_maxNumPlayers = p_iMaxPlayers;
  }

  public void setName(final String p_sName)
  {
    m_gameName = p_sName;
  }

  @Override
  public Set<String> getTableStackNames()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Set<String> getSeatNames()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Set<String> getSeatStackNames()
  {
    // TODO Auto-generated method stub
    return null;
  }
}
