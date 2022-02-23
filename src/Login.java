import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Login extends JFrame {

    public Login() {

        /******************* Interface features *********************/

        setBounds(600, 120, 350, 520);
        setMinimumSize(new java.awt.Dimension(350, 521));
        setMaximumSize(new java.awt.Dimension(350, 521));
        setPreferredSize(new java.awt.Dimension(350, 521));
        setVisible(true);
        back = new JPanel();
        back.setBackground(Color.WHITE);
        setContentPane(back);
        back.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        back.setAutoscrolls(true);
        back.setEnabled(false);

        login = new JLabel("LOGIN");
        login.setFont(new java.awt.Font("Roboto Black", 3, 36));
        login.setBounds(110, 10, 200, 70);
        back.add(login);

        user = new JLabel("User Name");
        user.setBounds(60, 140, 140, 20);
        user.setFont(new java.awt.Font("Roboto Medium", 3, 12));
        user.setForeground(Color.GRAY);
        back.add(user);

        password = new JLabel("Password");
        password.setBounds(60, 260, 90, 20);
        password.setForeground(Color.GRAY);
        password.setFont(new java.awt.Font("Roboto Medium", 3, 12));
        back.add(password);

        txtUser = new JTextField();
        txtUser.setFont(new java.awt.Font("Roboto Medium", 2, 12));
        txtUser.setBounds(60, 170, 190, 20);
        txtUser.setBorder(null);
        back.add(txtUser);


        txtPassword = new JPasswordField();
        txtPassword.setBounds(60, 295, 190, 10);
        txtPassword.setBorder(null);
        back.add(txtPassword);
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        lineUser = new JSeparator();
        lineUser.setBounds(50, 190, 200, 20);
        lineUser.setForeground(Color.GRAY);
        back.add(lineUser);

        linePassword = new JSeparator();
        linePassword.setBounds(50, 310, 200, 20);
        linePassword.setForeground(Color.GRAY);
        back.add(linePassword);

        btnLogin = new JButton("LOGIN");
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setBackground(new java.awt.Color(155, 96, 227));
        btnLogin.setFont(new java.awt.Font("Roboto Black", 3, 18));
        btnLogin.setBorder(null);
        btnLogin.setBounds(70, 360, 190, 35);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        back.add(btnLogin);

        btnRegister = new JButton("REGISTER");
        btnRegister.setForeground(Color.BLACK);
        btnRegister.setBackground(Color.WHITE);
        btnRegister.setFont(new java.awt.Font("Roboto Black", 3, 12));
        btnRegister.setBounds(110, 445, 120, 30);
        btnRegister.setBorder(null);
        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegister.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);

            }
        });
        back.add(btnRegister);

    }

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {

        txtPassword.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnLoginActionPerformed(evt);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });

    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        
        if (txtUser.getText().isEmpty() | txtPassword.getText().isEmpty()) {

            password.setForeground(new java.awt.Color(0, 0, 0));
            user.setForeground(new java.awt.Color(0, 0, 0));

            linePassword.setForeground(new java.awt.Color(255, 51, 51));
            lineUser.setForeground(new java.awt.Color(255, 51, 51));

            JOptionPane.showMessageDialog(null, "You must enter your username and password, otherwise consider registering");

            linePassword.setForeground(new java.awt.Color(0, 0, 0));
            lineUser.setForeground(new java.awt.Color(0, 0, 0));

            password.setForeground(new java.awt.Color(153, 153, 153));
            user.setForeground(new java.awt.Color(153, 153, 153));

        } else {

           String searchUser = MethodsSQL.searchRegisteredUser(txtUser.getText(), txtPassword.getText());

            if (txtUser.getText().equals("admin") && txtPassword.getText().equals("admin")) {

                JOptionPane.showMessageDialog(null, "Welcome, you are logged in as administrator");

                Dashboard windows = new Dashboard();
                windows.fullName.setText("ADMINISTRATOR");
                windows.setVisible(true);
                this.dispose();

            } else if (searchUser.equals("Login successfully")) {

                searchName = MethodsSQL.searchName(txtUser.getText());
                JOptionPane.showMessageDialog(null,
                 "                         - - WELCOME - - \n\n" +searchName);

                Dashboard windows = new Dashboard();
                windows.fullName.setText(searchName);
                windows.setVisible(true);
                this.dispose();

            } else {

                txtUser.setText("");
                txtPassword.setText("");
                txtUser.requestFocus();
            }
        }

    }


    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt){
        place = "Login";
        Register register = new Register();
        register.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {

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


        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    /************** Variables declaration *****************/

    private JPanel back;
    private JLabel login;
    private JLabel user;
    private JLabel password;
    private JTextField txtUser;
    private JPasswordField txtPassword;
    private JSeparator linePassword;
    private JSeparator lineUser;
    private JButton btnLogin;
    private JButton btnRegister;
    public static String place;
    public static String searchName;

}