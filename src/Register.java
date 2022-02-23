import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Register extends JFrame{

    public Register() {
        register();

    }

    

    private void register() {

        /******************* Interface features *********************/

        setBounds(600, 30, 432, 727);
        setVisible(true);
        back = new JPanel();
        setContentPane(back);
        back.setLayout(null);
        back.setBackground(Color.WHITE);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        back.setAutoscrolls(true);
        back.setEnabled(false);

        register = new JLabel("REGISTER");
        register.setFont(new java.awt.Font("Roboto Black", 3, 36));
        register.setForeground(Color.BLACK);
        register.setBounds(115, 20, 200, 70);
        back.add(register);

        user = new JLabel("User Name");
        user.setFont(new java.awt.Font("Roboto Black", 3, 12));
        user.setForeground(Color.GRAY);
        user.setBounds(60, 90, 140, 20);
        back.add(user);

        txtUser = new JTextField();
        txtUser.setFont(new java.awt.Font("Roboto Midium", 3, 12));
        txtUser.setBounds(60, 120, 250, 20);
        txtUser.setBorder(null);
        back.add(txtUser);
        txtUser.requestFocus();

        lineUser = new JSeparator();
        lineUser.setForeground(Color.GRAY);
        lineUser.setBounds(50, 140, 260, 10);
        back.add(lineUser);

        name = new JLabel("Name");
        name.setFont(new java.awt.Font("Roboto Black", 3, 12));
        name.setForeground(Color.GRAY);
        name.setBounds(60, 160, 140, 20);
        back.add(name);

        txtName = new JTextField();
        txtName.setFont(new java.awt.Font("Roboto Midium", 3, 12));
        txtName.setBounds(60, 190, 250, 20);
        txtName.setBorder(null);
        back.add(txtName);   

        lineName = new JSeparator();
        lineName.setForeground(Color.GRAY);
        lineName.setBounds(50, 210, 260, 10);
        back.add(lineName);

        lastName = new JLabel("Last Name");
        lastName.setFont(new java.awt.Font("Roboto Black", 3, 12));
        lastName.setForeground(Color.GRAY);
        lastName.setBounds(60, 230, 140, 20);
        back.add(lastName);

        txtLastName = new JTextField();
        txtLastName.setFont(new java.awt.Font("Roboto Midium", 3, 12));
        txtLastName.setBounds(60, 260, 250, 20);
        txtLastName.setBorder(null);
        back.add(txtLastName);

        lineLastName = new JSeparator();
        lineLastName.setForeground(Color.GRAY);
        lineLastName.setBounds(50, 280, 260, 10);
        back.add(lineLastName);

        phone = new JLabel("Telephone");
        phone.setFont(new java.awt.Font("Roboto Black", 3, 12));
        phone.setForeground(Color.GRAY);
        phone.setBounds(60, 300, 140, 20);
        back.add(phone);

        txtPhone = new JTextField();
        txtPhone.setFont(new java.awt.Font("Roboto Midium", 3, 12));
        txtPhone.setBounds(60, 330, 250, 20);
        txtPhone.setBorder(null);
        back.add(txtPhone);

        linePhone = new JSeparator();
        linePhone.setForeground(Color.GRAY);
        linePhone.setBounds(50, 350, 260, 10);
        back.add(linePhone);

        email = new JLabel("Email");
        email.setFont(new java.awt.Font("Roboto Black", 3, 12));
        email.setForeground(Color.GRAY);
        email.setBounds(60, 370, 140, 20);
        back.add(email);

        txtEmail = new JTextField();
        txtEmail.setFont(new java.awt.Font("Roboto Midium", 3, 12));
        txtEmail.setBounds(60, 400, 250, 20);
        txtEmail.setBorder(null);
        back.add(txtEmail);

        lineEmail = new JSeparator();
        lineEmail.setForeground(Color.GRAY);
        lineEmail.setBounds(50, 420, 260, 10);
        back.add(lineEmail);

        password = new JLabel("Password");
        password.setFont(new java.awt.Font("Roboto Black", 3, 12));
        password.setForeground(Color.GRAY);
        password.setBounds(60, 440, 140, 20);
        back.add(password);

        txtPassword = new JPasswordField();
        txtPassword.setFont(new java.awt.Font("Roboto Midium", 3, 12));
        txtPassword.setBounds(60, 470, 250, 20);
        txtPassword.setBorder(null);
        txtPassword.setToolTipText("");
        back.add(txtPassword);

        linePassword = new JSeparator();
        linePassword.setForeground(Color.GRAY);
        linePassword.setBounds(50, 490, 260, 10);
        back.add(linePassword);

        password2 = new JLabel("Repeat password ");
        password2.setFont(new java.awt.Font("Roboto Black", 3, 12));
        password2.setForeground(Color.GRAY);
        password2.setBounds(60, 510, 140, 20);
        back.add(password2);

        txtPassword2 = new JPasswordField();
        txtPassword2.setFont(new java.awt.Font("Roboto Midium", 3, 12));
        txtPassword2.setBounds(60, 540, 250, 20);
        txtPassword2.setBorder(null);
        txtPassword2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassword2ActionPerformed(evt);
            }
        });
        back.add(txtPassword2);

        linePassword2 = new JSeparator();
        linePassword2.setForeground(Color.GRAY);
        linePassword2.setBounds(50, 560, 260, 10);
        back.add(linePassword2);

        btnRegister = new JButton("REGISTAR");
        btnRegister.setFont(new java.awt.Font("Roboto Black", 3, 18));
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setBackground(new java.awt.Color(155, 96, 227));
        btnRegister.setBorder(null);
        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegister.setBounds(120, 600, 190, 40);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        back.add(btnRegister);

        btnBack = new JButton("<-");
        btnBack.setFont(new java.awt.Font("Roboto Black", 3, 30));
        btnBack.setForeground(Color.BLACK);
        btnBack.setBackground(Color.WHITE);
        btnBack.setBorder(null);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.setBounds(05, 0, 60, 30);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        back.add(btnBack);



    }

    private void txtPassword2ActionPerformed(java.awt.event.ActionEvent evt) {

        txtPassword2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnRegisterActionPerformed(evt);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });

    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        if (Login.place == "Login") {

            Login login = new Login();
            login.setVisible(true);
            this.dispose();

        }else {

            if (Login.searchName == null) {
                Login.searchName = "ADMINISTRATOR";
            }

            Dashboard dashboard = new Dashboard();
            dashboard.fullName.setText(Login.searchName);
            dashboard.setVisible(true);
            this.dispose();
        }

    }

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {

        if (txtUser.getText().isEmpty() && txtName.getText().isEmpty()) {

            lineUser.setForeground(new java.awt.Color(255, 51, 51));
            user.setForeground(new java.awt.Color(0, 0, 0));

            name.setForeground(new java.awt.Color(0, 0, 0));
            lineName.setForeground(new java.awt.Color(255, 51, 51));

            lastName.setForeground(new java.awt.Color(0, 0, 0));
            lineLastName.setForeground(new java.awt.Color(255, 51, 51));

            phone.setForeground(new java.awt.Color(0, 0, 0));
            linePhone.setForeground(new java.awt.Color(255, 51, 51));

            email.setForeground(new java.awt.Color(0, 0, 0));
            lineEmail.setForeground(new java.awt.Color(255, 51, 51));

            password.setForeground(new java.awt.Color(0, 0, 0));
            linePassword.setForeground(new java.awt.Color(255, 51, 51));

            password2.setForeground(new java.awt.Color(0, 0, 0));
            linePassword2.setForeground(new java.awt.Color(255, 51, 51));

            JOptionPane.showMessageDialog(this, "You must fill in all the fields to be able to register.");

            lineUser.setForeground(new java.awt.Color(0, 0, 0));
            user.setForeground(new java.awt.Color(153, 153, 153));

            name.setForeground(new java.awt.Color(153, 153, 153));
            lineName.setForeground(new java.awt.Color(0, 0, 0));

            lastName.setForeground(new java.awt.Color(153, 153, 153));
            lineLastName.setForeground(new java.awt.Color(0, 0, 0));

            phone.setForeground(new java.awt.Color(153, 153, 153));
            linePhone.setForeground(new java.awt.Color(0, 0, 0));

            email.setForeground(new java.awt.Color(153, 153, 153));
            lineEmail.setForeground(new java.awt.Color(0, 0, 0));

            password.setForeground(new java.awt.Color(153, 153, 153));
            linePassword.setForeground(new java.awt.Color(0, 0, 0));

            password2.setForeground(new java.awt.Color(153, 153, 153));
            linePassword2.setForeground(new java.awt.Color(0, 0, 0));
            txtUser.requestFocus();


        } else if (txtUser.getText().isEmpty()) {


            lineUser.setForeground(new java.awt.Color(255, 51, 51));
            user.setForeground(new java.awt.Color(0, 0, 0));
            JOptionPane.showMessageDialog(this, "The 'Username' field cannot be empty");
            lineUser.setForeground(new java.awt.Color(0, 0, 0));
            user.setForeground(new java.awt.Color(153, 153, 153));
            txtUser.requestFocus();

        } else if (txtName.getText().isEmpty()) {

            name.setForeground(new java.awt.Color(0, 0, 0));
            lineName.setForeground(new java.awt.Color(255, 51, 51));
            JOptionPane.showMessageDialog(this, "The field 'Name' cannot be empty, insert your name.");
            name.setForeground(new java.awt.Color(153, 153, 153));
            lineName.setForeground(new java.awt.Color(0, 0, 0));
            txtName.requestFocus();

        } else if (txtLastName.getText().isEmpty()) {

            lastName.setForeground(new java.awt.Color(0, 0, 0));
            lineLastName.setForeground(new java.awt.Color(255, 51, 51));
            JOptionPane.showMessageDialog(this, "The field 'Last name' cannot be empty, insert your last name.");
            lastName.setForeground(new java.awt.Color(153, 153, 153));
            lineLastName.setForeground(new java.awt.Color(0, 0, 0));
            txtLastName.requestFocus();

        } else if (txtPhone.getText().isEmpty()) {

            phone.setForeground(new java.awt.Color(0, 0, 0));
            linePhone.setForeground(new java.awt.Color(255, 51, 51));
            JOptionPane.showMessageDialog(this, "The 'Phone' field cannot be empty, please insert your phone.");
            phone.setForeground(new java.awt.Color(153, 153, 153));
            linePhone.setForeground(new java.awt.Color(0, 0, 0));
            txtPhone.requestFocus();

        } else if (txtEmail.getText().isEmpty()) {

            email.setForeground(new java.awt.Color(0, 0, 0));
            lineEmail.setForeground(new java.awt.Color(255, 51, 51));
            JOptionPane.showMessageDialog(this, "The 'Email' field cannot be empty, insert your email.");
            email.setForeground(new java.awt.Color(153, 153, 153));
            lineEmail.setForeground(new java.awt.Color(0, 0, 0));
            txtEmail.requestFocus();

        } else if (txtPassword.getText().isEmpty()) {

            password.setForeground(new java.awt.Color(0, 0, 0));
            linePassword.setForeground(new java.awt.Color(255, 51, 51));
            JOptionPane.showMessageDialog(this, "Field 'Password' cannot be empty, please enter a password.");
            password.setForeground(new java.awt.Color(153, 153, 153));
            linePassword.setForeground(new java.awt.Color(0, 0, 0));
            txtPassword.requestFocus();

        } else if (txtPassword2.getText().isEmpty()) {

            password2.setForeground(new java.awt.Color(0, 0, 0));
            linePassword2.setForeground(new java.awt.Color(255, 51, 51));
            JOptionPane.showMessageDialog(this, "You must confirm your password, please enter your password again.");
            password2.setForeground(new java.awt.Color(153, 153, 153));
            linePassword2.setForeground(new java.awt.Color(0, 0, 0));
            txtPassword2.requestFocus();

        } else if (!txtPassword.getText().equals(txtPassword2.getText())) {

            txtPassword.setForeground(new java.awt.Color(255, 51, 51));
            txtPassword2.setForeground(new java.awt.Color(255, 51, 51));

            password.setForeground(new java.awt.Color(0, 0, 0));
            password2.setForeground(new java.awt.Color(0, 0, 0));

            JOptionPane.showMessageDialog(this, "The passwords do not match, please enter a correct password.");

            txtPassword.setForeground(new java.awt.Color(0, 0, 0));
            txtPassword2.setForeground(new java.awt.Color(0, 0, 0));

            password.setForeground(new java.awt.Color(153, 153, 153));
            password2.setForeground(new java.awt.Color(153, 153, 153));

            txtPassword.setText("");
            txtPassword2.setText("");
            txtPassword.requestFocus();

        } else {

            int i = MethodsSQL.save (txtUser.getText(), txtName.getText(), txtLastName.getText(), txtPhone.getText(), txtEmail.getText(), txtPassword.getText());


            if (i > 0) {
                JOptionPane.showMessageDialog(this, "Your registration has been successful");
                Register register = new Register();
                register.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Your registration could not be done, please try again");
            }

        }

    }


    /************** Variables declaration *****************/

    private JPanel back;
    private JLabel register;
    private JLabel user;
    private JTextField txtUser;
    private JSeparator lineUser;
    private JLabel name;
    private JTextField txtName;
    private JSeparator lineName;
    private JLabel lastName;
    private JTextField txtLastName;
    private JSeparator lineLastName;
    private JLabel phone;
    private JTextField txtPhone;
    private JSeparator linePhone;
    private JLabel email;
    private JTextField txtEmail;
    private JSeparator lineEmail;
    private JLabel password;
    private JPasswordField txtPassword;
    private JSeparator linePassword;
    private JLabel password2;
    private JPasswordField txtPassword2;
    private JSeparator linePassword2;
    private JButton btnRegister;
    private JButton btnBack;
    
}

