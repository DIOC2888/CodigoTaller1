package Clases;

public class Habitacion {
    private boolean disponible;
    private String tipo;
    private String numero;
    private String idHabitacion;

    public Habitacion(boolean disponible, String tipo, String numero, String idHabitacion) {
        this.disponible = disponible;
        this.tipo = tipo;
        this.numero = numero;
        this.idHabitacion = idHabitacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public void asignarHabitacion() {
        this.disponible = false;
    }

    public void liberarHabitacion() {
        this.disponible = true;
    }
}