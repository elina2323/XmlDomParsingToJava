package javalessons;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("http://www.geoplugin.net/xml.gp?base_currency=USD");
            Node root = document.getDocumentElement();
            System.out.println("GeoPlugin");
            NodeList geo = root.getChildNodes();
            for (int i = 0; i < geo.getLength(); i++) {
                Node geoP = geo.item(i);
                if (geoP.getNodeType() == Node.ELEMENT_NODE)
                {
                    System.out.println(geoP.getNodeName() + ": " + geoP.getTextContent());
                }
            }
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        }
    }
}

