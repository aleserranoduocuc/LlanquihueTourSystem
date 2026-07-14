package com.mycompany.llanquihuetoursystem.data;

import com.mycompany.llanquihuetoursystem.model.*;
import java.util.ArrayList;
import java.util.List;

public class GestorEntidades {
    
    private List<Registrable> entidades;
    
    public GestorEntidades() {
        entidades = new ArrayList<>();
        inicializarEntidades();
    }
    
    private void inicializarEntidades() {
        // Crear direcciones
        Direccion dir1 = new Direccion("Av. Costanera", "123", "Puerto Varas", "Puerto Varas", "Los Lagos");
        Direccion dir2 = new Direccion("Calle Lago", "456", "Frutillar", "Frutillar", "Los Lagos");
        Direccion dir3 = new Direccion("Calle Central", "789", "Llanquihue", "Llanquihue", "Los Lagos");
        
        // Agregar Guías
        entidades.add(new Guia("14.141.414-1", "Pedro", "Silva", "+56914141414", 
                              "pedro.s@guia.cl", dir1, "Gastronomía", 6, "Español/Inglés", true));
        entidades.add(new Guia("25.252.525-2", "Laura", "Fernández", "+56925252525", 
                              "laura.f@guia.cl", dir2, "Paseos Lacustres", 8, "Español/Inglés/Alemán", true));
        
        // Agregar Operadores
        entidades.add(new Operador("47.474.747-4", "Roberto", "Torres", "+56947474747", 
                                  "roberto.t@operador.cl", dir1, "Lago Tour", "Navegación", 50, true));
        
        // Agregar Proveedores
        entidades.add(new Proveedor("61.616.161-6", "Marta", "Sánchez", "+56961616161", 
                                   "marta.s@proveedor.cl", dir3, "Hostelería", "08:00-22:00", 5));
        
        // Agregar Vehículos
        entidades.add(new Vehiculo("AB-12-CD", "Toyota", "Hiace", 2022, 15, true));
        entidades.add(new Vehiculo("EF-34-GH", "Mercedes", "Sprinter", 2023, 20, false));
        
        // Agregar Colaboradores Externos
        entidades.add(new ColaboradorExterno("78.787.878-7", "Carlos", "Mendoza", "+56978787878", 
                                            "Fotografía", "Visual Chile"));
        entidades.add(new ColaboradorExterno("89.898.989-8", "Ana", "Ramírez", "+56989898989", 
                                            "Traducción", "Lingua Global"));
    }
    
    public List<Registrable> getEntidades() {
        return entidades;
    }
    
    public void agregarEntidad(Registrable entidad) {
        entidades.add(entidad);
    }
    
    public void mostrarEntidades() {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║        📋 LISTA DE ENTIDADES                ║");
        System.out.println("║         Llanquihue Tour - Los Lagos         ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");
        
        System.out.println("📋 Total de entidades: " + entidades.size() + "\n");
        
        int contador = 1;
        for (Registrable entidad : entidades) {
            System.out.println("[" + contador + "]");
            
            // POLIMORFISMO: mostramos el resumen
            entidad.mostrarResumen();
            
            // instanceof para diferenciar comportamientos
            if (entidad instanceof Guia) {
                Guia guia = (Guia) entidad;
                System.out.println("   🔍 Especialidad destacada: " + guia.getEspecialidad());
                if (guia.isDisponible()) {
                    System.out.println("   ✅ Guía disponible para asignación inmediata");
                }
            } else if (entidad instanceof Vehiculo) {
                Vehiculo vehiculo = (Vehiculo) entidad;
                if (vehiculo.isDisponible()) {
                    System.out.println("   🚗 Vehículo disponible para rutas");
                } else {
                    System.out.println("   🚗 Vehículo en mantenimiento");
                }
            } else if (entidad instanceof ColaboradorExterno) {
                ColaboradorExterno colab = (ColaboradorExterno) entidad;
                System.out.println("   🤝 Colaborador asociado a: " + colab.getEmpresaAsociada());
            } else if (entidad instanceof Proveedor) {
                Proveedor prov = (Proveedor) entidad;
                System.out.println("   ⭐ Calificación: " + prov.getCalificacion() + " estrellas");
            }
            
            System.out.println();
            contador++;
        }
        
        System.out.println("✅ Total de entidades procesadas: " + entidades.size());
    }
}