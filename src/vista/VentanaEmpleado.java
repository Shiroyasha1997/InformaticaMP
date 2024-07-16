package vista;

import bd.Conexion;
import modelo.*;
import controlador.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

public class VentanaEmpleado extends javax.swing.JFrame {
    
    private final TableRowSorter<DefaultTableModel> sorter;
    
    public VentanaEmpleado() {
        initComponents();
        this.setLocationRelativeTo(null);
        // Maximizar la ventana al iniciar el programa
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        
        limpiarCampos();
        mostrarDepartamento();
        mostrarEmpleados(null);
        actualizarTablaEmpleados();
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(false);

        // Añadir ActionListener al checkbox responsable de área
        chkResponsable.addActionListener((ActionEvent e) -> {
            // Verificar si el checkbox está marcado
            if (chkResponsable.isSelected()) {
                String departamento = (String) cmbDepartamento.getSelectedItem();
                int departamentoId = obtenerIdDepartamento(departamento);
                int filaSeleccionada = tbEmpleado.getSelectedRow();
                
                // Verificar si hay una fila seleccionada
                if (filaSeleccionada != -1) {
                    // Verificar si el empleado actualmente seleccionado es responsable de área
                    boolean esResponsableActual = (boolean) tbEmpleado.getValueAt(filaSeleccionada, 4);
                    if (esResponsableActual) {
                        // Si el empleado actualmente seleccionado es responsable de área y el checkbox está marcado, salir del ActionListener
                        return;
                    }
                }
                
                // Verificar si el departamento ya tiene un responsable de área
                if (departamentoTieneResponsable(departamentoId)) {
                    JOptionPane.showMessageDialog(VentanaEmpleado.this, "El departamento ya tiene un responsable de área.");
                    chkResponsable.setSelected(false); // Desmarcar el checkbox
                }
            }
        });

        // Establecer el filtro para la búsqueda de empleados
        txtBuscar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrar();
            }

