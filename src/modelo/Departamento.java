package modelo;

public class Departamento {
    private int id;
    private String nombre;
    private int responsableDeAreaId;

    public Departamento() {
    }

    public Departamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getResponsableDeAreaId() {
        return responsableDeAreaId;
    }

    public void setResponsableDeAreaId(int responsableDeAreaId) {
        this.responsableDeAreaId = responsableDeAreaId;
    }
}