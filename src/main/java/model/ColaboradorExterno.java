package com.mycompany.llanquihuetoursystem.model;

public class ColaboradorExterno implements Registrable {
    private String rut;
    private String nombre;
    private String apellido;
    private String telefono;
    private String especialidad;
    private String empresaAsociada;

    public ColaboradorExterno(String rut, String nombre, String apellido, String telefono, 
                              String especialidad, String empresaAsociada) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.empresaAsociada = empresaAsociada;
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
    
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    
    public String getEmpresaAsociada() { return empresaAsociada; }
    public void setEmpresaAsociada(String empresaAsociada) { this.empresaAsociada = empresaAsociada; }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("🤝 COLABORADOR EXTERNO");
        System.out.println("   Nombre: " + getNombreCompleto());
        System.out.println("   RUT: " + rut);
        System.out.println("   Especialidad: " + especialidad);
        System.out.println("   Empresa Asociada: " + empresaAsociada);
        System.out.println();
    }

    @Override
    public String toString() {
        return "🤝 Colaborador: " + getNombreCompleto() + " | Especialidad: " + especialidad + 
               " | Empresa: " + empresaAsociada;
    }
}