            private void filtrar() {
                String filtro = txtBuscar.getText().trim();
                mostrarEmpleados(filtro);
            }
        });

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

        JLabelTitulo1 = new javax.swing.JLabel();
        JLabelTitulo2 = new javax.swing.JLabel();
        JLabelRun = new javax.swing.JLabel();
        JLabelNombre = new javax.swing.JLabel();
        JLabelApellido = new javax.swing.JLabel();
        JLabelDepartamento = new javax.swing.JLabel();
        jLabelBuscar = new javax.swing.JLabel();
        txtRun = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        chkResponsable = new javax.swing.JCheckBox();
        cmbDepartamento = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmpleado = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
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
        getContentPane().add(JLabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 210, 40));

        JLabelTitulo2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JLabelTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelTitulo2.setText("GESTOR DE EMPLEADOS");
        JLabelTitulo2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(JLabelTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, 40));
        JLabelTitulo2.getAccessibleContext().setAccessibleDescription("");

        JLabelRun.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JLabelRun.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabelRun.setText("RUN");
        getContentPane().add(JLabelRun, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 130, 30));

        JLabelNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JLabelNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabelNombre.setText("NOMBRE");
        getContentPane().add(JLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 130, 30));

        JLabelApellido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JLabelApellido.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabelApellido.setText("APELLIDO");
        getContentPane().add(JLabelApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 130, 30));

        JLabelDepartamento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JLabelDepartamento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabelDepartamento.setText("DEPARTAMENTO");
        getContentPane().add(JLabelDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 130, 30));

        jLabelBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelBuscar.setText("BUSCAR");
        getContentPane().add(jLabelBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 60, 30));

        txtRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRunActionPerformed(evt);
            }
        });
        getContentPane().add(txtRun, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 430, 30));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 430, 30));
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 430, 30));
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 1200, 30));

        chkResponsable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chkResponsable.setText("Responsable de Area");
        getContentPane().add(chkResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, -1, -1));

        cmbDepartamento.setMaximumRowCount(35);
        getContentPane().add(cmbDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 430, 30));

        tbEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Departamento", "RUN", "Nombre", "Apellido", "Responsable de Area"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbEmpleado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 1270, 580));

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 680, 130, 30));

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 720, 130, 30));

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 840, 180, 30));

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 840, 180, 30));

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 840, 180, 30));

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 840, 180, 30));

        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVolver.setText("Volver al Menu Principal");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 30, 230, 40));

        getAccessibleContext().setAccessibleName("INFORMATICA MP");
    }// </editor-fold>//GEN-END:initComponents
 
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada = tbEmpleado.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado para eliminar.");
            return;
        }

        String run = tbEmpleado.getValueAt(filaSeleccionada, 1).toString();
        String nombre = tbEmpleado.getValueAt(filaSeleccionada, 2).toString();
        String apellido = tbEmpleado.getValueAt(filaSeleccionada, 3).toString();
        String departamento = tbEmpleado.getValueAt(filaSeleccionada, 0).toString();
        int departamentoId = obtenerIdDepartamento(departamento);
        boolean responsableDeArea = (boolean) tbEmpleado.getValueAt(filaSeleccionada, 4);

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar al empleado seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            GestorEmpleado gestorEmpleado = new GestorEmpleado();
            if (gestorEmpleado.eliminarEmpleado(run)) {
                mensaje("Empleado eliminado correctamente");

                DefaultTableModel model = (DefaultTableModel) tbEmpleado.getModel();
                model.removeRow(filaSeleccionada);

                // Actualizar el responsable de área en el departamento si es necesario
                if (responsableDeArea) {
                    actualizarResponsableDeAreaDepartamento(departamentoId, null); // Pasar null si el empleado eliminado es responsable
                }
            } else {
                mensaje("Error al eliminar el empleado");
            }
        } catch (SQLException e) {
            // Verificar si la excepción es debido a restricción de clave externa (foreign key)
            if (e.getSQLState().equals("23000") && e.getErrorCode() == 1451) {
                mostrarError("No se puede eliminar el empleado porque tiene equipos asignados.");
            } else {
                mostrarError("Error al eliminar empleado: " + e.getMessage());
            }
        }

        limpiarCampos();
        actualizarTablaEmpleados();
        btnAgregar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEditar.setEnabled(true);
        tbEmpleado.setEnabled(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        habilitarCamposEdicion(true);

        // Deshabilitar botones
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(false);

        // Habilitar botones
        btnAgregar.setEnabled(true);
        btnEditar.setEnabled(true);
        btnLimpiar.setEnabled(true);

        // Habilitar interacción con la tabla
        tbEmpleado.setEnabled(true);

        // Actualizar la tabla de empleados
        limpiarCampos();
        actualizarTablaEmpleados();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String runNuevo = txtRun.getText().trim();
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String departamento = (String) cmbDepartamento.getSelectedItem();
        int filaSeleccionada = tbEmpleado.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado para editar.");
            return;
        }

        if (runNuevo.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            return;
        }

        String runAntiguo = tbEmpleado.getValueAt(filaSeleccionada, 1).toString();
        int departamentoId = obtenerIdDepartamento(departamento);
        boolean empleadoEsResponsable = (boolean) tbEmpleado.getValueAt(filaSeleccionada, 4);
        boolean responsableDeArea = chkResponsable.isSelected();

        // Verificar si el empleado que se está editando es responsable de área
        // y si está cambiando su estado a no ser responsable
        if (empleadoEsResponsable && !chkResponsable.isSelected()) {
            // Permitir que se actualice el empleado sin mostrar el mensaje de que el departamento ya tiene un responsable de área
        } else if (empleadoEsResponsable && departamentoTieneResponsable(departamentoId) && !chkResponsable.isSelected()) {
            JOptionPane.showMessageDialog(this, "El empleado seleccionado es el responsable de área del departamento actual. Desmarque la opción 'Responsable de Área' si desea cambiarlo.");
            return;
        }

        // Si el empleado que se está editando no es responsable de área
        // y el departamento ya tiene un responsable de área
        if (!empleadoEsResponsable && departamentoTieneResponsable(departamentoId) && chkResponsable.isSelected()) {
            JOptionPane.showMessageDialog(this, "El departamento seleccionado ya tiene un responsable de área.");
            return;
        }

        try {

            GestorEmpleado gestorEmpleado = new GestorEmpleado();
            if (gestorEmpleado.actualizarEmpleado(runAntiguo, runNuevo, nombre, apellido, departamentoId, responsableDeArea)) {
                mensaje("Datos del empleado actualizados correctamente");

                DefaultTableModel model = (DefaultTableModel) tbEmpleado.getModel();
                model.setValueAt(departamento, filaSeleccionada, 0);
                model.setValueAt(runNuevo, filaSeleccionada, 1);
                model.setValueAt(nombre, filaSeleccionada, 2);
                model.setValueAt(apellido, filaSeleccionada, 3);

                // Obtener el ID del empleado actualizado
                int idEmpleado = gestorEmpleado.obtenerIdEmpleado(runNuevo);

                // Actualizar el responsable de área en el departamento si es necesario
                if (responsableDeArea) {
                    actualizarResponsableDeAreaDepartamento(departamentoId, idEmpleado);
                } else {
                    actualizarResponsableDeAreaDepartamento(departamentoId, null); // Pasar null si el empleado no es responsable
                }

                limpiarCampos();
                btnAgregar.setEnabled(true);
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnCancelar.setEnabled(false);
                btnEditar.setEnabled(true);
                tbEmpleado.setEnabled(true);
            } else {
                mensaje("Error al actualizar los datos del empleado");
            }
        } catch (SQLException e) {
            mostrarError("Error al guardar cambios: " + e.getMessage());
        }

        limpiarCampos();
        actualizarTablaEmpleados();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Deshabilitar interacción con la tabla
        tbEmpleado.setEnabled(false);

        // Deshabilitar botón Editar
        btnEditar.setEnabled(false);

        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = tbEmpleado.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado para editar.");
            tbEmpleado.setEnabled(true);
            btnEditar.setEnabled(true);
            return;
        }

        // Obtener el RUN del empleado seleccionado
        String run = tbEmpleado.getValueAt(filaSeleccionada, 1).toString(); // Asumiendo que el RUN está en la primera columna

        // Verificar si el empleado tiene equipos asignados
        GestorEmpleado gestor = new GestorEmpleado();
        try {
            if (gestor.empleadoTieneEquiposAsignados(run)) {
                JOptionPane.showMessageDialog(this, "El empleado no se puede editar porque tiene equipos asignados o es responsable de área.");
                tbEmpleado.setEnabled(true);
                btnEditar.setEnabled(true);
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al verificar equipos asignados: " + e.getMessage());
            tbEmpleado.setEnabled(true);
            btnEditar.setEnabled(true);
            return;
        }

        // Mostrar datos del empleado
        mostrarDatosEmpleado(filaSeleccionada);

        // Habilitar botón Guardar y Cancelar, deshabilitar Agregar y Eliminar
        btnAgregar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // Obtener los valores de los campos de texto
        String run = this.txtRun.getText().trim();
        String nombre = this.txtNombre.getText().trim();
        String apellido = this.txtApellido.getText().trim();

        if (run.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            return;
        }

        try {
            if (new GestorEmpleado().validarRun(run)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ya existe un registro con el RUN " + run);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentanaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        int departamentoId = obtenerIdDepartamentoSeleccionado();
        if (departamentoId == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un departamento válido.");
            return;
        }

        boolean responsableDeArea = chkResponsable.isSelected();

        Empleado emp = new Empleado();
        emp.setRun(run);
        emp.setNombre(nombre);
        emp.setApellido(apellido);
        emp.setDepartamentoId(departamentoId);
        emp.setResponsableDeArea(responsableDeArea);

        try {
            GestorEmpleado gestorEmpleado = new GestorEmpleado();
            if (gestorEmpleado.agregarEmpleado(emp)) {
                mensaje("Los datos se han agregado correctamente!!!");

                // Obtener el ID del empleado recién agregado
                int empleadoId = gestorEmpleado.obtenerIdUltimoEmpleado();

                // Actualizar responsable de área en el departamento si es necesario
                if (responsableDeArea) {
                    actualizarResponsableDeAreaDepartamento(departamentoId, empleadoId);
                }
                mostrarEmpleados(null);
            } else {
                mensaje("Hubo un error al agregar los datos!!!");
            }
        } catch (SQLException e) {
            mostrarError("Error al agregar empleado: " + e.getMessage());
        }
        
        limpiarCampos();
        actualizarTablaEmpleados();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // Crear una instancia de VentanaPrincipal
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();

        // Hacer visible la ventana
        ventanaPrincipal.setVisible(true);

        // Cerrar la ventana actual si es necesario
        this.dispose(); // Esto cerrará la ventana actual, asegúrate de que sea el comportamiento deseado
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRunActionPerformed
   
    private int obtenerIdDepartamentoSeleccionado() {
        String nombreDepartamento = cmbDepartamento.getSelectedItem().toString();
        return obtenerIdDepartamento(nombreDepartamento);
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

    private boolean departamentoTieneResponsable(int departamentoId) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT COUNT(*) AS count FROM empleados WHERE departamento_id = ? AND responsable_de_area = true";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, departamentoId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar si el departamento tiene un responsable de área: " + e.toString());
            return false;
        }
    }
    
    private void actualizarResponsableDeAreaDepartamento(int departamentoId, Integer empleadoId) {
        try {
            GestorDepartamento gestorDepartamento = new GestorDepartamento();
            Departamento departamento = gestorDepartamento.obtenerDepartamentoPorId(departamentoId);

            if (departamento == null) {
                mensaje("El departamento con ID " + departamentoId + " no existe.");
                return;
            }

            boolean actualizacionExitosa;
            if (empleadoId != null) {
                actualizacionExitosa = gestorDepartamento.actualizarDepartamentoResponsable(departamentoId, empleadoId);
            } else {
                // Si el empleadoId es null, establecer el responsable de área como null en la base de datos
                actualizacionExitosa = gestorDepartamento.actualizarDepartamentoResponsable(departamentoId, null);
            }

            if (actualizacionExitosa) {
                mensaje("Responsable de área actualizado en el departamento correctamente.");
            } else {
                mensaje("No se pudo actualizar el responsable de área en el departamento.");
            }
        } catch (SQLException e) {
            mostrarError("Error al actualizar responsable de área en Departamentos: " + e.getMessage());
        }
    }
    
    private void actualizarTablaEmpleados() {
        // Limpiar el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) tbEmpleado.getModel();
        model.setRowCount(0); 

        // Volver a cargar los datos de la tabla desde la base de datos
        mostrarEmpleados(null);
    }

    private void mostrarDatosEmpleado(int filaSeleccionadaModelo) {
        // Convertir la fila seleccionada en el modelo de la tabla al índice correspondiente en el modelo de la tabla no ordenada
        int filaSeleccionada = tbEmpleado.convertRowIndexToModel(filaSeleccionadaModelo);

        DefaultTableModel model = (DefaultTableModel) tbEmpleado.getModel();

        txtNombre.setEnabled(true);
        txtApellido.setEnabled(true);
        cmbDepartamento.setEnabled(true);
        chkResponsable.setEnabled(true);
        btnAgregar.setEnabled(true);

        txtRun.setText(model.getValueAt(filaSeleccionada, 1).toString());
        txtNombre.setText(model.getValueAt(filaSeleccionada, 2).toString());
        txtApellido.setText(model.getValueAt(filaSeleccionada, 3).toString());
        String departamento = model.getValueAt(filaSeleccionada, 0).toString();
        cmbDepartamento.setSelectedItem(departamento);
        chkResponsable.setSelected((boolean) model.getValueAt(filaSeleccionada, 4));
    }
    
    private void mostrarDepartamento() {
        PreparedStatement ps;
        ResultSet rs;
        try {
            Connection conexion = Conexion.getConexion();
            ps = conexion.prepareStatement("SELECT * FROM departamentos");
            rs = ps.executeQuery();
            while (rs.next()) {
                cmbDepartamento.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    private void mostrarEmpleados(String filtro) {
        DefaultTableModel model = (DefaultTableModel) tbEmpleado.getModel();
        model.setRowCount(0); 

        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT d.nombre AS departamento, e.run, e.nombre, e.apellido, e.responsable_de_area "
                         + "FROM empleados e "
                         + "INNER JOIN departamentos d ON e.departamento_id = d.id ";

            if (filtro != null && !filtro.isEmpty()) {
                query += "WHERE e.run LIKE ? OR e.nombre LIKE ? OR e.apellido LIKE ?";
            }

            PreparedStatement ps = conexion.prepareStatement(query);

            if (filtro != null && !filtro.isEmpty()) {
                String filtroBusqueda = "%" + filtro + "%";
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
                boolean responsableDeArea = rs.getBoolean("responsable_de_area");
                datos.add(new Object[]{departamento, run, nombre, apellido, responsableDeArea});
            }

            // Ordenar la lista de datos por departamento antes de agregarla a la tabla
            Collections.sort(datos, (Object[] o1, Object[] o2) -> {
                String departamento1 = (String) o1[0];
                String departamento2 = (String) o2[0];
                return departamento1.compareTo(departamento2);
            });

            // Agregar los datos ordenados a la tabla
            for (Object[] fila : datos) {
                model.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    private void habilitarCamposEdicion(boolean estado) {
        txtRun.setEnabled(estado);
        txtNombre.setEnabled(estado);
        txtApellido.setEnabled(estado);
        cmbDepartamento.setEnabled(estado);
        chkResponsable.setEnabled(estado);
    }
    
    private void limpiarCampos() {
        txtRun.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        chkResponsable.setSelected(false);
    }
    
    private void mostrarError(String mensajeError) {
        JOptionPane.showMessageDialog(this, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void mensaje(String msg) {
        javax.swing.JOptionPane.showMessageDialog(this, msg);
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaEmpleado().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelApellido;
    private javax.swing.JLabel JLabelDepartamento;
    private javax.swing.JLabel JLabelNombre;
    private javax.swing.JLabel JLabelRun;
    private javax.swing.JLabel JLabelTitulo1;
    private javax.swing.JLabel JLabelTitulo2;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JCheckBox chkResponsable;
    private javax.swing.JComboBox<String> cmbDepartamento;
    private javax.swing.JLabel jLabelBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbEmpleado;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRun;
    // End of variables declaration//GEN-END:variables

}