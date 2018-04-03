package dal;

public class Enrolment {
	private int courseId;
	private int studentId;
	private int examId;
	public Enrolment(int id, int courseId, int studentId, int examId) {
		super();
		this.courseId = courseId;
		this.studentId = studentId;
		this.examId = examId;
	}
	public Enrolment(int courseId, int studentId, int examId) {
		super();
		this.courseId = courseId;
		this.studentId = studentId;
		this.examId = examId;
	}
	public Enrolment() {
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	@Override
	public String toString() {
		return "Enrolment [courseId=" + courseId + ", studentId=" + studentId + ", examId=" + examId
				+ "]";
	}
}
