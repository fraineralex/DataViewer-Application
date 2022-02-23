import java.sql.*;

import javax.swing.JOptionPane;

public class ConnectionSQL {

    private static Connection conn = null;

    private ConnectionSQL() {

        String connUrl = "jdbc:sqlserver://ASUS-VivoBook\\SQLEXPRESS:1433;"
                + "database=USUARIOS;"
                + "user=Frainer_Alexander;"
                + "password=1234;"
                + "loginTimeout=30";

        try {
            conn = (Connection) DriverManager.getConnection(connUrl);
            System.out.println("Connection established");
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }

    public static Connection getConnection() {
        if(conn == null) {
            new ConnectionSQL();
        }

        return conn;

    }

    public static void CloseConnection(Connection conn) {
        try {
            conn.close();
            conn = null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "it was not possible close the connection" );
        }

    }

}