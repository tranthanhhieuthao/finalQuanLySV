package TranHieu.FinalQuanLySinhVien.Controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import TranHieu.FinalQuanLySinhVien.BO.ClassStudent;
import TranHieu.FinalQuanLySinhVien.BO.Course;
import TranHieu.FinalQuanLySinhVien.BO.Score;

@ManagedBean(name = "controllerCourse")
@SessionScoped
public class ControllerCourse {

	public ControllerCourse() {

	}

	@ManagedProperty(value = "#{courseService}")
	private CourseService courseService;

	@ManagedProperty(value = "#{courseBean}")
	private Course courseBean;

	public Course getCourseBean() {
		return courseBean;
	}

	public void setCourseBean(Course courseBean) {
		this.courseBean = courseBean;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	private List<Course> listCourseStudent;

	public List<Course> getListCourseStudent() {
	listCourseStudent = courseService.listCourseStudent();
		return listCourseStudent;
	}

	public void setListCourseStudent(List<Course> listCourseStudent) {
		this.listCourseStudent = listCourseStudent;
	}

	public String findStudentLearnCourse(int id) {
		courseBean = courseService.findCourseStudentById(id);
		return "StudentLearnCourse?faces-redirect=true";
	}

	public String DeleteCourse(int id) {
		courseService.Delete(id);
		return "ListCourse";
	}

	public Course viewAddCourse() {
		courseBean = new Course();
		courseBean.setId(listCourseStudent.size() + 1);
		return courseBean;
	}

	public String addCourse() {
		courseService.save(courseBean);
		courseBean = new Course();
		return "ListCourse?faces-redirect=true";
	}

}
