package course_registration_systemsample;

import course_registration_systemsample.Coursedoa;
import course_registration_systemsample.EnrollmentDAO;
import course_registration_systemsample.StudentDAO;
import course_registration_systemsample.Course;

import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Coursedoa courseDAO = new Coursedoa();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
        StudentDAO studentDAO = new StudentDAO();

        int studentId = -1;

        // 👤 Login Prompt
        System.out.println("===== Student Login =====");
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        studentId = studentDAO.login(email, password);

        if (studentId == -1) {
            System.out.println("❌ Invalid login. Exiting.");
            return;
        }

        System.out.println("✅ Login successful! Welcome.\n");

        // Show course menu if logged in
        while (true) {
            System.out.println("===== COURSE REGISTRATION MENU =====");
            System.out.println("1. View all available courses");
            System.out.println("2. Enroll in a course");
            System.out.println("3. Drop a course");
            System.out.println("4. View my enrolled courses");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    List<Course> courses = courseDAO.getAllCourses();
                    System.out.println("\nAvailable Courses:");
                    for (Course c : courses) {
                        System.out.println(c.getCourseId() + " - " + c.getCourseName());
                    }
                }
                case 2 -> {
                    System.out.print("Enter Course ID to enroll: ");
                    int enrollCourseId = scanner.nextInt();
                    enrollmentDAO.enroll(studentId, enrollCourseId);
                }
                case 3 -> {
                    System.out.print("Enter Course ID to drop: ");
                    int dropCourseId = scanner.nextInt();
                    enrollmentDAO.drop(studentId, dropCourseId);
                }
                case 4 -> enrollmentDAO.viewEnrolledCourses(studentId);
                case 5 -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}


