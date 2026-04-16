package Clases;

public class Paciente {
    private String nombre;
    private String apellido;
    private String idPaciente;
    private String sexo;
    private int edad;
    private String telefono;


    public Paciente(String nombre, String apellido, String idPaciente, String sexo, int edad, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idPaciente = idPaciente;
        this.sexo = sexo;
        this.edad = edad;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
