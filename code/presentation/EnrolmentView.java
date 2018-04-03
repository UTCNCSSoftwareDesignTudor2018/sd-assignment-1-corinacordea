package presentation;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class EnrolmentView {
	
	private JFrame enrolFrame;
	private JPanel enrolPanel;
	private JTable enrolStudents;
	private JButton enrolStudentButton;
	private JLabel enrolStudentLabel;
	private JTextField enrolStudentTextField;
	private JLabel enrolCourseLabel;
	private JTextField enrolCourseTextField;
	private JTable viewStudents;
	private JTable viewCourses;
	private JScrollPane scrollPane;
	private JScrollPane scrollPaneStudents;
	private JScrollPane scrollPaneCourses;
	public EnrolmentView() {
		initialize();
	}
	public void initialize() {
		enrolFrame = new JFrame("Enroll");
		enrolFrame.setBounds(0, 0, 600, 400);
		enrolFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		enrolFrame.setLocationRelativeTo(null);
		enrolFrame.getContentPane().setLayout(null);
		
		enrolPanel = new JPanel();
		enrolPanel.setLayout(null);
		enrolPanel.setBounds(0, 0, 600, 400);
		enrolPanel.setVisible(true);
				
		viewStudents = new JTable();
		viewStudents.setBounds(50, 90, 180, 100);
		viewStudents.setVisible(true);
		enrolPanel.add(viewStudents);
		
		scrollPaneStudents = new JScrollPane(viewStudents);
		scrollPaneStudents.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneStudents.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneStudents.setBounds(50, 90, 180, 100);
		enrolFrame.add(scrollPaneStudents);
		
		viewCourses = new JTable();
		viewCourses.setBounds(250, 90, 180, 100);
		viewCourses.setVisible(true);
		enrolPanel.add(viewCourses);
		
		scrollPaneCourses = new JScrollPane(viewCourses);
		scrollPaneCourses.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneCourses.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneCourses.setBounds(250, 90, 180, 100);
		enrolFrame.add(scrollPaneCourses);
		
		enrolStudents = new JTable();
		enrolStudents.setBounds(50, 210, 400, 150);
		enrolStudents.setVisible(true);
		enrolPanel.add(enrolStudents);
		
		scrollPane = new JScrollPane(enrolStudents);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 210, 400, 150);
		enrolFrame.add(scrollPane);
		
		enrolStudentButton = new JButton("Enroll");
		enrolStudentButton.setBounds(250, 20, 100, 20);
		enrolPanel.add(enrolStudentButton);
		
		enrolStudentLabel = new JLabel("Student id");
		enrolStudentLabel.setBounds(50, 20, 70, 20);
		enrolPanel.add(enrolStudentLabel);
		
		enrolStudentTextField = new JTextField();
		enrolStudentTextField.setBounds(130, 20, 70, 20);
		enrolPanel.add(enrolStudentTextField);
		
		enrolCourseLabel = new JLabel("Course id");
		enrolCourseLabel.setBounds(50, 40, 70, 20);
		enrolPanel.add(enrolCourseLabel);
		
		enrolCourseTextField = new JTextField();
		enrolCourseTextField.setBounds(130, 40, 70, 20);
		enrolPanel.add(enrolCourseTextField);
		enrolFrame.add(enrolPanel);	
		
	}
	public JFrame getEnrolFrame() {
		return enrolFrame;
	}
	public void setEnrolFrame(JFrame enrolFrame) {
		this.enrolFrame = enrolFrame;
	}
	public JPanel getEnrolPanel() {
		return enrolPanel;
	}
	public void setEnrolPanel(JPanel enrolPanel) {
		this.enrolPanel = enrolPanel;
	}
	public JTable getEnrolStudents() {
		return enrolStudents;
	}
	public void setEnrolStudents(JTable enrolStudents) {
		this.enrolStudents = enrolStudents;
	}
	public JButton getEnrolStudentButton() {
		return enrolStudentButton;
	}
	public void setEnrolStudentButton(JButton enrolStudentButton) {
		this.enrolStudentButton = enrolStudentButton;
	}
	public JLabel getEnrolStudentLabel() {
		return enrolStudentLabel;
	}
	public void setEnrolStudentLabel(JLabel enrolStudentLabel) {
		this.enrolStudentLabel = enrolStudentLabel;
	}
	public JTextField getEnrolStudentTextField() {
		return enrolStudentTextField;
	}
	public void setEnrolStudentTextField(JTextField enrolStudentTextField) {
		this.enrolStudentTextField = enrolStudentTextField;
	}
	public JLabel getEnrolCourseLabel() {
		return enrolCourseLabel;
	}
	public void setEnrolCourseLabel(JLabel enrolCourseLabel) {
		this.enrolCourseLabel = enrolCourseLabel;
	}
	public JTextField getEnrolCourseTextField() {
		return enrolCourseTextField;
	}
	public void setEnrolCourseTextField(JTextField enrolCourseTextField) {
		this.enrolCourseTextField = enrolCourseTextField;
	}
	public JTable getViewStudents() {
		return viewStudents;
	}
	public void setViewStudents(JTable viewStudents) {
		this.viewStudents = viewStudents;
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
	public JScrollPane getScrollPaneStudents() {
		return scrollPaneStudents;
	}
	public void setScrollPaneStudents(JScrollPane scrollPaneStudents) {
		this.scrollPaneStudents = scrollPaneStudents;
	}
	public JScrollPane getScrollPaneCourses() {
		return scrollPaneCourses;
	}
	public void setScrollPaneCourses(JScrollPane scrollPaneCourses) {
		this.scrollPaneCourses = scrollPaneCourses;
	}
	
}
