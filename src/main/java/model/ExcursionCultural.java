package com.mycompany.llanquihuetoursystem.model;

public class ExcursionCultural extends ServicioTuristico {
    private String lugarHistorico;

    public ExcursionCultural(String nombre, int duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }

    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("🏛️ EXCURSIÓN CULTURAL");
        System.out.println("   Nombre: " + nombre);
        System.out.println("   Duración: " + duracionHoras + " horas");
        System.out.println("   Lugar histórico: " + lugarHistorico);
        System.out.println();
    }

    @Override
    public String toString() {
        return "🏛️ Excursión Cultural: " + nombre + 
               " | Duración: " + duracionHoras + " horas" +
               " | Lugar: " + lugarHistorico;
    }
}