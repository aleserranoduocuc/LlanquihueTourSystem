package com.mycompany.llanquihuetoursystem.model;

public class Operador extends Persona {
    private String empresa;
    private String tipoServicio;
    private int capacidadMaxima;
    private boolean activo;

    public Operador() {
        super();
    }

    public Operador(String rut, String nombre, String apellido, 
                    String telefono, String email, Direccion direccion,
                    String empresa, String tipoServicio, 
                    int capacidadMaxima, boolean activo) {
        super(rut, nombre, apellido, telefono, email, direccion);
        this.empresa = empresa;
        this.tipoServicio = tipoServicio;
        this.capacidadMaxima = capacidadMaxima;
        this.activo = activo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        if (capacidadMaxima < 0) {
            throw new IllegalArgumentException("La capacidad no puede ser negativa");
        }
        this.capacidadMaxima = capacidadMaxima;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String getRol() {
        return "Operador Turístico";
    }

    @Override
    public String toString() {
        return "Operador{" +
                "rut='" + getRut() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", empresa='" + empresa + '\'' +
                ", tipoServicio='" + tipoServicio + '\'' +
                ", capacidadMaxima=" + capacidadMaxima +
                ", activo=" + (activo ? "Sí" : "No") +
                '}';
    }
}