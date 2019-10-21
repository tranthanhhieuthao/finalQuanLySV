package TranHieu.FinalQuanLySinhVien.BO;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "class")
public class Class {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

//	@Column(name = "timeClass")
//	private DateFormat timeClass;

	@Column(name = "nameClass")
	private String nameClass;

	@Column(name = "note")
	private String note;

	public Class(String nameClass, String note) {
		this.nameClass = nameClass;
		this.note = note;
	}

	public String getNameClass() {
		return nameClass;
	}

	public void setNameClass(String nameClass) {
		this.nameClass = nameClass;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Class", joinColumns = { @JoinColumn(name = "class_id") }, inverseJoinColumns = {
			@JoinColumn(name = "student_id") })
	private Set<Student> classStuden = new HashSet<Student>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public DateFormat getTimeClass() {
//		return timeClass;
//	}
//
//	public void setTimeClass(DateFormat timeClass) {
//		this.timeClass = timeClass;
//	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Set<Student> getClassStuden() {
		return classStuden;
	}

	public void setClassStuden(Set<Student> classStuden) {
		this.classStuden = classStuden;
	}

}
