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
	
	private String sort ="Id";
	private String value ="DESC";
	
	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}

	private String nameSearch;

	public String getNameSearch() {
		return nameSearch;
	}


	public void setNameSearch(String nameSearch) {
		this.nameSearch = nameSearch;
	}


	public String getSort() {
		return sort;
	}


	public void setSort(String sort) {
		this.sort = sort;
	}

	private List<Student> students ;
	
	private List<Class> listClass;
	
	public List<Class> getListClass() {
		return listClass;
	}


	public void setListClass(List<Class> listClass) {
		this.listClass = listClass;
	}

	@ManagedProperty(value = "#{studentBean}")
	private Student student;

	@ManagedProperty(value = "#{studentService}")
	private StudentService studentService;


	public List<Student> getStudents() {
		if(nameSearch != null) students = studentService.searchByName(students, nameSearch);
		else if(sort != null) students = studentService.sortBy(students, sort,value);
		else students = studentService.listStudent();
		return students;
	}


	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	public String Delete(int id) {
		studentService.Delete(id);
		return "ListStudent?faces-redirect=true";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	public String DetailStudent(int id) {
		student = studentService.findStudentById(id);
		listClass =studentService.findListClassByStudentId(listClass, id);
		return "DetailStudent";
	}
	
	public String Back() {
		student = new Student();
		return "ListStudent?faces-redirect=true";
	}
	

	public String EditStudent() {
		studentService.EditStudent(student);
		student = new Student();
		return "ListStudent";
		
	}
	
	public String viewEditStudent(int id) {
		student =studentService.findStudentById(id);
		getStudents();
		return "EditStudent";
		
	}
	
	public String AddStudent() {
		studentService.SaveStudent(student);
		student = new Student();
		return "ListStudent";
	}
	
	public String viewAddStudent() {		
		student.setId(students.size() +1);
		return "AddStudent";
	}
	
	public String Reset() {
		nameSearch =null;
		students = studentService.listStudent();
		return "ListStudent";
	}
		





}
