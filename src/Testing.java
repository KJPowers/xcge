import java.io.FileNotFoundException;
import java.lang.String;

import org.xcge.engine.XMLRulesParser;

public class Testing {
  public Testing()
  { }
  
  public void testParsing(final String p_strSchema, final String p_strPath)
  {
    XMLRulesParser myRulesParser = new XMLRulesParser(p_strSchema);
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
    if(args.length == 2)
    {
      String strSchema = args[0];
      String strTemp = new String();
      if(strSchema != null && strSchema.trim().length() > 0)
      {
        strTemp = " against " + strSchema;
      }

      Testing test = new Testing();
      
      String strFile = args[1];

      // Do the test
      System.out.println("--==Evaluating " + strFile + strTemp + " ==--");
      test.testParsing(strSchema, strFile);
    }
  }
}
