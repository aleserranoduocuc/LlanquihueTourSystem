package com.mycompany.llanquihuetoursystem;

import com.mycompany.llanquihuetoursystem.data.CargadorDatos;
import com.mycompany.llanquihuetoursystem.model.*;
import com.mycompany.llanquihuetoursystem.service.GestionTuristica;
import java.util.List;
import java.util.Scanner;

public class LlanquihueTourSystem {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║     🏔️ LLANQUIHUE TOUR - SISTEMA DE GESTIÓN ║");
        System.out.println("║        Región de Los Lagos - Chile           ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");
        
        System.out.println("📂 Cargando datos desde archivos...\n");
        
        CargadorDatos cargador = new CargadorDatos();
        GestionTuristica gestion = new GestionTuristica();
        
        // Cargar empleados de ejemplo
        cargarEmpleadosEjemplo(gestion);
        
        try {
            // Cargar guías usando ClassLoader
            List<Guia> guias = cargador.cargarGuias();
            guias.forEach(gestion::agregarGuia);
            System.out.println("✅ " + guias.size() + " guías cargadas");
            
            // Cargar operadores
            List<Operador> operadores = cargador.cargarOperadores();
            operadores.forEach(gestion::agregarOperador);
            System.out.println("✅ " + operadores.size() + " operadores cargados");
            
            // Cargar proveedores
            List<Proveedor> proveedores = cargador.cargarProveedores();
            proveedores.forEach(gestion::agregarProveedor);
            System.out.println("✅ " + proveedores.size() + " proveedores cargados");
            
        } catch (Exception e) {
            System.out.println("⚠️ Error al cargar archivos. Usando datos de ejemplo...");
            cargarDatosEjemplo(gestion);
        }
        
        System.out.println("\n✅ ¡Sistema listo para usar!\n");
        
        // Menú interactivo
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║            MENÚ PRINCIPAL             ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║  1. Mostrar todos los registros       ║");
            System.out.println("║  2. Buscar guías por especialidad     ║");
            System.out.println("║  3. Ver guías disponibles             ║");
            System.out.println("║  4. Buscar operadores por servicio    ║");
            System.out.println("║  5. Buscar proveedores por rubro      ║");
            System.out.println("║  6. Buscar proveedores por calif.     ║");
            System.out.println("║  7. Buscar persona por nombre         ║");
            System.out.println("║  8. Ver estadísticas                  ║");
            System.out.println("║  9. Salir                             ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.print("👉 Seleccione una opción: ");
            
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("❌ Error: Ingrese un número válido");
                scanner.nextLine();
                opcion = 0;
                continue;
            }
            
