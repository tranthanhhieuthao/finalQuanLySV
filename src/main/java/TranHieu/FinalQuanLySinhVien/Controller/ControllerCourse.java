package TranHieu.FinalQuanLySinhVien.Controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import TranHieu.FinalQuanLySinhVien.BO.Course;

@ManagedBean(name ="controllerCourse")
@SessionScoped
public class ControllerCourse {
	
	public ControllerCourse() {
		
	}
	
	@ManagedProperty(value="#{courseService}")
	private CourseService courseService;

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
	
	

}
