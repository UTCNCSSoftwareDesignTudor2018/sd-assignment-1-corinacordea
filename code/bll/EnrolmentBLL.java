package bll;

import java.sql.ResultSet;

import dal.Enrolment;
import dal.EnrolmentDAO;

public class EnrolmentBLL {
	private EnrolmentDAO enrolmentDAO = new EnrolmentDAO();
	public EnrolmentBLL() {
		super();
	}
	
	public void insert(int idcourse, int idstudent, int idexam) {
		Enrolment e = new Enrolment();
		e.setCourseId(idcourse);
		e.setStudentId(idstudent);
		e.setExamId(idexam);
		enrolmentDAO.insert(e);
	}
	
	public void updateGrade(int idcourse, int idstudent, int grade) {
		Enrolment e = new Enrolment();
		e.setCourseId(idcourse);
		e.setStudentId(idstudent);
		e.setExamId(grade);
		enrolmentDAO.updateGrade(e);
	}
	
	public ResultSet viewStudents() {
		return enrolmentDAO.viewStudents();
	}
	public ResultSet viewCourses() {
		return enrolmentDAO.viewCourses();
	}
	
}
