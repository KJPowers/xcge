package org.xcge.shared.engine.rules;

/**
 * The root of all the rules. Subclasses of this will determine how the step is
 * handled.
 * 
 * @author Keith Powers (K.J.Powers@gmail.com)
 */
public interface IStep
{
  public IStep getNextStep();
}
