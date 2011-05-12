package org.xcge.shared;

import org.xcge.shared.XCGEErrorHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import org.xcge.shared.Game;
import org.xcge.shared.XCGEStatics;

public class XMLRulesParser implements Iterator
{
  public enum Asdf
  {
    //PLAYER_INFO,
    PI_I_MIN_PLAYERS,
    PI_I_MAX_PLAYERS,
    PI_I_TEAM_SIZE,
    PI_B_TEAM_DOUBLES,
    
    //DECK_TYPE,
    DT_STANDARD,
    DT_PINOCHLE
  }
  
  protected boolean m_bDoublesAllowed;
  protected int m_iMinPlayers = -1;
  protected int m_iMaxPlayers = -1;
  protected int m_iTeamSize = -1;
  protected String m_sName = "";
  private String m_strRuleFile;
  private String m_strSchemaFile;
  private Document m_doc;
  private DocumentBuilderFactory m_dbf;
  private SchemaFactory m_sf;
  private Game m_oGame;
  
  public XMLRulesParser()
  {
    this(null);
  }

  public XMLRulesParser(final String p_strSchemaFile)
  {
    m_strSchemaFile = p_strSchemaFile;
  }

  /* --------======== ========--------
   * Big comment to tell myself where the action is
   * --------======== ========--------
   */
  public void readRulesFromFile(final String p_strFileName) throws FileNotFoundException 
  {
    m_strRuleFile = p_strFileName;
    setupParsers();
    if(validateXML())
    {
      Element eleRoot = getBasicGameInfo();
      printTree("", eleRoot);
      m_oGame = parseXML();
    }
  }    

  private void setupParsers()
  {
    m_dbf = DocumentBuilderFactory.newInstance();

    if(m_strSchemaFile != null && m_strSchemaFile.trim().length() > 0)
    {
      m_dbf.setValidating(false);
      m_dbf.setNamespaceAware(true);

      if(m_strSchemaFile.substring(m_strSchemaFile.length() - 3).equals("xsd"))
      {
//        m_sf = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        m_sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
      }
      else // if()
      {
        System.setProperty(SchemaFactory.class.getName() + ":" + XMLConstants.RELAXNG_NS_URI, "com.thaiopensource.relaxng.jaxp.CompactSyntaxSchemaFactory");
        m_sf = SchemaFactory.newInstance(XMLConstants.RELAXNG_NS_URI);
      }
    }
  }
  
  private boolean validateXML()
  {
    boolean retVal = false;
    try
    {
      if(m_strSchemaFile != null && m_strSchemaFile.trim().length() > 0)
      {
        m_dbf.setSchema(m_sf.newSchema(new Source[] { new StreamSource(m_strSchemaFile) }));
      }

      //Using factory get an instance of document builder
      DocumentBuilder db = m_dbf.newDocumentBuilder();
      
      //parse using builder to get DOM representation of the XML file
      db.setErrorHandler(new XCGEErrorHandler());
      try
      {
        m_doc = db.parse(m_strRuleFile);
        retVal = true;
      }
      catch(SAXParseException p_exp)
      {
        final String strTemp;
        if(m_strSchemaFile != null && m_strSchemaFile.trim().length() > 0)
          strTemp = " against " + m_strSchemaFile;
        else
          strTemp = "";

        System.out.println("Error parsing " + m_strRuleFile + strTemp + ": " + p_exp.toString());
      }
    } catch(ParserConfigurationException p_exp)
    {
      p_exp.printStackTrace();
    } catch(SAXException p_exp)
    {
      p_exp.printStackTrace();
    } catch(IOException p_exp)
    {
      p_exp.printStackTrace();
    }

    return retVal;
  }
  
  private void printTree(final String p_strPrefix, final Node p_element)
  {
    NamedNodeMap nnmAttr = p_element.getAttributes();
    NodeList nlChildren = p_element.getChildNodes();
    String strName = p_element.getNodeName();
    String strValue = p_element.getNodeValue() == null ? "" : p_element.getNodeValue().trim();
    int depth = p_strPrefix.length();

    if((strName == null || strName.charAt(0) == '#') &&         // It has no name
       (strValue == null || strValue.trim().length() == 0) &&   // its value is null and
       (nnmAttr == null || nnmAttr.getLength() == 0) &&         // it has no attributes and
       (nlChildren == null || nlChildren.getLength() == 0))     // it has no children
    {
      return;
    }

    System.out.println(p_strPrefix + "depth: " + depth);
    System.out.print(p_strPrefix + strName + " (" + getStrNodeType(p_element.getNodeType()) + "): " + strValue.trim());

    // Attributes
    if(nnmAttr != null && nnmAttr.getLength() > 0)
    {
      System.out.print(" [");
      for(int i = 0; i < nnmAttr.getLength(); i++)
      {
        Node node = nnmAttr.item(i);
        if(i > 0) System.out.print(", ");
        System.out.print(node.getNodeName() + "=" + node.getNodeValue());
      }
      System.out.print("]");
    }
    System.out.println();
    
    //Child Elements
    for(int i = 0 ; i < nlChildren.getLength(); i++)
    {
      Node node = nlChildren.item(i);
      printTree(p_strPrefix + ' ', node);
    }
  }

