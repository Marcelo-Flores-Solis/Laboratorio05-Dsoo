import java.util.*;
public class Citas {
    private int codigo;
    Pacientes paciente;;
    Doctores doctor; 
    private String fecha;
    private String estado;
    private String hora;

    public Citas(int codigo, Doctores doctor, String estado, String fecha, String hora, Pacientes paciente) {
        this.codigo = codigo;
        this.doctor = doctor;
        this.estado = estado;
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
    }

    public int getCodigo() {return codigo;}
    public Pacientes getPaciente() {return paciente;}
    public Doctores getDoctor() {return doctor;}
    public String getFecha() {return fecha;}
    public String getEstado() {return estado;}
    public String getHora() {return hora;}
    public void setCodigo(int codigo) {this.codigo = codigo;}
    public void setPaciente(Pacientes paciente) {this.paciente = paciente;}
    public void setDoctor(Doctores doctor) {this.doctor = doctor;}
    public void setFecha(String fecha) {this.fecha = fecha;}
    public void setEstado(String estado) {this.estado = estado;}
    public void setHora(String hora) {this.hora = hora;}

    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Doctor: " + (doctor != null ? doctor.getNombre() : "Sin doctor asignado"));
        System.out.println("Paciente: " + (paciente != null ? paciente.getNombre() : "Sin paciente asignado"));
        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + hora);
        System.out.println("Estado: " + estado);
    }

    public void cambiarEstado(int opcion) {
        switch (opcion) {
            case 1:
                estado = "Pendiente";
                break;
            case 2:
                estado = "Atendido";
                break;
            case 3:
                estado = "Cancelado";
                break;
            default:
                System.out.println("Opción inválida. Use 1, 2 o 3.");
                return;
            }
        System.out.println("El estado ha sido cambiado a: " + estado);
        }




}
