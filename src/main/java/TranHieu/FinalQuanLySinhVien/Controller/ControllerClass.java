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
		for (Student a : classStudentBean.getClassStudent()) {
			System.out.println("truoc khi add method::" + a.getNameStudent());
		}
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
		classService.Delete(id);
		return "viewAddStudentOnClass";
	}

	public String addNowStudent(int id) {
		for (Student a : classStudentBean.getClassStudent()) {
			System.out.println("truoc khi add" + a.getNameStudent());
		}
		classStudentBean.getClassStudent().add(studentService.findStudentById(id));
		classService.save(classStudentBean);
		for (Student a : classStudentBean.getClassStudent()) {
			System.out.println(a.getNameStudent());
		}
		return "ListClass?faces-redirect=true";
	}

	public String Delete(int id) {
		classService.Delete(id);
		return "ListClass";
	}

}
