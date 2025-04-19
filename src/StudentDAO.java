import java.util.List;

public interface StudentDAO {
    void addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentByRollNo(int rollNo);
    void deleteStudent(int rollNo);
}