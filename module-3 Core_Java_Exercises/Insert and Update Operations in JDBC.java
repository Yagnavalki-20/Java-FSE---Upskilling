import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/schooldb"; // Your DB URL
    private static final String USER = "root";  // Your DB username
    private static final String PASSWORD = "password"; // Your DB password

    // Get a database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Insert a new student record
    public boolean insertStudent(String name, int age) {
        String sql = "INSERT INTO students (name, age) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, age);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update student details by ID
    public boolean updateStudent(int id, String name, int age) {
        String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // For testing
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        // Insert a new student
        if (dao.insertStudent("Alice", 21)) {
            System.out.println("Student inserted successfully.");
        } else {
            System.out.println("Insert failed.");
        }

        // Update student with id=1
        if (dao.updateStudent(1, "Alice Smith", 22)) {
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Update failed.");
        }
    }
}
