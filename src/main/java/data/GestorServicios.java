package com.mycompany.llanquihuetoursystem.data;

import com.mycompany.llanquihuetoursystem.model.ExcursionCultural;
import com.mycompany.llanquihuetoursystem.model.PaseoLacustre;
import com.mycompany.llanquihuetoursystem.model.RutaGastronomica;
import com.mycompany.llanquihuetoursystem.model.ServicioTuristico;
import java.util.ArrayList;
import java.util.List;

public class GestorServicios {
    
    private List<ServicioTuristico> servicios;
    
    public GestorServicios() {
        servicios = new ArrayList<>();
        inicializarServicios();
    }
    
    private void inicializarServicios() {
        // Al menos 5 objetos combinando diferentes subclases
        servicios.add(new RutaGastronomica("Sabor a Lago", 4, 6));
        servicios.add(new RutaGastronomica("Delicias del Sur", 3, 4));
        servicios.add(new PaseoLacustre("Navegación al Atardecer", 2, "Velero"));
        servicios.add(new PaseoLacustre("Explorando el Lago", 3, "Lancha Motora"));
        servicios.add(new ExcursionCultural("Historia Viva", 5, "Museo Colonial"));
        servicios.add(new ExcursionCultural("Patrimonio Mapuche", 4, "Fuerte Nahuelbuta"));
    }
    
    public List<ServicioTuristico> getServicios() {
        return servicios;
    }
    
    public void mostrarServicios() {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║        🌿 SERVICIOS TURÍSTICOS              ║");
        System.out.println("║         Llanquihue Tour - Los Lagos         ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");
        
        System.out.println("📋 Lista de servicios disponibles:\n");
        
        // Recorrido polimórfico con for-each
        for (ServicioTuristico servicio : servicios) {
            servicio.mostrarInformacion();
        }
        
        System.out.println("✅ Total de servicios: " + servicios.size());
    }
}