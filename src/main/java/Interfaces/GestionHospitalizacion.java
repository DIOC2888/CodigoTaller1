package Interfaces;

public interface GestionHospitalizacion {
    void mostrarResumen();
    void registrarAlta(String fechaAlta);
    void registrarIngreso(String fechaIngreso, String motivoIngreso);
}
