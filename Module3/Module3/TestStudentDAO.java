public class TestStudentDAO {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        // Insert new student
        boolean inserted = dao.insertStudent(4, "David", 21);
        System.out.println("Insert successful? " + inserted);

        // Update student details
        boolean updated = dao.updateStudent(4, "David Beckham", 22);
        System.out.println("Update successful? " + updated);
    }
}
