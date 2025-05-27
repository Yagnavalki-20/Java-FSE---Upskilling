import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "yourpassword";

        int fromAccount = 101;
        int toAccount = 102;
        double amount = 500.0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);

            conn.setAutoCommit(false); // Start transaction

            try (
                PreparedStatement debitStmt = conn.prepareStatement(
                    "UPDATE accounts SET balance = balance - ? WHERE account_id = ?"
                );
                PreparedStatement creditStmt = conn.prepareStatement(
                    "UPDATE accounts SET balance = balance + ? WHERE account_id = ?"
                )
            ) {
                // Debit from source account
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccount);
                int debitRows = debitStmt.executeUpdate();

                // Credit to destination account
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccount);
                int creditRows = creditStmt.executeUpdate();

                if (debitRows == 1 && creditRows == 1) {
                    conn.commit();  // Commit transaction
                    System.out.println("Transfer successful. Transaction committed.");
                } else {
                    conn.rollback();  // Rollback if any part fails
                    System.out.println("Transfer failed. Transaction rolled back.");
                }

            } catch (Exception ex) {
                conn.rollback();  // Rollback on exception
                System.out.println("Error occurred. Transaction rolled back.");
                ex.printStackTrace();
            } finally {
                conn.setAutoCommit(true); // Restore default
                conn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
