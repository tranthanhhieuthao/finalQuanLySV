package TranHieu.FinalQuanLySinhVien.BO;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;

@ManagedBean(name ="studentBean")
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
	private int phone;

	@Column(name = "email")
	private String email;

	@Column(name = "note")
	private String note;

//	@Column(name = "birthDay")
//	private DateFormat birthDay;
	
	public Student() {
		
	}
	
	
	public Student(String nameStudent, int age, String village, int phone, String email, String note) {
		this.nameStudent = nameStudent;
		this.age = age;
		this.village = village;
		this.phone = phone;
		this.email = email;
		this.note = note;
			}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Class", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = {
			@JoinColumn(name = "class_id") })
	private List<Class> studentClass = new ArrayList<Class>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Course", joinColumns = { @JoinColumn(name = "student_id")  }, inverseJoinColumns = {
			@JoinColumn(name = "course_id") })
	private Set<Course> studentCourse = new HashSet<Course>();

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

	public void setPhone(int phone) {
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

	public Set<Course> getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(Set<Course> studentCourse) {
		this.studentCourse = studentCourse;
	}

//	public DateFormat getBirthDay() {
//		return birthDay;
//	}
//
//	public void setBirthDay(DateFormat birthDay) {
//		this.birthDay = birthDay;
//	}

}
