package com.mycompany.llanquihuetoursystem.data;

import com.mycompany.llanquihuetoursystem.model.ExcursionCultural;
import com.mycompany.llanquihuetoursystem.model.PaseoLacustre;
import com.mycompany.llanquihuetoursystem.model.RutaGastronomica;

public class GestorServicios {
    
    public static void mostrarServiciosTuristicos() {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║        🌿 SERVICIOS TURÍSTICOS              ║");
        System.out.println("║         Llanquihue Tour - Los Lagos         ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");
        
        System.out.println("--- RUTAS GASTRONÓMICAS ---");
        RutaGastronomica ruta1 = new RutaGastronomica(
            "Sabor a Lago - Degustación de Mariscos", 4, 6
        );
        RutaGastronomica ruta2 = new RutaGastronomica(
            "Ruta de la Cerveza Artesanal", 3, 5
        );
        System.out.println(ruta1);
        System.out.println(ruta2);
        
        System.out.println("\n--- PASEOS LACUSTRES ---");
        PaseoLacustre paseo1 = new PaseoLacustre(
            "Navegación al Atardecer - Lago Llanquihue", 2, "Velero"
        );
        PaseoLacustre paseo2 = new PaseoLacustre(
            "Ruta de los Volcanes - Lago Todos los Santos", 4, "Lancha Motora"
        );
        System.out.println(paseo1);
        System.out.println(paseo2);
        
        System.out.println("\n--- EXCURSIONES CULTURALES ---");
        ExcursionCultural cultural1 = new ExcursionCultural(
            "Museo Colonial de Frutillar", 3, "Museo Colonial Alemán"
        );
        ExcursionCultural cultural2 = new ExcursionCultural(
            "Fuerte Nahuelbuta - Historia Mapuche", 5, "Fuerte Nahuelbuta"
        );
        System.out.println(cultural1);
        System.out.println(cultural2);
        
        System.out.println("\n✅ Servicios turísticos cargados exitosamente");
    }
}