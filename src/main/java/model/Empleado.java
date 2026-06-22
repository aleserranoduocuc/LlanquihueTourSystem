package com.mycompany.llanquihuetoursystem.model;

public class Empleado extends Persona {
    private String cargo;
    private double sueldoBase;
    private int aniosAntiguedad;
    private boolean activo;

    public Empleado() {
        super();
    }

    public Empleado(String rut, String nombre, String apellido, 
                    String telefono, String email, Direccion direccion,
                    String cargo, double sueldoBase, int aniosAntiguedad, 
                    boolean activo) {
        super(rut, nombre, apellido, telefono, email, direccion);
        this.cargo = cargo;
        this.sueldoBase = sueldoBase;
        this.aniosAntiguedad = aniosAntiguedad;
        this.activo = activo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        if (sueldoBase < 0) {
            throw new IllegalArgumentException("El sueldo no puede ser negativo");
        }
        this.sueldoBase = sueldoBase;
    }

    public int getAniosAntiguedad() {
        return aniosAntiguedad;
    }

    public void setAniosAntiguedad(int aniosAntiguedad) {
        if (aniosAntiguedad < 0) {
            throw new IllegalArgumentException("Los años de antigüedad no pueden ser negativos");
        }
        this.aniosAntiguedad = aniosAntiguedad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String getRol() {
        return "Empleado";
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "rut='" + getRut() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", cargo='" + cargo + '\'' +
                ", sueldoBase=" + sueldoBase +
                ", aniosAntiguedad=" + aniosAntiguedad +
                ", activo=" + (activo ? "Sí" : "No") +
                '}';
    }
}