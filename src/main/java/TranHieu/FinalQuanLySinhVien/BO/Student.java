package TranHieu.FinalQuanLySinhVien.BO;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

@ManagedBean(name ="studentBean")
@SessionScoped
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

	@Column(name = "birthDay")
	private Date birthDay;
	
	@Column(name ="avgStudent")
	private float avgStudent;

	//nen them contructor khong tham so de khoi tao Entity
	public Student() {
		
	}
			
	public Student( String nameStudent, int age, String village, int phone, String email, String note,
			Date birthDay, float avgStudent) {
		this.nameStudent = nameStudent;
		this.age = age;
		this.village = village;
		this.phone = phone;
		this.email = email;
		this.note = note;
		this.birthDay = birthDay;
		this.avgStudent = avgStudent;
	}

//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(name = "Student_Class", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = {
//			@JoinColumn(name = "class_id") })
//	private Set<ClassStudent> studentClass = new HashSet<ClassStudent>();

	@OneToMany(fetch = FetchType.EAGER,mappedBy = "student")
	private Set<Score> listScore = new HashSet<Score>();


	public int getId() {
		return id;
	}

	public Set<Score> getListScore() {
		return listScore;
	}

	public void setListScore(Set<Score> listScore) {
		this.listScore = listScore;
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

	public int getPhone() {
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

//	public Set<ClassStudent> getStudentClass() {
//		return studentClass;
//	}
//
//	public void setStudentClass(Set<ClassStudent> studentClass) {
//		this.studentClass = studentClass;
//	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	public float getAvgStudent() {
		return avgStudent;
	}


	public void setAvgStudent(float avgStudent) {
		this.avgStudent = avgStudent;
	}

}
