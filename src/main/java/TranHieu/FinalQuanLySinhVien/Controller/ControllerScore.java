package TranHieu.FinalQuanLySinhVien.Controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import TranHieu.FinalQuanLySinhVien.BO.Course;
import TranHieu.FinalQuanLySinhVien.BO.Score;
import TranHieu.FinalQuanLySinhVien.BO.Student;

@ManagedBean(name = "controllerScore")
@SessionScoped
public class ControllerScore {

	public ControllerScore() {

	}

	@ManagedProperty(value = "#{scoreService}")
	private ScoreService scoreService;

	@ManagedProperty(value = "#{scoreBean}")
	private Score scoreBean;

	@ManagedProperty(value = "#{studentBean}")
	private Student studentBean;

	@ManagedProperty(value = "#{courseBean}")
	private Course courseBean;

	@ManagedProperty(value = "#{studentService}")
	private StudentService studentService;

	@ManagedProperty(value = "#{courseService}")
	private CourseService courseService;

	private List<Score> listScoreStudent;

	List<Score> newListScore;

	public List<Score> getNewListScore() {
		 newListScore = scoreService.listScoreStudent();
		for (int i = 0; i < newListScore.size(); i++) {
			for (int j = 1; j < newListScore.size(); j++) {
				if (newListScore.get(i).getClassStudent() == newListScore.get(j).getClassStudent() &&
						newListScore.get(i).getCourse() == newListScore.get(j).getCourse() &&
						newListScore.get(i).getTimeStart() == newListScore.get(j).getTimeStart()) {
					newListScore.remove(j);
				}
			}
		}
		return newListScore;
	}

	public void setNewListScore(List<Score> newListScore) {
		this.newListScore = newListScore;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public Student getStudentBean() {
		return studentBean;
	}

	public void setStudentBean(Student studentBean) {
		this.studentBean = studentBean;
	}

	public Course getCourseBean() {
		return courseBean;
	}

	public void setCourseBean(Course courseBean) {
		this.courseBean = courseBean;
	}

	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}

	public void setScoreBean(Score scoreBean) {
		this.scoreBean = scoreBean;
	}

	public Score getScoreBean() {
		return scoreBean;
	}

	public List<Score> getListScoreStudent() {
		return scoreService.listScoreStudent();
	}

	public void setListScoreStudent(List<Score> listScoreStudent) {
		this.listScoreStudent = listScoreStudent;
	}

	public String EditScore() {
		scoreService.update(scoreBean);
		return "ListScore";

	}

	public String viewEditScore(int id) {
		scoreBean = scoreService.findScoreOfStudentById(id);
		return "EditScore";

	}

	public String addCourse(int id) {
		courseBean = courseService.findCourseStudentById(id);
		return null;
	}

	public String addStudent(int id) {
		studentBean = studentService.findStudentById(id);
		return null;
	}

	public String viewScoreForStudent() {
		scoreBean = new Score();
		return "viewMarkScoreForStudent";
	}

	public void RemoveDuplicate() {

	}

	public String MarkScoreForStudent() {
		scoreBean.setCourse(courseBean);// hien 1 list course roi pick theo id
		scoreBean.setScoreStudent(0);
		scoreBean.setStudent(studentBean);// hien 1 list student roi pick theo id
		scoreBean.setStudent(studentBean);
		scoreService.save(scoreBean);
		return "ListScore";
	}

	public String DeleteScore(int id) {
		scoreService.Delete(id);
		return "ListScore";
	}

}
