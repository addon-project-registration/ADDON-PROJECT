package course_registration_systemsample;
;

import course_registration_systemsample.DBconnection;
import course_registration_systemsample.Course;
import java.sql.*;
import java.util.*;

public class Coursedoa {
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT course_id, course_name FROM course";

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                courses.add(new Course(rs.getInt("course_id"), rs.getString("course_name")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}

