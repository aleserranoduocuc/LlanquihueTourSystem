package com.mycompany.llanquihuetoursystem.data;

import com.mycompany.llanquihuetoursystem.model.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CargadorDatos {

    public List<Guia> cargarGuias() {
        List<Guia> guias = new ArrayList<>();
        
        // Usar ClassLoader para encontrar el archivo en resources
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("guias.csv")) {
            
            if (inputStream == null) {
                System.err.println("❌ No se encontró el archivo guias.csv en resources");
                return guias;
            }
            
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String linea;
                br.readLine(); // Saltar cabecera
                
                while ((linea = br.readLine()) != null) {
                    try {
                        String[] datos = linea.split(",");
                        
                        Direccion direccion = new Direccion(
                            datos[5].trim(),
                            datos[6].trim(),
                            datos[7].trim(),
                            datos[8].trim(),
                            datos[9].trim()
                        );
                        
                        Guia guia = new Guia(
                            datos[0].trim(),
                            datos[1].trim(),
                            datos[2].trim(),
                            datos[3].trim(),
                            datos[4].trim(),
                            direccion,
                            datos[10].trim(),
                            Integer.parseInt(datos[11].trim()),
                            datos[12].trim(),
                            Boolean.parseBoolean(datos[13].trim())
                        );
                        
                        guias.add(guia);
                    } catch (Exception e) {
                        System.err.println("Error al procesar línea: " + linea);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("❌ Error al leer archivo: " + e.getMessage());
        }
        
        return guias;
    }

    public List<Operador> cargarOperadores() {
        List<Operador> operadores = new ArrayList<>();
        
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("operadores.csv")) {
            
            if (inputStream == null) {
                System.err.println("❌ No se encontró el archivo operadores.csv en resources");
                return operadores;
            }
            
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String linea;
                br.readLine(); // Saltar cabecera
                
                while ((linea = br.readLine()) != null) {
                    try {
                        String[] datos = linea.split(",");
                        
                        Direccion direccion = new Direccion(
                            datos[5].trim(),
                            datos[6].trim(),
                            datos[7].trim(),
                            datos[8].trim(),
                            datos[9].trim()
                        );
                        
                        Operador operador = new Operador(
                            datos[0].trim(),
                            datos[1].trim(),
                            datos[2].trim(),
                            datos[3].trim(),
                            datos[4].trim(),
                            direccion,
                            datos[10].trim(),
                            datos[11].trim(),
                            Integer.parseInt(datos[12].trim()),
                            Boolean.parseBoolean(datos[13].trim())
                        );
                        
                        operadores.add(operador);
                    } catch (Exception e) {
                        System.err.println("Error al procesar línea: " + linea);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("❌ Error al leer archivo: " + e.getMessage());
        }
        
        return operadores;
    }

    public List<Proveedor> cargarProveedores() {
        List<Proveedor> proveedores = new ArrayList<>();
        
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("proveedores.csv")) {
            
            if (inputStream == null) {
                System.err.println("❌ No se encontró el archivo proveedores.csv en resources");
                return proveedores;
            }
            
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String linea;
                br.readLine(); // Saltar cabecera
                
                while ((linea = br.readLine()) != null) {
                    try {
                        String[] datos = linea.split(",");
                        
                        Direccion direccion = new Direccion(
                            datos[5].trim(),
                            datos[6].trim(),
                            datos[7].trim(),
                            datos[8].trim(),
                            datos[9].trim()
                        );
                        
                        Proveedor proveedor = new Proveedor(
                            datos[0].trim(),
                            datos[1].trim(),
                            datos[2].trim(),
                            datos[3].trim(),
                            datos[4].trim(),
                            direccion,
                            datos[10].trim(),
                            datos[11].trim(),
                            Integer.parseInt(datos[12].trim())
                        );
                        
                        proveedores.add(proveedor);
                    } catch (Exception e) {
                        System.err.println("Error al procesar línea: " + linea);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("❌ Error al leer archivo: " + e.getMessage());
        }
        
        return proveedores;
    }
}