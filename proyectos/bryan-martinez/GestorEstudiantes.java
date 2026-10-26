package utp.academic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Administra la lista de estudiantes y la persistencia en archivo.
 * @author Bryan Martinez
 */
public class GestorEstudiantes {
    private List<Estudiante> listaEstudiantes;
    private final String ARCHIVO_DATOS = "estudiantes.txt";

    public GestorEstudiantes() {
        this.listaEstudiantes = new ArrayList<>();
        cargarDesdeArchivo();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
        guardarEnArchivo();
        System.out.println("✅ Estudiante registrado exitosamente.");
    }

    public void listarEstudiantes() {
        if (listaEstudiantes.isEmpty()) {
            System.out.println("⚠️ No hay estudiantes registrados en el sistema.");
            return;
        }
        System.out.println("\n===== LISTA DE ESTUDIANTES REGISTRADOS =====");
        for (Estudiante e : listaEstudiantes) {
            System.out.println(e);
        }
    }

    public Estudiante buscarPorCedula(String cedula) {
        for (Estudiante e : listaEstudiantes) {
            if (e.getCedula().equalsIgnoreCase(cedula)) {
                return e;
            }
        }
        return null;
    }

    // Persistencia: Guardar datos en archivo de texto plano
    private void guardarEnArchivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO_DATOS))) {
            for (Estudiante e : listaEstudiantes) {
                writer.println(e.aFormatoCSV());
            }
        } catch (IOException e) {
            System.err.println("❌ Error al guardar datos: " + e.getMessage());
        }
    }

    // Persistencia: Cargar datos desde el archivo al iniciar
    private void cargarDesdeArchivo() {
        File archivo = new File(ARCHIVO_DATOS);
        if (!archivo.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    String cedula = datos[0];
                    String nombre = datos[1];
                    String carrera = datos[2];
                    double indice = Double.parseDouble(datos[3]);
                    listaEstudiantes.add(new Estudiante(cedula, nombre, carrera, indice));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("❌ Error al cargar archivo de datos: " + e.getMessage());
        }
    }
}