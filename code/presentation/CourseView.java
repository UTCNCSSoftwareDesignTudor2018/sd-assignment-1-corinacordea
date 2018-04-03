package presentation;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class CourseView {
	
	private JFrame courseFrame;
	private JPanel coursePanel;
	private JTable courses;
	private JButton addCourseButton;
	private JLabel idTeacherLabel;
	private JTextField idTeacherTextField;
	private JLabel idCourseLabel;
	private JTextField idCourseTextField;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JTable viewTeachers;
	private JTable viewCourses;
	private JScrollPane scrollPane;
	private JScrollPane scrollPaneTeachers;
	private JScrollPane scrollPaneCourses;
	public CourseView() {
		initialize();
	}
	public void initialize() {
		courseFrame = new JFrame("Course");
		courseFrame.setBounds(0, 0, 600, 400);
		courseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		courseFrame.setLocationRelativeTo(null);
		courseFrame.getContentPane().setLayout(null);
		
		coursePanel = new JPanel();
		coursePanel.setLayout(null);
		coursePanel.setBounds(0, 0, 600, 400);
		coursePanel.setVisible(true);
				
		viewTeachers = new JTable();
		viewTeachers.setBounds(50, 90, 180, 100);
		viewTeachers.setVisible(true);
		coursePanel.add(viewTeachers);
		
		scrollPaneTeachers = new JScrollPane(viewTeachers);
		scrollPaneTeachers.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneTeachers.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneTeachers.setBounds(50, 90, 180, 100);
		courseFrame.add(scrollPaneTeachers);
		
		viewCourses = new JTable();
		viewCourses.setBounds(250, 90, 180, 100);
		viewCourses.setVisible(true);
		coursePanel.add(viewCourses);
		
		scrollPaneCourses = new JScrollPane(viewCourses);
		scrollPaneCourses.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneCourses.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneCourses.setBounds(250, 90, 180, 100);
		courseFrame.add(scrollPaneCourses);
		
		courses = new JTable();
		courses.setBounds(50, 210, 400, 150);
		courses.setVisible(true);
		coursePanel.add(courses);
		
		scrollPane = new JScrollPane(courses);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 210, 400, 150);
		courseFrame.add(scrollPane);
		
		addCourseButton = new JButton("Add course");
		addCourseButton.setBounds(250, 20, 100, 20);
		coursePanel.add(addCourseButton);
		
		idTeacherLabel = new JLabel("Teacher id");
		idTeacherLabel.setBounds(50, 20, 70, 20);
		coursePanel.add(idTeacherLabel);
		
		idTeacherTextField = new JTextField();
		idTeacherTextField.setBounds(130, 20, 70, 20);
		coursePanel.add(idTeacherTextField);
		
		idCourseLabel = new JLabel("Course id");
		idCourseLabel.setBounds(50, 40, 70, 20);
		coursePanel.add(idCourseLabel);
		
		idCourseTextField = new JTextField();
		idCourseTextField.setBounds(130, 40, 70, 20);
		coursePanel.add(idCourseTextField);
		
		nameLabel = new JLabel("Course name");
		nameLabel.setBounds(50, 60, 80, 20);
		coursePanel.add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(130, 60, 70, 20);
		coursePanel.add(nameTextField);
		
		courseFrame.add(coursePanel);	
		
	}
	public JFrame getCourseFrame() {
		return courseFrame;
	}
	public void setCourseFrame(JFrame courseFrame) {
		this.courseFrame = courseFrame;
	}
	public JPanel getCoursePanel() {
		return coursePanel;
	}
	public void setCoursePanel(JPanel coursePanel) {
		this.coursePanel = coursePanel;
	}
	public JTable getCourses() {
		return courses;
	}
	public void setCourses(JTable courses) {
		this.courses = courses;
	}
	public JButton getAddCourseButton() {
		return addCourseButton;
	}
	public void setAddCourseButton(JButton addCourseButton) {
		this.addCourseButton = addCourseButton;
	}
	public JLabel getIdTeacherLabel() {
		return idTeacherLabel;
	}
	public void setIdTeacherLabel(JLabel idTeacherLabel) {
		this.idTeacherLabel = idTeacherLabel;
	}
	public JTextField getIdTeacherTextField() {
		return idTeacherTextField;
	}
	public void setIdTeacherTextField(JTextField idTeacherTextField) {
		this.idTeacherTextField = idTeacherTextField;
	}
	public JLabel getIdCourseLabel() {
		return idCourseLabel;
	}
	public void setIdCourseLabel(JLabel idCourseLabel) {
		this.idCourseLabel = idCourseLabel;
	}
	public JTextField getIdCourseTextField() {
		return idCourseTextField;
	}
	public void setIdCourseTextField(JTextField idCourseTextField) {
		this.idCourseTextField = idCourseTextField;
	}
	public JLabel getNameLabel() {
		return nameLabel;
	}
	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}
	public JTextField getNameTextField() {
		return nameTextField;
	}
	public void setNameTextField(JTextField nameTextField) {
		this.nameTextField = nameTextField;
	}
	public JTable getViewTeachers() {
		return viewTeachers;
	}
	public void setViewTeachers(JTable viewTeachers) {
		this.viewTeachers = viewTeachers;
	}
	public JTable getViewCourses() {
		return viewCourses;
	}
	public void setViewCourses(JTable viewCourses) {
		this.viewCourses = viewCourses;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	public JScrollPane getScrollPaneTeachers() {
		return scrollPaneTeachers;
	}
	public void setScrollPaneTeachers(JScrollPane scrollPaneTeachers) {
		this.scrollPaneTeachers = scrollPaneTeachers;
	}
	public JScrollPane getScrollPaneCourses() {
		return scrollPaneCourses;
	}
	public void setScrollPaneCourses(JScrollPane scrollPaneCourses) {
		this.scrollPaneCourses = scrollPaneCourses;
	}

}
