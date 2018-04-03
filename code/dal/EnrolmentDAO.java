package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnrolmentDAO  {
	protected static final Logger LOGGER = Logger.getLogger(EnrolmentDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO enrolments (courses_idcourses, students_idstudents, exams_idexams) VALUES (?,?,?)";
	private static final String viewStudentsStatementString = "SELECT students.idstudents, students.students_name FROM students";
	private static final String viewCoursesStatementString = "SELECT courses.idcourses, courses.name FROM courses ";
	private static final String updateGradeStatementString = "UPDATE enrolments SET enrolments.exams_idexams = ? WHERE enrolments.courses_idcourses =? and enrolments.students_idstudents = ?";
	
	public void insert(Enrolment enrolment) {
		Connection dbConnection = ConnectionToDb.getConnection();

		PreparedStatement insertStatement = null;
	
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, enrolment.getCourseId());
			insertStatement.setInt(2, enrolment.getStudentId());
			insertStatement.setInt(3, enrolment.getExamId());
			insertStatement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "EnrolmentDAO:insert " + e.getMessage());
		} finally {
			ConnectionToDb.close(insertStatement);
			ConnectionToDb.close(dbConnection);
		}
	}
	
	public ResultSet viewStudents() {
		Connection dbConnection = ConnectionToDb.getConnection();
		PreparedStatement viewStatement = null;
		ResultSet rs = null;
		try {
			viewStatement = dbConnection.prepareStatement(viewStudentsStatementString);
			rs = viewStatement.executeQuery();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "EnrolmentDAO:view " + e.getMessage());
		}
		return rs;
	}
	
	public ResultSet viewCourses() {
		Connection dbConnection = ConnectionToDb.getConnection();
		PreparedStatement viewStatement = null;
		ResultSet rs = null;
		try {
			viewStatement = dbConnection.prepareStatement(viewCoursesStatementString);
			rs = viewStatement.executeQuery();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "EnrolmentDAO:view " + e.getMessage());
		}
		return rs;
	}
	
	public void updateGrade(Enrolment enrol) {
		Connection dbConnection = ConnectionToDb.getConnection();
		PreparedStatement updateStatement = null;
		try {
			updateStatement = dbConnection.prepareStatement(updateGradeStatementString, Statement.RETURN_GENERATED_KEYS);
			updateStatement.setInt(1, enrol.getExamId());
			updateStatement.setInt(2, enrol.getCourseId());
			updateStatement.setInt(3, enrol.getStudentId());
			updateStatement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDAO:updateStudent " + e.getMessage());
		} finally {
			ConnectionToDb.close(updateStatement);
			ConnectionToDb.close(dbConnection);
		}
	}

}
