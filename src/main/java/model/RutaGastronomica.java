package com.mycompany.llanquihuetoursystem.model;

public class RutaGastronomica extends ServicioTuristico {
    private int numeroDeParadas;

    public RutaGastronomica(String nombre, int duracionHoras, int numeroDeParadas) {
        super(nombre, duracionHoras);
        this.numeroDeParadas = numeroDeParadas;
    }

    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    public void setNumeroDeParadas(int numeroDeParadas) {
        this.numeroDeParadas = numeroDeParadas;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("🍽️ RUTA GASTRONÓMICA");
        System.out.println("   Nombre: " + nombre);
        System.out.println("   Duración: " + duracionHoras + " horas");
        System.out.println("   Número de paradas: " + numeroDeParadas);
        System.out.println();
    }

    @Override
    public String toString() {
        return "🍽️ Ruta Gastronómica: " + nombre + 
               " | Duración: " + duracionHoras + " horas" +
               " | Paradas: " + numeroDeParadas;
    }
}