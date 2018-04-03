package dal;

public class Student {
	private int id;
	private String name;
	private String address;
	private String username;
	private String password;
	private String group;
	private String cardNumber;
	private String personalNumericalCode;
	
	public Student() {
		super();
	}
	public Student(int id, String name, String cardNumber, String personalNumericalCode, String address, String group, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.username = username;
		this.password = password;
		this.group = group;
		this.cardNumber = cardNumber;
		this.personalNumericalCode = personalNumericalCode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getPersonalNumericalCode() {
		return personalNumericalCode;
	}
	public void setPersonalNumericalCode(String personalNumericalCode) {
		this.personalNumericalCode = personalNumericalCode;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", username=" + username
				+ ", password=" + password + ", group=" + group + ", cardNumber=" + cardNumber
				+ ", personalNumericalCode=" + personalNumericalCode + "]";
	}
}
