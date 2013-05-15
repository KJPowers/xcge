package org.xcge.engine.rules.action;


public interface IAction<E extends IAction<E>>
{
  public E getInstance();
  
//  public abstract void doAction(Table p_oGameState, final ActionCriteria p_oAC);
}
