package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseDAO {
	protected static final Logger LOGGER = Logger.getLogger(CourseDAO.class.getName());
	private static final String viewCoursesStatementString = "SELECT courses.idcourses, courses.name FROM courses";
	private static final String findCoursesStatementString = "SELECT courses.idcourses, courses.name, courses.teachers_idteachers FROM courses, enrolments WHERE courses.idcourses = enrolments.courses_idcourses and enrolments.students_idstudents = ?";
	private static final String insertCourseStatementString = "INSERT INTO courses (courses.idcourses, courses.name, courses.teachers_idteachers) VALUES(?,?,?)";

	
	public ResultSet viewCourses() {
		Connection dbConnection = ConnectionToDb.getConnection();
		PreparedStatement viewStatement = null;
		ResultSet rs = null;
		try {
			viewStatement = dbConnection.prepareStatement(viewCoursesStatementString);
			rs = viewStatement.executeQuery();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "CourseDAO:view " + e.getMessage());
		}
		return rs;
	}

	public void insert(Course course) {
		Connection dbConnection = ConnectionToDb.getConnection();

		PreparedStatement insertStatement = null;
	
		try {
			insertStatement = dbConnection.prepareStatement(insertCourseStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, course.getId());
			insertStatement.setString(2, course.getName());
			insertStatement.setInt(3, course.getTeacher());
			insertStatement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "CourseDAO:insert " + e.getMessage());
		} finally {
			ConnectionToDb.close(insertStatement);
			ConnectionToDb.close(dbConnection);
		}
	}
	
	public ArrayList<Course> findCourses(int studentId) {
		ArrayList<Course> toReturn = new ArrayList<Course>();
		Connection dbConnection = ConnectionToDb.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findCoursesStatementString);
			findStatement.setInt(1, studentId);
			rs = findStatement.executeQuery();
			
			while (rs.next()) {
				Course c = new Course(rs.getInt("idcourses"), 
						rs.getString("name"),
						rs.getInt("teachers_idteachers")); 
			toReturn.add(c);
			}
			return toReturn;
		}catch (SQLException e) {
			LOGGER.log(Level.WARNING, "CourseDAO:find " + e.getMessage());
		} finally {
			ConnectionToDb.close(rs);
			ConnectionToDb.close(findStatement);
			ConnectionToDb.close(dbConnection);
		}
		return toReturn;
	}
}
