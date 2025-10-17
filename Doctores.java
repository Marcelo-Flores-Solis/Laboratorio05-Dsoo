public class Doctores {
    private String nombre;
    private int codigo;
    private String especialidad;
    private String horarioAtencion;

    public Doctores(String nombre, int codigo, String especialidad, String horarioAtencion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.especialidad = especialidad;
        this.horarioAtencion = horarioAtencion;
    }
    public String getNombre() {return nombre;}
    public int getCodigo() {return codigo;}
    public String getEspecialidad() {return especialidad;}
    public String getHorarioAtencion() {return horarioAtencion;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setCodigo(int codigo) {this.codigo = codigo;}
    public void setEspecialidad(String especialidad) {this.especialidad = especialidad;}
    public void setHorarioAtencion(String horarioAtencion) {this.horarioAtencion = horarioAtencion;}

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codigo);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Horario de Atención: " + horarioAtencion);
    }
}
