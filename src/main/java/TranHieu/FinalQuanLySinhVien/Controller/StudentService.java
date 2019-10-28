package TranHieu.FinalQuanLySinhVien.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import TranHieu.FinalQuanLySinhVien.BO.Student;
import TranHieu.FinalQuanLySinhVien.BO.ClassStudent;
import TranHieu.FinalQuanLySinhVien.DAO.StudentDAO;

@ManagedBean(name ="studentService")
@SessionScoped
public class StudentService implements StudentInterface {
	
	
	//khi inject cac thuoc tinh nen them phuong thuc set cho bean do (khong dung get)
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


	public void Delete(int id) {
		studentDAO.Delete(id);
	}
	
	public Student findStudentById(int id) {
		return studentDAO.findById(id);
	}
	
	public void EditStudent(Student studentEdit) {
		studentDAO.Edit(studentEdit);
	}
	
	public void SaveStudent(Student student) {
		studentDAO.save(student);
	}
	
	public List<Student> sortBy(List<Student> listStudent,String sortBy,String value) {
		return studentDAO.sortBy(listStudent, sortBy,value);
	}
	
	public List<Student> searchByName(List<Student> list,String name,String column) {
		list =studentDAO.searchByName(list, name,column);
		return list;
	}

	public List<Student> searchFillter(List<Student> list, String nameStudent, String villageStudent,String emailStudent,int ageStudent,String valueAge){
		return studentDAO.searchFillter(list, nameStudent, villageStudent, emailStudent, ageStudent, valueAge);
	}



}
