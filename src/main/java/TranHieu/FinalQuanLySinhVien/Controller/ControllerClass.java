package TranHieu.FinalQuanLySinhVien.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import TranHieu.FinalQuanLySinhVien.BO.ClassStudent;
import TranHieu.FinalQuanLySinhVien.BO.Student;

@ManagedBean(name = "controllerClass")
@SessionScoped
public class ControllerClass {

	@ManagedProperty(value = "#{classService}")
	private ClassService classService;

	@ManagedProperty(value = "#{classBean}")
	private ClassStudent classStudentBean;

	@ManagedProperty(value = "#{studentService}")
	private StudentService studentService;

	private List<ClassStudent> listClassStudent;

	private Student studentInClass;

	private List<Student> students;

	public List<Student> getStudents() {
		students = studentService.listStudent();
		return students;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public Student getStudent() {
		return studentInClass;
	}

	public void setStudent(Student studentInClass) {
		this.studentInClass = studentInClass;
	}

	public ControllerClass() {

	}

	public void setClassService(ClassService classService) {
		this.classService = classService;
	}

	public List<ClassStudent> getListClassStudent() {
		listClassStudent = classService.listClassStudent();
		return listClassStudent;
	}

	public void setListClassStudent(List<ClassStudent> listClassStudent) {
		this.listClassStudent = listClassStudent;
	}

	public String findClassStudentById(int id) {
		classStudentBean = classService.findClassStudentById(id);
		return "StudentOfClass";
	}

	public void setClassStudentBean(ClassStudent classStudentBean) {
		this.classStudentBean = classStudentBean;
	}

	public ClassStudent getClassStudentBean() {
		return classStudentBean;
	}

	public String viewAddStudent(int id) {
		classStudentBean = classService.findClassStudentById(id);
		return "viewAddStudentOnClass";
	}

	public String addNowStudent(int id) {
		classStudentBean.getClassStudent().add(studentService.findStudentById(id));
		classService.update(classStudentBean);
		return "ListClass?faces-redirect=true";
	}

	public String Delete(int id) {
		classService.Delete(id);
		return "ListClass";
	}
	
	public String statusClass(int id) {
		int quatity =0;
		classStudentBean = classService.findClassStudentById(id);
		quatity = classStudentBean.getClassStudent().size();
		if(quatity <50) return "Have"+" "+(50-quatity)+" "+"slot";
		return "Full_"+50;
	}

}
