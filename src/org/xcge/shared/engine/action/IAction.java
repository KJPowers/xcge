package org.xcge.shared.engine.action;

import org.xcge.shared.GameState;

public interface IAction<E extends IAction<E>>
{
  public E getInstance();
  
  public abstract void doAction(GameState p_oGameState, final ActionCriteria p_oAC);
}
