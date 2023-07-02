package modelo;

public class Persona {

    private int idpersona;
    private String nombre;
    private String apellido;
    private String dni;
    private double salario;

    public Persona() {
    }

    public Persona(int idpersona, String nombre, String apellido, String dni, double salario) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.salario = salario;
    }

    public Persona(String nombre, String apellido, String dni, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.salario = salario;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNombreCompleto() {
        return this.apellido + ", " + this.nombre;
    }
}
