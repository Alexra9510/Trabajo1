import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarEstudiante {

    private static final String URL = "jdbc:mysql://localhost:3306/bd_estudiantes?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = ""; // Deja vacío si no tienes contraseña

    public static void main(String[] args) {
        int idEliminar = 28; // ✅ Cambia este valor por el ID del estudiante que quieres eliminar

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("✅ Conexión establecida correctamente.");

            String sql = "DELETE FROM estudiante WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idEliminar);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("🗑️ Estudiante con ID " + idEliminar + " eliminado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró estudiante con ese ID.");
            }

            conexion.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
