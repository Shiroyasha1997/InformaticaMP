package modelo;

public class Empleado {
    private String run;
    private String nombre;
    private String apellido;
    private int departamentoId;
    private boolean responsableDeArea;

    // Constructor
    public Empleado(String run, String nombre, String apellido, int departamentoId, boolean responsableDeArea) {
        this.run = run;
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamentoId = departamentoId;
        this.responsableDeArea = responsableDeArea;
    }

    public Empleado() {
    }

    // Getters y Setters
    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
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

    public int getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    public boolean isResponsableDeArea() {
        return responsableDeArea;
    }

    public void setResponsableDeArea(boolean responsableDeArea) {
        this.responsableDeArea = responsableDeArea;
    }
}