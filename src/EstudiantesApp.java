import java.sql.*;

public class EstudiantesApp {

    private static final String URL = "jdbc:mysql://localhost:3306/bd_estudiantes?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
                System.out.println("✅ Conexión establecida correctamente.");

                // INSERTAR ESTUDIANTE
                String insertar = "INSERT INTO estudiante (nombre, cedula, correo) VALUES (?, ?, ?)";
                PreparedStatement ps = conexion.prepareStatement(insertar);
                ps.setString(1, "Carolina Romero");
                ps.setString(2, "987654321");
                ps.setString(3, "carolina@example.com");
                int filas = ps.executeUpdate();
                System.out.println("🟢 Estudiantes insertados: " + filas);

               


                System.out.println("\n✅ Conexión cerrada correctamente.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
