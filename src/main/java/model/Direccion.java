package com.mycompany.llanquihuetoursystem.model;

import java.io.Serializable;

public class Direccion implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String calle;
    private String numero;
    private String comuna;
    private String ciudad;
    private String region;

    public Direccion() {
    }

    public Direccion(String calle, String numero, String comuna, 
                     String ciudad, String region) {
        this.calle = calle;
        this.numero = numero;
        this.comuna = comuna;
        this.ciudad = ciudad;
        this.region = region;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDireccionCompleta() {
        return calle + " " + numero + ", " + comuna + ", " + ciudad + ", " + region;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", comuna='" + comuna + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}