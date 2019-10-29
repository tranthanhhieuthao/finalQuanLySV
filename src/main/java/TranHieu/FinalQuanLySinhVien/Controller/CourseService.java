package TranHieu.FinalQuanLySinhVien.Controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import TranHieu.FinalQuanLySinhVien.BO.Course;
import TranHieu.FinalQuanLySinhVien.DAO.CourseDAO;

@ManagedBean(name ="courseService")
@SessionScoped
public class CourseService implements CourseInterface {
	
	public CourseService() {
		
	}
	
	@ManagedProperty(value ="#{courseDAO}")
	private CourseDAO courseDAO;

	
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Override
	public List<Course> listCourseStudent() {
		return courseDAO.showAll();
	}

	@Override
	public Course findCourseStudentById(int id) {
		return courseDAO.findById(id);
	}

	@Override
	public void save(Course course) {
		courseDAO.save(course);
		
	}

	@Override
	public void Delete(int id) {
		courseDAO.Delete(id);
		
	}

	@Override
	public void update(Course courseUpdate) {
		courseDAO.update(courseUpdate);
		
	}

}
