package org.xcge.engine.parser;

import java.io.File;

import org.xcge.engine.rules.IStep;

/**
 * Interface that defines the way parsers will turn 
 *
 * @author Keith Powers (K.J.Powers@gmail.com)
 *
 */
public interface IRulesParser
{
  /**
   * Do any necessary initialization
   */
  public void initialize();
  
  /**
   * Validate the rules file and get everything from it.
   * 
   * @param p_oFile
   */
  public void parse(final File p_oFile);
  /**
   * Get the root step after parsing
   *  
   * @return
   * @throws IllegalStateException if it is called before actually parsing a rules file
   */
  public IStep getRootStep() throws IllegalStateException;
}
