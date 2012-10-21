package org.xcge.shared.engine;

import java.io.Serializable;

/**
 * 
 *
 * @author Keith Powers (K.J.Powers@gmail.com)
 */
public class StackDescriptor implements Serializable
{
  private static final long serialVersionUID = 7063118999085168424L;
  
  private String m_strSeatName;
  private String m_strStackName;

  public StackDescriptor(final String p_strSeatName, final String p_strStackName)
  {
    m_strSeatName = p_strSeatName;
    m_strStackName = p_strStackName;
  }
  
  public StackDescriptor()
  {
    this(null, null);
  }

  public String getSeatName()
  {
    return m_strSeatName;
  }

  public void setSeatName(String p_strSeatName)
  {
    m_strSeatName = p_strSeatName;
  }

  public String getStackName()
  {
    return m_strStackName;
  }

  public void setStackName(String p_strStackName)
  {
    m_strStackName = p_strStackName;
  }
  
  @Override
  public boolean equals(final Object p_o)
  {
    if(this == p_o)
    {
      return true;
    }
    if(p_o == null ||
       !(p_o instanceof StackDescriptor))
    {
      return false;
    }
    if((m_strSeatName != null && m_strSeatName.equals(((StackDescriptor)p_o).m_strSeatName)) ||
       (m_strSeatName == null && ((StackDescriptor)p_o).m_strSeatName == null))
    {
      if((m_strStackName != null && m_strStackName.equals(((StackDescriptor)p_o).m_strStackName)) ||
          (m_strStackName == null && ((StackDescriptor)p_o).m_strStackName == null))
      {
        return true;
      }
    }
    return false;
  }
  
  @Override
  public int hashCode()
  {
    int iHashCode = 0;
    if(m_strSeatName != null)
    {
      iHashCode += 37 * m_strSeatName.hashCode();
    }
    if(m_strStackName != null)
    {
      iHashCode += 37 * m_strStackName.hashCode();
    }
    return iHashCode;
  }
}
