package org.xcge.shared;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class XCGEErrorHandler implements ErrorHandler
{
  public void error(SAXParseException p_exp) throws SAXParseException
  {
    throw p_exp;
  }

  public void fatalError(SAXParseException p_exp) throws SAXParseException
  {
    throw p_exp;
  }

  public void warning(SAXParseException p_exp) throws SAXParseException
  {
    throw p_exp;
  }
}

