package com.mycompany.llanquihuetoursystem.model;

public class Empleado extends Persona {
    private String cargo;
    private double salario;
    private int añosAntiguedad;
    private boolean activo;

    // CONSTRUCTOR CORRECTO - DEBE LLAMAR A super() CON TODOS LOS PARÁMETROS
    public Empleado(String rut, String nombre, String apellido, String telefono, String email,
                    Direccion direccion, String cargo, double salario, int añosAntiguedad, boolean activo) {
        super(rut, nombre, apellido, telefono, email, direccion);
        this.cargo = cargo;
        this.salario = salario;
        this.añosAntiguedad = añosAntiguedad;
        this.activo = activo;
    }

    // Getters y Setters
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
    
    public int getAñosAntiguedad() { return añosAntiguedad; }
    public void setAñosAntiguedad(int añosAntiguedad) { this.añosAntiguedad = añosAntiguedad; }
    
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String getRol() {
        return "Empleado";
    }

    @Override
    public void mostrarResumen() {
        System.out.println("👔 EMPLEADO");
        System.out.println("   Nombre: " + getNombreCompleto());
        System.out.println("   RUT: " + rut);
        System.out.println("   Cargo: " + cargo);
        System.out.println("   Salario: $" + salario);
        System.out.println("   Antigüedad: " + añosAntiguedad + " años");
        System.out.println("   Activo: " + (activo ? "Sí" : "No"));
        System.out.println();
    }

    @Override
    public String toString() {
        return super.toString() + " | Cargo: " + cargo + " | Salario: $" + salario;
    }
}