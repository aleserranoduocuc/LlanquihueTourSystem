package com.mycompany.llanquihuetoursystem.model;

public class Proveedor extends Persona {
    private String rubro;
    private String horarioAtencion;
    private int calificacion;

    public Proveedor() {
        super();
    }

    public Proveedor(String rut, String nombre, String apellido, 
                     String telefono, String email, Direccion direccion,
                     String rubro, String horarioAtencion, int calificacion) {
        super(rut, nombre, apellido, telefono, email, direccion);
        this.rubro = rubro;
        this.horarioAtencion = horarioAtencion;
        this.calificacion = calificacion;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        if (calificacion < 0 || calificacion > 5) {
            throw new IllegalArgumentException("La calificación debe estar entre 0 y 5");
        }
        this.calificacion = calificacion;
    }

    @Override
    public String getRol() {
        return "Proveedor";
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "rut='" + getRut() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", rubro='" + rubro + '\'' +
                ", horarioAtencion='" + horarioAtencion + '\'' +
                ", calificacion=" + calificacion +
                '}';
    }
}