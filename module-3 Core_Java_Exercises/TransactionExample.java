import java.sql.*;

public class TransactionExample {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:bank.db"; // Ensure this DB and accounts table exist

        try (Connection conn = DriverManager.getConnection(url)) {
            conn.setAutoCommit(false);

            try (PreparedStatement debit = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
                 PreparedStatement credit = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?")) {

                debit.setInt(1, 100);
                debit.setInt(2, 1);
                debit.executeUpdate();

                credit.setInt(1, 100);
                credit.setInt(2, 2);
                credit.executeUpdate();

                conn.commit();
                System.out.println("Transaction successful.");
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Transaction failed, rolled back.");
            }

        } catch (SQLException e) {
            System.out.println("DB error: " + e.getMessage());
        }
    }
}
