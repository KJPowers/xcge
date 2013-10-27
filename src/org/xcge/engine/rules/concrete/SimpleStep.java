package org.xcge.engine.rules.concrete;

import org.xcge.engine.rules.IStep;


/**
 * Much like a simple type in XML, this step can only do one action before
 * specifying the next step. Will this actually be useful? Who knows.
 * 
 * @author Keith Powers (K.J.Powers@gmail.com)
 */
public abstract class SimpleStep implements IStep
{
  IStep m_oNextStep = null;
  
  public IStep getNextStep() { return m_oNextStep; }
}
