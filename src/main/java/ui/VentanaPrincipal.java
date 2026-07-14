package com.mycompany.llanquihuetoursystem.ui;

import com.mycompany.llanquihuetoursystem.data.GestorEntidades;
import com.mycompany.llanquihuetoursystem.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    
    private GestorEntidades gestor;
    private JTextArea areaTexto;
    private JComboBox<String> comboOpciones;
    
    public VentanaPrincipal() {
        gestor = new GestorEntidades();
        initComponents();
    }
    
    private void initComponents() {
        setTitle("🏔️ Llanquihue Tour - Sistema de Gestión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        // Panel superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(new Color(33, 97, 143));
        panelSuperior.setPreferredSize(new Dimension(600, 60));
        
        JLabel titulo = new JLabel("🏔️ LLANQUIHUE TOUR");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        panelSuperior.add(titulo);
        
        add(panelSuperior, BorderLayout.NORTH);
        
        // Panel central
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        scrollPane.setPreferredSize(new Dimension(550, 300));
        panelCentral.add(scrollPane, BorderLayout.CENTER);
        
        add(panelCentral, BorderLayout.CENTER);
        
        // Panel inferior
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new GridLayout(4, 1, 5, 5));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Combo y botón para agregar
        JPanel panelCombo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        String[] opciones = {"Seleccione una opción", "Agregar Guía", "Agregar Vehículo", "Agregar Colaborador Externo"};
        comboOpciones = new JComboBox<>(opciones);
        comboOpciones.setPreferredSize(new Dimension(250, 30));
        
        JButton btnAgregar = new JButton("➕ Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEntidad();
            }
        });
        
        panelCombo.add(comboOpciones);
        panelCombo.add(btnAgregar);
        panelInferior.add(panelCombo);
        
        // Botones de acción
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        JButton btnMostrar = new JButton("📋 Mostrar Entidades");
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarEntidades();
            }
        });
        
        JButton btnLimpiar = new JButton("🗑️ Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaTexto.setText("");
            }
        });
        
        JButton btnSalir = new JButton("🚪 Salir");
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        panelBotones.add(btnMostrar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnSalir);
        panelInferior.add(panelBotones);
        
        // Mensaje de bienvenida
        JPanel panelInfo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel info = new JLabel("Seleccione una opción para agregar entidades");
        info.setFont(new Font("Arial", Font.PLAIN, 12));
        panelInfo.add(info);
        panelInferior.add(panelInfo);
        
        add(panelInferior, BorderLayout.SOUTH);
    }
    
    private void agregarEntidad() {
        int opcion = comboOpciones.getSelectedIndex();
        
        switch (opcion) {
            case 1: // Agregar Guía
                agregarGuia();
                break;
            case 2: // Agregar Vehículo
                agregarVehiculo();
                break;
            case 3: // Agregar Colaborador Externo
                agregarColaboradorExterno();
                break;
            default:
                JOptionPane.showMessageDialog(this, 
                    "Por favor, seleccione una opción válida.", 
                    "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void agregarGuia() {
        try {
            JTextField txtRut = new JTextField();
            JTextField txtNombre = new JTextField();
            JTextField txtApellido = new JTextField();
            JTextField txtTelefono = new JTextField();
            JTextField txtEmail = new JTextField();
            JTextField txtEspecialidad = new JTextField();
            JTextField txtExperiencia = new JTextField();
            JTextField txtIdiomas = new JTextField();
            
            Object[] campos = {
                "RUT:", txtRut,
                "Nombre:", txtNombre,
                "Apellido:", txtApellido,
                "Teléfono:", txtTelefono,
                "Email:", txtEmail,
                "Especialidad:", txtEspecialidad,
                "Años de experiencia:", txtExperiencia,
                "Idiomas:", txtIdiomas
            };
            
            int resultado = JOptionPane.showConfirmDialog(this, campos, 
                "Agregar Guía Turístico", JOptionPane.OK_CANCEL_OPTION);
            
            if (resultado == JOptionPane.OK_OPTION) {
                Direccion dir = new Direccion("Calle", "123", "Ciudad", "Comuna", "Región");
                Guia guia = new Guia(
                    txtRut.getText(),
                    txtNombre.getText(),
                    txtApellido.getText(),
                    txtTelefono.getText(),
                    txtEmail.getText(),
                    dir,
                    txtEspecialidad.getText(),
                    Integer.parseInt(txtExperiencia.getText()),
                    txtIdiomas.getText(),
                    true
                );
                gestor.agregarEntidad(guia);
                JOptionPane.showMessageDialog(this, "✅ Guía agregado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                mostrarEntidades();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "❌ Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void agregarVehiculo() {
        try {
            JTextField txtPatente = new JTextField();
            JTextField txtMarca = new JTextField();
            JTextField txtModelo = new JTextField();
            JTextField txtAño = new JTextField();
            JTextField txtCapacidad = new JTextField();
            
            Object[] campos = {
                "Patente:", txtPatente,
                "Marca:", txtMarca,
                "Modelo:", txtModelo,
                "Año:", txtAño,
                "Capacidad (pasajeros):", txtCapacidad
            };
            
            int resultado = JOptionPane.showConfirmDialog(this, campos, 
                "Agregar Vehículo", JOptionPane.OK_CANCEL_OPTION);
            
            if (resultado == JOptionPane.OK_OPTION) {
                Vehiculo vehiculo = new Vehiculo(
                    txtPatente.getText(),
                    txtMarca.getText(),
                    txtModelo.getText(),
                    Integer.parseInt(txtAño.getText()),
                    Integer.parseInt(txtCapacidad.getText()),
                    true
                );
                gestor.agregarEntidad(vehiculo);
                JOptionPane.showMessageDialog(this, "✅ Vehículo agregado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                mostrarEntidades();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "❌ Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void agregarColaboradorExterno() {
        try {
            JTextField txtRut = new JTextField();
            JTextField txtNombre = new JTextField();
            JTextField txtApellido = new JTextField();
            JTextField txtTelefono = new JTextField();
            JTextField txtEspecialidad = new JTextField();
            JTextField txtEmpresa = new JTextField();
            
            Object[] campos = {
                "RUT:", txtRut,
                "Nombre:", txtNombre,
                "Apellido:", txtApellido,
                "Teléfono:", txtTelefono,
                "Especialidad:", txtEspecialidad,
                "Empresa Asociada:", txtEmpresa
            };
            
            int resultado = JOptionPane.showConfirmDialog(this, campos, 
                "Agregar Colaborador Externo", JOptionPane.OK_CANCEL_OPTION);
            
            if (resultado == JOptionPane.OK_OPTION) {
                ColaboradorExterno colaborador = new ColaboradorExterno(
                    txtRut.getText(),
                    txtNombre.getText(),
                    txtApellido.getText(),
                    txtTelefono.getText(),
                    txtEspecialidad.getText(),
                    txtEmpresa.getText()
                );
                gestor.agregarEntidad(colaborador);
                JOptionPane.showMessageDialog(this, "✅ Colaborador agregado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                mostrarEntidades();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "❌ Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void mostrarEntidades() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔══════════════════════════════════════════════╗\n");
        sb.append("║        📋 LISTA DE ENTIDADES                ║\n");
        sb.append("║         Llanquihue Tour - Los Lagos         ║\n");
        sb.append("╚══════════════════════════════════════════════╝\n\n");
        
        int contador = 1;
        for (Registrable entidad : gestor.getEntidades()) {
            sb.append("[").append(contador).append("] ");
            
            if (entidad instanceof Guia) {
                sb.append("🧭 Guía Turístico\n");
            } else if (entidad instanceof Operador) {
                sb.append("🚌 Operador Turístico\n");
            } else if (entidad instanceof Proveedor) {
                sb.append("📦 Proveedor\n");
            } else if (entidad instanceof Vehiculo) {
                sb.append("🚗 Vehículo\n");
            } else if (entidad instanceof ColaboradorExterno) {
                sb.append("🤝 Colaborador Externo\n");
            } else {
                sb.append("📋 " + entidad.getClass().getSimpleName() + "\n");
            }
            
            sb.append(entidad.toString()).append("\n\n");
            contador++;
        }
        
        sb.append("✅ Total de entidades: ").append(gestor.getEntidades().size());
        
        areaTexto.setText(sb.toString());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}