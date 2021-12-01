package Form;

// Impotación de las clases correspondientes
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {
    
    
    // Instancia de conexión privada y estática
    private static Connection conexion = null;

    // Constructor privado para poder acceder a nuestra conexión
    private ConnectionSQL() {
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
    
    // Método para establecer conexión a la base de datos
    public static Connection getConnection(){
        if(conexion == null){
            new ConnectionSQL();
        }
        
        return conexion;  
    }
                
}
