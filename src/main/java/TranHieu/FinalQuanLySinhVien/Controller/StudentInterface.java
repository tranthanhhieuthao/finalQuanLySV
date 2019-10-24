package TranHieu.FinalQuanLySinhVien.Controller;

import java.util.List;

import TranHieu.FinalQuanLySinhVien.BO.Student;
import TranHieu.FinalQuanLySinhVien.BO.Class;
import TranHieu.FinalQuanLySinhVien.DAO.StudentDAO;

public interface StudentInterface {
	
	public List<Student> listStudent();
	
	public void Delete(int id);
	
	public Student findStudentById(int id);
	
	public void EditStudent(Student studentEdit);
	
	public void SaveStudent(Student student);
	
	public List<Student> sortBy(List<Student> listStudent,String sortBy,String value);
	
	public List<Student> searchByName(List<Student> list,String name);
	


}
