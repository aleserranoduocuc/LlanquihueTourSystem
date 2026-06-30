package com.mycompany.llanquihuetoursystem.service;

import com.mycompany.llanquihuetoursystem.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestionTuristica {
    private List<Guia> guias;
    private List<Operador> operadores;
    private List<Proveedor> proveedores;
    private List<Empleado> empleados;
    private List<Persona> todasLasPersonas;

    public GestionTuristica() {
        this.guias = new ArrayList<>();
        this.operadores = new ArrayList<>();
        this.proveedores = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.todasLasPersonas = new ArrayList<>();
    }

    public void agregarGuia(Guia guia) {
        guias.add(guia);
        todasLasPersonas.add(guia);
    }

    public void agregarOperador(Operador operador) {
        operadores.add(operador);
        todasLasPersonas.add(operador);
    }

    public void agregarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
        todasLasPersonas.add(proveedor);
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        todasLasPersonas.add(empleado);
    }

    public List<Guia> buscarGuiasPorEspecialidad(String especialidad) {
        return guias.stream()
                .filter(g -> g.getEspecialidad().toLowerCase().contains(especialidad.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Guia> buscarGuiasDisponibles() {
        return guias.stream()
                .filter(Guia::isDisponible)
                .collect(Collectors.toList());
    }

    public List<Operador> buscarOperadoresPorServicio(String tipoServicio) {
        return operadores.stream()
                .filter(o -> o.getTipoServicio().toLowerCase().contains(tipoServicio.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Proveedor> buscarProveedoresPorRubro(String rubro) {
        return proveedores.stream()
                .filter(p -> p.getRubro().toLowerCase().contains(rubro.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Proveedor> buscarProveedoresPorCalificacion(int calificacionMinima) {
        return proveedores.stream()
                .filter(p -> p.getCalificacion() >= calificacionMinima)
                .collect(Collectors.toList());
    }

    public List<Persona> buscarPersonaPorNombre(String nombre) {
        return todasLasPersonas.stream()
                .filter(p -> p.getNombre().toLowerCase().contains(nombre.toLowerCase()) ||
                           p.getApellido().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void mostrarTodosLosRegistros() {
        System.out.println("\n=== LISTADO COMPLETO DE REGISTROS ===");
        
        System.out.println("\n--- EMPLEADOS (" + empleados.size() + ") ---");
        empleados.forEach(System.out::println);
        
        System.out.println("\n--- GUÍAS TURÍSTICOS (" + guias.size() + ") ---");
        guias.forEach(System.out::println);
        
        System.out.println("\n--- OPERADORES TURÍSTICOS (" + operadores.size() + ") ---");
        operadores.forEach(System.out::println);
        
        System.out.println("\n--- PROVEEDORES (" + proveedores.size() + ") ---");
        proveedores.forEach(System.out::println);
    }

    public void mostrarEstadisticas() {
        System.out.println("\n=== ESTADÍSTICAS DEL SISTEMA ===");
        System.out.println("Total Empleados: " + empleados.size());
        System.out.println("Total Guías: " + guias.size());
        System.out.println("Total Operadores: " + operadores.size());
        System.out.println("Total Proveedores: " + proveedores.size());
        System.out.println("Total Personas Registradas: " + todasLasPersonas.size());
        
        long guiasDisponibles = guias.stream().filter(Guia::isDisponible).count();
        System.out.println("Guías Disponibles: " + guiasDisponibles);
        
        if (!proveedores.isEmpty()) {
            double promedioCalificacion = proveedores.stream()
                    .mapToInt(Proveedor::getCalificacion)
                    .average()
                    .orElse(0);
            System.out.println("Calificación Promedio de Proveedores: " + 
                             String.format("%.2f", promedioCalificacion));
        }
        
        long empleadosActivos = empleados.stream().filter(Empleado::isActivo).count();
        System.out.println("Empleados Activos: " + empleadosActivos);
    }

    public List<Guia> getGuias() { return guias; }
    public List<Operador> getOperadores() { return operadores; }
    public List<Proveedor> getProveedores() { return proveedores; }
    public List<Empleado> getEmpleados() { return empleados; }
    public List<Persona> getTodasLasPersonas() { return todasLasPersonas; }
}