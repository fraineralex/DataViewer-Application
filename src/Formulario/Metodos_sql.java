package Formulario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Metodos_sql {

    //public static Conexion conexion = new Conexion();
    
    Connection conectar = Conexion.getConnection();

    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static int resultado_numero = 0;

    public int guardar(String usuario, String nombre, String apellidos, String telefono, String correo, String contraseña) {

        int resultado = 0;
        Connection conexion = null;

        String sentencia_guardar = ("INSERT INTO USUARIOS (USUARIO, NOMBRE, APELLIDOS, TELEFONO, CORREO, CONTRASEÑA) VALUES (?, ?, ?, ?, ?, ?)");

        try {
            conexion = Conexion.getConnection();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, usuario);
            sentencia_preparada.setString(2, nombre);
            sentencia_preparada.setString(3, apellidos);
            sentencia_preparada.setString(4, telefono);
            sentencia_preparada.setString(5, correo);
            sentencia_preparada.setString(6, contraseña);

            resultado = sentencia_preparada.executeUpdate();
            //sentencia_preparada.close();

            //conexion.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return resultado;

    }

    public static String buscarNombre(String usuario) {

        String busqueda_nombre = null;
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            String sentencia_buscar = ("SELECT NOMBRE, APELLIDOS FROM USUARIOS WHERE USUARIO = '" + usuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellidos");
                busqueda_nombre = (nombre + " " + apellidos);
            }

            //conexion.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return busqueda_nombre;
    }

    public static String buscarUsuarioRegistrado(String usuario, String contraseña) {
        String busqueda_usuario = null;
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            String sentencia_buscar_usuario = ("SELECT NOMBRE, USUARIO, CONTRASEÑA FROM USUARIOS WHERE USUARIO = '" + usuario + "' AND CONTRASEÑA = '" + contraseña + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar_usuario);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                busqueda_usuario = "Se ha iniciado sesión correctamente";
            } else {
                busqueda_usuario = "No se ha podido iniciar sesión,";
            }

            //conexion.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return busqueda_usuario;
    }

}
