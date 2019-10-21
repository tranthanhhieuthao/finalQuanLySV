package TranHieu.FinalQuanLySinhVien.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import TranHieu.FinalQuanLySinhVien.BO.Student;

@ManagedBean(name ="controllerStudent")
@SessionScoped
public class Controller implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Student> lists;
	
	public Controller() {
		lists = new ArrayList<Student>();
		lists =studentService.listStudent();
	}
	@ManagedProperty(value ="#{studentService}")
	private StudentService studentService;

//	@ManagedProperty(value ="#{studentBean}")
//	private Student studentBean;
	
	public List<Student> getLists() {
		return lists;
	}


//	public Student getStudentBean() {
//		return studentBean;
//	}
//
//	public void setStudentBean(Student studentBean) {
//		this.studentBean = studentBean;
//	}

	public void setLists(List<Student> lists) {
		this.lists = lists;
	}

	public StudentService getStudentService() {
		return studentService;
	}


}
