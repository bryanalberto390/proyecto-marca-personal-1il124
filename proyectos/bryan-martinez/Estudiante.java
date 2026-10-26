package utp.academic;

import java.io.Serializable;

/**
 * Clase que representa a un estudiante universitario de la UTP.
 * @author Bryan Martinez
 */
public class Estudiante implements Serializable {
    private String cedula;
    private String nombre;
    private String carrera;
    private double indiceAcademico;

    // Constructor
    public Estudiante(String cedula, String nombre, String carrera, double indiceAcademico) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.carrera = carrera;
        this.indiceAcademico = indiceAcademico;
    }

    // Getters y Setters
    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public double getIndiceAcademico() { return indiceAcademico; }
    public void setIndiceAcademico(double indiceAcademico) { this.indiceAcademico = indiceAcademico; }

    // Formato CSV para guardar en archivo plano
    public String aFormatoCSV() {
        return cedula + "," + nombre + "," + carrera + "," + indiceAcademico;
    }

    @Override
    public String toString() {
        return String.format("Cédula: %-12s | Nombre: %-25s | Carrera: %-25s | Índice: %.2f", 
                cedula, nombre, carrera, indiceAcademico);
    }
}