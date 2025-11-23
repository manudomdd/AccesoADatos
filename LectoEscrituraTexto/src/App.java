import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static List<Empleado> empleados = new ArrayList<>(); 
    
    public static void main(String[] args) {

        carga(); // agrega empleados a la lista

        // ==== ESCRIBIR EN EL ARCHIVO ====
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("empleados.txt"))) {

            for (Empleado e : empleados) {
                writer.write(e.getNombre());
                writer.write(", ");
                writer.write(e.getApellido()); 
                writer.write(", ");
                writer.write(String.valueOf(e.getEdad()));
                writer.newLine();                
            }           
            System.out.println("Archivo empleados.txt escrito correctamente.");

        } catch (Exception ex) {
            ex.printStackTrace(); 
        }

        // ==== LEER EL ARCHIVO ====
        try (BufferedReader reader = new BufferedReader(new FileReader("empleados.txt"))) {
            String linea; 
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(", "); 
                if (datos.length == 3) {
                    String nombre = datos[0]; 
                    String apellidos = datos[1]; 
                    int edad = Integer.parseInt(datos[2]); 

                    System.out.println("Nombre: " + nombre + " Apellido: " + apellidos + " Edad: " + edad); 
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace(); 
        }
    }

    public static void carga() {
        empleados.add(new Empleado("Manuel", "Dominguez", 24)); 
        empleados.add(new Empleado("Laura", "García", 30));
        empleados.add(new Empleado("Carlos", "López", 28));
    }   
}
