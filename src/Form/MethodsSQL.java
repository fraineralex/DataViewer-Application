package Form;

// Impotaciones correspondientes
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MethodsSQL {

    // Creando una instancia tipo conección mediante el método "getConnection" en la clase "ConnectionSQL"
    Connection conectar = ConnectionSQL.getConnection();

    // Declalración de variables a utilizar a nivel de clase
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static int resultado_numero = 0;

    
    // Método que inserta los datos proporcionados por "RegisterGUI" en la base de datos
    public int guardar(String usuario, String nombre, String apellidos, String telefono, String correo, String contraseña) {

        int resultado = 0;
        Connection conexion = null;
         
        String sentencia_guardar = ("INSERT INTO USUARIOS (USUARIO, NOMBRE, APELLIDOS, TELEFONO, CORREO, CONTRASEÑA) VALUES (?, ?, ?, ?, ?, ?)");

        try {
            conexion = ConnectionSQL.getConnection();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, usuario);
            sentencia_preparada.setString(2, nombre);
            sentencia_preparada.setString(3, apellidos);
            sentencia_preparada.setString(4, telefono);
            sentencia_preparada.setString(5, correo);
            sentencia_preparada.setString(6, contraseña);

            resultado = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();

            conexion.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return resultado;

    }
    
    // Métodoo que permite buscar el nombre y apellido de la base de datos.
    public static String buscarNombre(String usuario) {

        String busqueda_nombre = null;
        Connection conexion = null;
        try {
            conexion = ConnectionSQL.getConnection();
            String sentencia_buscar = ("SELECT NOMBRE, APELLIDOS FROM USUARIOS WHERE USUARIO = '" + usuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellidos");
                busqueda_nombre = (nombre + " " + apellidos);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
 
        return busqueda_nombre;
    }

    // Método que permite la validación de los usuarios registrados en la base de datos.
    public static String buscarUsuarioRegistrado(String usuario, String contraseña) {
        String busqueda_usuario = null;
        Connection conexion = null;

        try {
            conexion = ConnectionSQL.getConnection();
            String sentencia_buscar_usuario = ("SELECT NOMBRE, USUARIO, CONTRASEÑA FROM USUARIOS WHERE USUARIO = '" + usuario + "' AND CONTRASEÑA = '" + contraseña + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar_usuario);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                busqueda_usuario = "Se ha iniciado sesión correctamente";
            } else {
                busqueda_usuario = "No se ha podido iniciar sesión,";
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return busqueda_usuario;
    }

}
