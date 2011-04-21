import java.io.FileNotFoundException;
import java.lang.String;
import org.stupidiville.games.oxcgen.shared.XMLRulesParser;

public class Testing {
  public Testing()
  { }
  
  public void testParsing(final String p_strPath)
  {
    XMLRulesParser myRulesParser = new XMLRulesParser();
    try
    {
      myRulesParser.readRulesFromFile(p_strPath);
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
