package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import bll.StudentBLL;

public class StudentController {
	private ActionListener viewButtonActionListener;
	private ActionListener updateButtonActionListener;
	private ActionListener saveDataButtonActionListener;
	private StudentView studentView;
	
	public StudentController(StudentView sv) {
		super();
		this.studentView = sv;
	}
	
	public void control(String username, String password){
		viewButtonActionListener=new ActionListener(){
			public void actionPerformed(ActionEvent event){
				StudentBLL student = new StudentBLL();
				ArrayList<String> data = student.findStudent(username, password);
				studentView.getViewPanel().setVisible(true);
				studentView.getStudentIdTextField().setEditable(false);
				studentView.getStudentPanel().add(studentView.getViewPanel());
				studentView.getViewPanel().add(studentView.getUpdateButton());
				studentView.getStudentFrame().repaint();
				studentView.getStudentIdTextField().setText(data.get(0));
				studentView.getStudentNameTextField().setText(data.get(1));
				studentView.getStudentCardNumberTextField().setText(data.get(2));
				studentView.getStudentPersonalNumericalCodeTextField().setText(data.get(3));
				studentView.getStudentAddressTextField().setText(data.get(4));
				studentView.getStudentGroupTextField().setText(data.get(5));
				}
			};
		studentView.getViewButton().addActionListener(viewButtonActionListener);
		
		updateButtonActionListener=new ActionListener(){
			public void actionPerformed(ActionEvent event){
				int id = Integer.parseInt(studentView.getStudentIdTextField().getText());
				String name = studentView.getStudentNameTextField().getText();
				String cardNumber = studentView.getStudentCardNumberTextField().getText();
				String code = studentView.getStudentPersonalNumericalCodeTextField().getText();
				String address = studentView.getStudentAddressTextField().getText();
				String group = studentView.getStudentGroupTextField().getText();
				StudentBLL student = new StudentBLL();
				student.updateStudent(id, name, cardNumber, code, address, group, username, password);
				studentView.getViewPanel().setVisible(true);
				studentView.getStudentPanel().add(studentView.getViewPanel());
				studentView.getStudentFrame().repaint();
				}
			};
		studentView.getUpdateButton().addActionListener(updateButtonActionListener);
	}
	public void createAccount() {
		saveDataButtonActionListener=new ActionListener(){
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent event){
				StudentBLL student = new StudentBLL();
				student.insertStudent(
				Integer.parseInt(studentView.getStudentIdTextField().getText()),
				studentView.getStudentNameTextField().getText(),
				studentView.getStudentCardNumberTextField().getText(),
				studentView.getStudentPersonalNumericalCodeTextField().getText(),
				studentView.getStudentAddressTextField().getText(),
				studentView.getStudentGroupTextField().getText(),
				studentView.getStudentUsernameTextField().getText(),
				studentView.getStudentPasswordField().getText());
				studentView.getStudentFrame().dispose();
				}
			};
		studentView.getSaveDataButton().addActionListener(saveDataButtonActionListener);
	}
	
}
