import org.xcge.cards.CardStack;
import org.xcge.cards.FrenchDeck;
import org.xcge.cards.StatefulCard;
import org.xcge.cards.CardStateEnum;
import org.xcge.shared.Table;
import org.xcge.shared.engine.action.MoveCards;
import org.xcge.shared.engine.action.SingleCardCompare;

public class Test
{
  public Test() { }
  
  public static void main(String[] args)
  {
    Test test = new Test();
    
    test.war2();
  }
  
  public void war2()
  {
    Table oGameState = new Table(2);
    oGameState.setNumPlayAreaStacks(2);
    //oGameState.setNumPlayerStacks(0);
    //oGameState.setNumPlayerHandStacks(1);
    //oGameState.setDealer(oGameState.getSeatByIndex(0));
    
    FrenchDeckFactory oDeck = new FrenchDeckFactory(FrenchDeckFactory.Variant.STANDARD52);
    CardStack oCards = oDeck.getCardStack();
    oCards.shuffle();
    
    oGameState.deal(oCards, Table.DEAL_ALL);
    SingleCardCompare oCompare = new SingleCardCompare(SingleCardCompare.Ranking.ACE_HIGH);
    while(oGameState.getHandCardStack(/* player index */0, /* hand index */0).size() > 0 &&
          oGameState.getHandCardStack(/* player index */1, /* hand index */0).size() > 0)
    {
      int iCount0 = oGameState.getHandCardStack(0, 0).size() + oGameState.getPlayAreaCardStack(0).size();
      int iCount1 = oGameState.getHandCardStack(1, 0).size() + oGameState.getPlayAreaCardStack(1).size();
      if(iCount0 < 10)
      {
        System.out.print(" ");
      }
      System.out.print(iCount0 + " to ");
      if(iCount1 < 10)
      {
        System.out.print(" ");
      }
      System.out.print(iCount1 + ": ");
      
      try
      {
        oGameState.move(1, oGameState.getHandCardStack(0, 0), oGameState.getPlayAreaCardStack(0));
      }
      catch(final Throwable p_exp)
      {
        // S'ok.  We'll just let this one slide
      }
      
      try
      {
        oGameState.move(1, oGameState.getHandCardStack(1, 0), oGameState.getPlayAreaCardStack(1));
      }
      catch(final Throwable p_exp)
      {
        // S'ok.  We'll just let this one slide
      }
      // Now turn them face-up
      oGameState.setState(oGameState.getPlayAreaCardStack(0, 1), CardStateEnum.FACE_UP);
      oGameState.setState(oGameState.getPlayAreaCardStack(1, 1), CardStateEnum.FACE_UP);
      
      System.out.print("Comparing " +
                       oGameState.getPlayAreaTopCard(0).toString() +
                       " with " +
                       oGameState.getPlayAreaTopCard(1).toString() +
                       "...");
      switch(oCompare.doAction(oGameState.getPlayAreaTopCard(0),
                               oGameState.getPlayAreaTopCard(1),
                               null))
      {
        case P1:
          // move P2 table stack to P1 table stack
          oGameState.move(all, oGameState.getPlayAreaCardStack(1), top, oGameState.getPlayAreaCardStack(0), top, all_at_once);
          // flip them face down
          oGameState.setState(oGameState.getPlayAreaCardStack(0), CardStateEnum.FACE_DOWN);
          // shuffle
          oGameState.shuffle(oGameState.getPlayAreaCardStack(0));
          // print results
          System.out.println("Player 1 won " +
                             oGameState.getPlayAreaCardStack(0).size() +
                             " cards.");
          // move P1 table stack to bottom of P1 hand
          oGameState.move(all, oGameState.getPlayAreaCardStack(0), oGameState.getHandCardStack(0));
          break;
        case P2:
          // move P1 table stack to P2 table stack
          oGameState.move(all, oGameState.getPlayAreaCardStack(0), top, oGameState.getPlayAreaCardStack(1), top, all_at_once);
          // flip them face down
          oGameState.setState(oGameState.getPlayAreaCardStack(1), CardStateEnum.FACE_DOWN);
          // shuffle
          oGameState.shuffle(oGameState.getPlayAreaCardStack(1));
          // print results
          System.out.println("Player 2 won " +
                             oGameState.getPlayAreaCardStack(1).size() +
                             " cards.");
          // move P2 table stack to bottom of P2 hand
          oGameState.move(all, oGameState.getPlayAreaCardStack(1), oGameState.getHandCardStack(1));
          break;
        case TIE:
          System.out.println("It's a tie, this means WAR!");
          if(oGameState.getHandCardStack(0).size() > 3)
          {
            //oMove.doAction(oCards1, oP1Cards, 3, false);
          }
          else if(oGameState.getHandCardStack(0).size() > 0)
          {
            oMove.doAction(oCards1, oP1Cards, oCards1.size() - 1, false);
          }

          if(oCards2.size() > 3)
          {
            oMove.doAction(oCards2, oP2Cards, 3, false);
          }
          else if(oCards2.size() > 0)
          {
            oMove.doAction(oCards2, oP2Cards, oCards2.size() - 1, false);
          }
          break;
      }
    }
  }

