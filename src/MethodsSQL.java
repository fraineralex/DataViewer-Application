import java.sql.*;
public class MethodsSQL {

    Connection connection = ConnectionSQL.getConnection();

    public static PreparedStatement preparedStatement;
    public static ResultSet result;
    public static int numberResult = 0;

    public static int save(String user, String name, String lastName, String phone, String email, String password) {

        int result = 0;
        Connection conn = null;

        String statementSave = ("INSERT INTO USUARIOS (USUARIO, NOMBRE, APELLIDOS, TELEFONO, CORREO, CONTRASEÑA) VALUES (?, ?, ?, ?, ?, ?)");

        try {
            conn = ConnectionSQL.getConnection();
            preparedStatement = conn.prepareStatement(statementSave);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, password);

            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e);
        }

        return result;

    }

    public static String searchName(String user) {

        String search = null;
        Connection conn = null;

        try {
            conn = ConnectionSQL.getConnection();
            String statementSearch = ("SELECT NOMBRE, APELLIDOS FROM USUARIOS WHERE USUARIO = '"  + user + "'");
            preparedStatement = conn.prepareStatement(statementSearch);
            result = preparedStatement.executeQuery();
            
            if (result.next()) {
                String name = result.getString("nombre");
                String lastName = result.getString("apellidos");
                search = (name + " " + lastName);
            }
        } catch (Exception e) {
            System.out.print(e);
        }

        return search;

    }

    public static String searchRegisteredUser(String user, String password) {

        String searchUser = null;
        Connection conn = null;

        try {
            conn = ConnectionSQL.getConnection();
            String statementSearchUser = ("SELECT NOMBRE, USUARIO, CONTRASEÑA FROM USUARIOS WHERE USUARIO = '" + user + "' AND CONTRASEÑA = '" + password + "'");
            preparedStatement = conn.prepareStatement(statementSearchUser);
            result = preparedStatement.executeQuery();

            if (result.next()) {
                searchUser = "Login successfully";
            } else {
                searchUser = "Incorrect username or password";
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return searchUser;

    }

        
}
