package TranHieu.FinalQuanLySinhVien.BO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nameCourse")
	private String nameCourse;

	@Column(name = "coefficient")
	private float coefficient;

	@Column(name = "note")
	private String note;

	public Course(String nameCourse, float coefficient, String note) {
		this.nameCourse = nameCourse;
		this.coefficient = coefficient;
		this.note = note;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Course", joinColumns = { @JoinColumn(name = "course_id") }, inverseJoinColumns = {
			@JoinColumn(name = "student_id") })
	private Set<Student> courseStudent = new HashSet<Student>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameCourse() {
		return nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}

	public float getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Set<Student> getCourseStudent() {
		return courseStudent;
	}

	public void setCourseStudent(Set<Student> courseStudent) {
		this.courseStudent = courseStudent;
	}

}
