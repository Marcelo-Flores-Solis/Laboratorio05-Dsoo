import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    private ArrayList<Doctores> doctores;
    private ArrayList<Pacientes> pacientes;
    private ArrayList<Citas> citas;
    private Scanner sc;
    public Sistema() {
        this.doctores = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.citas = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }
    public void registrarDoctor(Doctores doctor) {
        doctores.add(doctor);
    }

    public void registrarPaciente(Pacientes paciente) {
        pacientes.add(paciente);
    }

    public void registrarCita(Citas cita) {
        citas.add(cita);
    }
    
    public void mostrarDoctores() {
        for (Doctores doctor : doctores) {
            doctor.mostrarInformacion();
        }
    }
    public void mostrarPacientes() {
        for (Pacientes paciente : pacientes) {
            paciente.mostrarInformacion();
        }
    }
    public void mostrarCitas(){
        for(Citas cita : citas) {
            cita.mostrarInformacion();
        }
    }

    public void mostrarCitasPorDoctor(int codigoDoctor) {
        for (Citas cita : citas) {
            if (cita.getDoctor() != null && cita.getDoctor().getCodigo() == codigoDoctor) {
                cita.mostrarInformacion();
            }
        }
    }

    public void mostrarCitasPorPaciente(int codigoPaciente) {
        for (Citas cita : citas) {
            if (cita.getPaciente() != null && cita.getPaciente().getCodigo() == codigoPaciente) {
                cita.mostrarInformacion();
            }
        }
    }

    public void mostrarCitasPorEstado(String estado) {
        for (Citas cita : citas) {
            if (cita.getEstado() != null && cita.getEstado().equalsIgnoreCase(estado)) {
                cita.mostrarInformacion();
            }
        }
    }


    public boolean validarCita(int codigoDoctor, String fecha, String hora) {
        for (Citas c : citas) {
            if (c.getDoctor() != null && c.getFecha() != null && c.getHora() != null) {
                if (c.getDoctor().getCodigo() == codigoDoctor &&
                    c.getFecha().equals(fecha) &&
                    c.getHora().equals(hora)) {
                    return false; 
                }
            }
        }
        return true;
    }

    public void crearCita() {
        System.out.println("=== Registrar nueva cita ===");

        System.out.print("Ingrese el código de la cita: ");
        int codigoCita = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese el código del doctor: ");
        int codigoDoctor = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese el código del paciente: ");
        int codigoPaciente = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese la fecha de la cita (dd/mm/aaaa): ");
        String fecha = sc.nextLine();

        System.out.print("Ingrese la hora de la cita (HH:mm): ");
        String hora = sc.nextLine();

        System.out.print("Ingrese el estado de la cita: ");
        String estado = sc.nextLine();
        // Validaciones básicas
        if (!validarFecha(fecha)) {
            System.out.println("Fecha inválida. Use el formato dd/mm/aaaa.");
            return;
        }
        if (!validarHora(hora)) {
            System.out.println("Hora inválida. Use el formato HH:mm (00-23:00-59).");
            return;
        }
        if (!validarCita(codigoDoctor, fecha, hora)) {
            System.out.println("El doctor ya tiene una cita el " + fecha + " a las " + hora + ".");
            return;
        }
        Doctores doctor = buscarDoctorPorCodigo(codigoDoctor);
        Pacientes paciente = buscarPacientePorCodigo(codigoPaciente);

        if (doctor == null) {
            System.out.println("No se encontró un doctor con el código " + codigoDoctor + ". Cree el doctor primero.");
            return;
        }
        if (paciente == null) {
            System.out.println("No se encontró un paciente con el código " + codigoPaciente + ". Cree el paciente primero.");
            return;
        }

        Citas nuevaCita = new Citas(codigoCita, doctor, estado, fecha, hora, paciente);
        registrarCita(nuevaCita);
        System.out.println("Cita registrada exitosamente.");
    }

    private Doctores buscarDoctorPorCodigo(int codigo) {
        for (Doctores d : doctores) {
            if (d.getCodigo() == codigo) return d;
        }
        return null;
    }

    private Pacientes buscarPacientePorCodigo(int codigo) {
        for (Pacientes p : pacientes) {
            if (p.getCodigo() == codigo) return p;
        }
        return null;
    }
    
    private boolean validarCodigoDoctorUnico(int codigo) {
        for (Doctores doctor : doctores) {
            if (doctor.getCodigo() == codigo) { 
                return false; 
            }
        }
        return true; 
    }
    private boolean validarCodigoPacienteUnico(int codigo) {
        for (Pacientes paciente : pacientes) {
            if (paciente.getCodigo() == codigo) { 
                return false; 
            }
        }
        return true; 
    }
    public void ingresarDoctor() {
        System.out.println("\nIngreso de datos del doctor");
        System.out.print("Introducir el código del Doctor (entero): ");
        int codigoDoctor = sc.nextInt();
        sc.nextLine();
        System.out.print("Introducir el nombre del Doctor: ");
        String nombreDoctor = sc.nextLine(); 
        if (!validarNombreDoctor(nombreDoctor)) {
            System.out.println("Nombre de doctor inválido. No puede estar vacío.");
            return;
        }
        System.out.print("Introducir la especialidad del Doctor: ");
        String especialidadDoctor = sc.nextLine();       
        System.out.print("Introducir el horario de atencion del Doctor: ");
        String atencionDoctor = sc.nextLine();
        if (!validarCodigoDoctorUnico(codigoDoctor)) {
            System.err.println(" El código " + codigoDoctor + " ya existe.");
            return; 
        } 
        Doctores doctor = new Doctores(nombreDoctor, codigoDoctor, especialidadDoctor, atencionDoctor); 
        registrarDoctor(doctor);       
        System.out.println(" Doctor " + nombreDoctor + " creado exitosamente.");
    }

    public void ingresarPaciente() {
        System.out.println("\nIngreso de datos del paciente");
        System.out.print("Introducir el código del Paciente (entero): ");
        int codigoPaciente = sc.nextInt();
        sc.nextLine();
        System.out.print("Introducir el nombre del Paciente: ");
        String nombrePaciente = sc.nextLine();
        if (!validarNombrePaciente(nombrePaciente)) {
            System.out.println("Nombre de paciente inválido. No puede estar vacío.");
            return;
        }
        System.out.print("Introducir la edad del Paciente: ");
        int edadPaciente = sc.nextInt();
        System.out.print("Introducir el dni del Paciente: ");
        int dniPacciente = sc.nextInt();
        sc.nextLine();

        // Validaciones adicionales
        if (!validarEdad(edadPaciente)) {
            System.out.println("Edad inválida. Debe ser mayor que 0.");
            return;
        }
        if (!validarDni(dniPacciente)) {
            System.out.println("DNI inválido. Debe ser un número positivo de 7-8 dígitos.");
            return;
        }
        if (!dniNoRepetido(dniPacciente)) {
            System.out.println("DNI ya registrado. No se puede crear paciente con DNI duplicado.");
            return;
        }

        if (!validarCodigoPacienteUnico(codigoPaciente)) {
            System.out.println(" El código " + codigoPaciente + " ya existe. Objeto Paciente no creado.");
            return; 
        }
        Pacientes paciente = new Pacientes(codigoPaciente, dniPacciente, edadPaciente, nombrePaciente);
        registrarPaciente(paciente);
        System.out.println(" Paciente " + nombrePaciente + " creado exitosamente.");        
    }

    // --- Validadores al final del sistema ---
    private boolean validarNombreDoctor(String nombre) {
        if (nombre == null) return false;
        String s = nombre.trim();
        if (s.isEmpty()) return false;
        // Simple: asegurar que no haya dígitos en el nombre
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }

    private boolean validarNombrePaciente(String nombre) {
        if (nombre == null) return false;
        String s = nombre.trim();
        if (s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }

    private boolean validarDni(int dni) {
        return dni > 0 && (dni >= 1000000 && dni <= 99999999);
    }

    private boolean dniNoRepetido(int dni) {
        for (Pacientes p : pacientes) {
            if (p.getDni() == dni) return false;
        }
        return true;
    }

    private boolean validarEdad(int edad) {
        return edad > 0;
    }

    private boolean validarFecha(String fecha) {
        if (fecha == null) return false;
        // Formato esperado dd/mm/aaaa (comprobación simple sin regex)
        String[] parts = fecha.split("/");
        if (parts.length != 3) return false;
        try {
            int d = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);
            if (y < 1900 || parts[2].length() != 4) return false;
            if (m < 1 || m > 12) return false;
            if (d < 1 || d > 31) return false; // validación simple, no considera meses con menos días
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean validarHora(String hora) {
        if (hora == null) return false;
        // Formato HH:mm 00-23:00-59 (comprobación simple sin regex)
        String[] parts = hora.split(":");
        if (parts.length != 2) return false;
        try {
            int hh = Integer.parseInt(parts[0]);
            int mm = Integer.parseInt(parts[1]);
            if (hh < 0 || hh > 23) return false;
            if (mm < 0 || mm > 59) return false;
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}