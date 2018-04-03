package presentation;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Start {
	private JFrame frame;
	private JPanel panel;
	private JRadioButton studentButton;
	private JRadioButton teacherButton;
	private ButtonGroup group;
	private JLabel username;
	private JLabel password;
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JButton createAccountButton;
	
	public Start() {
		initialize();
	}
	
	public static void main(String[] args) {
		
		Start start = new Start();
		start.frame.setVisible(true);
		MainController controller = new MainController(start);	
		controller.control();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
	    panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(100, 100, 600, 400);
		panel.setVisible(true);
		frame.getContentPane().add(panel);
		studentButton = new JRadioButton("Student");
		studentButton.setBounds(70, 0, 100, 15);
		teacherButton = new JRadioButton("Teacher");
		teacherButton.setBounds(170, 0, 100, 15);
		group = new ButtonGroup();
		group.add(studentButton);
		group.add(teacherButton);
		username = new JLabel("Username");
		username.setBounds(70, 30, 100, 15);
		password = new JLabel("Password");
		password.setBounds(70, 60, 100, 15);
		usernameTextField = new JTextField();
		usernameTextField.setBounds(170, 30, 100, 15);
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(170, 60, 100, 15);
	    loginButton = new JButton("Login");
		loginButton.setBounds(100, 90, 150, 25);
		createAccountButton = new JButton("Create Account");
		createAccountButton.setBounds(100, 120, 150, 25);
		panel.add(studentButton);
		panel.add(teacherButton);
		panel.add(username);
		panel.add(password);
		panel.add(usernameTextField);
		panel.add(passwordField);
		panel.add(loginButton);
		panel.add(createAccountButton);
		frame.repaint();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JRadioButton getStudentButton() {
		return studentButton;
	}

	public void setStudentButton(JRadioButton studentButton) {
		this.studentButton = studentButton;
	}

	public JRadioButton getTeacherButton() {
		return teacherButton;
	}

	public void setTeacherButton(JRadioButton teacherButton) {
		this.teacherButton = teacherButton;
	}

	public ButtonGroup getGroup() {
		return group;
	}

	public void setGroup(ButtonGroup group) {
		this.group = group;
	}

	public JLabel getUsername() {
		return username;
	}

	public void setUsername(JLabel username) {
		this.username = username;
	}

	public JLabel getPassword() {
		return password;
	}

	public void setPassword(JLabel password) {
		this.password = password;
	}

	public JTextField getUsernameTextField() {
		return usernameTextField;
	}

	public void setUsernameTextField(JTextField usernameTextField) {
		this.usernameTextField = usernameTextField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}

	public JButton getCreateAccountButton() {
		return createAccountButton;
	}

	public void setCreateAccountButton(JButton createAccountButton) {
		this.createAccountButton = createAccountButton;
	}
	
}
