package org.stupidiville.games.oxcgen.shared;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Rules implements Iterator
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
  private Document m_doc;
  
  public Rules()
  { }
  
  public void readRulesFromFile(final String p_sFileName) throws FileNotFoundException 
  {
    m_strRuleFile = p_sFileName;
    parseXML();
    parseDocument();
  }
  
  private void parseXML()
  {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    try
    {      
      //Using factory get an instance of document builder
      DocumentBuilder db = dbf.newDocumentBuilder();
      
      //parse using builder to get DOM representation of the XML file
      m_doc = db.parse(m_strRuleFile);
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
  }
  
  private void parseDocument()
  {
    Element eleRoot = getBasicGameInfo(); 
    //get a nodelist of <employee> elements
    NodeList nodesl = eleRoot.getChildNodes();
    if(nodesl != null && nodesl.getLength() > 0)
    {
      for(int i = 0 ; i < nodesl.getLength();i++)
      {        
        //get the employee element
        Element el = (Element)nodesl.item(i);
      }
    }
  }
  
  private Element getBasicGameInfo()
  {
    final Element eleRoot = m_doc.getDocumentElement();
    
    NamedNodeMap nnm = eleRoot.getAttributes();
    for(int i = 0; i < nnm.getLength(); i++)
    {
      Node node = nnm.item(i);
      System.out.println(node.getLocalName());
      
    }
    nnm.item(0);
    
    
    return eleRoot;
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