            switch (opcion) {
                case 1:
                    gestion.mostrarTodosLosRegistros();
                    break;
                    
                case 2:
                    System.out.print("🔍 Ingrese especialidad a buscar: ");
                    String especialidad = scanner.nextLine();
                    List<Guia> guiasEncontradas = gestion.buscarGuiasPorEspecialidad(especialidad);
                    System.out.println("\n📋 Guías encontradas (" + guiasEncontradas.size() + "):");
                    if (guiasEncontradas.isEmpty()) {
                        System.out.println("   No se encontraron guías con esa especialidad.");
                    } else {
                        guiasEncontradas.forEach(System.out::println);
                    }
                    break;
                    
                case 3:
                    List<Guia> guiasDisponibles = gestion.buscarGuiasDisponibles();
                    System.out.println("\n📋 Guías disponibles (" + guiasDisponibles.size() + "):");
                    if (guiasDisponibles.isEmpty()) {
                        System.out.println("   No hay guías disponibles en este momento.");
                    } else {
                        guiasDisponibles.forEach(System.out::println);
                    }
                    break;
                    
                case 4:
                    System.out.print("🔍 Ingrese tipo de servicio: ");
                    String tipoServicio = scanner.nextLine();
                    List<Operador> operadoresEncontrados = gestion.buscarOperadoresPorServicio(tipoServicio);
                    System.out.println("\n📋 Operadores encontrados (" + operadoresEncontrados.size() + "):");
                    if (operadoresEncontrados.isEmpty()) {
                        System.out.println("   No se encontraron operadores con ese servicio.");
                    } else {
                        operadoresEncontrados.forEach(System.out::println);
                    }
                    break;
                    
                case 5:
                    System.out.print("🔍 Ingrese rubro: ");
                    String rubro = scanner.nextLine();
                    List<Proveedor> proveedoresEncontrados = gestion.buscarProveedoresPorRubro(rubro);
                    System.out.println("\n📋 Proveedores encontrados (" + proveedoresEncontrados.size() + "):");
                    if (proveedoresEncontrados.isEmpty()) {
                        System.out.println("   No se encontraron proveedores con ese rubro.");
                    } else {
                        proveedoresEncontrados.forEach(System.out::println);
                    }
                    break;
                    
                case 6:
                    System.out.print("🔍 Ingrese calificación mínima (0-5): ");
                    try {
                        int calificacionMin = scanner.nextInt();
                        scanner.nextLine();
                        if (calificacionMin < 0 || calificacionMin > 5) {
                            System.out.println("❌ Calificación debe estar entre 0 y 5.");
                            break;
                        }
                        List<Proveedor> proveedoresCalificados = gestion.buscarProveedoresPorCalificacion(calificacionMin);
                        System.out.println("\n📋 Proveedores con calificación ≥ " + calificacionMin + " (" + 
                                         proveedoresCalificados.size() + "):");
                        if (proveedoresCalificados.isEmpty()) {
                            System.out.println("   No se encontraron proveedores con esa calificación.");
                        } else {
                            proveedoresCalificados.forEach(System.out::println);
                        }
                    } catch (Exception e) {
                        System.out.println("❌ Error: Ingrese un número válido.");
                        scanner.nextLine();
                    }
                    break;
                    
                case 7:
                    System.out.print("🔍 Ingrese nombre a buscar: ");
                    String nombre = scanner.nextLine();
                    List<Persona> personasEncontradas = gestion.buscarPersonaPorNombre(nombre);
                    System.out.println("\n📋 Personas encontradas (" + personasEncontradas.size() + "):");
                    if (personasEncontradas.isEmpty()) {
                        System.out.println("   No se encontraron personas con ese nombre.");
                    } else {
                        personasEncontradas.forEach(p -> 
                            System.out.println("   " + p.getRol() + ": " + p.getNombreCompleto() + " (RUT: " + p.getRut() + ")")
                        );
                    }
                    break;
                    
                case 8:
                    gestion.mostrarEstadisticas();
                    break;
                    
                case 9:
                    System.out.println("\n╔══════════════════════════════════════════════╗");
                    System.out.println("║  ¡Gracias por usar Llanquihue Tour!         ║");
                    System.out.println("║  📍 Región de Los Lagos, Chile              ║");
                    System.out.println("║  🏔️ ¡Hasta pronto!                         ║");
                    System.out.println("╚══════════════════════════════════════════════╝");
                    break;
                    
                default:
                    System.out.println("❌ Opción inválida. Intente nuevamente.");
            }
            
