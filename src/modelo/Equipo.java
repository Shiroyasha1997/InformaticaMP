package modelo;

public class Equipo {
    private int id;
    private String tipo;
    private String fecha;
    private String marca;
    private String ordenDeCompra;
    private String modelo;
    private String numeroDeSerie;
    private String mac;
    private Integer responsableDeAreaId;
    private Integer asignadoId;
    private String estado;
    private String sistemaOperativo;
    private String ram;
    private String almacenamiento;
    private boolean ups;
    private String procesador;

    public Equipo() {
    }

    public Equipo(int id, String tipo, String fecha, String marca, String ordenDeCompra, String modelo, String numeroDeSerie, String mac, Integer responsableDeAreaId, Integer asignadoId, String estado, String sistemaOperativo, String ram, String almacenamiento, boolean ups, String procesador) {
        this.id = id;
        this.tipo = tipo;
        this.fecha = fecha;
        this.marca = marca;
        this.ordenDeCompra = ordenDeCompra;
        this.modelo = modelo;
        this.numeroDeSerie = numeroDeSerie;
        this.mac = mac;
        this.responsableDeAreaId = responsableDeAreaId;
        this.asignadoId = asignadoId;
        this.estado = estado;
        this.sistemaOperativo = sistemaOperativo;
        this.ram = ram;
        this.almacenamiento = almacenamiento;
        this.ups = ups;
        this.procesador = procesador;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getOrdenDeCompra() {
        return ordenDeCompra;
    }

    public void setOrdenDeCompra(String ordenDeCompra) {
        this.ordenDeCompra = ordenDeCompra;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(String numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Integer getResponsableDeAreaId() {
        return responsableDeAreaId;
    }

    public void setResponsableDeAreaId(Integer responsableDeAreaId) {
        this.responsableDeAreaId = responsableDeAreaId;
    }

    public Integer getAsignadoId() {
        return asignadoId;
    }

    public void setAsignadoId(Integer asignadoId) {
        this.asignadoId = asignadoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public boolean isUps() {
        return ups;
    }

    public void setUps(boolean ups) {
        this.ups = ups;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }
}
