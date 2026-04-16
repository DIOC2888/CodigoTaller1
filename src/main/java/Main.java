import Clases.Habitacion;
import Clases.Hospitalizacion;
import Clases.Paciente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Paciente paciente = null;
        Habitacion habitacion = null;
        Hospitalizacion hospitalizacion = null;

        int opcion;

        do {
            System.out.println("\n=== MENÚ DE HOSPITALIZACIÓN ===");
            System.out.println("1. Registrar paciente + ingreso + habitación");
            System.out.println("2. Registrar alta");
            System.out.println("3. Mostrar resumen");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    if (hospitalizacion != null && !hospitalizacion.getHabitacion().isDisponible()) {
                        System.out.println("Ya hay una hospitalización activa. Primero debe registrarse el alta.");
                        break;
                    }

                    System.out.println("\n=== REGISTRO DE PACIENTE ===");
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();

                    System.out.print("ID del paciente: ");
                    String idPaciente = sc.nextLine();

                    System.out.print("Sexo: ");
                    String sexo = sc.nextLine();

                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();

                    paciente = new Paciente(nombre, apellido, idPaciente, sexo, edad, telefono);

                    System.out.println("\n=== REGISTRO DE HABITACIÓN ===");
                    System.out.print("ID de la habitación: ");
                    String idHabitacion = sc.nextLine();

                    System.out.print("Número de habitación: ");
                    String numeroHabitacion = sc.nextLine();

                    System.out.print("Tipo de habitación: ");
                    String tipoHabitacion = sc.nextLine();

                    habitacion = new Habitacion(true, tipoHabitacion, numeroHabitacion, idHabitacion);

                    System.out.println("\n=== REGISTRO DE INGRESO ===");
                    System.out.print("ID de hospitalización: ");
                    String idHospitalizacion = sc.nextLine();

                    System.out.print("Fecha de ingreso: ");
                    String fechaIngreso = sc.nextLine();

                    System.out.print("Motivo de ingreso: ");
                    String motivoIngreso = sc.nextLine();

                    hospitalizacion = new Hospitalizacion(
                            idHospitalizacion,
                            "",
                            "",
                            "",
                            "Pendiente",
                            paciente,
                            habitacion
                    );

                    hospitalizacion.registrarIngreso(fechaIngreso, motivoIngreso);
                    System.out.println("Paciente, habitación e ingreso registrados con éxito.");
                    break;

                case 2:
                    if (hospitalizacion == null || hospitalizacion.getHabitacion().isDisponible()) {
                        System.out.println("No hay ninguna hospitalización activa.");
                    } else {
                        System.out.print("Ingrese la fecha de alta: ");
                        String fechaAlta = sc.nextLine();
                        hospitalizacion.registrarAlta(fechaAlta);
                        System.out.println("Alta registrada con éxito.");
                    }
                    break;

                case 3:
                    if (hospitalizacion == null) {
                        System.out.println("No hay hospitalización registrada.");
                    } else {
                        System.out.println("\n=== RESUMEN ===");
                        System.out.println("ID Hospitalización: " + hospitalizacion.getIdHospitalizacion());
                        System.out.println("Estado: " + hospitalizacion.getEstado());
                        System.out.println("Fecha de ingreso: " + hospitalizacion.getFechaIngreso());
                        System.out.println("Fecha de alta: " + hospitalizacion.getFechaAlta());
                        System.out.println("Motivo de ingreso: " + hospitalizacion.getMotivoIngreso());

                        System.out.println("\n--- Paciente ---");
                        System.out.println("Nombre: " + hospitalizacion.getPaciente().getNombre() + " " +
                                hospitalizacion.getPaciente().getApellido());
                        System.out.println("ID: " + hospitalizacion.getPaciente().getIdPaciente());
                        System.out.println("Sexo: " + hospitalizacion.getPaciente().getSexo());
                        System.out.println("Edad: " + hospitalizacion.getPaciente().getEdad());
                        System.out.println("Teléfono: " + hospitalizacion.getPaciente().getTelefono());

                        System.out.println("\n--- Habitación ---");
                        System.out.println("ID: " + hospitalizacion.getHabitacion().getIdHabitacion());
                        System.out.println("Número: " + hospitalizacion.getHabitacion().getNumero());
                        System.out.println("Tipo: " + hospitalizacion.getHabitacion().getTipo());
                        System.out.println("Disponible: " +
                                (hospitalizacion.getHabitacion().isDisponible() ? "Sí" : "No"));
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 4);

        sc.close();
    }
}