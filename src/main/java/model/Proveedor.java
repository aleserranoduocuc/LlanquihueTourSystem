package com.mycompany.llanquihuetoursystem.model;

public class Proveedor extends Persona {
    private String rubro;
    private String horarioAtencion;
    private int calificacion;

    public Proveedor(String rut, String nombre, String apellido, String telefono, String email,
                     Direccion direccion, String rubro, String horarioAtencion, int calificacion) {
        super(rut, nombre, apellido, telefono, email, direccion);
        this.rubro = rubro;
        this.horarioAtencion = horarioAtencion;
        this.calificacion = calificacion;
    }

    // Getters y Setters
    public String getRubro() { return rubro; }
    public void setRubro(String rubro) { this.rubro = rubro; }
    
    public String getHorarioAtencion() { return horarioAtencion; }
    public void setHorarioAtencion(String horarioAtencion) { this.horarioAtencion = horarioAtencion; }
    
    public int getCalificacion() { return calificacion; }
    public void setCalificacion(int calificacion) { this.calificacion = calificacion; }

    @Override
    public String getRol() {
        return "Proveedor";
    }

    @Override
    public void mostrarResumen() {
        System.out.println("📦 PROVEEDOR");
        System.out.println("   Nombre: " + getNombreCompleto());
        System.out.println("   RUT: " + rut);
        System.out.println("   Rubro: " + rubro);
        System.out.println("   Horario: " + horarioAtencion);
        System.out.println("   Calificación: " + calificacion + " ★");
        System.out.println();
    }

    @Override
    public String toString() {
        return super.toString() + " | Rubro: " + rubro + " | Calificación: " + calificacion + "★";
    }
}