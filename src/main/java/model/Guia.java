package com.mycompany.llanquihuetoursystem.model;

public class Guia extends Persona {
    private String especialidad;
    private int aniosExperiencia;
    private String idiomas;
    private boolean disponible;

    public Guia() {
        super();
    }

    public Guia(String rut, String nombre, String apellido, 
                String telefono, String email, Direccion direccion,
                String especialidad, int aniosExperiencia, 
                String idiomas, boolean disponible) {
        super(rut, nombre, apellido, telefono, email, direccion);
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
        this.idiomas = idiomas;
        this.disponible = disponible;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        if (aniosExperiencia < 0) {
            throw new IllegalArgumentException("Los años de experiencia no pueden ser negativos");
        }
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String getRol() {
        return "Guía Turístico";
    }

    @Override
    public String toString() {
        return "Guia{" +
                "rut='" + getRut() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", aniosExperiencia=" + aniosExperiencia +
                ", idiomas='" + idiomas + '\'' +
                ", disponible=" + (disponible ? "Sí" : "No") +
                '}';
    }
}