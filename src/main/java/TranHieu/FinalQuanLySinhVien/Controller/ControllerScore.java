package TranHieu.FinalQuanLySinhVien.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import TranHieu.FinalQuanLySinhVien.Authentication.SessionUtils;
import TranHieu.FinalQuanLySinhVien.BO.ClassStudent;
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
	private Score scoreBean = new Score();

	@ManagedProperty(value = "#{studentBean}")
	private Student studentBean;

	@ManagedProperty(value = "#{courseBean}")
	private Course courseBean;

	@ManagedProperty(value = "#{classtBean}")
	private ClassStudent classBean;

	@ManagedProperty(value = "#{studentService}")
	private StudentService studentService;

	@ManagedProperty(value = "#{courseService}")
	private CourseService courseService;

	@ManagedProperty(value = "#{classService}")
	private ClassService classService;

	private List<Score> listScoreStudent;

	private List<Score> newListScore;

	private List<Score> detailScore = new ArrayList<Score>();

	public List<Score> getNewListScore() {
		newListScore = scoreService.listScoreStudent();
		for (int i = 0; i < newListScore.size(); i++) {
			for (int j = 0; j < newListScore.size(); j++) {
				if (newListScore.get(i).getClassStudent().equals(newListScore.get(j).getClassStudent())
						&& newListScore.get(i).getCourse().equals(newListScore.get(j).getCourse())
						&& newListScore.get(i).getTimeStart().equals(newListScore.get(j).getTimeStart())) {
					if (i != j) {
						newListScore.remove(j);
						i = 0;
					}

				}
			}
		}
		return newListScore;
	}

	public List<Score> getDetailScore() {
		return this.detailScore;
	}

	public void setDetailScore(List<Score> detailScore) {
		this.detailScore = detailScore;
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
		listScoreStudent = scoreService.listScoreStudent();
		return listScoreStudent;
	}

	public void setListScoreStudent(List<Score> listScoreStudent) {
		this.listScoreStudent = listScoreStudent;
	}

	public String EditScore() {
		scoreService.update(scoreBean);
		return null;

	}

	public Score viewEditScore(int id) {
		scoreBean = scoreService.findScoreOfStudentById(id);
		return scoreBean;

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

	public String MarkScoreForStudent() {
		HttpSession session = SessionUtils.getSession();
		for (Student st : studentService.listStudent()) {
			if (st.getEmail().equals(session.getAttribute("user"))) {
				scoreBean.setStudent(st);
			}
		}
		scoreBean.setCourse(courseBean);// hien 1 list course roi pick theo id
		scoreBean.setScoreStudent(0);
		scoreBean.setClassStudent(classBean);
		scoreService.save(scoreBean);
		return "ListScore?faces-redirect=true";
	}

	public String statusClass(int id) {
		int quatityScoreOfStudent = 0;
		List<Score> statusList = scoreService.listScoreStudent();
		Score statusScore = scoreService.findScoreOfStudentById(id);
		for (Score sc : statusList) {
			if (sc.getClassStudent().getNameClass()
					.equals(statusScore.getClassStudent().getNameClass())
					&& sc.getCourse().getNameCourse()
							.equals(statusScore.getCourse().getNameCourse())
					&& sc.getTimeStart().equals(statusScore.getTimeStart())) {
				quatityScoreOfStudent++;
			}
		}
		if (quatityScoreOfStudent < 51) {
			return "remain" + " " + (51 - quatityScoreOfStudent) + " " + "slot";
		}
		return "Full can't add more Student";
	}

	public Score viewaddStudentSubject(int id) {
		scoreBean = new Score();
		scoreBean = scoreService.findScoreOfStudentById(id);
		return scoreBean;
	}

	public String addStudentSubject(int id) {
		scoreBean.setScoreStudent(0);
		scoreBean.setStudent(studentService.findStudentById(id));
		scoreBean.setId(scoreService.listScoreStudent().size() + 1);
		scoreService.save(scoreBean);
		return null;
	}

	public String registerSubject(int id) {
		HttpSession session = SessionUtils.getSession();
		scoreBean = scoreService.findScoreOfStudentById(id);
		if (session.getAttribute("permission").equals("Admin")) {
			for (Student st : studentService.listStudent()) {
				if (st.getEmail().equals(session.getAttribute("user"))) {
					scoreBean.setStudent(st);
					scoreBean.setScoreStudent(0);
					scoreService.save(scoreBean);
				}
			}
		}
		return "DetailStudent?faces-redirect=true";
	}

	public String DeleteScore(int id) {
		HttpSession session = SessionUtils.getSession();
		if (session.getAttribute("permission").equals("Admin")) {
			if (scoreService.findScoreOfStudentById(id).getTimeStart().before(new Date())) {
				return null;
			}
			scoreService.Delete(id);
			return null;
		}
		scoreService.Delete(id);
		return "ListScore?faces-redirect=true";
	}

	public List<Score> detailSubject(int id) {
		scoreBean = scoreService.findScoreOfStudentById(id);
		detailScore = scoreService.detailSubject(scoreBean.getClassStudent().getId(), scoreBean.getTimeStart(),
				scoreBean.getCourse().getId());
		detailScore.remove(0);
		return detailScore;
	}

}
