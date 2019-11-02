package TranHieu.FinalQuanLySinhVien.Controller;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import TranHieu.FinalQuanLySinhVien.BO.ClassStudent;
import TranHieu.FinalQuanLySinhVien.BO.Course;
import TranHieu.FinalQuanLySinhVien.BO.Score;
import TranHieu.FinalQuanLySinhVien.BO.Student;

@ManagedBean(name = "controllerScore")
@SessionScoped
public class ControllerScore {

	public ControllerScore() {

	}
	
	private Date timeStart;
	
	private Date timeEnd;
	
	private String teacher;

	@ManagedProperty(value = "#{scoreService}")
	private ScoreService scoreService;

	@ManagedProperty(value = "#{scoreBean}")
	private Score scoreBean;

	@ManagedProperty(value = "#{studentBean}")
	private Student studentBean;

	@ManagedProperty(value = "#{courseBean}")
	private Course courseBean;
	
	@ManagedProperty(value ="#{classtBean}")
	private ClassStudent classBean;

	@ManagedProperty(value = "#{studentService}")
	private StudentService studentService;

	@ManagedProperty(value = "#{courseService}")
	private CourseService courseService;
	
	@ManagedProperty(value="#{classService}")
	private ClassService classService;

	private List<Score> listScoreStudent;

	List<Score> newListScore;

	public List<Score> getNewListScore() {
		newListScore = scoreService.listScoreStudent();
		for (int i = 0; i < newListScore.size()-1; i++) {

			for (int j = 0; j < newListScore.size()-1; j++) {

				if (newListScore.get(i).getClassStudent().equals( newListScore.get(j).getClassStudent())
						&& newListScore.get(i).getCourse().equals( newListScore.get(j).getCourse())
						&& newListScore.get(i).getTimeStart().equals( newListScore.get(j).getTimeStart())) {
					if(i !=j) newListScore.remove(j);						

				}
			}
		}

		return newListScore;
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

	public void setClassService(ClassService classService) {
		this.classService = classService;
	}

	public ClassStudent getClassBean() {
		return classBean;
	}

	public void setClassBean(ClassStudent classBean) {
		this.classBean = classBean;
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
	
	public String addClass(int id) {
		classBean = classService.findClassStudentById(id);
		return null;
	}

	public String viewScoreForStudent() {
		studentBean = studentService.findStudentById(1);
		scoreBean.setId(scoreService.listScoreStudent().size()+1);
		return "viewMarkScoreForStudent";
	}

	public String MarkScoreForStudent() {
		
		scoreBean.setCourse(courseBean);// hien 1 list course roi pick theo id
		scoreBean.setScoreStudent(0);
		scoreBean.setStudent(studentBean);// hien 1 list student roi pick theo id
		scoreBean.setClassStudent(classBean);
		scoreService.save(scoreBean);
		return "ListScore";
	}
	
	public String viewaddStudentSubject(int id) {
		scoreBean = scoreService.findScoreOfStudentById(id);	
		 return "addStudentSubject";
	}
	
	public String addStudentSubject(int id) {
		scoreBean.setScoreStudent(0);
		scoreBean.setStudent(studentService.findStudentById(id));
		scoreService.save(scoreBean);
		return null;
	}

	public String DeleteScore(int id) {
		scoreService.Delete(id);
		return "ScoreEditStudentAndDelete";
	}

}
