package TranHieu.FinalQuanLySinhVien.BO;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

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
	@NotNull(message = "Time Start can't be empty")
//	@Temporal(TemporalType.DATE)
	@Future(message = "can't set time in the past")
	private Date timeStart;
	
	@Column(name="timeEnd")
	@NotNull(message = "Time End can't be empty")
//	@Temporal(TemporalType.DATE)
	@Future(message="can't set time in the past")
	private Date timeEnd;
	
	@Column(name="teacher")
	@NotNull(message = "Name teacher can't be empty")
	@Size(min=2,max=15,message = "Name teacher should be than two")
	private String teacher;
	
	@Column(name="scoreStudent")
	@NotNull(message = "Score can't be empty")
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