            if (opcion != 9) {
                System.out.println("\n⏎ Presione Enter para continuar...");
                scanner.nextLine();
            }
            
        } while (opcion != 9);
        
        scanner.close();
    }
    
    private static void cargarEmpleadosEjemplo(GestionTuristica gestion) {
        Direccion dir1 = new Direccion("Av. Costanera", "123", "Puerto Varas", "Puerto Varas", "Los Lagos");
        Direccion dir2 = new Direccion("Calle Lago", "456", "Frutillar", "Frutillar", "Los Lagos");
        Direccion dir3 = new Direccion("Calle Central", "789", "Llanquihue", "Llanquihue", "Los Lagos");
        
        Empleado emp1 = new Empleado("12.345.678-9", "María", "González", "+56912345678", 
                                    "maria.g@llanquihue.cl", dir1, 
                                    "Gerente General", 2500000, 8, true);
        Empleado emp2 = new Empleado("98.765.432-1", "Carlos", "Pérez", "+56987654321", 
                                    "carlos.p@llanquihue.cl", dir2, 
                                    "Coordinador de Rutas", 1800000, 5, true);
        Empleado emp3 = new Empleado("11.222.333-4", "Ana", "Martínez", "+56911122233", 
                                    "ana.m@llanquihue.cl", dir3, 
                                    "Asistente Administrativo", 1200000, 3, true);
        
        gestion.agregarEmpleado(emp1);
        gestion.agregarEmpleado(emp2);
        gestion.agregarEmpleado(emp3);
        System.out.println("✅ " + 3 + " empleados cargados");
    }
    
    private static void cargarDatosEjemplo(GestionTuristica gestion) {
        Direccion dirGuia1 = new Direccion("Calle del Lago", "234", "Puerto Varas", "Puerto Varas", "Los Lagos");
        Direccion dirGuia2 = new Direccion("Av. Los Volcanes", "567", "Llanquihue", "Llanquihue", "Los Lagos");
        Direccion dirGuia3 = new Direccion("Calle Los Pinos", "890", "Frutillar", "Frutillar", "Los Lagos");
        
        Guia guia1 = new Guia("14.141.414-1", "Pedro", "Silva", "+56914141414", 
                             "pedro.s@guia.cl", dirGuia1, 
                             "Gastronomía", 6, "Español/Inglés/Portugués", true);
        Guia guia2 = new Guia("25.252.525-2", "Laura", "Fernández", "+56925252525", 
                             "laura.f@guia.cl", dirGuia2, 
                             "Paseos Lacustres", 8, "Español/Inglés/Alemán", true);
        Guia guia3 = new Guia("36.363.636-3", "Diego", "Reyes", "+56936363636", 
                             "diego.r@guia.cl", dirGuia3, 
                             "Cultural", 4, "Español/Mapudungun", false);
        
        gestion.agregarGuia(guia1);
        gestion.agregarGuia(guia2);
        gestion.agregarGuia(guia3);
        
        Direccion dirOp1 = new Direccion("Camino al Sur", "345", "Puerto Montt", "Puerto Montt", "Los Lagos");
        Direccion dirOp2 = new Direccion("Av. Costanera", "678", "Puerto Varas", "Puerto Varas", "Los Lagos");
        
        Operador op1 = new Operador("47.474.747-4", "Roberto", "Torres", "+56947474747", 
                                   "roberto.t@operador.cl", dirOp1, 
                                   "Lago Tour", "Navegación", 50, true);
        Operador op2 = new Operador("58.585.858-5", "Patricia", "López", "+56958585858", 
                                   "patricia.l@operador.cl", dirOp2, 
                                   "Sur Expediciones", "Trekking", 20, true);
        
        gestion.agregarOperador(op1);
        gestion.agregarOperador(op2);
        
        Direccion dirProv1 = new Direccion("Calle Comercio", "123", "Puerto Varas", "Puerto Varas", "Los Lagos");
        Direccion dirProv2 = new Direccion("Av. Los Lagos", "456", "Llanquihue", "Llanquihue", "Los Lagos");
        Direccion dirProv3 = new Direccion("Calle del Mar", "789", "Frutillar", "Frutillar", "Los Lagos");
        
        Proveedor prov1 = new Proveedor("61.616.161-6", "Marta", "Sánchez", "+56961616161", 
                                       "marta.s@proveedor.cl", dirProv1, 
                                       "Hostelería", "08:00-22:00", 5);
        Proveedor prov2 = new Proveedor("72.727.272-7", "Jorge", "Flores", "+56972727272", 
                                       "jorge.f@proveedor.cl", dirProv2, 
                                       "Gastronomía", "10:00-21:00", 4);
        Proveedor prov3 = new Proveedor("83.838.383-8", "Claudia", "Herrera", "+56983838383", 
                                       "claudia.h@proveedor.cl", dirProv3, 
                                       "Artesanía", "09:00-19:00", 5);
        
        gestion.agregarProveedor(prov1);
        gestion.agregarProveedor(prov2);
        gestion.agregarProveedor(prov3);
        
        System.out.println("📌 Usando datos de ejemplo:");
        System.out.println("   - 3 guías, 2 operadores, 3 proveedores");
    }
}