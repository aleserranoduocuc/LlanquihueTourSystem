package com.mycompany.llanquihuetoursystem.ui;

import com.mycompany.llanquihuetoursystem.data.GestorServicios;

public class Main {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║     🏔️ LLANQUIHUE TOUR - SISTEMA DE GESTIÓN ║");
        System.out.println("║        Región de Los Lagos - Chile           ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");
        
        GestorServicios gestor = new GestorServicios();
        gestor.mostrarServicios();
    }
}