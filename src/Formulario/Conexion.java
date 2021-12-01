package Formulario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static Connection conexion = null;

    private Conexion() {
        String conexionUrl = "jdbc:sqlserver://LAPTOP-ASUS\\SQLEXPRESS:1433;"
                + "database=USUARIOS;"
                + "user=Frainer_Alexander;"
                + "password=1234;"
                + "loginTimeout=30";
        try {
            conexion = (Connection) DriverManager.getConnection(conexionUrl);
            System.out.println("Conexión establecida");
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public static Connection getConnection(){
        if(conexion == null){
            new Conexion();
        }
        
        return conexion;  
    }
                
}
