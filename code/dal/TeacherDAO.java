package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeacherDAO {

	protected static final Logger LOGGER = Logger.getLogger(TeacherDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO teachers (idteachers, teachers_name, teachers_username, teachers_password) VALUES (?,?,?,?)";
	private static final String findStatementString = "SELECT * FROM teachers where teachers.teachers_username = ? and teachers.teachers_password = ?";
	private static final String viewStatementString = "SELECT students.idstudents, students.students_name, students.students_group, courses.idcourses, courses.name, exams.idexams, exams.grade FROM students, courses, exams, enrolments WHERE students.idstudents = enrolments.students_idstudents and courses.idcourses = enrolments.courses_idcourses and exams.idexams = enrolments.exams_idexams";
	private static final String viewCoursesStatementString = "SELECT courses.idcourses, courses.name, teachers.idteachers, teachers.teachers_name FROM courses, teachers WHERE teachers.idteachers = courses.teachers_idteachers";
	private static final String viewTeachersStatementString = "SELECT teachers.idteachers, teachers.teachers_name FROM teachers";
	
	public Teacher findTeacher(String username, String password) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = findStatementString;
		try {
			connection = ConnectionToDb.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(resultSet.getInt("idteachers"));
				teacher.setName(resultSet.getString("teachers_name"));
				teacher.setUsername(username);
				teacher.setPassword(password);
				return teacher;
			}

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDAO:findById " + e.getMessage());
		} finally {
			ConnectionToDb.close(resultSet);
			ConnectionToDb.close(statement);
			ConnectionToDb.close(connection);
		}
		return null;
	}

	public ResultSet view() {
		Connection dbConnection = ConnectionToDb.getConnection();
		PreparedStatement viewStatement = null;
		ResultSet rs = null;
		try {
			viewStatement = dbConnection.prepareStatement(viewStatementString);
			rs = viewStatement.executeQuery();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "TeacherDAO:view " + e.getMessage());
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
			LOGGER.log(Level.WARNING, "TeacherDAO:view " + e.getMessage());
		}
		return rs;
	}

	public ResultSet viewTeachers() {
		Connection dbConnection = ConnectionToDb.getConnection();
		PreparedStatement viewStatement = null;
		ResultSet rs = null;
		try {
			viewStatement = dbConnection.prepareStatement(viewTeachersStatementString);
			rs = viewStatement.executeQuery();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "TeacherDAO:view " + e.getMessage());
		}
		return rs;
	}
	
	public void insert(Teacher teacher) {
		Connection dbConnection = ConnectionToDb.getConnection();
		PreparedStatement insertStatement = null;

		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, teacher.getId());
			insertStatement.setString(2, teacher.getName());
			insertStatement.setString(3, teacher.getUsername());
			insertStatement.setString(4, teacher.getPassword());
			insertStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "TeacherDAO:insert " + e.getMessage());
		} finally {
			ConnectionToDb.close(insertStatement);
			ConnectionToDb.close(dbConnection);
		}
	}

}
