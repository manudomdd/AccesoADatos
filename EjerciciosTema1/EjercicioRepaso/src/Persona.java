public class Persona {

    private int id; 
    private String nombre; 
    private int edad; 
    private String dni; 

    public Persona(int id, String nombre, int edad, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", edad='" + getEdad() + "'" +
            ", dni='" + getDni() + "'" +
            "}";
    }
}
