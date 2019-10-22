package TranHieu.FinalQuanLySinhVien.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import TranHieu.FinalQuanLySinhVien.BO.Student;

@ManagedBean(name = "controllerStudent", eager = true)
@SessionScoped
public class Controller implements Serializable {
	private static final long serialVersionUID = 1L;

	public Controller() {
	System.out.println("abc");
	}

	private List<Student> students ;

	@ManagedProperty(value = "#{studentService}")
	private StudentService studentService;


	public List<Student> getStudents() {
		students = new ArrayList<Student>();
		students = studentService.listStudent();
		return students;
	}


	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}


//	public StudentService getStudentService() {
//		return studentService;
//	}

}
