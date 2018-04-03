package bll;

import java.util.ArrayList;
import java.util.List;

import dal.Student;
import dal.StudentDAO;


public class StudentBLL {
	private StudentDAO studentDAO = new StudentDAO();
	private List<Validator<Student>> validators;
	public StudentBLL() {
		super();
		validators = new ArrayList<Validator<Student>>();
		validators.add(new NameValidator());
	}
	
	public ArrayList<String> findStudent(String username, String password) {
		Student s = studentDAO.findStudent(username, password);
		ArrayList<String> result = new ArrayList<String>();
		result.add(String.valueOf(s.getId()));
		result.add(s.getName());
		result.add(s.getCardNumber());
		result.add(s.getPersonalNumericalCode());
		result.add(s.getAddress());
		result.add(s.getGroup());
		return result;	
	}
	
	public void updateStudent(int id, String name, String cardNumber, String code, String address, String group, String username, String password) {
		Student student = new Student(id, name, cardNumber, code, address, group, username, password);
		studentDAO.update(student);
	}
	
	public void insertStudent(int id, String name, String cardNumber, String code, String address, String group, String username, String password) {
		Student student = new Student(id, name, cardNumber, code, address, group, username, password);
		for (Validator<Student> v : validators) {
			v.validate(student);
		}
		studentDAO.insert(student);
	}
}
