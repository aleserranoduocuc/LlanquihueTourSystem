package com.mycompany.llanquihuetoursystem.model;

public class Vehiculo implements Registrable {
    private String patente;
    private String marca;
    private String modelo;
    private int año;
    private int capacidadPasajeros;
    private boolean disponible;

    public Vehiculo(String patente, String marca, String modelo, int año, int capacidadPasajeros, boolean disponible) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.capacidadPasajeros = capacidadPasajeros;
        this.disponible = disponible;
    }

    // Getters y Setters
    public String getPatente() { return patente; }
    public void setPatente(String patente) { this.patente = patente; }
    
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    
    public int getAño() { return año; }
    public void setAño(int año) { this.año = año; }
    
    public int getCapacidadPasajeros() { return capacidadPasajeros; }
    public void setCapacidadPasajeros(int capacidadPasajeros) { this.capacidadPasajeros = capacidadPasajeros; }
    
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public void mostrarResumen() {
        System.out.println("🚗 VEHÍCULO");
        System.out.println("   Patente: " + patente);
        System.out.println("   Marca: " + marca);
        System.out.println("   Modelo: " + modelo);
        System.out.println("   Año: " + año);
        System.out.println("   Capacidad: " + capacidadPasajeros + " pasajeros");
        System.out.println("   Disponible: " + (disponible ? "Sí" : "No"));
        System.out.println();
    }

    @Override
    public String toString() {
        return "🚗 " + marca + " " + modelo + " (" + año + ") | Patente: " + patente + " | Capacidad: " + capacidadPasajeros;
    }
}