  public void war()
  {
    FrenchDeckFactory oDeck = new FrenchDeckFactory(FrenchDeckFactory.Variant.STANDARD52);
    CardStack oCards = oDeck.getCardStack();
    oCards.shuffle();

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
    while((oCards1.size() + oP1Cards.size()) > 0 &&
          (oCards2.size() + oP2Cards.size()) > 0)
    {
      if(oCards1.size() + oP1Cards.size() < 10)
      {
        System.out.print(" ");
      }
      System.out.print((oCards1.size() + oP1Cards.size()) + " to ");
      if(oCards2.size() + oP2Cards.size() < 10)
      {
        System.out.print(" ");
      }
      System.out.print((oCards2.size() + oP2Cards.size()) + ": ");

      if(oCards1.size() > 0)
      {
        oP1Card = oCards1.takeTop();
        oP1Card.flip();
        oP1Cards.putTop(oP1Card);
      }

      if(oCards2.size() > 0)
      {
        oP2Card = oCards2.takeTop();
        oP2Card.flip();
        oP2Cards.putTop(oP2Card);
      }

      System.out.print("Comparing " + oP1Cards.peekTop().toShortString(true) + " with " + oP2Cards.peekTop().toShortString(true) + "...");
      switch(oCompare.doAction(oP1Cards.peekTop(), oP2Cards.peekTop(), null))
      {
        case P1:
          oP1Cards.putTop(oP2Cards);
          oP1Cards.setState(CardStateEnum.FACE_DOWN);
          oP1Cards.shuffle();
          System.out.println("Player 1 won " + oP1Cards.size() + " cards.");
          oCards1.putBottom(oP1Cards);
          break;
        case P2:
          oP2Cards.putTop(oP1Cards);
          oP2Cards.setState(CardStateEnum.FACE_DOWN);
          oP2Cards.shuffle();
          System.out.println("Player 2 won " + oP2Cards.size() + " cards.");
          oCards2.putBottom(oP2Cards);
          break;
        case TIE:
          System.out.println("It's a tie, this means WAR!");
          if(oCards1.size() > 3)
          {
            oMove.doAction(oCards1, oP1Cards, 3, false);
          }
          else if(oCards1.size() > 0)
          {
            oMove.doAction(oCards1, oP1Cards, oCards1.size() - 1, false);
          }

          if(oCards2.size() > 3)
          {
            oMove.doAction(oCards2, oP2Cards, 3, false);
          }
          else if(oCards2.size() > 0)
          {
            oMove.doAction(oCards2, oP2Cards, oCards2.size() - 1, false);
          }
          break;
      }
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
      if(p_bForceFaceUp && oCard.getState() == CardStateEnum.FACE_DOWN) oCard.flip();
      System.out.println(oCard.toString());
    }
  }
  
  public void testEngine()
  {
    FrenchDeckFactory oDeck = new FrenchDeckFactory();
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
