package course_registration_systemsample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import  course_registration_systemsample.StudentDAO;
import  course_registration_systemsample.CourseDAO;
import  course_registration_systemsample.EnrollmentDAO;
import course_registration_systemsample.Course;
import java.util.List;
import java.util.Scanner;

public class DBconnection {
	 private static final String URL = "jdbc:mysql://localhost:3306/course_registration_system";
	    private static final String USER = "root";
	    private static final String PASSWORD = "Kgisl@123"; 

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }



	public static void main(String[] args) {
		

}
}