package com.mycompany.llanquihuetoursystem.model;

public class Operador extends Persona {
    private String empresa;
    private String tipoServicio;
    private int capacidadMaxima;
    private boolean activo;

    public Operador(String rut, String nombre, String apellido, String telefono, String email,
                    Direccion direccion, String empresa, String tipoServicio, int capacidadMaxima, boolean activo) {
        super(rut, nombre, apellido, telefono, email, direccion);
        this.empresa = empresa;
        this.tipoServicio = tipoServicio;
        this.capacidadMaxima = capacidadMaxima;
        this.activo = activo;
    }

    // Getters y Setters
    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }
    
    public String getTipoServicio() { return tipoServicio; }
    public void setTipoServicio(String tipoServicio) { this.tipoServicio = tipoServicio; }
    
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public void setCapacidadMaxima(int capacidadMaxima) { this.capacidadMaxima = capacidadMaxima; }
    
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String getRol() {
        return "Operador Turístico";
    }

    @Override
    public void mostrarResumen() {
        System.out.println("🚌 OPERADOR TURÍSTICO");
        System.out.println("   Nombre: " + getNombreCompleto());
        System.out.println("   RUT: " + rut);
        System.out.println("   Empresa: " + empresa);
        System.out.println("   Servicio: " + tipoServicio);
        System.out.println("   Capacidad: " + capacidadMaxima + " personas");
        System.out.println("   Activo: " + (activo ? "Sí" : "No"));
        System.out.println();
    }

    @Override
    public String toString() {
        return super.toString() + " | Empresa: " + empresa + " | Servicio: " + tipoServicio;
    }
}