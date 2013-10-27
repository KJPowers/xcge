package org.xcge.engine.table;

import org.xcge.engine.rules.IRules;
import org.xcge.engine.state.CardTracker;

public class Table
{
  final IRules      m_iRules;
  final CardTracker m_oCardTracker;
  final Seat[]      m_colSeats;

  // final LinkedHashMap<String, Player> m_hmPlayers;

  Table(final IRules p_iRules)
  {
    m_iRules = p_iRules;

    m_oCardTracker = new CardTracker(m_iRules);
    // m_hmPlayers = new LinkedHashMap<String,
    // Player>(m_iRules.getSeatNames().size());

    m_colSeats = new Seat[m_iRules.getMaxNumPlayers()];
  }

  public void startGame()
  {
    ;
  }

  public boolean isGameInProgress()
  {
    // TODO
    return false;
  }

  public int numSeats()
  {
    return 0;
  }

  public CardTracker getCardTracker()
  {
    return m_oCardTracker;
  }
}
