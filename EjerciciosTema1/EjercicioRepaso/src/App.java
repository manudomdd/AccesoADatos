import java.io.*;
import java.util.Scanner;

public class App {

    private static File directorio;
    private static File fichero1;
    private static File fichero2;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        int option;

        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Crear directorio");
            System.out.println("2. Crear fichero ejercicio1");
            System.out.println("3. Mostrar longitud de ejercicio1");
            System.out.println("4. Crear fichero ejercicio2");
            System.out.println("5. Mostrar ficheros del directorio");
            System.out.println("6. Eliminar ejercicio1");
            System.out.println("7. Guardar persona en persona1.txt");
            System.out.println("8. Mostrar persona de persona1.txt");
            System.out.println("9. Modificar la persona añadida"); 
            System.out.println("10. Crear fichero de texto."); 
            System.out.println("11. Salir\n");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> crearDirectorio();
                case 2 -> crearFichero1();
                case 3 -> longitudEj1();
                case 4 -> crearFichero2();
                case 5 -> mostrarFicheros();
                case 6 -> eliminarEjercicio1();
                case 7 -> guardarPersona();
                case 8 -> leerPersona();
                case 9 -> modificarPersona();
                case 10 -> crearFicheroTexto();
                case 11 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Seleccione una opción válida.");
            }

        } while (option != 11);
    }

    //1. Crea un directorio llamadio “ejercicios”
    public static void crearDirectorio() {
        directorio = new File("ejercicios");

        if (!directorio.exists()) {
            directorio.mkdir();
            System.out.println("Directorio creado.");
        } else {
            System.out.println("El directorio ya existe.");
        }
    }

    //2. Crea un fichero llamado ejercicios1, dentro del directorio anterior
    public static void crearFichero1() {
        try {
            fichero1 = new File("ejercicios/ejercicio1.txt");
            fichero1.createNewFile();
            System.out.println("Fichero ejercicio1 creado.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //3. Muestra por pantalla la longitud del fichero con nombre “ejercicio1”
    public static void longitudEj1() {
        if (fichero1 != null && fichero1.exists()) {
            System.out.println("Tamaño: " + fichero1.length() + " bytes.");
        } else {
            System.out.println("El fichero ejercicio1 no existe.");
        }
    }

    //4. Crea un fichero llamado ejercicio2, dentro del directorio ejercicios
    public static void crearFichero2() {
        try {
            fichero2 = new File("ejercicios/ejercicio2.txt");
            fichero2.createNewFile();
            System.out.println("Fichero ejercicio2 creado.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //5. Muestra todos los ficheros del directorio ejercicios
    public static void mostrarFicheros() {
        if (directorio == null || !directorio.exists()) {
            System.out.println("El directorio no existe.");
            return;
        }

        File[] archivos = directorio.listFiles();

        System.out.println("Ficheros dentro de 'ejercicios':");
        for (File f : archivos) {
            System.out.println(" - " + f.getName());
        }
    }

    //6. Elimina el fichero llamado ejercicio1
    public static void eliminarEjercicio1() {
        if (fichero1 != null && fichero1.exists()) {
            fichero1.delete();
            System.out.println("Fichero ejercicio1 eliminado.");
        } else {
            System.out.println("No se puede eliminar: ejercicio1 no existe.");
        }
    }

    //7. Guardar Persona en persona1.txt (pidiendo datos)
    public static void guardarPersona() {
        System.out.print("Introduzca el id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduzca el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Introduzca la edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduzca el dni: ");
        String dni = scanner.nextLine();

        Persona p = new Persona(id, nombre, edad, dni);

        guardarPersona(p);

        System.out.println("Persona guardada en persona1.txt");
    }

    //Guardar PERSONA EN TEXTO
    public static void guardarPersona(Persona p) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("persona1.txt"))) {

            pw.println(p.getId());
            pw.println(p.getNombre());
            pw.println(p.getEdad());
            pw.println(p.getDni());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //8. Leer Persona desde persona1.txt
    public static Persona leerPersona() {
        Persona p = null;

        try (BufferedReader br = new BufferedReader(new FileReader("persona1.txt"))) {

            int id = Integer.parseInt(br.readLine());
            String nombre = br.readLine();
            int edad = Integer.parseInt(br.readLine());
            String dni = br.readLine();

            p = new Persona(id, nombre, edad, dni);

            System.out.println("Persona leída: " + p);

        } catch (Exception ex) {
            System.out.println("No se pudo leer persona1.txt");
        }

        return p;
    }

    // 9. Modifica sus propiedades y vuelve a guardarlo en el fichero persona1.txt
    public static void modificarPersona() {
        Persona p = leerPersona(); // Leemos la persona del fichero

        if (p != null) {
            // Modificamos sus propiedades
            p.setEdad(29);
            p.setNombre("Antonio");

            // Guardamos de nuevo en el fichero
            guardarPersona(p);
            System.out.println("Persona modificada y guardada en persona1.txt");
        } else {
            System.out.println("No se puede modificar: el fichero persona1.txt no existe o está vacío.");
        }
    }


    // 10. Crea un fichero de texto utilizando la clase FileWriter.
    public static void crearFicheroTexto() {

        String mensaje = "Esto es un texto de prueba, estamos creando nuestro primer fichero de texto";

        try (FileWriter fw = new FileWriter("textoPrueba.txt")) {
            fw.write(mensaje);
            System.out.println("Fichero de texto creado correctamente.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
