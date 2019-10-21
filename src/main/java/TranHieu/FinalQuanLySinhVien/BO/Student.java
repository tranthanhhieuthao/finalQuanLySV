package TranHieu.FinalQuanLySinhVien.BO;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nameStudent")
	private String nameStudent;

	@Column(name = "age")
	private int age;

	@Column(name = "village")
	private String village;

	@Column(name = "phone")
	private double phone;

	@Column(name = "email")
	private String email;

	@Column(name = "note")
	private String note;

	@Column(name = "birthDay")
	private DateFormat birthDay;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Class", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = {
			@JoinColumn(name = "class_id") })
	private List<Class> studentClass = new ArrayList<Class>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Course", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = {
			@JoinColumn(name = "course_id") })
	private List<Course> studentCourse = new ArrayList<Course>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameStudent() {
		return nameStudent;
	}

	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public double getPhone() {
		return phone;
	}

	public void setPhone(double phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<Class> getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(List<Class> studentClass) {
		this.studentClass = studentClass;
	}

	public List<Course> getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(List<Course> studentCourse) {
		this.studentCourse = studentCourse;
	}

	public DateFormat getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(DateFormat birthDay) {
		this.birthDay = birthDay;
	}

}
