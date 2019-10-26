package TranHieu.FinalQuanLySinhVien.BO;

import javax.persistence.*;

@Entity
@Table(name="score")
public class Score {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="scoreStudent")
	private float scoreStudent;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="student1_id",nullable = false)
	private Student student;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="course1_id",nullable=false)
	private Course course;
	
	public Score() {
		
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
	
	
	

}
