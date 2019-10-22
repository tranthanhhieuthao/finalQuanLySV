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
	
	}

	private List<Student> students ;
	
	@ManagedProperty(value = "#{studentBean}")
	private Student student;

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
	
	public String Delete(int id) {
		studentService.Delete(id);
		return null;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public String DetailStudent(int id) {
		student = studentService.findStudentById(id);
		return "DetailStudent";
	}
	

	public String EditStudent(int id) {
		Student studentEdit = studentService.findStudentById(id);
		studentService.EditStudent(studentEdit);
		return "EditStudent";
		
	}


	public Student getStudent() {
		return student;
	}


//	public StudentService getStudentService() {
//		return studentService;
//	}

}
