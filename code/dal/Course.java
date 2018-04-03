package dal;

public class Course {
	private int id;
	private String name;
	private int teacherid;
	public Course(int id, String name, int teacherid) {
		super();
		this.id = id;
		this.name = name;
		this.teacherid = teacherid;
	}
	public Course(String name, int teacherid) {
		super();
		this.name = name;
		this.teacherid = teacherid;
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
	public int getTeacher() {
		return teacherid;
	}
	public void setTeacher(int teacherid) {
		this.teacherid = teacherid;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", teacher=" + teacherid + "]";
	}
}
