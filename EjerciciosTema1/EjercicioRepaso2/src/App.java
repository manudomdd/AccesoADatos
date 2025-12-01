import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class App {
    public static void main(String[] args) {
        mostrarIds();
        mostrarAutoresYTitulos(); 
    }

    public static void mostrarIds() {
        try {
            File file = new File("books.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String id = element.getAttribute("id");
                    System.out.println("Id de elemento: " + id);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mostrarAutoresYTitulos() {
    try {
        File file = new File("books.xml");

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("book");

        System.out.println("Listado de autores y títulos:");
        System.out.println("--------------------------------");

        for (int i = 0; i < nodeList.getLength(); i++) {

            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element book = (Element) node;

                // Obtener <author>
                String author = book.getElementsByTagName("author")
                                    .item(0)
                                    .getTextContent();

                // Obtener <title>
                String title = book.getElementsByTagName("title")
                                   .item(0)
                                   .getTextContent();

                System.out.println("Autor:  " + author);
                System.out.println("Título: " + title);
                System.out.println();
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
