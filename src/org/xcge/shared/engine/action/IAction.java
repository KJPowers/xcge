package org.xcge.shared.engine.action;

import org.xcge.shared.Table;

public interface IAction<E extends IAction<E>>
{
  public E getInstance();
  
  public abstract void doAction(Table p_oGameState, final ActionCriteria p_oAC);
}
