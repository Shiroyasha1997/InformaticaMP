package vista;

import bd.Conexion;
import modelo.*;
import controlador.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

public class VentanaEquipo extends javax.swing.JFrame {
    
    private TableRowSorter<DefaultTableModel> sorter;
     private Color colorDeshabilitado = Color.BLACK; // Color negro para texto deshabilitado
    
    public VentanaEquipo() {
        initComponents();
        this.setLocationRelativeTo(null);
        // Maximizar la ventana al iniciar el programa
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        
        mostrarEmpleados(null);
        mostrarEquipos(null);
        
        // Deshabilitar botones
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(false);
        
        // Deshabilitar campos de texto
        txtAsignado.setEnabled(false);
        txtResponsable.setEnabled(false);
        txtDepartamento.setEnabled(false);
        
        // Establecer color de texto deshabilitado
        txtAsignado.setDisabledTextColor(colorDeshabilitado);
        txtResponsable.setDisabledTextColor(colorDeshabilitado);
        txtDepartamento.setDisabledTextColor(colorDeshabilitado);
        
        // Añadir DocumentListener para txtBuscarEmpleado
        txtBuscarEmpleado.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarEmpleados();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarEmpleados();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarEmpleados();
            }

            private void filtrarEmpleados() {
                String filtroEmpleado = txtBuscarEmpleado.getText().trim();
                mostrarEmpleados(filtroEmpleado);
            }
        });
        
        // Añadir DocumentListener para txtBuscarEquipo
        txtBuscarEquipo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarEquipos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarEquipos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarEquipos();
            }

            private void filtrarEquipos() {
                String filtroEquipo = txtBuscarEquipo.getText().trim();
                mostrarEquipos(filtroEquipo);
            }
        });
        
        // Configurar el sorter para ordenar la tabla
        sorter = new TableRowSorter<>((DefaultTableModel) tbEquipo.getModel());
        tbEquipo.setRowSorter(sorter);
        
        // Configurar el sorter para ordenar la tabla
        sorter = new TableRowSorter<>((DefaultTableModel) tbEmpleado.getModel());
        tbEmpleado.setRowSorter(sorter);
        
        // Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Establecer el tamaño del JFrame para que coincida con el tamaño del monitor
        setSize(screenSize.width, screenSize.height);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgEstado = new javax.swing.ButtonGroup();
        JLabelTitulo1 = new javax.swing.JLabel();
        JLabelTitulo2 = new javax.swing.JLabel();
        jLabelMac = new javax.swing.JLabel();
        jLabelTipo = new javax.swing.JLabel();
        jLabelMarca = new javax.swing.JLabel();
        jLabelModelo = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jLabelOrdenDeCompra = new javax.swing.JLabel();
        jLabelNumeroDeSerie = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jLabelAsignado = new javax.swing.JLabel();
        jLabelDepartamento = new javax.swing.JLabel();
        jLabelResponsable = new javax.swing.JLabel();
        jLabelSistemaOperativo = new javax.swing.JLabel();
        jLabelProcesador = new javax.swing.JLabel();
        jLabelRam = new javax.swing.JLabel();
        jLabelAlmacenamiento = new javax.swing.JLabel();
        jLabelBuscarEquipo = new javax.swing.JLabel();
        jLabelBuscarEmpleado = new javax.swing.JLabel();
        txtBuscarEmpleado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmpleado = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbEquipo = new javax.swing.JTable();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        txtMac = new javax.swing.JTextField();
        txtOrdenDeCompra = new javax.swing.JTextField();
        txtNumeroDeSerie = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtSistemaOperativo = new javax.swing.JTextField();
        txtProcesador = new javax.swing.JTextField();
        txtRam = new javax.swing.JTextField();
        txtAlmacenamiento = new javax.swing.JTextField();
        txtResponsable = new javax.swing.JTextField();
        txtDepartamento = new javax.swing.JTextField();
        txtAsignado = new javax.swing.JTextField();
        txtBuscarEquipo = new javax.swing.JTextField();
        rdReacondicionado = new javax.swing.JRadioButton();
        rdUsado = new javax.swing.JRadioButton();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        rdNuevo = new javax.swing.JRadioButton();
        chkUps = new javax.swing.JCheckBox();
        btnCargarEmpleado = new javax.swing.JButton();
        btnQuitarEmpleado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INFORMATICA MP");
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1680, 1050));
        setName("frame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);
        setSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JLabelTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JLabelTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelTitulo1.setText("INFORMATICA MP");
        JLabelTitulo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(JLabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 210, 40));

        JLabelTitulo2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JLabelTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelTitulo2.setText("GESTOR EQUIPOS");
        JLabelTitulo2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(JLabelTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 210, 40));
        JLabelTitulo2.getAccessibleContext().setAccessibleDescription("");

        jLabelMac.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMac.setText("MAC");
        getContentPane().add(jLabelMac, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        jLabelTipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTipo.setText("TIPO");
        getContentPane().add(jLabelTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 40, -1));

        jLabelMarca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMarca.setText("MARCA");
        getContentPane().add(jLabelMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        jLabelModelo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelModelo.setText("MODELO");
        getContentPane().add(jLabelModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        jLabelEstado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEstado.setText("ESTADO");
        getContentPane().add(jLabelEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, 60, -1));

        jLabelOrdenDeCompra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelOrdenDeCompra.setText("ORDEN DE COMPRA");
        getContentPane().add(jLabelOrdenDeCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, -1, -1));

        jLabelNumeroDeSerie.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNumeroDeSerie.setText("NUMERO DE SERIE");
        getContentPane().add(jLabelNumeroDeSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        jLabelFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelFecha.setText("FECHA");
        getContentPane().add(jLabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, -1, -1));

        jLabelAsignado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelAsignado.setText("ASIGNADO");
        getContentPane().add(jLabelAsignado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 700, -1, -1));

        jLabelDepartamento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDepartamento.setText("DEPARTAMENTO");
        getContentPane().add(jLabelDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 820, 120, -1));

        jLabelResponsable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelResponsable.setText("RESPONSABLE");
        getContentPane().add(jLabelResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 760, -1, -1));

        jLabelSistemaOperativo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSistemaOperativo.setText("SISTEMA OPERATIVO");
        getContentPane().add(jLabelSistemaOperativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 150, -1));

        jLabelProcesador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelProcesador.setText("PROCESADOR");
        getContentPane().add(jLabelProcesador, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, -1));

        jLabelRam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelRam.setText("RAM");
        getContentPane().add(jLabelRam, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, -1, -1));

        jLabelAlmacenamiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelAlmacenamiento.setText("ALMACENAMIENTO");
        getContentPane().add(jLabelAlmacenamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, -1, -1));

        jLabelBuscarEquipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelBuscarEquipo.setText("BUSCAR EQUIPO");
        getContentPane().add(jLabelBuscarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 140, 30));

        jLabelBuscarEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelBuscarEmpleado.setText("BUSCAR EMPLEADO");
        getContentPane().add(jLabelBuscarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 560, 150, 30));
        getContentPane().add(txtBuscarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 560, 910, 30));

        tbEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Departamento", "RUN", "Nombre Completo", "Responsable de Area"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbEmpleado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 600, 1050, 360));

        tbEquipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Numero de Serie", "Responsable", "Asignado", "Departamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbEquipo);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, 1050, 320));
        getContentPane().add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 260, 30));
        getContentPane().add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 260, 30));
        getContentPane().add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 260, 30));
        getContentPane().add(txtMac, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 260, 30));
        getContentPane().add(txtOrdenDeCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 260, 30));
        getContentPane().add(txtNumeroDeSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 260, 30));
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 260, 30));
        getContentPane().add(txtSistemaOperativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 260, 30));
        getContentPane().add(txtProcesador, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 260, 30));
        getContentPane().add(txtRam, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 260, 30));
        getContentPane().add(txtAlmacenamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 260, 30));
        getContentPane().add(txtResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 780, 560, 30));
        getContentPane().add(txtDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 840, 560, 30));
        getContentPane().add(txtAsignado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 720, 560, 30));
        getContentPane().add(txtBuscarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 120, 930, 30));

        btgEstado.add(rdReacondicionado);
        rdReacondicionado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdReacondicionado.setText("Reacondicionado");
        getContentPane().add(rdReacondicionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, -1, -1));

        btgEstado.add(rdUsado);
        rdUsado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdUsado.setText("Usado");
        getContentPane().add(rdUsado, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, -1, -1));

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 590, 180, 30));

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 590, 180, 30));

        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVolver.setText("Volver al Menu Principal");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, 20, 230, 40));

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 490, 180, 30));

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 490, 180, 30));

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 490, 180, 30));

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 490, 180, 30));

        btgEstado.add(rdNuevo);
        rdNuevo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdNuevo.setText("Nuevo");
        getContentPane().add(rdNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, -1, -1));

        chkUps.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chkUps.setText("UPS");
        getContentPane().add(chkUps, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 180, 30));

        btnCargarEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCargarEmpleado.setText("Cargar Empleado");
        btnCargarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarEmpleadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCargarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 910, 180, 30));

        btnQuitarEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnQuitarEmpleado.setText("Quitar Empleado");
        btnQuitarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarEmpleadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuitarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 910, 180, 30));

        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents
 
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // Obtener los nombres completos de los empleados de los campos de texto
        String nombreCompletoResponsable = txtResponsable.getText().trim();
        String nombreCompletoAsignado = txtAsignado.getText().trim();

        Integer idResponsable = null;
        Integer idAsignado = null;

        try {
            // Obtener los IDs de los empleados a partir de sus nombres completos
            GestorEmpleado gestorEmpleado = new GestorEmpleado();

            if (!nombreCompletoResponsable.isEmpty()) {
                idResponsable = gestorEmpleado.obtenerIdEmpleadoPorNombreCompleto(nombreCompletoResponsable);
                if (idResponsable == null) {
                    mostrarError("Debe haber un responsable de area.");
                    return;
                }
            }

            if (!nombreCompletoAsignado.isEmpty()) {
                idAsignado = gestorEmpleado.obtenerIdEmpleadoPorNombreCompleto(nombreCompletoAsignado);
                if (idAsignado == null) {
                    mostrarError("El empleado asignado no existe en la base de datos.");
                    return;
                }
            }

            // Obtener los valores de los campos de texto
            String tipo = txtTipo.getText().trim();
            String marca = txtMarca.getText().trim();
            String modelo = txtModelo.getText().trim();
            String numeroDeSerie = txtNumeroDeSerie.getText().trim();
            String ordenDeCompra = txtOrdenDeCompra.getText().trim();
            String mac = txtMac.getText().trim();
            String fecha = txtFecha.getText().trim();
            String estado = "";

            // Verificar cuál radio botón está seleccionado y asignar el estado correspondiente
            if (rdNuevo.isSelected()) {
                estado = "Nuevo";
            } else if (rdReacondicionado.isSelected()) {
                estado = "Reacondicionado";
            } else if (rdUsado.isSelected()) {
                estado = "Usado";
            } else {
                // Si ninguno está seleccionado, mostrar un mensaje de error
                mostrarError("Seleccione un estado para el equipo.");
                return;
            }

            String sistemaOperativo = txtSistemaOperativo.getText().trim();
            String procesador = txtProcesador.getText().trim();
            String ram = txtRam.getText().trim();
            String almacenamiento = txtAlmacenamiento.getText().trim();

            // Verificar que los campos obligatorios no estén vacíos
            if (tipo.isEmpty() || marca.isEmpty() || modelo.isEmpty() || numeroDeSerie.isEmpty() || ordenDeCompra.isEmpty() || mac.isEmpty() || fecha.isEmpty() || estado.isEmpty() || sistemaOperativo.isEmpty() || procesador.isEmpty() || ram.isEmpty() || almacenamiento.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear un objeto Equipo con los datos ingresados por el usuario
            Equipo equipo = new Equipo();
            equipo.setTipo(tipo);
            equipo.setMarca(marca);
            equipo.setModelo(modelo);
            equipo.setNumeroDeSerie(numeroDeSerie);
            equipo.setOrdenDeCompra(ordenDeCompra);
            equipo.setMac(mac);
            equipo.setFecha(fecha);
            equipo.setEstado(estado);

            // Asignar valores de ID, puede ser null
            equipo.setResponsableDeAreaId(idResponsable);
            equipo.setAsignadoId(idAsignado);

            // Establecer los valores adicionales
            equipo.setSistemaOperativo(sistemaOperativo);
            equipo.setRam(ram);
            equipo.setAlmacenamiento(almacenamiento);
            equipo.setUps(chkUps.isSelected());
            equipo.setProcesador(procesador);

            // Lógica para agregar el equipo utilizando el GestorEquipo
            GestorEquipo gestorEquipo = new GestorEquipo();
            boolean agregadoCorrectamente = gestorEquipo.agregarEquipo(equipo);

            if (agregadoCorrectamente) {
                mensaje("Equipo agregado correctamente");
                limpiarCampos(); // Limpiar los campos de texto relacionados con los equipos después de agregar
                // Actualizar la tabla de equipos
                actualizarTablaEquipos();
            } else {
                mensaje("Error al agregar el equipo");
            }
        } catch (SQLException e) {
            mostrarError("Error al agregar el equipo: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // Crear una instancia de VentanaPrincipal
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();

        // Hacer visible la ventana
        ventanaPrincipal.setVisible(true);

        // Cerrar la ventana actual si es necesario
        this.dispose(); // Esto cerrará la ventana actual, asegúrate de que sea el comportamiento deseado
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Deshabilitar interacción con la tabla
        tbEquipo.setEnabled(false);

        // Deshabilitar botón Editar
        btnEditar.setEnabled(false);

        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = tbEquipo.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un equipo para editar.");
            tbEquipo.setEnabled(true);
            btnEditar.setEnabled(true);
            return;
        }

        // Mostrar datos del equipo
        mostrarDatosEquipo(filaSeleccionada);

        // Habilitar campos de edición, botón Guardar y Limpiar
        txtTipo.setEnabled(true);
        txtMarca.setEnabled(true);
        txtModelo.setEnabled(true);
        txtNumeroDeSerie.setEnabled(true);
        txtOrdenDeCompra.setEnabled(true);
        txtMac.setEnabled(true);
        txtFecha.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnLimpiar.setEnabled(true);

        // Habilitar botón Agregar, Eliminar y Cancelar
        btnAgregar.setEnabled(false);
        btnEliminar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Obtener los nombres completos de los empleados de los campos de texto
        String nombreCompletoResponsable = txtResponsable.getText().trim();
        String nombreCompletoAsignado = txtAsignado.getText().trim();

        Integer idResponsable = null;
        Integer idAsignado = null;

        try {
            // Obtener los IDs de los empleados a partir de sus nombres completos
            GestorEmpleado gestorEmpleado = new GestorEmpleado();

            if (!nombreCompletoResponsable.isEmpty()) {
                idResponsable = gestorEmpleado.obtenerIdEmpleadoPorNombreCompleto(nombreCompletoResponsable);
                if (idResponsable == null) {
                    mostrarError("Debe haber un responsable de area.");
                    return;
                }
            }

            if (!nombreCompletoAsignado.isEmpty()) {
                idAsignado = gestorEmpleado.obtenerIdEmpleadoPorNombreCompleto(nombreCompletoAsignado);
                if (idAsignado == null) {
                    mostrarError("El empleado asignado no existe en la base de datos.");
                    return;
                }
            }

            // Obtener los valores de los campos de texto
            String tipo = txtTipo.getText();
            String marca = txtMarca.getText();
            String modelo = txtModelo.getText();
            String numeroDeSerie = txtNumeroDeSerie.getText();
            String ordenDeCompra = txtOrdenDeCompra.getText();
            String mac = txtMac.getText();
            String fecha = txtFecha.getText();
            String estado = "";

            // Verificar cuál radio botón está seleccionado y asignar el estado correspondiente
            if (rdNuevo.isSelected()) {
                estado = "Nuevo";
            } else if (rdReacondicionado.isSelected()) {
                estado = "Reacondicionado";
            } else if (rdUsado.isSelected()) {
                estado = "Usado";
            } else {
                // Si ninguno está seleccionado, mostrar un mensaje de error
                mostrarError("Seleccione un estado para el equipo.");
                return;
            }

            String sistemaOperativo = txtSistemaOperativo.getText();
            String procesador = txtProcesador.getText();
            String ram = txtRam.getText();
            String almacenamiento = txtAlmacenamiento.getText();

            // Verificar que los campos obligatorios no estén vacíos
            if (tipo.isEmpty() || marca.isEmpty() || modelo.isEmpty() || numeroDeSerie.isEmpty() || ordenDeCompra.isEmpty() || mac.isEmpty() || fecha.isEmpty() || estado.isEmpty() || sistemaOperativo.isEmpty() || procesador.isEmpty() || ram.isEmpty() || almacenamiento.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear un objeto Equipo con los datos ingresados por el usuario
            Equipo equipo = new Equipo();
            equipo.setTipo(tipo);
            equipo.setMarca(marca);
            equipo.setModelo(modelo);
            equipo.setNumeroDeSerie(numeroDeSerie);
            equipo.setOrdenDeCompra(ordenDeCompra);
            equipo.setMac(mac);
            equipo.setFecha(fecha);
            equipo.setEstado(estado);

            // Establecer los IDs de los empleados
            equipo.setResponsableDeAreaId(idResponsable);
            equipo.setAsignadoId(idAsignado);

            // Establecer los valores adicionales
            equipo.setSistemaOperativo(sistemaOperativo);
            equipo.setRam(ram);
            equipo.setAlmacenamiento(almacenamiento);
            equipo.setUps(chkUps.isSelected());
            equipo.setProcesador(procesador);

            // Lógica para actualizar el equipo utilizando el GestorEquipo
            GestorEquipo gestorEquipo = new GestorEquipo();

            // Obtener el ID del equipo por su número de serie
            int idEquipo = gestorEquipo.obtenerIdEquipoPorNumeroDeSerie(numeroDeSerie);

            if (idEquipo == 0) {
                mostrarError("El equipo seleccionado no existe en la base de datos.");
                return;
            }

            // Establecer el ID del equipo
            equipo.setId(idEquipo);

            boolean actualizadoCorrectamente = gestorEquipo.actualizarEquipo(equipo);

            if (actualizadoCorrectamente) {
                mensaje("Equipo actualizado correctamente");
                limpiarCampos(); // Limpiar los campos de texto relacionados con los equipos después de guardar
                actualizarTablaEquipos(); // Actualizar la tabla de equipos después de la edición
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnCancelar.setEnabled(false);
                btnEditar.setEnabled(true);
                btnAgregar.setEnabled(true);
                tbEquipo.setEnabled(true);
            } else {
                mensaje("Error al actualizar el equipo");
            }
        } catch (SQLException e) {
            mostrarError("Error al agregar el equipo: " + e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Limpiar campos
        limpiarCampos();

        // Habilitar campos de edición
        
        
        // Deshabilitar botón Guardar, Eliminar y Cancelar
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(false);

        // Habilitar botón Agregar, Editar y Limpiar
        btnAgregar.setEnabled(true);
        btnEditar.setEnabled(true);
        btnLimpiar.setEnabled(true);

        // Habilitar la interacción con la tabla
        tbEquipo.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = tbEquipo.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un equipo para eliminar.");
            return;
        }

        // Preguntar al usuario si realmente desea eliminar el equipo
        int opcion = JOptionPane.showConfirmDialog(this, "¿Desea eliminar este equipo?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.NO_OPTION) {
            return; // Si el usuario elige "No", no se elimina el equipo
        }

        String numeroDeSerie = tbEquipo.getValueAt(filaSeleccionada, 0).toString();

        try {
            // Lógica para eliminar el equipo utilizando el GestorEquipo
            GestorEquipo gestorEquipo = new GestorEquipo();
            if (gestorEquipo.eliminarEquipo(numeroDeSerie)) {
                mensaje("Equipo eliminado correctamente");
                DefaultTableModel model = (DefaultTableModel) tbEquipo.getModel();
                model.removeRow(filaSeleccionada);
                limpiarCampos(); // Función para limpiar los campos de texto relacionados con los equipos

                // Habilitar campos de edición y botón Agregar
                // Aquí habilitarías los campos y botones relacionados con la adición de nuevos equipos si están deshabilitados

                // Deshabilitar botón Guardar, Eliminar y Cancelar
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnCancelar.setEnabled(false);

                // Aquí deshabilitarías los botones Guardar, Eliminar y Cancelar relacionados con la edición de equipos si están habilitados
            } else {
                mensaje("Error al eliminar el equipo");
            }
        } catch (SQLException e) {
            mostrarError("Error al eliminar equipo: " + e.getMessage());
        }

        // Habilitar botón Agregar, Editar y Limpiar
        btnAgregar.setEnabled(true);
        btnEditar.setEnabled(true);
        btnLimpiar.setEnabled(true);

        // Habilitar la interacción con la tabla
        tbEquipo.setEnabled(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCargarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarEmpleadoActionPerformed
        // Obtener la fila seleccionada en la tabla de empleados
        int filaSeleccionada = tbEmpleado.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado para cargar sus detalles.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener el departamento del empleado seleccionado
        String departamento = tbEmpleado.getValueAt(filaSeleccionada, 0).toString();

        // Consultar la base de datos para obtener el nombre completo del responsable de área del departamento seleccionado
        String nombreResponsable = obtenerNombreResponsable(departamento);

        // Obtener el nombre completo del empleado seleccionado
        String nombreCompleto = tbEmpleado.getValueAt(filaSeleccionada, 2).toString();

        // Establecer el nombre del empleado en el campo txtAsignado
        txtAsignado.setText(nombreCompleto);

        // Establecer el departamento del empleado en el campo txtDepartamento
        txtDepartamento.setText(departamento);

        // Establecer el nombre del responsable en el campo txtResponsable
        txtResponsable.setText(nombreResponsable);
    }//GEN-LAST:event_btnCargarEmpleadoActionPerformed

    private void btnQuitarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarEmpleadoActionPerformed
        txtResponsable.setText("");
        txtAsignado.setText("");
        txtDepartamento.setText("");
    }//GEN-LAST:event_btnQuitarEmpleadoActionPerformed
    
    private String obtenerNombreResponsable(String departamento) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT E.nombre, E.apellido " +
                           "FROM Empleados E " +
                           "INNER JOIN Departamentos D ON E.id = D.responsable_de_area_id " +
                           "WHERE D.nombre = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, departamento);
            ResultSet resultado = statement.executeQuery();

            if (resultado.next()) {
                // Se encontró el responsable de área
                String nombreResponsable = resultado.getString("nombre");
                String apellidoResponsable = resultado.getString("apellido");
                String nombreCompleto = nombreResponsable + " " + apellidoResponsable;
                conexion.close();
                return nombreCompleto;
            } else {
                // No se encontró un responsable de área para el departamento especificado
                conexion.close();
                return "No Posee";
            }
        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
            return "No Posee";
        }
    }

    private int obtenerIdDepartamento(String nombreDepartamento) {
        PreparedStatement ps;
        ResultSet rs;
        int id = -1;
        try {
            Connection conexion = Conexion.getConexion();
            ps = conexion.prepareStatement("SELECT id FROM departamentos WHERE nombre = ?");
            ps.setString(1, nombreDepartamento);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return id;
    }
    
    private void actualizarTablaEquipos() {
        // Limpiar el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) tbEquipo.getModel();
        model.setRowCount(0); 

        // Volver a cargar los datos de la tabla desde la base de datos
        mostrarEquipos(null);
    }

    private void mostrarDatosEquipo(int filaSeleccionadaModelo) {
        int filaSeleccionada = tbEquipo.convertRowIndexToModel(filaSeleccionadaModelo);
        DefaultTableModel model = (DefaultTableModel) tbEquipo.getModel();

        // Obtener el número de serie del equipo seleccionado
        String numeroDeSerie = model.getValueAt(filaSeleccionada, 0).toString();

        // Realizar la consulta para obtener los detalles del equipo desde la base de datos
        try (Connection conexion = Conexion.getConexion()) {
            String query = "SELECT e.*, r.nombre AS nombre_responsable, r.apellido AS apellido_responsable, d.nombre AS nombre_departamento, a.nombre AS nombre_asignado, a.apellido AS apellido_asignado " +
                           "FROM Equipos e " +
                           "LEFT JOIN Empleados r ON e.responsable_de_area_id = r.id " +
                           "LEFT JOIN Empleados a ON e.asignado_id = a.id " +
                           "LEFT JOIN Departamentos d ON r.departamento_id = d.id " +
                           "WHERE e.numero_de_serie = ?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, numeroDeSerie);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // Obtener los datos del equipo desde la consulta
                        String tipo = rs.getString("tipo");
                        String marca = rs.getString("marca");
                        String modelo = rs.getString("modelo");
                        String ordenCompra = rs.getString("orden_de_compra");
                        String mac = rs.getString("mac");
                        String fecha = rs.getString("fecha");
                        String estado = rs.getString("estado");
                        String sistemaOperativo = rs.getString("sistema_operativo");
                        String ram = rs.getString("ram");
                        String almacenamiento = rs.getString("almacenamiento");
                        boolean ups = rs.getBoolean("ups");
                        String procesador = rs.getString("procesador");
                        String nombreResponsable = rs.getString("nombre_responsable");
                        String apellidoResponsable = rs.getString("apellido_responsable");
                        String nombreAsignado = rs.getString("nombre_asignado");
                        String apellidoAsignado = rs.getString("apellido_asignado");
                        String nombreDepartamento = rs.getString("nombre_departamento");

                        // Mostrar los datos del equipo en los campos correspondientes
                        txtTipo.setText(tipo);
                        txtMarca.setText(marca);
                        txtModelo.setText(modelo);
                        txtNumeroDeSerie.setText(numeroDeSerie);
                        txtOrdenDeCompra.setText(ordenCompra);
                        txtMac.setText(mac);
                        txtFecha.setText(fecha);
                        txtSistemaOperativo.setText(sistemaOperativo);
                        txtRam.setText(ram);
                        txtAlmacenamiento.setText(almacenamiento);
                        chkUps.setSelected(ups);
                        txtProcesador.setText(procesador);

                        // Establecer el estado del equipo utilizando el ButtonGroup btgEstado
                        switch (estado) {
                            case "Nuevo":
                                rdNuevo.setSelected(true);
                                break;
                            case "Reacondicionado":
                                rdReacondicionado.setSelected(true);
                                break;
                            case "Usado":
                                rdUsado.setSelected(true);
                                break;
                            default:
                                // Puedes manejar un caso por defecto si el estado no coincide con ninguno de los anteriores
                                break;
                        }

                        // Mostrar el nombre del responsable en el campo txtResponsable
                        if (nombreResponsable != null && apellidoResponsable != null) {
                            txtResponsable.setText(nombreResponsable + " " + apellidoResponsable);
                        } else {
                            txtResponsable.setText("");
                        }

                        // Mostrar el nombre del asignado en el campo txtAsignado
                        if (nombreAsignado != null && apellidoAsignado != null) {
                            txtAsignado.setText(nombreAsignado + " " + apellidoAsignado);
                        } else {
                            txtAsignado.setText("");
                        }

                        // Mostrar el nombre del departamento en el campo txtDepartamento
                        if (nombreDepartamento != null) {
                            txtDepartamento.setText(nombreDepartamento);
                        } else {
                            txtDepartamento.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No se encontraron datos para el equipo seleccionado.");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al mostrar datos del equipo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void mostrarEmpleados(String filtroEmpleado) {
        DefaultTableModel model = (DefaultTableModel) tbEmpleado.getModel();
        model.setRowCount(0);

        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT e.departamento_id, d.nombre AS departamento, e.run, e.nombre, e.apellido, r.nombre AS responsable_nombre, r.apellido AS responsable_apellido "
                         + "FROM empleados e "
                         + "INNER JOIN departamentos d ON e.departamento_id = d.id "
                         + "LEFT JOIN empleados r ON d.responsable_de_area_id = r.id ";

            if (filtroEmpleado != null && !filtroEmpleado.isEmpty()) {
                query += "WHERE e.run LIKE ? OR e.nombre LIKE ? OR e.apellido LIKE ?";
            }

            PreparedStatement ps = conexion.prepareStatement(query);

            if (filtroEmpleado != null && !filtroEmpleado.isEmpty()) {
                String filtroBusqueda = "%" + filtroEmpleado + "%";
                ps.setString(1, filtroBusqueda);
                ps.setString(2, filtroBusqueda);
                ps.setString(3, filtroBusqueda);
            }

            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return;
            }

            // Lista para almacenar los datos antes de agregarlos a la tabla
            List<Object[]> datos = new ArrayList<>();

            while (rs.next()) {
                String departamento = rs.getString("departamento");
                String run = rs.getString("run");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String nombreCompleto = nombre + " " + apellido; // Concatenar nombre y apellido
                String nombreResponsable = rs.getString("responsable_nombre");
                String apellidoResponsable = rs.getString("responsable_apellido");

                // Verificar si el responsable es null y asignar "No Posee" si es necesario
                String nombreCompletoResponsable = (nombreResponsable != null && apellidoResponsable != null) ? 
                    nombreResponsable + " " + apellidoResponsable : "No Posee";
                
                datos.add(new Object[]{departamento, run, nombreCompleto, nombreCompletoResponsable});
            }

            // Agregar los datos a la tabla
            for (Object[] fila : datos) {
                model.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    private void mostrarEquipos(String filtroEquipo) {
        DefaultTableModel model = (DefaultTableModel) tbEquipo.getModel();
        model.setRowCount(0);

        String query = "SELECT e.numero_de_serie, CONCAT(responsable.nombre, ' ', responsable.apellido) AS responsable, " +
                       "CONCAT(asignado.nombre, ' ', asignado.apellido) AS asignado, departamento.nombre AS departamento " +
                       "FROM Equipos AS e " +
                       "LEFT JOIN Empleados AS responsable ON e.responsable_de_area_id = responsable.id " +
                       "LEFT JOIN Empleados AS asignado ON e.asignado_id = asignado.id " +
                       "LEFT JOIN Departamentos AS departamento ON responsable.departamento_id = departamento.id";

        if (filtroEquipo != null && !filtroEquipo.isEmpty()) {
            query += " WHERE e.numero_de_serie LIKE ? OR CONCAT(responsable.nombre, ' ', responsable.apellido) LIKE ? " +
                     "OR CONCAT(asignado.nombre, ' ', asignado.apellido) LIKE ? OR departamento.nombre LIKE ?";
        }

        try (Connection conexion = Conexion.getConexion();
             PreparedStatement ps = conexion.prepareStatement(query)) {

            if (filtroEquipo != null && !filtroEquipo.isEmpty()) {
                String filtroBusqueda = "%" + filtroEquipo + "%";
                for (int i = 1; i <= 4; i++) {
                    ps.setString(i, filtroBusqueda);
                }
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String numeroDeSerie = rs.getString("numero_de_serie");
                    String responsable = rs.getString("responsable");
                    String asignado = rs.getString("asignado");
                    String departamento = rs.getString("departamento");
                    model.addRow(new Object[]{numeroDeSerie, responsable, asignado, departamento});
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al mostrar equipos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtTipo.setText("");
        txtFecha.setText("");
        txtMarca.setText("");
        txtOrdenDeCompra.setText("");
        txtModelo.setText("");
        txtNumeroDeSerie.setText("");
        txtMac.setText("");
        btgEstado.clearSelection();
        txtSistemaOperativo.setText("");
        txtRam.setText("");
        txtAlmacenamiento.setText("");
        txtProcesador.setText("");
        chkUps.setSelected(false); // Reiniciar el estado del checkbox UPS
        txtResponsable.setText("");
        txtAsignado.setText("");
        txtDepartamento.setText("");
    }
    
    private void mostrarError(String mensajeError) {
        JOptionPane.showMessageDialog(this, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void mensaje(String msg) {
        javax.swing.JOptionPane.showMessageDialog(this, msg);
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaEquipo().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelTitulo1;
    private javax.swing.JLabel JLabelTitulo2;
    private javax.swing.ButtonGroup btgEstado;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCargarEmpleado;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnQuitarEmpleado;
    private javax.swing.JButton btnVolver;
    private javax.swing.JCheckBox chkUps;
    private javax.swing.JLabel jLabelAlmacenamiento;
    private javax.swing.JLabel jLabelAsignado;
    private javax.swing.JLabel jLabelBuscarEmpleado;
    private javax.swing.JLabel jLabelBuscarEquipo;
    private javax.swing.JLabel jLabelDepartamento;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelMac;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelNumeroDeSerie;
    private javax.swing.JLabel jLabelOrdenDeCompra;
    private javax.swing.JLabel jLabelProcesador;
    private javax.swing.JLabel jLabelRam;
    private javax.swing.JLabel jLabelResponsable;
    private javax.swing.JLabel jLabelSistemaOperativo;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdNuevo;
    private javax.swing.JRadioButton rdReacondicionado;
    private javax.swing.JRadioButton rdUsado;
    private javax.swing.JTable tbEmpleado;
    private javax.swing.JTable tbEquipo;
    private javax.swing.JTextField txtAlmacenamiento;
    private javax.swing.JTextField txtAsignado;
    private javax.swing.JTextField txtBuscarEmpleado;
    private javax.swing.JTextField txtBuscarEquipo;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtMac;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNumeroDeSerie;
    private javax.swing.JTextField txtOrdenDeCompra;
    private javax.swing.JTextField txtProcesador;
    private javax.swing.JTextField txtRam;
    private javax.swing.JTextField txtResponsable;
    private javax.swing.JTextField txtSistemaOperativo;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables

}