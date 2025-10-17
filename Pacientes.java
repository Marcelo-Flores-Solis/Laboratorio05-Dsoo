public class Pacientes {
    private String nombre;
    private int codigo;
    private int edad ;
    private int dni ;

    public Pacientes(int codigo, int dni, int edad, String nombre) {
        this.codigo = codigo;
        this.dni = dni;
        this.edad = edad;
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setCodigo(int codigo) {this.codigo = codigo;}
    public void setEdad(int edad) {this.edad = edad;}
    public void setDni(int dni) {this.dni = dni;}
    public String getNombre() {return nombre;}
    public int getCodigo() {return codigo;}
    public int getEdad() {return edad;}
    public int getDni() {return dni;}

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codigo);
        System.out.println("Edad: " + edad);
        System.out.println("DNI: " + dni);
    }

    public void crearPaciente(int codigo, int dni, int edad, String nombre) {
        this.codigo = codigo;
        this.dni = dni;
        this.edad = edad;
        this.nombre = nombre;
    }

    
}
