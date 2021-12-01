package Formulario;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PantallaPrincipal extends javax.swing.JFrame {

    //public static Conexion conexion = new Conexion();
    //Conexion conexion = new Conexion();
    //Connection conectar = conexion.conectar();
    
    Connection conectar = Conexion.getConnection();

    public PantallaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        tablaRegistros.setModel(mostrarRegistro());
    }

    public DefaultTableModel mostrarRegistro() {
        DefaultTableModel tusuario = new DefaultTableModel();
        tusuario.addColumn("NOMBRE");
        tusuario.addColumn("APELLIDO");
        tusuario.addColumn("TELEFONO");
        tusuario.addColumn("CORREO");
        //tablaRegistros.setModel(tusuario);

        String[] datos = new String[4];

        try {
            Statement leer = conectar.createStatement();
            ResultSet resultado = leer.executeQuery("SELECT NOMBRE, APELLIDOS, TELEFONO, CORREO FROM USUARIOS");

            while (resultado.next()) {
                datos[0] = resultado.getString("NOMBRE");
                datos[1] = resultado.getString("APELLIDOS");
                datos[2] = resultado.getString("TELEFONO");
                datos[3] = resultado.getString("CORREO");
                tusuario.addRow(datos);
            }
            //tablaRegistros.setModel(tusuario);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return tusuario;

    }
    
    public void actualizar() {
        
        int fila = tablaRegistros.getSelectedRow();
        
        String nombre = (this.tablaRegistros.getValueAt(fila, 0).toString());
        String apellido = tablaRegistros.getValueAt(fila, 1).toString();
        String telefono = tablaRegistros.getValueAt(fila, 2).toString();
        String correo = tablaRegistros.getValueAt(fila, 3).toString();
        
        try {
            PreparedStatement actualizar = conectar.prepareStatement("UPDATE USUARIOS SET NOMBRE = '"+nombre+"', APELLIDOS = '"+apellido+"', TELEFONO = '"+telefono+"', CORREO = '"+correo+"' WHERE CORREO = '"+correo+"'" );
            actualizar.executeUpdate();
            JOptionPane.showMessageDialog(this, "Datos actualizados correctamente");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se logró actualizar la información, purebe con otros datos. " + e);
        }
    }
    
    public void eliminar(){
        
        int fila = tablaRegistros.getSelectedRow();
        
        String correo = tablaRegistros.getValueAt(fila, 3).toString();
        
        try {
            PreparedStatement eliminar = conectar.prepareStatement("DELETE FROM USUARIOS WHERE CORREO = '"+correo+"'");
            eliminar.executeUpdate();
            JOptionPane.showMessageDialog(this, "Cliente eliminado satisfactoriamente");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se logró eliminar el cliente. " + e);
        }
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clientesRegistrados = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRegistros = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        clientesRegistrados.setBackground(new java.awt.Color(255, 238, 247));
        clientesRegistrados.setFocusCycleRoot(true);
        clientesRegistrados.setMaximumSize(new java.awt.Dimension(720, 480));
        clientesRegistrados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Black", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Clientes Registrados");
        jLabel1.setAutoscrolls(true);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clientesRegistrados.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 280, 40));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 3, 14)); // NOI18N
        jLabel2.setText("Inicio de sesión como: ");
        clientesRegistrados.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 160, 30));

        lbNombre.setBackground(new java.awt.Color(255, 255, 255));
        lbNombre.setFont(new java.awt.Font("Roboto Black", 3, 14)); // NOI18N
        lbNombre.setForeground(new java.awt.Color(102, 102, 102));
        lbNombre.setToolTipText("");
        clientesRegistrados.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 350, 30));

        tablaRegistros.setAutoCreateRowSorter(true);
        tablaRegistros.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        tablaRegistros.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NOMBRE", "APELLIDO", "TELÉFONO", "CORREO ELECTRÓNICO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaRegistros.setToolTipText("");
        jScrollPane1.setViewportView(tablaRegistros);

        clientesRegistrados.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 520, 220));

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Roboto Black", 3, 14)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon("D:\\Downloads\\iloveimg-resized\\actualizar-base-de-datos.png")); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setBorder(null);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        clientesRegistrados.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 160, 50));

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Roboto Black", 3, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon("D:\\Downloads\\iloveimg-resized (1)\\basura.png")); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        clientesRegistrados.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 160, 50));

        btnAtras.setBackground(new java.awt.Color(255, 238, 247));
        btnAtras.setFont(new java.awt.Font("Roboto Black", 3, 36)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(153, 153, 153));
        btnAtras.setIcon(new javax.swing.ImageIcon("C:\\Users\\Frainer Alexander\\Dropbox\\PC\\Documents\\NetBeansProjects\\INTERFAZ\\src\\Imagenes\\hacia-atras.png")); // NOI18N
        btnAtras.setBorder(null);
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        clientesRegistrados.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 90, -1));

        btnCerrarSesion.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setFont(new java.awt.Font("Roboto Black", 3, 14)); // NOI18N
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon("D:\\Downloads\\iloveimg-resized\\usuario.png")); // NOI18N
        btnCerrarSesion.setText("CERRA SESIÓN");
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        clientesRegistrados.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 150, 50));

        btnRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setFont(new java.awt.Font("Roboto Black", 3, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon("D:\\Downloads\\registros (1).png")); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setBorder(null);
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        clientesRegistrados.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 150, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clientesRegistrados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clientesRegistrados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
     eliminar();
     tablaRegistros.setModel(mostrarRegistro());
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        Login ventana = new Login();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        Registro ventana = new Registro();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        Login ventana = new Login();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizar();
        tablaRegistros.setModel(mostrarRegistro());
    }//GEN-LAST:event_btnActualizarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JPanel clientesRegistrados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lbNombre;
    private javax.swing.JTable tablaRegistros;
    // End of variables declaration//GEN-END:variables
}
