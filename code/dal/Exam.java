package dal;

public class Exam {
	private int id;
	private int grade;
	public Exam(int id, int grade) {
		super();
		this.id = id;
		this.grade = grade;
	}
	public Exam(int grade) {
		super();
		this.grade = grade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Exam [id=" + id + ", grade=" + grade + "]";
	}
}
