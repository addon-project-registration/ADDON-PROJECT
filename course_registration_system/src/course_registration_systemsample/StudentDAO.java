package course_registration_systemsample;

import course_registration_systemsample.DBconnection;
import course_registration_systemsample.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	public int login(String email, String password) {
	    String query = "SELECT student_id FROM student WHERE email = ? AND password = ?";
	    try (Connection conn = DBconnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {

	        stmt.setString(1, email);
	        stmt.setString(2, password);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            return rs.getInt("student_id");  // Login successful
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return -1; // Login failed
	}


    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student";

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("department")
                );
                students.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
