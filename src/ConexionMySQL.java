import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionMySQL {

    private static final String URL = "jdbc:mysql://localhost:3306/bd_estudiantes?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = ""; // Sin contraseña

    public static void main(String[] args) {
        Connection conexion = null;

        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");

          
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("✅ Conexión exitosa a MySQL");

       
            String sql = "SELECT * FROM estudiante";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

       
            System.out.println("📋 Lista de estudiantes:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String cedula = rs.getString("cedula");
                String correo = rs.getString("correo");

                System.out.println("ID: " + id + ", Nombre: " + nombre + " " + 
                                   ", Cédula: " + cedula + ", Correo: " + correo);
            }

           
            rs.close();
            ps.close();
            conexion.close();
            System.out.println("✅ Conexión cerrada correctamente.");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }
}
