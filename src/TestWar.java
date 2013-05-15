import java.io.File;

import org.xcge.cards.CardStack;
import org.xcge.cards.CardStateEnum;
import org.xcge.cards.StatefulCard;
import org.xcge.engine.parser.IRulesParser;
import org.xcge.engine.rules.IStep;
import org.xcge.engine.rules.Rules;

public class TestWar
{
  public TestWar() { }
  
  public static void main(String[] args)
  {
    TestWar test = new TestWar();
    
    test.war();
  }
  
  public void war()
  {
//    FrenchDeckFactory oDeck = new FrenchDeckFactory(FrenchDeckFactory.Variant.STANDARD52);
//    CardStack oCards = oDeck.getCardStack();
//    oCards.shuffle();
//
//    // Make the player decks
//    CardStack oCards1 = new CardStack();
//    CardStack oCards2 = new CardStack();
//
//    // Deal the cards
//    MoveCards oMove = new MoveCards();
//    SingleCardCompare oCompare = new SingleCardCompare(SingleCardCompare.Ranking.ACE_HIGH);
//    boolean b = true;
//    while(oCards.size() > 0)
//    {
//      if(b)
//      { oMove.doAction(oCards, oCards1);
//      } else
//      { oMove.doAction(oCards, oCards2);
//      }
//      b = !b;
//    }
//    
//    CardStack oP1Cards = new CardStack();
//    CardStack oP2Cards = new CardStack();
//    StatefulCard oP1Card;
//    StatefulCard oP2Card;
//    while((oCards1.size() + oP1Cards.size()) > 0 &&
//          (oCards2.size() + oP2Cards.size()) > 0)
//    {
//      if(oCards1.size() + oP1Cards.size() < 10)
//      {
//        System.out.print(" ");
//      }
//      System.out.print((oCards1.size() + oP1Cards.size()) + " to ");
//      if(oCards2.size() + oP2Cards.size() < 10)
//      {
//        System.out.print(" ");
//      }
//      System.out.print((oCards2.size() + oP2Cards.size()) + ": ");
//
//      if(oCards1.size() > 0)
//      {
//        oP1Card = oCards1.takeTop();
//        oP1Card.flip();
//        oP1Cards.putTop(oP1Card);
//      }
//
//      if(oCards2.size() > 0)
//      {
//        oP2Card = oCards2.takeTop();
//        oP2Card.flip();
//        oP2Cards.putTop(oP2Card);
//      }
//
//      System.out.print("Comparing " + oP1Cards.peekTop().toShortString(true) + " with " + oP2Cards.peekTop().toShortString(true) + "...");
//      switch(oCompare.doAction(oP1Cards.peekTop(), oP2Cards.peekTop(), null))
//      {
//        case P1:
//          oP1Cards.putTop(oP2Cards);
//          oP1Cards.setState(CardStateEnum.FACE_DOWN);
//          oP1Cards.shuffle();
//          System.out.println("Player 1 won " + oP1Cards.size() + " cards.");
//          oCards1.putBottom(oP1Cards);
//          break;
//        case P2:
//          oP2Cards.putTop(oP1Cards);
//          oP2Cards.setState(CardStateEnum.FACE_DOWN);
//          oP2Cards.shuffle();
//          System.out.println("Player 2 won " + oP2Cards.size() + " cards.");
//          oCards2.putBottom(oP2Cards);
//          break;
//        case TIE:
//          System.out.println("It's a tie, this means WAR!");
//          if(oCards1.size() > 3)
//          {
//            oMove.doAction(oCards1, oP1Cards, 3, false);
//          }
//          else if(oCards1.size() > 0)
//          {
//            oMove.doAction(oCards1, oP1Cards, oCards1.size() - 1, false);
//          }
//
//          if(oCards2.size() > 3)
//          {
//            oMove.doAction(oCards2, oP2Cards, 3, false);
//          }
//          else if(oCards2.size() > 0)
//          {
//            oMove.doAction(oCards2, oP2Cards, oCards2.size() - 1, false);
//          }
//          break;
//      }
//    }
//    if(oCards2.size() == 0 && oCards1.size() == 52)
//    { System.out.println("Player 1 wins!");
//    } else if(oCards1.size() == 0 && oCards2.size() == 52)
//    { System.out.println("Player 2 wins!");
//    } else
//    { System.out.println("WTF happened?  You lost cards!  Player 1 has " + oCards1.size() + " and Player 2 has " + oCards2.size());
//    }
  }

  private void printStack(final CardStack p_oCards, final boolean p_bForceFaceUp)
  {
    StatefulCard oCard;
    while(p_oCards.size() > 0)
    {
      oCard = p_oCards.takeTop();
      if(p_bForceFaceUp && oCard.getState() == CardStateEnum.FACE_DOWN) oCard.flip();
      System.out.println(oCard.toString());
    }
  }
  
  public void testEngine()
  {
//    FrenchDeckFactory oDeck = new FrenchDeckFactory();
//    CardStack oCards = oDeck.getCardStack();
//    oCards.flip();
//    
//    StatefulCard oCard;
//    while(oCards.size() > 0)
//    {
//      oCard = oCards.takeTop();
//      oCard.flip();
//      System.out.println(oCard);
//    }
  }
  
  public Rules getWarRules()
  {
    final IStep oRootStep;
    oRootStep = new 
    
    final Rules oWarRules = new Rules(null);
    
    return null;
  }
  
  private final class WarRulesFactory implements IRulesParser
  {

    @Override
    public void initialize()
    {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void parse(File p_oFile)
    {
      // TODO Auto-generated method stub
      
    }

    @Override
    public IStep getRootStep() throws IllegalStateException
    {
      // TODO Auto-generated method stub
      return null;
    }
    
  }
}
