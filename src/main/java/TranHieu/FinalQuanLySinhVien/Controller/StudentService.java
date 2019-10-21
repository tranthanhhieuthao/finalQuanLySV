package TranHieu.FinalQuanLySinhVien.Controller;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import TranHieu.FinalQuanLySinhVien.BO.Student;
import TranHieu.FinalQuanLySinhVien.DAO.StudentDAO;

@ManagedBean(name ="studentService")
@ApplicationScoped
@SessionScoped
public class StudentService {
	
	@ManagedProperty(value = "#{studentDAO}")
	private StudentDAO studentDAO;
	
	public List<Student> listStudent(){
		return studentDAO.showAll();
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

}
