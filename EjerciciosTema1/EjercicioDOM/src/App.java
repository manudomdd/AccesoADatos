import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document; // <--- ASEGÚRATE QUE ES ESTE IMPORT
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class App {

    public static void main(String[] args) {
        try {
            // 1. Cargar el archivo XML
            // Asegúrate de que la ruta es correcta. Si está en la raíz del proyecto quita "src/"
            File file = new File("libros.xml"); 
            
            // 2. Crear el Builder
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            // 3. Parsear el archivo y normalizar
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            
            System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());
            
            // 4. Crear la lista de nodos. En tu XML la etiqueta que se repite es "book"
            NodeList nodeList = doc.getElementsByTagName("book");
            
            System.out.println("Número de libros encontrados: " + nodeList.getLength());
            System.out.println("----------------------------");

            // 
            
            // 5. Recorrer la lista
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                
                // Verificar que sea un Nodo de Elemento (y no texto vacío o comentarios)
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    
                    // A. LEER ATRIBUTOS (ej: id="bk101")
                    String id = element.getAttribute("id");
                    
                    // B. LEER ELEMENTOS HIJOS
                    // Usamos .item(0) porque asumimos que solo hay un autor por libro
                    String author = element.getElementsByTagName("author").item(0).getTextContent();
                    String title = element.getElementsByTagName("title").item(0).getTextContent();
                    String genre = element.getElementsByTagName("genre").item(0).getTextContent();
                    String price = element.getElementsByTagName("price").item(0).getTextContent();
                    String publishDate = element.getElementsByTagName("publish_date").item(0).getTextContent();
                    String description = element.getElementsByTagName("description").item(0).getTextContent();
                    
                    // C. IMPRIMIR LOS DATOS
                    System.out.println("\nLibro ID: " + id);
                    System.out.println(" - Título: " + title);
                    System.out.println(" - Autor: " + author);
                    System.out.println(" - Género: " + genre);
                    System.out.println(" - Precio: " + price);
                    System.out.println(" - Publicado: " + publishDate);
                    // Usamos .trim() en descripción para limpiar saltos de línea del XML
                    System.out.println(" - Descripción: " + description.trim());
                }
            }
            
        } catch (Exception e) {
            System.out.println("Ocurrió un error leyendo el XML:");
            e.printStackTrace();
        }
    }
}