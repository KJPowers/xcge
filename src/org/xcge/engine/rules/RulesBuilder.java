package org.xcge.engine.rules;

public class RulesBuilder
{
  public static void setNextStep(final SimpleStep p_oBaseStep, final IStep p_oNextStep)
  {
    p_oBaseStep.m_oNextStep = p_oNextStep;
  }
}
