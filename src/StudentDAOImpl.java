import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public void addStudent(Student student) {
        String query = "INSERT INTO students (roll_no, name, age) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, student.getRollNo());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: Roll No already exists.");
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                students.add(new Student(rs.getInt("roll_no"), rs.getString("name"), rs.getInt("age")));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return students;
    }

    @Override
    public Student getStudentByRollNo(int rollNo) {
        String query = "SELECT * FROM students WHERE roll_no = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, rollNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(rs.getInt("roll_no"), rs.getString("name"), rs.getInt("age"));
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteStudent(int rollNo) {
        String query = "DELETE FROM students WHERE roll_no = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, rollNo);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
