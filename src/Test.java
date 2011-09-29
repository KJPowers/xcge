import org.xcge.cards.CardStack;
import org.xcge.cards.Deck;
import org.xcge.cards.StatefulCard;
import org.xcge.cards.CardState;
import org.xcge.shared.engine.action.MoveCards;
import org.xcge.shared.engine.action.SingleCardCompare;

public class Test
{
  public Test() { }
  
  public static void main(String[] args)
  {
    Test test = new Test();
    
    test.war();
  }

  public void war()
  {
    Deck oDeck = new Deck(Deck.Type.STANDARD52);
    CardStack oCards = oDeck.getCardStack();

    // Make the player decks
    CardStack oCards1 = new CardStack();
    CardStack oCards2 = new CardStack();

    // Deal the cards
    MoveCards oMove = new MoveCards();
    SingleCardCompare oCompare = new SingleCardCompare(SingleCardCompare.Ranking.ACE_HIGH);
    boolean b = true;
    while(oCards.size() > 0)
    {
      if(b)
      { oMove.doAction(oCards, oCards1);
      } else
      { oMove.doAction(oCards, oCards2);
      }
      b = !b;
    }
    
    CardStack oP1Cards = new CardStack();
    CardStack oP2Cards = new CardStack();
    StatefulCard oP1Card;
    StatefulCard oP2Card;
    while(oCards1.size() > 0 && oCards2.size() > 0)
    {
      oP1Card = oCards1.takeTop();
      oP1Card.flip();

      oP2Card = oCards2.takeTop();
      oP2Card.flip();

      oP1Cards.putTop(oP1Card);
      oP2Cards.putTop(oP2Card);
    }
    if(oCards2.size() == 0 && oCards1.size() == 52)
    { System.out.println("Player 1 wins!");
    } else if(oCards1.size() == 0 && oCards2.size() == 52)
    { System.out.println("Player 2 wins!");
    } else
    { System.out.println("WTF happened?  You lost cards!  Player 1 has " + oCards1.size() + " and Player 2 has " + oCards2.size());
    }
  }

  private void printStack(final CardStack p_oCards, final boolean p_bForceFaceUp)
  {
    StatefulCard oCard;
    while(p_oCards.size() > 0)
    {
      oCard = p_oCards.takeTop();
      if(p_bForceFaceUp && oCard.getState() == CardState.FACE_DOWN) oCard.flip();
      System.out.println(oCard.toString());
    }
  }
  
  public void testEngine()
  {
    Deck oDeck = new Deck();
    CardStack oCards = oDeck.getCardStack();
    oCards.flip();
    
    StatefulCard oCard;
    while(oCards.size() > 0)
    {
      oCard = oCards.takeTop();
      oCard.flip();
      System.out.println(oCard);
    }
  }
}
