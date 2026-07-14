package com.mycompany.llanquihuetoursystem.model;

public abstract class Persona implements Registrable {
    protected String rut;
    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String email;
    protected Direccion direccion;

    public Persona(String rut, String nombre, String apellido, String telefono, String email, Direccion direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    // Getters y Setters
    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public abstract String getRol();

    @Override
    public void mostrarResumen() {
        System.out.println("📋 " + getRol() + ": " + getNombreCompleto() + " (RUT: " + rut + ")");
    }

    @Override
    public String toString() {
        return getRol() + ": " + getNombreCompleto() + " | RUT: " + rut + " | Tel: " + telefono;
    }
}