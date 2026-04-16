import Clases.Habitacion;
import Clases.Hospitalizacion;
import Clases.Paciente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Paciente paciente = new Paciente(
                "María",
                "López",
                "P001",
                "Femenino",
                28,
                "8888-9999"
        );

        Habitacion habitacion = new Habitacion(
                true,
                "Privada",
                "101",
                "H001"
        );

        Hospitalizacion hospitalizacion = new Hospitalizacion(
                "HO001",
                "",
                "",
                "",
                "Pendiente",
                paciente,
                habitacion
        );

        int opcion;

        do {
            System.out.println("\n=== MENÚ DE HOSPITALIZACIÓN ===");
            System.out.println("1. Mostrar resumen");
            System.out.println("2. Registrar ingreso");
            System.out.println("3. Registrar alta");
            System.out.println("4. Ver estado de habitación");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n=== RESUMEN ===");
                    hospitalizacion.mostrarResumen();
                    System.out.println("Fecha de ingreso: " + hospitalizacion.getFechaIngreso());
                    System.out.println("Fecha de alta: " + hospitalizacion.getFechaAlta());
                    System.out.println("Motivo de ingreso: " + hospitalizacion.getMotivoIngreso());
                    break;

                case 2:
                    if (!habitacion.isDisponible()) {
                        System.out.println("No se puede registrar ingreso porque la habitación ya está ocupada.");
                    } else {
                        System.out.print("Ingrese la fecha de ingreso: ");
                        String fechaIngreso = sc.nextLine();

                        System.out.print("Ingrese el motivo de ingreso: ");
                        String motivoIngreso = sc.nextLine();

                        hospitalizacion.registrarIngreso(fechaIngreso, motivoIngreso);
                        System.out.println("Ingreso registrado con éxito.");
                    }
                    break;

                case 3:
                    if (habitacion.isDisponible()) {
                        System.out.println("No se puede registrar alta porque no hay un paciente ingresado.");
                    } else {
                        System.out.print("Ingrese la fecha de alta: ");
                        String fechaAlta = sc.nextLine();

                        hospitalizacion.registrarAlta(fechaAlta);
                        System.out.println("Alta registrada con éxito.");
                    }
                    break;

                case 4:
                    System.out.println("\n=== ESTADO DE HABITACIÓN ===");
                    System.out.println("Número: " + habitacion.getNumero());
                    System.out.println("Tipo: " + habitacion.getTipo());
                    System.out.println("Disponible: " + (habitacion.isDisponible() ? "Sí" : "No"));
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 5);

        sc.close();
    }
}