package TranHieu.FinalQuanLySinhVien.Controller;

import java.util.List;

import TranHieu.FinalQuanLySinhVien.BO.Student;
import TranHieu.FinalQuanLySinhVien.DAO.StudentDAO;

public interface StudentInterface {
	
	public List<Student> listStudent();
	
	public StudentDAO getStudentDAO();

}
