package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bll.CourseBLL;
import bll.TeacherBLL;

public class CourseController {
	CourseView courseView = new CourseView();
	private ActionListener addCourseActionListener;
	public CourseController(CourseView cv) {
		super();
		this.courseView = cv;
	}
	
	public void control(){
		addCourseActionListener=new ActionListener(){
			public void actionPerformed(ActionEvent event){
				CreateTableModel model =new CreateTableModel();
				CourseBLL course = new CourseBLL();
				TeacherBLL teacher = new TeacherBLL();
				try {				
					int idteacher = Integer.parseInt(courseView.getIdTeacherTextField().getText());
					String name = courseView.getNameTextField().getText();
					int idcourse = Integer.parseInt(courseView.getIdCourseTextField().getText());
					course.insertCourse(idcourse, name, idteacher);
					courseView.getViewCourses().setModel(model.getTable(course.viewCourses()));
					courseView.getCourses().setModel(model.getTable(teacher.viewCourses()));
				} catch (Exception e) {
					e.printStackTrace();
				}
				courseView.getCourseFrame().repaint();			
			}
		};
		courseView.getAddCourseButton().addActionListener(addCourseActionListener);
	}
}