  private String getStrNodeType(final short p_iNodeType)
  {
    switch(p_iNodeType)
    {
      case Node.ELEMENT_NODE:
        return "Element";
      case Node.ATTRIBUTE_NODE:
        return "Attr";
      case Node.TEXT_NODE:
        return "Text";
      case Node.CDATA_SECTION_NODE:
        return "CDATASection";
      case Node.ENTITY_REFERENCE_NODE:
        return "EntityReference";
      case Node.ENTITY_NODE:
        return "Entity";
      case Node.PROCESSING_INSTRUCTION_NODE:
        return "ProcessingInstruction";
      case Node.COMMENT_NODE:
        return "Comment";
      case Node.DOCUMENT_NODE:
        return "Document";
      case Node.DOCUMENT_TYPE_NODE:
        return "DocumentType";
      case Node.DOCUMENT_FRAGMENT_NODE:
        return "DocumentFragment";
      case Node.NOTATION_NODE:
        return "Notation";
      default:
        return null;
    }
  }
  
  private Element getBasicGameInfo()
  {
    final Element eleRoot = m_doc.getDocumentElement();
//    System.out.print("root: " + eleRoot.getNodeName() + " (");
    NamedNodeMap nnm = eleRoot.getAttributes();
    for(int i = 0; i < nnm.getLength(); i++)
    {
      Node node = nnm.item(i);
      if(i > 0) System.out.print(", ");
//      System.out.print(node.getNodeName() + "=" + node.getNodeValue());
    }    
//    System.out.println(")");
    
    return eleRoot;
  }
  
  public Game parseXML()
  {
    Game retGame = new Game();

    final Element eleRoot = m_doc.getDocumentElement();
    //XML Schema can't guarantee a root element value, so make sure it's "GAME" (case insensitive)
    if(!XCGEStatics.GAME.equals(eleRoot.getNodeName().toUpperCase()))
    {
      return null;
    }

    // First attempt: read attributes for game name
    NamedNodeMap nnm = eleRoot.getAttributes();
    for(int i = 0; i < nnm.getLength(); i++)
    {
      Node node = nnm.item(i);
      if(XCGEStatics.NAME.equals(node.getNodeName().toUpperCase()))
      {
        retGame.setName(node.getNodeValue());
      }
//      if(i > 0) System.out.print(", ");
//      System.out.print(node.getNodeName() + "=" + node.getNodeValue());

    }    
    

    return retGame;
  }

  /*public void readRulesFromFileInputStream(final FileInputStream p_FIS)
  {
    try
    {
      parser.parse(p_sFileName);
    } catch (SAXException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }*/
  
  // Getters
  public boolean getDoublesAllowed() { return m_bDoublesAllowed; }
  public int getMinPlayers()         { return m_iMinPlayers; }
  public int getMaxPlayers()         { return m_iMaxPlayers; }
  public int getTeamSize()           { return m_iTeamSize; }
  public String getName()            { return m_sName; }
  
  // Setters
  public void setDoublesAllowed(final boolean p_bDoublesAllowed)
  { m_bDoublesAllowed = p_bDoublesAllowed;
  }
  public void setMinPlayers(final int p_iMinPlayers)
  { m_iMinPlayers = p_iMinPlayers;
  }
  public void setMaxPlayers(final int p_iMaxPlayers)
  { m_iMaxPlayers = p_iMaxPlayers;
  }
  public void setTeamSize (final int p_iTeamSize)
  { m_iTeamSize = p_iTeamSize ;
  }
  public void setName (final String p_sName)
  { m_sName = p_sName;
  }

  @Override
  public boolean hasNext()
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Object next()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void remove()
  {
    // TODO Auto-generated method stub
    
  }
}
