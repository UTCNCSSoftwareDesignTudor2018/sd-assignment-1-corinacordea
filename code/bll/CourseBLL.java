package bll;

import java.sql.ResultSet;

import dal.Course;
import dal.CourseDAO;

public class CourseBLL {
	private CourseDAO CourseDAO = new CourseDAO();
	public CourseBLL() {
		super();
	}
	public ResultSet viewCourses() {
		return CourseDAO.viewCourses();
	}
	
	public void insertCourse(int idcourse, String name, int idteacher) {
		Course course = new Course(idcourse, name, idteacher);
		CourseDAO.insert(course);
	}
}
