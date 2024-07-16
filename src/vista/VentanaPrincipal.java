package vista;


public class VentanaPrincipal extends javax.swing.JFrame {

    public VentanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        // Maximizar la ventana al iniciar el programa
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLabelTitulo1 = new javax.swing.JLabel();
        btnEmpleado = new javax.swing.JButton();
        btnEquipo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INFORMATICA MP");
        setAlwaysOnTop(true);
        setIconImages(null);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1680, 1050));
        setName("frame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);
        setSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JLabelTitulo1.setFont(new java.awt.Font("HP Simplified", 1, 36)); // NOI18N
        JLabelTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelTitulo1.setText("INFORMATICA MP");
        JLabelTitulo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(JLabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 340, 90));

        btnEmpleado.setFont(new java.awt.Font("HP Simplified", 1, 24)); // NOI18N
        btnEmpleado.setText("GESTOR EMPLEADOS");
        btnEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 530, 320, 70));

        btnEquipo.setFont(new java.awt.Font("HP Simplified", 1, 24)); // NOI18N
        btnEquipo.setText("GESTOR EQUIPOS");
        btnEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 420, 320, 70));
    }// </editor-fold>//GEN-END:initComponents
 
    private void btnEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipoActionPerformed
        // Crear una instancia de VentanaEquipo
        VentanaEquipo ventanaEquipo = new VentanaEquipo();

        // Hacer visible la ventana
        ventanaEquipo.setVisible(true);

        // Cerrar la ventana actual si es necesario
        this.dispose(); // Esto cerrará la ventana actual, asegúrate de que sea el comportamiento deseado
    }//GEN-LAST:event_btnEquipoActionPerformed

    private void btnEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadoActionPerformed
        // Crear una instancia de VentanaEquipo
        VentanaEmpleado ventanaEmpleado = new VentanaEmpleado();

        // Hacer visible la ventana
        ventanaEmpleado.setVisible(true);

        // Cerrar la ventana actual si es necesario
        this.dispose(); // Esto cerrará la ventana actual, asegúrate de que sea el comportamiento deseado
    }//GEN-LAST:event_btnEmpleadoActionPerformed
   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelTitulo1;
    private javax.swing.JButton btnEmpleado;
    private javax.swing.JButton btnEquipo;
    // End of variables declaration//GEN-END:variables

}