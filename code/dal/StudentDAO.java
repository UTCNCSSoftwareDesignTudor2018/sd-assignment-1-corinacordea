package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDAO  {
	
	protected static final Logger LOGGER = Logger.getLogger(StudentDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO students (idstudents, students_name, students_card_number, students_personal_numerical_code, students_address, students_group, students_username, students_password) VALUES (?,?,?,?,?,?,?,?)";
	private static final String findStatementString = "SELECT * FROM students where students.students_username = ? and students.students_password = ?";
	private static final String findStudentStatementString = "SELECT * FROM students where students.idstudents = ?";
	private static final String deleteStatementString = "DELETE FROM students where idstudents = ?";
	private static final String updateStudentStatementString = "UPDATE students SET students.students_group = ? WHERE students.idstudents = ?";
	private static final String updateStatementString = "UPDATE students SET students.students_name = ?, students.students_card_number = ?, students.students_personal_numerical_code = ?, students.students_address = ?, students.students_group = ?, students.students_username = ?, students.students_password = ? WHERE students.idstudents = ?";
	private static final String viewStatementString = "SELECT students.idstudents, students.students_name, students.students_card_number, students.students_personal_numerical_code, students.students_address, students.students_group, students.students_username, students.students_password FROM students";

	
	public Student findStudent(String username, String password) {
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
			if(resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt("idstudents"));
				student.setName(resultSet.getString("students_name"));
				student.setAddress(resultSet.getString("students_address"));
				student.setCardNumber(resultSet.getString("students_card_number"));
				student.setPersonalNumericalCode(resultSet.getString("students_personal_numerical_code"));
				student.setGroup(resultSet.getString("students_group"));
				student.setUsername(username);
				student.setPassword(password);
				return student;
			}
		
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDAO:find " + e.getMessage());
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
			LOGGER.log(Level.WARNING, "StudentDAO:view " + e.getMessage());
		} 
		return rs;
		
	}

	public void insert(Student student) {
		Connection dbConnection = ConnectionToDb.getConnection();

		PreparedStatement insertStatement = null;
	
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, student.getId());
			insertStatement.setString(2, student.getName());
			insertStatement.setString(3, student.getCardNumber());
			insertStatement.setString(4, student.getPersonalNumericalCode());
			insertStatement.setString(5, student.getAddress());
			insertStatement.setString(6, student.getGroup());
			insertStatement.setString(7, student.getUsername());
			insertStatement.setString(8, student.getPassword());
			insertStatement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDAO:insert " + e.getMessage());
		} finally {
			ConnectionToDb.close(insertStatement);
			ConnectionToDb.close(dbConnection);
		}
	}

	public void updateStudent(Student student) {
		Connection dbConnection = ConnectionToDb.getConnection();
		PreparedStatement updateStatement = null;
		try {
			updateStatement = dbConnection.prepareStatement(updateStudentStatementString, Statement.RETURN_GENERATED_KEYS);
			updateStatement.setString(1, student.getGroup());
			updateStatement.setInt(2, student.getId());
			updateStatement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDAO:updateStudent " + e.getMessage());
		} finally {
			ConnectionToDb.close(updateStatement);
			ConnectionToDb.close(dbConnection);
		}
	}
	
	public void update (Student student) {
		Connection dbConnection = ConnectionToDb.getConnection();

		PreparedStatement updateStatement = null;
		try {
			updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
			updateStatement.setString(1, student.getName());	
			updateStatement.setString(2, student.getCardNumber());
			updateStatement.setString(3, student.getPersonalNumericalCode());
			updateStatement.setString(4, student.getAddress());
			updateStatement.setString(5, student.getGroup());
			updateStatement.setString(6, student.getUsername());
			updateStatement.setString(7, student.getPassword());
			updateStatement.setInt(8, student.getId());
			updateStatement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDAO:update " + e.getMessage());
		} finally {
			ConnectionToDb.close(updateStatement);
			ConnectionToDb.close(dbConnection);
		}
	}

	public void delete(Student student) {
		Connection dbConnection = ConnectionToDb.getConnection();

		PreparedStatement deleteStatement = null;
		try {
			deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
			deleteStatement.setInt(1, student.getId());
			deleteStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDAO:delete " + e.getMessage());
		} finally {
			ConnectionToDb.close(deleteStatement);
			ConnectionToDb.close(dbConnection);
		}
	}
	
	public Student findById(int studentId) {
		Student toReturn = null;

		Connection dbConnection = ConnectionToDb.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStudentStatementString);
			findStatement.setInt(1, studentId);
			rs = findStatement.executeQuery();
			rs.next();

			String studentName = rs.getString("students_name");
			String studentCard = rs.getString("students_card_number");
			String studentNumber = rs.getString("students_personal_numerical_code");
			String studentAddress = rs.getString("students_address");
			String studentGroup = rs.getString("students_group");
			String studentUsername = rs.getString("students_username");
			String studentPassword = rs.getString("students_password");
			toReturn = new Student(studentId, studentName, studentCard, studentNumber, studentAddress, studentGroup, studentUsername, studentPassword);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDAO:findById " + e.getMessage());
		} finally {
			ConnectionToDb.close(rs);
			ConnectionToDb.close(findStatement);
			ConnectionToDb.close(dbConnection);
		}
		return toReturn;
	}
}

