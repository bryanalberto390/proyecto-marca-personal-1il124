package utp.academic;

import java.util.Scanner;

/**
 * Menú principal por consola.
 * @author Bryan Martinez
 */
public class Main {
    public static void main(String[] args) {
        GestorEstudiantes gestor = new GestorEstudiantes();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n=== UTP ACADEMIC CORE - SISTEMA DE REGISTRO ===");
            System.out.println("1. Registrar nuevo estudiante");
            System.out.println("2. Mostrar todos los estudiantes");
            System.out.println("3. Buscar estudiante por cédula");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese cédula: ");
                        String cedula = scanner.nextLine();
                        System.out.print("Ingrese nombre completo: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese carrera: ");
                        String carrera = scanner.nextLine();
                        System.out.print("Ingrese índice académico (ej. 2.50): ");
                        double indice = Double.parseDouble(scanner.nextLine());

                        gestor.agregarEstudiante(new Estudiante(cedula, nombre, carrera, indice));
                        break;

                    case 2:
                        gestor.listarEstudiantes();
                        break;

                    case 3:
                        System.out.print("Ingrese la cédula a buscar: ");
                        String busqueda = scanner.nextLine();
                        Estudiante encontrado = gestor.buscarPorCedula(busqueda);
                        if (encontrado != null) {
                            System.out.println("\nEstudiante encontrado:");
                            System.out.println(encontrado);
                        } else {
                            System.out.println("❌ Estudiante no encontrado.");
                        }
                        break;

                    case 4:
                        System.out.println("👋 Saliendo del sistema. Datos guardados correctamente.");
                        break;

                    default:
                        System.out.println("⚠️ Opción no válida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Por favor ingrese un número válido.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}