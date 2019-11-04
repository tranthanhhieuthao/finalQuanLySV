package TranHieu.FinalQuanLySinhVien.BO;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

@ManagedBean(name ="scoreBean")
@SessionScoped
@Entity
@Table(name="score")
public class Score {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="timeStart")
	private Date timeStart;
	
	@Column(name="timeEnd")
	private Date timeEnd;
	
	@Column(name="teacher")
	private String teacher;
	
	@Column(name="scoreStudent")
	private float scoreStudent;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="student1_id",nullable = false)
	private Student student;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="course1_id",nullable=false)
	private Course course;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="classStudent_id",nullable=false)
	private ClassStudent classStudent;
	
	public Score() {
		
	}
	
	
	public Score(Date timeStart, Date timeEnd, String teacher, float scoreStudent) {

		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.teacher = teacher;
		this.scoreStudent = scoreStudent;
	}


	public Date getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getScoreStudent() {
		return scoreStudent;
	}

	public void setScoreStudent(float scoreStudent) {
		this.scoreStudent = scoreStudent;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public ClassStudent getClassStudent() {
		return classStudent;
	}

	public void setClassStudent(ClassStudent classStudent) {
		this.classStudent = classStudent;
	}
	
	
	
	

}
