package org.xcge.engine.rules;

import java.util.Set;

public interface IRules
{
  /**
   * Get the table's stacks' names.
   *
   * @return
   */
  public Set<String> getTableStackNames();

  /**
   * Get the names of the seats. If order is important, return a TreeSet or a
   * LinkedHashSet. If seat names are not important, return a set with N
   * elements, where N = the number of seats and each seat is named uniquely (by
   * number might be handy here).
   *
   * @return
   */
  public Set<String> getSeatNames();

  /**
   * Get the seats' stacks' names. If asymmetric gameplay is desired (where
   * certain players have different stacks), enforce this at the visibility
   * level within the game.
   *
   * @return
   */
  public Set<String> getSeatStackNames();

  public int getMinNumPlayers();

  public int getMaxNumPlayers();
}
