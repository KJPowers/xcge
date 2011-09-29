import org.xcge.cards.CardStack;
import org.xcge.cards.Deck;
import org.xcge.cards.StatefulCard;
import org.xcge.cards.CardState;
import org.xcge.shared.engine.action.MoveCards;

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
    Deck oDeck = new Deck();
    CardStack oCards = oDeck.getCardStack();

    // Make the player decks
    CardStack oCards1 = new CardStack();
    CardStack oCards2 = new CardStack();

    // Deal the cards
    MoveCards oMove = new MoveCards();
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
    
    System.out.println("Deck:");
    oCards.printStack(false);
    System.out.println("Deck 1:");
    oCards1.printStack(false);
    System.out.println("Deck 2:");
    oCards2.printStack(true);
    System.out.println("Deck 2 (2):");
    oCards2.printStack(false);
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
