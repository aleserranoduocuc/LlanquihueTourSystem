package com.mycompany.llanquihuetoursystem.model;

public class Guia extends Persona {
    private String especialidad;
    private int añosExperiencia;
    private String idiomas;
    private boolean disponible;

    public Guia(String rut, String nombre, String apellido, String telefono, String email,
                Direccion direccion, String especialidad, int añosExperiencia, String idiomas, boolean disponible) {
        super(rut, nombre, apellido, telefono, email, direccion);
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
        this.idiomas = idiomas;
        this.disponible = disponible;
    }

    // Getters y Setters
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    
    public int getAñosExperiencia() { return añosExperiencia; }
    public void setAñosExperiencia(int añosExperiencia) { this.añosExperiencia = añosExperiencia; }
    
    public String getIdiomas() { return idiomas; }
    public void setIdiomas(String idiomas) { this.idiomas = idiomas; }
    
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String getRol() {
        return "Guía Turístico";
    }

    @Override
    public void mostrarResumen() {
        System.out.println("🧭 GUÍA TURÍSTICO");
        System.out.println("   Nombre: " + getNombreCompleto());
        System.out.println("   RUT: " + rut);
        System.out.println("   Especialidad: " + especialidad);
        System.out.println("   Experiencia: " + añosExperiencia + " años");
        System.out.println("   Idiomas: " + idiomas);
        System.out.println("   Disponible: " + (disponible ? "Sí" : "No"));
        System.out.println();
    }

    @Override
    public String toString() {
        return super.toString() + " | Especialidad: " + especialidad + " | Disponible: " + (disponible ? "Sí" : "No");
    }
}