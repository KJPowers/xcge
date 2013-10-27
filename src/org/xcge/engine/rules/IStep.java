package org.xcge.engine.rules;

import org.xcge.engine.state.GameState;

/**
 * The root of all the rules. Subclasses of this will determine how the step is
 * handled.
 * 
 * @see TODO
 * @author Keith Powers (K.J.Powers@gmail.com)
 */
public interface IStep
{
  /**
   * Do some action and tell the {@link Rules} which step to process next.
   * @param p_gameState The game's state
   * @return The next step to process
   */
  public IStep doAction(final GameState p_gameState);
}
