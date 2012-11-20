package org.xcge.table;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.xcge.cards.CardStack;
import org.xcge.exceptions.NoSuchStackException;	
import org.xcge.shared.engine.StackDescriptor;

/**
 * Track and move cards
 * @author Keith Powers (K.J.Powers@gmail.com)
 */
public class Tracker
{
  public static final String TABLE = "Table";
  
  final HashMap<StackDescriptor, CardStack> m_hmStacks;
  
  public Tracker(final Set<StackDescriptor> p_colStacks)
  {
    m_hmStacks = new HashMap<StackDescriptor, CardStack>(p_colStacks.size());
    HashSet<String> colSeatNames = new HashSet<String>();
    HashSet<String> colStackNames = new HashSet<String>();
    for(StackDescriptor oStack : p_colStacks)
    {
      m_hmStacks.put(oStack, new CardStack());
      if(!colSeatNames.contains(oStack.getSeatName()))
      {
        colSeatNames.add(oStack.getSeatName());
      }
      if(!colStackNames.contains(oStack.getStackName()))
      {
        colStackNames.add(oStack.getStackName());
      }
    }
  }
  
  public Tracker(final Set<String> p_colTableStacks,
                 final Set<String> p_colSeatNames,
                 final Set<String> p_colSeatStacks)
  {
    m_hmStacks = new HashMap<StackDescriptor, CardStack>(p_colTableStacks.size() + p_colSeatNames.size() * p_colSeatStacks.size());
    for(final String strTableStack : p_colTableStacks)
    {
      m_hmStacks.put(new StackDescriptor(TABLE, strTableStack), new CardStack());
    }
    for(final String strSeat : p_colSeatNames)
    {
      for(final String strSeatStack : p_colSeatStacks)
      {
        m_hmStacks.put(new StackDescriptor(strSeat, strSeatStack), new CardStack());
      }
    }
  }
  
//  /**
//   * 
//   * @param p_colTableStackNames
//   * @param p_colSeatNames
//   * @param p_colSeatStackNames
//   */
//  public CardManager(final Set<String> p_colTableStackNames,
//                     final Set<String> p_colSeatNames,
//                     final Set<String> p_colSeatStackNames)
//  {
//    try
//    {
//      m_iNumTableGroups = validateStackNames(p_colTableStackNames);
//      m_iNumSeats       = validateSeatNames (p_colSeatNames);
//      m_iNumSeatGroups  = validateStackNames(p_colSeatStackNames);
//    }
//    catch(Throwable p_ex)
//    {
//      ;
//    }
//    
//    m_hmCards = new HashMap<String, HashMap<String, CardStack>>(m_iNumSeats + 1);
//    HashMap<String, CardStack> hmCards = new HashMap<String, CardStack>(m_iNumTableGroups);
//    m_hmCards.put(TABLE, hmCards);
//    for(String strStackName : p_colTableStackNames)
//    {
//      hmCards.put(strStackName, new CardStack());
//    }
//    
//    for(String strSeatName : p_colSeatNames)
//    {
//      hmCards = new HashMap<String, CardStack>(m_iNumSeatGroups);
//      m_hmCards.put(strSeatName, hmCards);
//      for(String strStackName : p_colSeatStackNames)
//      {
//        hmCards.put(strStackName, new CardStack());
//      }
//    }
//  }
  
  /**
   * Get a CardStack using a StackDescriptor
   * @param p_oStackDescriptor
   * @return the CardStack described by p_StackDescriptor
   * @throws NoSuchStackException 
   */
  public CardStack getStack(final StackDescriptor p_oStackDescriptor) throws NoSuchStackException
  {
    if(!m_hmStacks.containsKey(p_oStackDescriptor))
    {
      throw new NoSuchStackException("No stack named " + p_oStackDescriptor.getStackName() +
                                     " exists for the player " + p_oStackDescriptor.getSeatName() +
                                     ".");
    }
    return m_hmStacks.get(p_oStackDescriptor);
  }
  
  /**
   * Get a CardStack belonging to the table using the String name of the stack.
   * @param p_oStackDescriptor
   * @return the CardStack described by p_StackDescriptor
   */
  public CardStack getTableStack(final String p_strStackName)
  {
    return m_hmStacks.get(new StackDescriptor(TABLE, p_strStackName));
  }
  
  /**
   * Cheap trick.  This could easily be done outside this method, but oh well :)
   * 
   * @param p_iCount
   * @param p_fromStack
   * @param p_toStack
   * @param p_eMoveType
   */
  public void moveCards(final int             p_iCount,
                        final StackDescriptor p_fromStack,
                        final StackDescriptor p_toStack,
                        final MoveTypeEnum    p_eMoveType,
                        final boolean         p_bAsGroup)
  {
    p_eMoveTypeEnum.move(p_iCount, p_fromStack, p_toStack);
//    // Temporary stack
//    final CardStack oTempStack = p_bFromTop ? getStack(p_fromStack).takeTop(p_iCount) : getStack(p_fromStack).takeBottom(p_iCount);
//    
//    // If moving TT or BB, it matters if it's as a group.  Reverse when necessary.
//    // If moving TB or BT, it doesn't matter if it's as a group.  Don't waste time reversing.
//    if(!p_bAsGroup && (p_bFromTop == p_bToTop))
//    {
//      oTempStack.reverse();
//    }
//    
//    if(p_bToTop)
//    {
//      getStack(p_toStack).putTop(oTempStack);
//    }
//    else
//    {
//      getStack(p_toStack).putBottom(oTempStack);
//    }
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
