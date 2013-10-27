package org.xcge.engine.state;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

import org.xcge.cards.CardStack;
import org.xcge.engine.rules.IRules;

/**
 * Track and move cards
 * @author Keith Powers (K.J.Powers@gmail.com)
 */
public class CardTracker
{
  public static final String TABLE = "Table";
  
  final LinkedHashMap<String, HashMap<String, CardStack>> m_hmCards;
  public int                                              m_iNumTableGroups;
  public int                                              m_iNumSeats;
  public int                                              m_iNumSeatGroups;
  
  /**
   * 
   * @param p_iRules
   */
  public CardTracker(final IRules p_iRules)
  {
    this(p_iRules.getTableStackNames(), p_iRules.getSeatNames(), p_iRules.getSeatStackNames());
  }

  /**
   * 
   * @param p_colTableStackNames
   * @param p_colSeatNames
   * @param p_colSeatStackNames
   */
  protected CardTracker(final Set<String> p_colTableStackNames,
                        final Set<String> p_colSeatNames,
                        final Set<String> p_colSeatStackNames)
  {
    try
    {
      m_iNumTableGroups = validateStackNames(p_colTableStackNames);
      m_iNumSeats       = validateSeatNames (p_colSeatNames);
      m_iNumSeatGroups  = validateStackNames(p_colSeatStackNames);
    }
    catch(Throwable p_ex)
    {
      ;
    }
    
    m_hmCards = new LinkedHashMap<String, HashMap<String, CardStack>>(m_iNumSeats + 1);
    HashMap<String, CardStack> hmCards = new HashMap<String, CardStack>(m_iNumTableGroups);
    m_hmCards.put(TABLE, hmCards);
    for(String strStackName : p_colTableStackNames)
    {
      hmCards.put(strStackName, new CardStack());
    }
    
    for(String strSeatName : p_colSeatNames)
    {
      hmCards = new HashMap<String, CardStack>(m_iNumSeatGroups);
      m_hmCards.put(strSeatName, hmCards);
      for(String strStackName : p_colSeatStackNames)
      {
        hmCards.put(strStackName, new CardStack());
      }
    }
  }
  
  /**
   * Get a CardStack using a StackDescriptor
   * @param p_oStackDescriptor
   * @return the CardStack described by p_StackDescriptor
   */
  public CardStack getStack(final StackDescriptor p_StackDescriptor)
  {
    return m_hmCards.get(p_StackDescriptor.getSeatName()).get(p_StackDescriptor.getStackName());
  }

  public void moveCards(final StackDescriptor p_fromStack,
                        final StackDescriptor p_toStack,
                        final int             p_iCount,
                        final boolean         p_bAsGroup)
  {
    moveCards(p_fromStack,
              p_toStack,
              true,
              true,
              p_iCount,
              p_bAsGroup);
  }
  
  public void moveCards(final StackDescriptor p_fromStack,
                        final StackDescriptor p_toStack,
                        final boolean         p_bFromTop,
                        final boolean         p_bToTop,
                        final int             p_iCount,
                        final boolean         p_bAsGroup)
  {
    // Temporary stack
    final CardStack oTempStack = p_bFromTop ? getStack(p_fromStack).takeTop(p_iCount) : getStack(p_fromStack).takeBottom(p_iCount);
    
    // If moving TT or BB, it matters if it's as a group.  Reverse when necessary.
    // If moving TB or BT, it doesn't matter if it's as a group.  Don't waste time reversing.
    if(!p_bAsGroup && (p_bFromTop == p_bToTop))
    {
      oTempStack.reverse();
    }
    
    if(p_bToTop)
    {
      getStack(p_toStack).putTop(oTempStack);
    }
    else
    {
      getStack(p_toStack).putBottom(oTempStack);
    }
  }
  
  public StackDescriptor getStackDescriptor(final String p_strSeatName, final String p_strStackName)
  {
    return new StackDescriptor(p_strSeatName, p_strStackName);
  }


  /**
   * Make sure someone doesn't try to use a reserved name for a seat:
   * - Table: the main play area
   * @param p_colSeatNames a Set (to prevent duplicates) of stack names
   * @return the number of seats
   */
  protected int validateSeatNames(final Set<String> p_colSeatNames)
  {
    for(String strSeatName : p_colSeatNames)
    {
      if(TABLE.equals(strSeatName))
      {
        throw new IllegalArgumentException(TABLE +
                                           " is reserved and cannot be used as a seat name.");
      }
    }
    return p_colSeatNames.size();
  }
  
  /**
   * Make sure someone doesn't try to use a reserved name for a stack
   * @param p_colStackNames a Set (to prevent duplicates) of stack names
   * @return the number of stacks
   */
  protected int validateStackNames(final Set<String> p_colStackNames)
  {
    return p_colStackNames.size();
  }
}
