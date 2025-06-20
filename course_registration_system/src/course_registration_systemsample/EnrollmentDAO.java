package course_registration_systemsample;

import course_registration_systemsample.DBconnection;
import java.sql.*;

public class EnrollmentDAO {

    public void enroll(int studentId, int courseId) {
        String query = "INSERT INTO enrollment (student_id, course_id, status) VALUES (?, ?, 'enrolled')";
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            stmt.executeUpdate();
            System.out.println("✅ Enrollment successful!");
        } catch (SQLException e) {
            System.out.println("❌ Enrollment failed: " + e.getMessage());
        }
    }

    public void drop(int studentId, int courseId) {
        String query = "DELETE FROM enrollment WHERE student_id = ? AND course_id = ?";
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Successfully dropped the course.");
            } else {
                System.out.println("❌ You are not enrolled in this course.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewEnrolledCourses(int studentId) {
        String query = """
                SELECT c.course_name
                FROM enrollment e
                JOIN course c ON e.course_id = c.course_id
                WHERE e.student_id = ? AND e.status = 'enrolled'
                """;

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();

            System.out.println("\n📚 Enrolled Courses:");
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("- " + rs.getString("course_name"));
            }
            if (!found) {
                System.out.println("You are not enrolled in any courses.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
