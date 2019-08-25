
package main;

  import java.io.File;  
  import java.io.FileInputStream;  
  import java.io.FileNotFoundException;  
  import javax.ws.rs.*;  
 import javax.xml.xpath.XPath;  
  import javax.xml.xpath.XPathConstants;  
  import javax.xml.xpath.XPathExpression;  
  import javax.xml.xpath.XPathExpressionException;  
  import javax.xml.xpath.XPathFactory;  
  import org.w3c.dom.NodeList;  
  import org.xml.sax.InputSource;  
    
  @Path("/TranslatorService/{word}")  
  public class Translator {  
      
    @GET  
    public String translate (@PathParam("word") String word) throws XPathExpressionException, FileNotFoundException{  
        
     String output = null;  
     
      XPathFactory factory = XPathFactory.newInstance();  
      XPath path = factory.newXPath();  
      XPathExpression xPE = path.compile("//word[@en='"+ word.trim().toLowerCase() +"']");  
        
      File xmlDoc = new File("C:/Users/wedad/Documents/NetBeansProjects/TranslatorAssingment/src/java/main/dictionary.xml");  
      InputSource source = new InputSource(new FileInputStream(xmlDoc));  
        
      Object result = xPE.evaluate(source, XPathConstants.NODESET);  
      NodeList nList = (NodeList)result;  
        
      if (nList.getLength() < 1)  
        output = "Word " + word + " does not exist in our little dictionary";  
      else {  
        for (int i = 0; i < nList.getLength(); i++) {  
          output = "Word " + word + " translates as: " + nList.item(i).getTextContent();  
        }  
      }  
        
      return output;  
    }  
      
  }  


