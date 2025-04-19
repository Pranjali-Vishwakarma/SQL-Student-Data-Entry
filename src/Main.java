/*
Name: Pranjali Vishwakarma
PRN: 230770126092
Batch: SY AIML B1
*/

import java.util.*;

public class StudentMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAOImpl();

        System.out.println("------ Student Data Entry System (MySQL + JDBC) ------");

        while (true) {
            System.out.println("\n1. Add Student\n2. View All Students\n3. Search Student by Roll No\n4. Delete Student\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int rollNo = sc.nextInt();
                    sc.nextLine(); // flush
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    dao.addStudent(new Student(rollNo, name, age));
                    break;
                case 2:
                    List<Student> students = dao.getAllStudents();
                    if (students.isEmpty()) System.out.println("No records found.");
                    else students.forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter Roll No: ");
                    int searchRoll = sc.nextInt();
                    Student student = dao.getStudentByRollNo(searchRoll);
                    if (student != null) System.out.println(student);
                    break;
                case 4:
                    System.out.print("Enter Roll No: ");
                    int deleteRoll = sc.nextInt();
                    dao.deleteStudent(deleteRoll);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
