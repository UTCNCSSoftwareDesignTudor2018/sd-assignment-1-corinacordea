package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bll.CourseBLL;
import bll.EnrolmentBLL;
import bll.TeacherBLL;

public class TeacherController {
	private TeacherView teacherView;
	private ActionListener viewButtonActionListener;
	private ActionListener deleteButtonActionListener;
	private ActionListener deleteStudentActionListener;
	private ActionListener updateButtonActionListener;
	private ActionListener updateStudentActionListener;
	private ActionListener enrolButtonActionListener;
	private ActionListener addCourseButtonActionListener;
	private ActionListener gradeButtonActionListener;
	private ActionListener saveDataButtonActionListener;
	private ActionListener reportButtonActionListener;
	private ActionListener reportStudentActionListener;
	public TeacherController(TeacherView tv) {
		super();
		this.teacherView = tv;
	}
	
	public void control(String username, String password){
		viewButtonActionListener=new ActionListener(){
			public void actionPerformed(ActionEvent event){
				teacherView.viewStudents();
				TeacherBLL teacher = new TeacherBLL();
				CreateTableModel model =new CreateTableModel();
				try {
					teacherView.getStudents().setModel(model.getTable(teacher.viewStudents()));
				} catch (Exception e) {
					e.printStackTrace();
				}
				teacherView.getViewFrame().setVisible(true);
			}
		};
		teacherView.getViewButton().addActionListener(viewButtonActionListener);
		
		updateButtonActionListener=new ActionListener(){
			public void actionPerformed(ActionEvent event){
				teacherView.updateStudent();
				TeacherBLL teacher = new TeacherBLL();
				CreateTableModel model =new CreateTableModel();
				try {				
					teacherView.getUpdateStudents().setModel(model.getTable(teacher.viewStudents()));
					updateStudentActionListener=new ActionListener(){
						public void actionPerformed(ActionEvent event){
							CreateTableModel model =new CreateTableModel();
							try {				
								int id = Integer.parseInt(teacherView.getUpdateTextField().getText());
								String group = teacherView.getUpdateGroupTextField().getText();
								teacher.updateStudent(id, group);
								teacherView.getUpdateStudents().setModel(model.getTable(teacher.viewStudents()));
							} catch (Exception e) {
								e.printStackTrace();
							}
							teacherView.getUpdateFrame().repaint();
						}
					};
					teacherView.getUpdateStudentButton().addActionListener(updateStudentActionListener);
				} catch (Exception e) {
					e.printStackTrace();
				}
				teacherView.getUpdateFrame().setVisible(true);
			}
		};
		teacherView.getUpdateButton().addActionListener(updateButtonActionListener);
		
		deleteButtonActionListener=new ActionListener(){
			public void actionPerformed(ActionEvent event){
				teacherView.deleteStudent();
				TeacherBLL teacher = new TeacherBLL();
				CreateTableModel model =new CreateTableModel();
				try {				
					teacherView.getDeleteStudents().setModel(model.getTable(teacher.viewStudents()));
					deleteStudentActionListener=new ActionListener(){
						public void actionPerformed(ActionEvent event){
							CreateTableModel model =new CreateTableModel();
							try {				
								int id = Integer.parseInt(teacherView.getDeleteTextField().getText());
								teacher.deleteStudent(id);
								teacherView.getDeleteStudents().setModel(model.getTable(teacher.viewStudents()));
							} catch (Exception e) {
								e.printStackTrace();
							}
							teacherView.getDeleteFrame().repaint();
						}
					};
					teacherView.getDeleteStudentButton().addActionListener(deleteStudentActionListener);
				} catch (Exception e) {
					e.printStackTrace();
				}
				teacherView.getDeleteFrame().setVisible(true);
			}
		};
		teacherView.getDeleteButton().addActionListener(deleteButtonActionListener);
	
		enrolButtonActionListener = new ActionListener(){
			public void actionPerformed(ActionEvent event){
				EnrolmentView ev = new EnrolmentView();
				ev.getEnrolFrame().setVisible(true);
				CreateTableModel model =new CreateTableModel();
				EnrolmentBLL enrol = new EnrolmentBLL();
				TeacherBLL teacher = new TeacherBLL();
				try {
					ev.getViewStudents().setModel(model.getTable(enrol.viewStudents()));
					ev.getViewCourses().setModel(model.getTable(enrol.viewCourses()));
					ev.getEnrolStudents().setModel(model.getTable(teacher.viewStudents()));
				} catch (Exception e) {
					e.printStackTrace();
				}
				EnrolmentController enrolmentController = new EnrolmentController(ev);
				enrolmentController.control();
			}
		};
		teacherView.getEnrollButton().addActionListener(enrolButtonActionListener);
		
		addCourseButtonActionListener = new ActionListener(){
			public void actionPerformed(ActionEvent event){
				CourseView cv = new CourseView();
				cv.getCourseFrame().setVisible(true);
				CreateTableModel model =new CreateTableModel();
				CourseBLL course = new CourseBLL();
				TeacherBLL teacher = new TeacherBLL();
				try {
					cv.getViewTeachers().setModel(model.getTable(teacher.viewTeachers()));
					cv.getViewCourses().setModel(model.getTable(course.viewCourses()));
					cv.getCourses().setModel(model.getTable(teacher.viewCourses()));
				} catch (Exception e) {
					e.printStackTrace();
				}
				CourseController courseController = new CourseController(cv);
				courseController.control();
			}
		};
		teacherView.getAddCourse().addActionListener(addCourseButtonActionListener);
		
		gradeButtonActionListener=new ActionListener(){
			private ActionListener gradeStudentActionListener;

			public void actionPerformed(ActionEvent event){
				teacherView.giveGrade();
				TeacherBLL teacher = new TeacherBLL();
				EnrolmentBLL enrol = new EnrolmentBLL();
				CreateTableModel model =new CreateTableModel();
				try {				
					teacherView.getGradeStudents().setModel(model.getTable(teacher.viewStudents()));
					gradeStudentActionListener=new ActionListener(){
						public void actionPerformed(ActionEvent event){
							CreateTableModel model =new CreateTableModel();
							try {				
								int idstudent = Integer.parseInt(teacherView.getIdStudentTextField().getText());
								int idcourse = Integer.parseInt(teacherView.getIdCourseTextField().getText());
								int grade = Integer.parseInt(teacherView.getGradeTextField().getText());
								enrol.updateGrade(idcourse, idstudent, grade);
								teacherView.getGradeStudents().setModel(model.getTable(teacher.viewStudents()));
							} catch (Exception e) {
								e.printStackTrace();
							}
							teacherView.getGradeFrame().repaint();
						}
					};
					teacherView.getAddGradeButton().addActionListener(gradeStudentActionListener);
				} catch (Exception e) {
					e.printStackTrace();
				}
				teacherView.getGradeFrame().setVisible(true);
			}
		};
		teacherView.getGiveGrade().addActionListener(gradeButtonActionListener);
		
		reportButtonActionListener=new ActionListener(){

			public void actionPerformed(ActionEvent event){
				teacherView.generateReport();;
				TeacherBLL teacher = new TeacherBLL();
				CreateTableModel model =new CreateTableModel();
				try {				
					teacherView.getStudentsReport().setModel(model.getTable(teacher.viewStudents()));
					reportStudentActionListener=new ActionListener(){
						public void actionPerformed(ActionEvent event){
							try {				
								int id = Integer.parseInt(teacherView.getReportTextField().getText());
								teacher.createReport(id);
							} catch (Exception e) {
								e.printStackTrace();
							}
							teacherView.getReportFrame().dispose();
						}
					};
					teacherView.getReportStudentButton().addActionListener(reportStudentActionListener);
				} catch (Exception e) {
					e.printStackTrace();
				}
				teacherView.getReportFrame().setVisible(true);
			}
		};
		teacherView.getGenerateReportButton().addActionListener(reportButtonActionListener);
		
	}
	
	public void createAccount() {
		saveDataButtonActionListener=new ActionListener(){
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent event){
				TeacherBLL teacher = new TeacherBLL();
				teacher.insertTeacher(
				Integer.parseInt(teacherView.getTeacherIdTextField().getText()),
				teacherView.getTeacherNameTextField().getText(),
				teacherView.getUsernameTextField().getText(),
				teacherView.getPasswordTextField().getText());
				teacherView.getAccountFrame().dispose();
				}
			};
		teacherView.getSaveDataButton().addActionListener(saveDataButtonActionListener);
	}

	public TeacherView getTeacherView() {
		return teacherView;
	}

	public void setTeacherView(TeacherView teacherView) {
		this.teacherView = teacherView;
	}
	
}
