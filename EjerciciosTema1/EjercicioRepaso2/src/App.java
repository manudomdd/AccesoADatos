import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class App {

    static class Libro {
        String title;
        double price;

        Libro(String title, double price) {
            this.title = title;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        mostrarIds();
        mostrarAutoresYTitulos(); 
        ordenarLibroPrecio();
    }

    public static void mostrarIds() {
        try {
            File file = new File("EjerciciosTema1\\EjercicioRepaso2\\books.xml");


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
            File file = new File("EjerciciosTema1\\EjercicioRepaso2\\books.xml");


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

    public static void ordenarLibroPrecio() {
        try {
            File file = new File("EjerciciosTema1\\EjercicioRepaso2\\books.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
            DocumentBuilder db = dbf.newDocumentBuilder(); 
            Document document = db.parse(file); 
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("book"); 

            List<Libro> listaLibros = new ArrayList<>();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i); 

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node; 

                    String title = element.getElementsByTagName("title").item(0).getTextContent(); 
                    String priceStr = element.getElementsByTagName("price").item(0).getTextContent();
                    double price = Double.parseDouble(priceStr);

                    listaLibros.add(new Libro(title, price));
                }
            }

            // Ordenar por precio ascendente
            listaLibros.sort(Comparator.comparingDouble(l -> l.price));

            System.out.println("Libros ordenados por precio:");
            for (Libro libro : listaLibros) {
                System.out.println("Título: " + libro.title + " - Precio: " + libro.price);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
