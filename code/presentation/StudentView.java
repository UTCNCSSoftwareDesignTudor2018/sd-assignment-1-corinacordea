package presentation;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class StudentView {
	private JFrame studentFrame;
	private JPanel studentPanel;
	private JPanel viewPanel;
	private JButton viewButton;
	private JButton updateButton;
	private JButton saveDataButton;
	
	private JLabel studentId;
	private JLabel studentName;
	private JLabel studentCardNumber;
	private JLabel studentPersonalNumericalCode;
	private JLabel studentAddress;
	private JLabel studentGroup;
	private JLabel studentUsername;
	private JLabel studentPassword;
	
	private JTextField studentIdTextField;
	private JTextField studentNameTextField;
	private JTextField studentCardNumberTextField;
	private JTextField studentPersonalNumericalCodeTextField;
	private JTextField studentAddressTextField;
	private JTextField studentGroupTextField;
	private JTextField studentUsernameTextField;
	private JPasswordField studentPasswordField;
	
	public StudentView() {
		initialize();
	}
	private void initialize() {
		studentFrame = new JFrame("Student");
		studentFrame.setBounds(0, 0, 600, 400);
		studentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		studentFrame.setLocationRelativeTo(null);
		studentFrame.getContentPane().setLayout(null);
		studentPanel = new JPanel();
		studentPanel.setLayout(null);
		studentPanel.setBounds(0, 0, 600, 400);
		studentPanel.setVisible(true);
		viewPanel = new JPanel();
		viewPanel.setLayout(null);
		viewPanel.setBounds(0, 50, 200, 350);
		viewButton = new JButton("View Data");
		viewButton.setBounds(35, 20, 130, 20);
		updateButton = new JButton("Update Data");
		updateButton.setBounds(35, 260, 130, 20);
		studentId = new JLabel("Id");
		studentId.setBounds(20, 50, 90, 20);
		viewPanel.add(studentId);
		studentIdTextField = new JTextField();
		studentIdTextField.setBounds(120, 50, 70, 20);
		viewPanel.add(studentIdTextField);
		studentName = new JLabel("Name");
		studentName.setBounds(20, 80, 90, 20);
		viewPanel.add(studentName);
		studentNameTextField = new JTextField();
		studentNameTextField.setBounds(120, 80, 70, 20);
		viewPanel.add(studentNameTextField);
		studentCardNumber = new JLabel("Card number");
		studentCardNumber.setBounds(20, 110, 90, 20);
		viewPanel.add(studentCardNumber);
		studentCardNumberTextField = new JTextField();
		studentCardNumberTextField.setBounds(120, 110, 70, 20);
		viewPanel.add(studentCardNumberTextField);
		studentPersonalNumericalCode = new JLabel("Numerical code");
		studentPersonalNumericalCode.setBounds(20, 140, 90, 20);
		viewPanel.add(studentPersonalNumericalCode);
		studentPersonalNumericalCodeTextField = new JTextField();
		studentPersonalNumericalCodeTextField.setBounds(120, 140, 70, 20);
		viewPanel.add(studentPersonalNumericalCodeTextField);
		studentAddress = new JLabel("Address");
		studentAddress.setBounds(20, 170, 90, 20);
		viewPanel.add(studentAddress);
		studentAddressTextField = new JTextField();
		studentAddressTextField.setBounds(120, 170, 70, 20);
		viewPanel.add(studentAddressTextField);
		studentGroup = new JLabel("Group");
		studentGroup.setBounds(20, 200, 90, 20);
		viewPanel.add(studentGroup);
		studentGroupTextField = new JTextField();
		studentGroupTextField.setBounds(120, 200, 70, 20);
		viewPanel.add(studentGroupTextField);
		studentUsername = new JLabel("Username");
		studentUsername.setBounds(20, 230, 90, 20);
		studentUsernameTextField = new JTextField();
		studentUsernameTextField.setBounds(120, 230, 70, 20);
		studentPassword = new JLabel("Password");
		studentPassword.setBounds(20, 260, 90, 20);
		studentPasswordField = new JPasswordField();
		studentPasswordField.setBounds(120, 260, 70, 20);
		saveDataButton = new JButton("Save Data");
		saveDataButton.setBounds(35, 10, 130, 20);
		studentFrame.getContentPane().add(studentPanel);	
	}
	public JFrame getStudentFrame() {
		return studentFrame;
	}
	public void setStudentFrame(JFrame studentFrame) {
		this.studentFrame = studentFrame;
	}
	public JButton getViewButton() {
		return viewButton;
	}
	public void setViewButton(JButton viewButton) {
		this.viewButton = viewButton;
	}
	public JPanel getStudentPanel() {
		return studentPanel;
	}
	public void setStudentPanel(JPanel studentPanel) {
		this.studentPanel = studentPanel;
	}
	public JLabel getStudentId() {
		return studentId;
	}
	public void setStudentId(JLabel studentId) {
		this.studentId = studentId;
	}
	public JLabel getStudentName() {
		return studentName;
	}
	public void setStudentName(JLabel studentName) {
		this.studentName = studentName;
	}
	public JLabel getStudentCardNumber() {
		return studentCardNumber;
	}
	public void setStudentCardNumber(JLabel studentCardNumber) {
		this.studentCardNumber = studentCardNumber;
	}
	public JLabel getStudentPersonalNumericalCode() {
		return studentPersonalNumericalCode;
	}
	public void setStudentPersonalNumericalCode(JLabel studentPersonalNumericalCode) {
		this.studentPersonalNumericalCode = studentPersonalNumericalCode;
	}
	public JLabel getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(JLabel studentAddress) {
		this.studentAddress = studentAddress;
	}
	public JLabel getStudentGroup() {
		return studentGroup;
	}
	public void setStudentGroup(JLabel studentGroup) {
		this.studentGroup = studentGroup;
	}
	public JTextField getStudentIdTextField() {
		return studentIdTextField;
	}
	public void setStudentIdTextField(JTextField studentIdTextField) {
		this.studentIdTextField = studentIdTextField;
	}
	public JTextField getStudentNameTextField() {
		return studentNameTextField;
	}
	public void setStudentNameTextField(JTextField studentNameTextField) {
		this.studentNameTextField = studentNameTextField;
	}
	public JTextField getStudentPersonalNumericalCodeTextField() {
		return studentPersonalNumericalCodeTextField;
	}
	public void setStudentPersonalNumericalCodeTextField(JTextField studentPersonalNumericalCodeTextField) {
		this.studentPersonalNumericalCodeTextField = studentPersonalNumericalCodeTextField;
	}
	public JTextField getStudentAddressTextField() {
		return studentAddressTextField;
	}
	public void setStudentAddressTextField(JTextField studentAddressTextField) {
		this.studentAddressTextField = studentAddressTextField;
	}
	public JTextField getStudentGroupTextField() {
		return studentGroupTextField;
	}
	public void setStudentGroupTextField(JTextField studentGroupTextField) {
		this.studentGroupTextField = studentGroupTextField;
	}
	public JPanel getViewPanel() {
		return viewPanel;
	}
	public void setViewPanel(JPanel viewPanel) {
		this.viewPanel = viewPanel;
	}
	public JTextField getStudentCardNumberTextField() {
		return studentCardNumberTextField;
	}
	public void setStudentCardNumberTextField(JTextField studentCardNumberTextField) {
		this.studentCardNumberTextField = studentCardNumberTextField;
	}
	public JButton getUpdateButton() {
		return updateButton;
	}
	public void setUpdateButton(JButton updateButton) {
		this.updateButton = updateButton;
	}
	public JLabel getStudentUsername() {
		return studentUsername;
	}
	public void setStudentUsername(JLabel studentUsername) {
		this.studentUsername = studentUsername;
	}
	public JLabel getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(JLabel studentPassword) {
		this.studentPassword = studentPassword;
	}
	public JTextField getStudentUsernameTextField() {
		return studentUsernameTextField;
	}
	public void setStudentUsernameTextField(JTextField studentUsernameTextField) {
		this.studentUsernameTextField = studentUsernameTextField;
	}
	public JPasswordField getStudentPasswordField() {
		return studentPasswordField;
	}
	public void setStudentPasswordField(JPasswordField studentPasswordField) {
		this.studentPasswordField = studentPasswordField;
	}
	public JButton getSaveDataButton() {
		return saveDataButton;
	}
	public void setSaveDataButton(JButton saveDataButton) {
		this.saveDataButton = saveDataButton;
	}

}
