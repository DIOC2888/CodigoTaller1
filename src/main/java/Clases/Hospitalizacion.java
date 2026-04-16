package Clases;

import Interfaces.GestionHospitalizacion;

public class Hospitalizacion implements GestionHospitalizacion {
    private String idHospitalizacion;
    private String fechaIngreso;
    private String fechaAlta;
    private String motivoIngreso;
    private String estado;
    private Paciente paciente;
    private Habitacion habitacion;

    public Hospitalizacion(String idHospitalizacion, String fechaIngreso, String fechaAlta,
                           String motivoIngreso, String estado, Paciente paciente,
                           Habitacion habitacion) {
        this.idHospitalizacion = idHospitalizacion;
        this.fechaIngreso = fechaIngreso;
        this.fechaAlta = fechaAlta;
        this.motivoIngreso = motivoIngreso;
        this.estado = estado;
        this.paciente = paciente;
        this.habitacion = habitacion;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public String getIdHospitalizacion() {
        return idHospitalizacion;
    }

    public void setIdHospitalizacion(String idHospitalizacion) {
        this.idHospitalizacion = idHospitalizacion;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getMotivoIngreso() {
        return motivoIngreso;
    }

    public void setMotivoIngreso(String motivoIngreso) {
        this.motivoIngreso = motivoIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    @Override
    public void mostrarResumen() {
        System.out.println("Hospitalización: " + idHospitalizacion);
        System.out.println("Paciente: " + paciente.getNombre());
        System.out.println("Habitación: " + habitacion.getNumero());
        System.out.println("Estado: " + estado);
    }

    @Override
    public void registrarAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
        this.estado = "Alta";
        habitacion.liberarHabitacion();
    }

    @Override
    public void registrarIngreso(String fechaIngreso, String motivoIngreso) {
        this.fechaIngreso = fechaIngreso;
        this.motivoIngreso = motivoIngreso;
        this.estado = "Ingresado";
        habitacion.asignarHabitacion();
    }
}
