package presentation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import bll.StudentBLL;
import bll.TeacherBLL;



public class MainController {
	private ActionListener loginButtonActionListener;
	private ActionListener createAccountButtonActionListener;
	private Start start;
	private String user;
	private String password;
	
	public MainController() {
		super();
	}

	public MainController(Start start) {
		super();
		this.start = start;
	}
	
	public void control(){
		loginButtonActionListener=new ActionListener(){
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent event){
				user = start.getUsernameTextField().getText();
				password = start.getPasswordField().getText();
					if(start.getStudentButton().isSelected()) {
						StudentBLL student = new StudentBLL();
						try {
							if(!student.findStudent(user, password).isEmpty()) {
								StudentView sv = new StudentView();
								sv.getStudentFrame().setVisible(true);
								sv.getStudentPanel().add(sv.getViewButton());
								StudentController studentController = new StudentController(sv);
								studentController.control(user, password);
							}
						}
						catch (Exception e) {
							JOptionPane.showMessageDialog(start.getFrame(),"Wrong username or password!");
						}
					}
					else if(start.getTeacherButton().isSelected()) {
						TeacherBLL teacher = new TeacherBLL();
						try {
							if(!teacher.findTeacher(user, password).isEmpty()) {
								TeacherView tv = new TeacherView();
								tv.getTeacherFrame().setVisible(true);
								TeacherController teacherController = new TeacherController(tv);
								teacherController.control(user, password);
							}
						}
						catch (Exception e) {
							JOptionPane.showMessageDialog(start.getFrame(),"Wrong username or password!");
						}
					}
				}
			};
		start.getLoginButton().addActionListener(loginButtonActionListener);
		
		createAccountButtonActionListener=new ActionListener(){
			public void actionPerformed(ActionEvent event){
					if(start.getStudentButton().isSelected()) {
						
								StudentView sv = new StudentView();
								sv.getStudentFrame().setVisible(true);
								sv.getViewPanel().setVisible(true);
								sv.getViewPanel().add(sv.getStudentUsername());
								sv.getViewPanel().add(sv.getStudentUsernameTextField());
								sv.getViewPanel().add(sv.getStudentPassword());
								sv.getViewPanel().add(sv.getStudentPasswordField());
								sv.getViewPanel().add(sv.getSaveDataButton());
								sv.getStudentPanel().add(sv.getViewPanel());
								StudentController studentController = new StudentController(sv);
								studentController.createAccount();
					}
					else if(start.getTeacherButton().isSelected()) {
								TeacherView tv = new TeacherView();
								tv.createAccount();
								TeacherController teacherController = new TeacherController(tv);
								teacherController.createAccount();
					}
				}
			};
		start.getCreateAccountButton().addActionListener(createAccountButtonActionListener);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
