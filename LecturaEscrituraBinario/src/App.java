import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static List<Empleado> empleados = new ArrayList<>();

    public static final int TAM_NOMBRE = 20;
    public static final int TAM_APELLIDO = 20;
    public static final int TAM_DIRECCION = 50;

    public static void main(String[] args) throws Exception {

        carga();          // Cargar empleados en la lista
        guardarArchivo(); // Guardar en binario
        leerArchivo();    // Leer desde binario
    }

    // ============================================
    //        GUARDAR EMPLEADOS EN ARCHIVO
    // ============================================
    public static void guardarArchivo() {

        try {
            RandomAccessFile raf = new RandomAccessFile("Empleados.dat", "rw");

            for (Empleado e : empleados) {
                writeFixedString(e.getNombre(), TAM_NOMBRE, raf);
                writeFixedString(e.getApellido(), TAM_APELLIDO, raf);
                raf.writeInt(e.getEdad());
                writeFixedString(e.getDireccion(), TAM_DIRECCION, raf);
            }

            raf.close();

        } catch (FileNotFoundException e) {
            System.out.println("El directorio no existe.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Escribir cadena con longitud fija
    public static void writeFixedString(String s, int size, RandomAccessFile raf) throws Exception {
        StringBuffer sb = new StringBuffer(s);
        sb.setLength(size);  // Rellenar con espacios
        raf.writeChars(sb.toString());
    }

    // ============================================
    //        LEER ARCHIVO BINARIO
    // ============================================
    public static void leerArchivo() {

        try {
            RandomAccessFile raf = new RandomAccessFile("Empleados.dat", "r");

            while (raf.getFilePointer() < raf.length()) {

                String nombre = readFixedString(TAM_NOMBRE, raf);
                String apellido = readFixedString(TAM_APELLIDO, raf);
                int edad = raf.readInt();
                String direccion = readFixedString(TAM_DIRECCION, raf);

                System.out.println("---- EMPLEADO ----");
                System.out.println("Nombre: " + nombre.trim());
                System.out.println("Apellido: " + apellido.trim());
                System.out.println("Edad: " + edad);
                System.out.println("Dirección: " + direccion.trim());
                System.out.println("-------------------");
            }

            raf.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Leer cadena con longitud fija
    public static String readFixedString(int size, RandomAccessFile raf) throws Exception {
        StringBuilder sb = new StringBuilder(size);

        for (int i = 0; i < size; i++) {
            sb.append(raf.readChar()); // Cada char ocupa 2 bytes en RandomAccessFile
        }

        return sb.toString();
    }

    // ============================================
    //                 CARGA INICIAL
    // ============================================
    public static void carga() {
        empleados.add(new Empleado("Manuel", "Dominguez", 26, "Santa Angela"));
    }
}
