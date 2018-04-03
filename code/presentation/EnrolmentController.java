package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bll.EnrolmentBLL;
import bll.TeacherBLL;

public class EnrolmentController {
	EnrolmentView enrolmentView = new EnrolmentView();
	private ActionListener enrolStudentActionListener;
	public EnrolmentController(EnrolmentView tv) {
		super();
		this.enrolmentView = tv;
	}
	
	public void control(){
		enrolStudentActionListener=new ActionListener(){
			public void actionPerformed(ActionEvent event){
				CreateTableModel model =new CreateTableModel();
				EnrolmentBLL enrol = new EnrolmentBLL();
				TeacherBLL teacher = new TeacherBLL();
				try {				
					int idstudent = Integer.parseInt(enrolmentView.getEnrolStudentTextField().getText());
					int idcourse = Integer.parseInt(enrolmentView.getEnrolCourseTextField().getText());
					enrol.insert(idcourse, idstudent, 11);
					enrolmentView.getEnrolStudents().setModel(model.getTable(teacher.viewStudents()));
				} catch (Exception e) {
					e.printStackTrace();
				}
				enrolmentView.getEnrolFrame().repaint();			
			}
		};
		enrolmentView.getEnrolStudentButton().addActionListener(enrolStudentActionListener);
	}
}
