import java.io.FileNotFoundException;
import java.lang.String;
import org.stupidiville.games.oxcgen.shared.Rules;

public class Testing {
  public Testing()
  { }
  
  public void testParsing(final String p_strPath)
  {
    Rules myRules = new Rules();
    try
    {
      myRules.readRulesFromFile(p_strPath);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
  }
  
  public static void main(String[] args)
  {
    Testing test = new Testing();
    for(String str : args)
    {
      System.out.println("--==Evaluating " + str + "==--");
      test.testParsing(str);
    }
  }
}
