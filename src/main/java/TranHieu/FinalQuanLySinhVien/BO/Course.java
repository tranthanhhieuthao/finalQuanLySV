package TranHieu.FinalQuanLySinhVien.BO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

@ManagedBean(name="courseBean")
@SessionScoped
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
	
	public Course() {
		
	}

	public Course(String nameCourse, float coefficient, String note) {
		this.nameCourse = nameCourse;
		this.coefficient = coefficient;
		this.note = note;
	}
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "course")
	private List<Score> listScore = new ArrayList<Score>();

	

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

	public List<Score> getListScore() {
		return listScore;
	}

	public void setListScore(List<Score> listScore) {
		this.listScore = listScore;
	}

	public void setNote(String note) {
		this.note = note;
	}



}
