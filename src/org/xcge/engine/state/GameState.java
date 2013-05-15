package org.xcge.engine.state;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xcge.engine.Score;
import org.xcge.shared.Seat;


/**
 * The GameState class keeps track of - you guessed it - the game state.  This
 * includes the location of all the cards (by extending/implementing CardTracker), the score,
 * whose turn it is, ...?.
 * 
 * 
 * @author Keith Powers - K.J.Powers@gmail.com
 *
 */
public class GameState implements Cloneable
{
  private final List<Seat> m_alSeats;
  private final Map<Seat, Score> m_scoresBySeat;
  private int m_iCurrentPlayerIndex = 0;
  private CardTracker m_oCardManager;
  
  public GameState(final int p_iNumSeats)
  {
    m_alSeats = new ArrayList<Seat>(p_iNumSeats);
    m_scoresBySeat = new HashMap<Seat, Score>();
  }
  
  //
  
//  // Getters / setters
//  public Player getCurrentPlayer()
//  {
//    return m_alPlayers.get(m_iCurrentPlayerIndex);
//  }
//  
//  protected ArrayList<Player> getPlayers()
//  {
//    return m_alPlayers;
//  }
//  
//  public void setPlayers(ArrayList<Player> p_alPlayers)
//  {
//    m_alPlayers = p_alPlayers;
//  }

}
