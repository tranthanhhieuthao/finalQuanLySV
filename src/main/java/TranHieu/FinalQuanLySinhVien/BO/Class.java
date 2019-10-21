package TranHieu.FinalQuanLySinhVien.BO;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name ="class")
public class Class {
	
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="timeClass")
	private DateFormat timeClass;
	
	@Column(name ="note")
	private String note;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name ="Student_Class",
	joinColumns = { @JoinColumn(name ="class_id")},
	inverseJoinColumns = { @JoinColumn(name ="student_id")})
	private List<Student> classStuden = new ArrayList<Student>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DateFormat getTimeClass() {
		return timeClass;
	}

	public void setTimeClass(DateFormat timeClass) {
		this.timeClass = timeClass;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<Student> getClassStuden() {
		return classStuden;
	}

	public void setClassStuden(List<Student> classStuden) {
		this.classStuden = classStuden;
	}
	
	

}
