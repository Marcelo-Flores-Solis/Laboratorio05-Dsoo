
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema(); 
        Scanner sc = new Scanner(System.in);

        int numero ;
        
        do { 
            System.out.println("Bienvenido al sistema de Registros del Hospital X");
            System.out.println("Elija una opcion para comenzar");
            System.out.println("opcion 1 : Registrar Doctores");
            System.out.println("opcion 2 : Registrar Pacientes");
            System.out.println("opcion 3 : Crear Citas");
            System.out.println("opcion 4 : Mostrar Citas");
            System.out.println("opcion 5 : Mostrar Citas por Doctor");
            System.out.println("opcion 6 : Mostrar Citas por Paciente");
            System.out.println("opcion 7 : Mostrar Citas por Estado");
            System.out.println("opcion 8 : Salir");
            numero=sc.nextInt();
            sc.nextLine();

        switch (numero) {
            case 1 :
                        sistema.ingresarDoctor();                    
                    break;
            case 2 :
                        sistema.ingresarPaciente();
                    break;
            case 3 :
                        sistema.crearCita();
                    break;

            case 4 :
                        sistema.mostrarCitas();
                    break;
                    
            case 5 :
                    System.out.println("Ingrese el codigo del doctor para ver sus citas");
                    int codigoDoctor = sc.nextInt();
                        sistema.mostrarCitasPorDoctor(codigoDoctor);
                    break;
            case 6 :
                    System.out.println("Ingrese el codigo del paciente para ver sus citas");
                    int codigoPaciente = sc.nextInt();
                        sistema.mostrarCitasPorPaciente(codigoPaciente);
                    break;
            case 7 :
                    System.out.println("Ingrese el estado de las citas que desea ver (Pendiente, Atendido, Cancelado)");
                        String estado = sc.nextLine();
                        sistema.mostrarCitasPorEstado(estado);
                    break;

            case 8 :
                    System.out.println("Saliendo del sistema");
                break;
            
            default:
                System.out.println("Opcion no valida , intente denuevo");
        }
        } while (numero!=8);

    }
}
