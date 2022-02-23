import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Dashboard extends JFrame{

    Connection conn = ConnectionSQL.getConnection();

    public Dashboard() {
        dashboard();
        table.setModel(showRecords());

    }

    public DefaultTableModel showRecords() {
        
        DefaultTableModel tUser = new DefaultTableModel();
        tUser.addColumn("NOMBRE");
        tUser.addColumn("APELLIDO");
        tUser.addColumn("TELEFONO");
        tUser.addColumn("CORREO");

        String [] data = new String [4];
        try {
            Statement read = conn.createStatement();
            ResultSet result = read.executeQuery("SELECT NOMBRE, APELLIDOS, TELEFONO, CORREO FROM USUARIOS");

            while (result.next()) {
                data[0] = result.getString("NOMBRE");
                data[1] = result.getString("APELLIDOS");
                data[2] = result.getString("TELEFONO");
                data[3] = result.getString("CORREO");
                tUser.addRow(data);
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return tUser;

    }

    private void Update() {

        int row = table.getSelectedRow();

        String name = (this.table.getValueAt(row, 0)).toString();
        String lastName = (this.table.getValueAt(row, 1)).toString();
        String phone = (this.table.getValueAt(row, 2)).toString();
        String email = (this.table.getValueAt(row, 3)).toString();

        try {
            PreparedStatement update = conn.prepareStatement("UPDATE USUARIOS SET NOMBRE = '" + name + "', APELLIDOS = '" + lastName + "', TELEFONO = '" + phone + "', CORREO = '" + email + "' WHERE CORREO = '" + email + "' OR TELEFONO = '" + phone + "'");
            update.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data updated successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "It was not possible to update the information, try with other data" + e);
        }
        
    }

    private void Delete() {

        int row = table.getSelectedRow();

        String email = (this.table.getValueAt(row, 3).toString());

        try {
            PreparedStatement delete = conn.prepareStatement("DELETE USUARIOS WHERE CORREO = '" + email + "'");
            delete.executeUpdate();
            JOptionPane.showMessageDialog(null, "User deleted successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "It was not possible to delete this user" + e);
        }

    }




    private void dashboard() {

        /****************** Interface features ******************/

        back = new JPanel();
        back.setBackground(Color.WHITE);
        back.setMinimumSize(new java.awt.Dimension(870, 520));
        setBounds(400, 130, 870, 520);
        setVisible(true);
        setContentPane(back);
        back.setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        registered = new JLabel("Registered Clients"); 
        registered.setFont(new java.awt.Font("Roboto Black", 3, 30));
        registered.setForeground(Color.BLACK);
        registered.setBounds(310, 10, 500, 50);
        back.add(registered);

        btnRegister = new JButton("REGISTER");
        btnRegister.setFont(new java.awt.Font("Roboto Black", 3, 14));
        btnRegister.setForeground(Color.BLACK);
        btnRegister.setBackground(Color.WHITE);
        btnRegister.setIcon(new javax.swing.ImageIcon("D:\\Downloads\\images\\Register.png"));
        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegister.setBorder(null);
        btnRegister.setBounds(10, 140, 150, 50);
        btnRegister.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                btnRegisterActionPerformed(evt);
            }

        });
        back.add(btnRegister);

        btnSingOff = new JButton("SING OFF");
        btnSingOff.setFont(new java.awt.Font("Roboto Black", 3, 14));
        btnSingOff.setForeground(Color.BLACK);
        btnSingOff.setBackground(Color.WHITE);
        btnSingOff.setIcon(new javax.swing.ImageIcon("D:\\Downloads\\images\\User.png"));
        btnSingOff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSingOff.setBorder(null);
        btnSingOff.setBounds(10, 230, 150, 50);
        btnSingOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSingOffActionPerformed(evt);
            }

        });
        back.add(btnSingOff);

        btnUpdate = new JButton("UPDATE");
        btnUpdate.setFont(new java.awt.Font("Roboto Black", 3, 14));
        btnUpdate.setForeground(Color.BLACK);
        btnUpdate.setBackground(Color.WHITE);
        btnUpdate.setIcon(new javax.swing.ImageIcon("D:\\Downloads\\images\\Update.png"));
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setBorder(null);
        btnUpdate.setBounds(250, 350, 150, 50);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        back.add(btnUpdate);

        btnDelete = new JButton("DELETE");
        btnDelete.setFont(new java.awt.Font("Roboto Black", 3, 14));
        btnDelete.setForeground(Color.BLACK);
        btnDelete.setBackground(Color.WHITE);
        btnDelete.setIcon(new javax.swing.ImageIcon("D:\\Downloads\\images\\Delete.png"));
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setBorder(null);
        btnDelete.setBounds(495, 350, 150, 50);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        back.add(btnDelete);

        user = new JLabel("USER:");
        user.setFont(new java.awt.Font("Roboto Black", 3, 14));
        user.setForeground(Color.BLACK);
        user.setBorder(null);
        user.setBounds(10, 450, 160, 30);
        back.add(user);

        fullName = new JLabel("");
        fullName.setFont(new java.awt.Font("Roboto Black", 3, 14));
        fullName.setForeground(Color.GRAY);
        fullName.setBorder(null);
        fullName.setBounds(60, 450, 400, 30);
        back.add(fullName);

        table = new JTable();
        table.setAutoCreateRowSorter(true);
        table.setFont(new java.awt.Font("Roboto", 0, 10));
        table.setToolTipText("");
        scroll = new JScrollPane(table);
        scroll.setBounds(190, 100, 520, 220);
        back.add(scroll);
        table.setModel(new javax.swing.table.DefaultTableModel(
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
                "NAME", "LAST NAME", "TELEPHONE", "EMAIL"

            }
        ){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class

            };

            public Class getColumnClass(int columnIdex) {
                return types [columnIdex];
            }

        });

    }

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {
        Login.place = "Dashboard";
        Register newRegister = new Register();
        newRegister.setVisible(true);
        this.dispose();
    }

    private void btnSingOffActionPerformed(java.awt.event.ActionEvent evt) {
        ConnectionSQL.CloseConnection(conn);
        Login newLogin = new Login();
        newLogin.setVisible(true);
        this.dispose();
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        Update();
        table.setModel(showRecords());

    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt){
        Delete();
        table.setModel(showRecords());
    }


    /************** Variables declaration *****************/

    private JPanel back;
    private JLabel registered;
    private JButton btnRegister;
    private JButton btnSingOff;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JLabel user;
    public JLabel fullName;
    private JTable table;
    private JScrollPane scroll;

}
