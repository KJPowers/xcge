import org.xcge.cards.CardStack;
import org.xcge.cards.Deck;
import org.xcge.cards.StatefulCard;

public class Test
{
  public Test() { }
  
  public static void main(String[] args)
  {
    Test test = new Test();
    
    test.testEngine();
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
