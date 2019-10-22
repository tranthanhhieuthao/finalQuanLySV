package TranHieu.FinalQuanLySinhVien.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import TranHieu.FinalQuanLySinhVien.BO.Student;
import TranHieu.FinalQuanLySinhVien.DAO.StudentDAO;

@ManagedBean(name ="studentService")
@SessionScoped
public class StudentService {
	
	@ManagedProperty(value = "#{studentDAO}")
	private StudentDAO studentDAO;
	
	public StudentService() {
		
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}


	public List<Student> listStudent(){
		return studentDAO.showAll();
	}





}
