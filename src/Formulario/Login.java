// Etiqueta a com.Login
package Formulario;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;


// Herencia de java Swing
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }

    Metodos_sql metodos = new Metodos_sql();
    
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        login = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        usuario = new javax.swing.JLabel();
        contraseña = new javax.swing.JLabel();
        llineaPassword = new javax.swing.JSeparator();
        lineaUsuario = new javax.swing.JSeparator();
        btnRegistrarse = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(350, 499));
        setMinimumSize(new java.awt.Dimension(350, 499));

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setForeground(new java.awt.Color(153, 153, 153));
        fondo.setAutoscrolls(true);
        fondo.setEnabled(false);
        fondo.setFont(new java.awt.Font("Roboto Medium", 3, 12)); // NOI18N
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login.setFont(new java.awt.Font("Roboto Black", 3, 36)); // NOI18N
        login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        login.setText("LOGIN");
        fondo.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 350, 40));

        txtUsuario.setFont(new java.awt.Font("Roboto Medium", 2, 12)); // NOI18N
        txtUsuario.setToolTipText("");
        txtUsuario.setActionCommand("<Not Set>");
        txtUsuario.setBorder(null);
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        fondo.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 190, 20));

        txtContraseña.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        txtContraseña.setBorder(null);
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        fondo.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 190, 10));

        usuario.setFont(new java.awt.Font("Roboto Medium", 3, 12)); // NOI18N
        usuario.setForeground(new java.awt.Color(153, 153, 153));
        usuario.setText("Nombre de Usuario");
        fondo.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 140, 20));

        contraseña.setFont(new java.awt.Font("Roboto Medium", 3, 12)); // NOI18N
        contraseña.setForeground(new java.awt.Color(153, 153, 153));
        contraseña.setText("Contraseña");
        fondo.add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 90, 20));
        fondo.add(llineaPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 200, 20));
        fondo.add(lineaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 200, 20));

        btnRegistrarse.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarse.setFont(new java.awt.Font("Roboto Black", 3, 12)); // NOI18N
        btnRegistrarse.setForeground(new java.awt.Color(153, 153, 153));
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.setBorder(null);
        btnRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarse.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnRegistrarse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        fondo.add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 120, 30));

        btnIniciar.setBackground(new java.awt.Color(155, 96, 227));
        btnIniciar.setFont(new java.awt.Font("Roboto Black", 3, 18)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("Iniciar sesión");
        btnIniciar.setBorder(null);
        btnIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        fondo.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 190, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
         
        txtContraseña.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                btnIniciarActionPerformed(evt); //Método que tienes que crearte
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    });
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        Registro ventana = new Registro();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed

        if (txtUsuario.getText().isEmpty() | txtContraseña.getText().isEmpty()) {
            
        
            contraseña.setForeground(new java.awt.Color(0, 0, 0));
            usuario.setForeground(new java.awt.Color(0, 0, 0));
            
            txtContraseña.setForeground(new java.awt.Color(255, 51, 51));
            txtUsuario.setForeground(new java.awt.Color(255, 51, 51));

            JOptionPane.showMessageDialog(null, "Debe ingresar su usuario y contraseña, si no está registrado debe registrarse");

            txtContraseña.setForeground(new java.awt.Color(0, 0, 0));
            txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
            
            contraseña.setForeground(new java.awt.Color(153,153,153));
            usuario.setForeground(new java.awt.Color(153,153,153));

        } else {

            String busqueda_usuario = Metodos_sql.buscarUsuarioRegistrado(txtUsuario.getText(), txtContraseña.getText());

            if (txtUsuario.getText().equals("admin") && txtContraseña.getText().equals("admin")) {
                JOptionPane.showMessageDialog(this, "Bienvenido, has iniciado sesión como administrador");

                PantallaPrincipal ventana = new PantallaPrincipal();
                ventana.lbNombre.setText("Administrador");
                ventana.setVisible(true);
                this.dispose();
            } else if (busqueda_usuario.equals("Se ha iniciado sesión correctamente")) {
                String busqueda_nombre = Metodos_sql.buscarNombre(txtUsuario.getText());
                JOptionPane.showMessageDialog(this, "Bienvenido (a) \n" + busqueda_nombre);

                PantallaPrincipal ventana = new PantallaPrincipal();
                ventana.lbNombre.setText(busqueda_nombre);
                ventana.setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Este usuario no se encuentra registrado, por favor registrese");
                txtUsuario.setText(""); //Vacia el JTextField
                txtContraseña.setText("");
                txtUsuario.requestFocus();
            }
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    /**
         * @param args the command line arguments
         */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JLabel contraseña;
    private javax.swing.JPanel fondo;
    private javax.swing.JSeparator lineaUsuario;
    private javax.swing.JSeparator llineaPassword;
    private javax.swing.JLabel login;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
