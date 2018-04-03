package bll;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import dal.Course;
import dal.CourseDAO;
import dal.Student;
import dal.StudentDAO;
import dal.Teacher;
import dal.TeacherDAO;

public class TeacherBLL {
	private TeacherDAO teacherDAO = new TeacherDAO();
	private int reportNumber = 1;
	public TeacherBLL() {
		super();
	}
	
	public ArrayList<String> findTeacher(String username, String password) {
		Teacher teacher = teacherDAO.findTeacher(username, password);
		ArrayList<String> result = new ArrayList<String>();
		result.add(String.valueOf(teacher.getId()));
		result.add(teacher.getName());
		return result;	
	}
	
	public ResultSet viewStudents() {
		return teacherDAO.view();
	}
	
	public ResultSet viewCourses() {
		return teacherDAO.viewCourses();
	}
	
	public ResultSet viewTeachers() {
		return teacherDAO.viewTeachers();
	}
	
	public void deleteStudent(int id) {
		StudentDAO s = new StudentDAO();
		Student student = new Student();
		student.setId(id);
		s.delete(student);
	}
	
	public void updateStudent(int id, String group) {
		StudentDAO s = new StudentDAO();
		Student student = new Student();
		student.setId(id);
		student.setGroup(group);
		s.updateStudent(student);
	}
	
	public void insertTeacher(int id, String name, String username, String password) {
		Teacher teacher = new Teacher(id, name, username, password);
		teacherDAO.insert(teacher);
	}
	
	public void createReport(int studentId) {
		CourseDAO c = new CourseDAO();
		ArrayList<Course> courses = c.findCourses(studentId);
		StudentDAO s = new StudentDAO();
		Student student = s.findById(studentId);
		File report = new File("report" + reportNumber + ".txt");
		reportNumber++;
		try {
			if (report.exists() == false) {
				report.createNewFile();
			}
			PrintWriter out = new PrintWriter(report);
			for(Course course: courses) {
			out.append("Student name: " + student.getName() + " Student group: " + student.getGroup()
					+ " Course id: " + course.getId() + " Course name: " + course.getName() + "\r\n" );
			}
			out.close();
		} catch (IOException e) {
			System.out.println("Could not create file!");
		}
	}
}
