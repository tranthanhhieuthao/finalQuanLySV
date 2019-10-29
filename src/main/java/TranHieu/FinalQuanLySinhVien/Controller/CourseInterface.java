package TranHieu.FinalQuanLySinhVien.Controller;

import java.util.List;

import TranHieu.FinalQuanLySinhVien.BO.Course;

public interface CourseInterface {
	public List<Course> listCourseStudent();

	public Course findCourseStudentById(int id);
	
	public void save(Course course);
	
	public void Delete(int id);
	
	public void update(Course courseUpdate);

}
