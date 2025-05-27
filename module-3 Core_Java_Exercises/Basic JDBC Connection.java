import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcSelectExample {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load the SQLite JDBC driver (optional for newer Java versions)
            Class.forName("org.sqlite.JDBC");

            // Create a connection to the database
            String url = "jdbc:sqlite:school.db"; // SQLite database file path
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            // Create a statement object to execute query
            stmt = conn.createStatement();

            // Execute SELECT query
            String sql = "SELECT id, name, age FROM students";
            rs = stmt.executeQuery(sql);

            // Iterate over the result set and print the data
            System.out.println("Students data:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(id + "\t" + name + "\t" + age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources to avoid memory leaks
            try { if (rs != null) rs.close(); } catch (Exception ignored) {}
            try { if (stmt != null) stmt.close(); } catch (Exception ignored) {}
            try { if (conn != null) conn.close(); } catch (Exception ignored) {}
        }
    }
}
