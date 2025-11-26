import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document; // <--- ASEGÚRATE QUE ES ESTE IMPORT
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class App {
    public static void main(String[] args) {
        try {
            File file = new File("libros.xml"); 
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            
            System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());
            
            NodeList nodeList = doc.getElementsByTagName("book");
            
            System.out.println("Número de libros encontrados: " + nodeList.getLength());
            System.out.println("----------------------------");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String id = element.getAttribute("id");

                    String author = element.getElementsByTagName("author").item(0).getTextContent();
                    String title = element.getElementsByTagName("title").item(0).getTextContent();
                    String genre = element.getElementsByTagName("genre").item(0).getTextContent();
                    String price = element.getElementsByTagName("price").item(0).getTextContent();
                    String publishDate = element.getElementsByTagName("publish_date").item(0).getTextContent();
                    String description = element.getElementsByTagName("description").item(0).getTextContent();
                    
                    System.out.println("\nLibro ID: " + id);
                    System.out.println(" - Título: " + title);
                    System.out.println(" - Autor: " + author);
                    System.out.println(" - Género: " + genre);
                    System.out.println(" - Precio: " + price);
                    System.out.println(" - Publicado: " + publishDate);

                    System.out.println(" - Descripción: " + description.trim());
                }
            }         
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            System.out.println("Ocurrió un error leyendo el XML:");
        }
    }
}