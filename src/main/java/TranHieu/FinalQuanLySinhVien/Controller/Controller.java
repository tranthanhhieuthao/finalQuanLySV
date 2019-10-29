package TranHieu.FinalQuanLySinhVien.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import TranHieu.FinalQuanLySinhVien.BO.Student;
import TranHieu.FinalQuanLySinhVien.BO.ClassStudent;
import TranHieu.FinalQuanLySinhVien.BO.Score;

@ManagedBean(name = "controllerStudent", eager = true)
@SessionScoped
public class Controller implements Serializable {
	private static final long serialVersionUID = 1L;

	public Controller() {
			
	}
	
	private String sort ;
	private String value ;
	private String column;
	private float avg =0 ;
	

	 private String nameStudentFillter;
	 private String villageStudentFillter;
	 private String emailStudentFillter;
	 private String valueAgeFillter;
	 private int ageStudentFillter;

	 
	
	public String getNameStudentFillter() {
		return nameStudentFillter;
	}



	public void setNameStudentFillter(String nameStudentFillter) {
		this.nameStudentFillter = nameStudentFillter;
	}



	public String getVillageStudentFillter() {
		return villageStudentFillter;
	}



	public void setVillageStudentFillter(String villageStudentFillter) {
		this.villageStudentFillter = villageStudentFillter;
	}



	public String getEmailStudentFillter() {
		return emailStudentFillter;
	}



	public void setEmailStudentFillter(String emailStudentFillter) {
		this.emailStudentFillter = emailStudentFillter;
	}



	public String getValueAgeFillter() {
		return valueAgeFillter;
	}



	public void setValueAgeFillter(String valueAgeFillter) {
		this.valueAgeFillter = valueAgeFillter;
	}



	public int getAgeStudentFillter() {
		return ageStudentFillter;
	}



	public void setAgeStudentFillter(int ageStudentFillter) {
		this.ageStudentFillter = ageStudentFillter;
	}



	public float getAvg() {
		return avg;
	}



	public void setAvg(float avg) {
		this.avg = avg;
	}



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


	public String getColumn() {
		return column;
	}


	public void setColumn(String column) {
		this.column = column;
	}

	public void setListClass(List<Class> listClass) {
		this.listClass = listClass;
	}

	@ManagedProperty(value = "#{studentBean}")
	private Student student = new Student();

	@ManagedProperty(value = "#{studentService}")
	private StudentService studentService;


	public List<Student> getStudents() {
		if(nameSearch != null) students = studentService.searchByName(students, nameSearch,column);
		else if(sort != null) students = studentService.sortBy(students, sort,value);
		else if(nameStudentFillter !=null ) {
	
			students=studentService.searchFillter(students, nameStudentFillter, villageStudentFillter, emailStudentFillter, ageStudentFillter, valueAgeFillter);
		}
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
		return "DetailStudent";
	}
	
	public String Back() {
		student = new Student();
		return "ListStudent?faces-redirect=true";
	}
	

	public String EditStudent() {
		System.out.println("da chay vao day");
		studentService.EditStudent(student);
		System.out.println("da edit oke");
		return "ListStudent";
		
	}
	
	public String viewEditStudent(int id) {
		student =studentService.findStudentById(id);
		return "EditStudent";
		
	}
	
	public String AddStudent() {
		studentService.SaveStudent(student);
		student = new Student();
		return "ListStudent";
	}
	
	public String viewAddStudent() {
		student = new Student();
		student.setId(students.size() +1);
		return "AddStudent";
	}
	
	public String Reset() {
		nameSearch =null;
		nameStudentFillter=null;
		column =null;
		students = studentService.listStudent();
		return "ListStudent";
	}
	
	public float Avg(int id) {		
		float sum =0;
		float sumCoefficient=0;
		student =studentService.findStudentById(id);
		for(Score list : student.getListScore()) {
		 sum += list.getScoreStudent()*list.getCourse().getCoefficient();
		 sumCoefficient +=list.getCourse().getCoefficient();
		}
		avg =((float)sum/sumCoefficient) ;
		student.setAvgStudent((float)avg) ;
		return avg;
	}
	
	public String pass_Failed() {
		if(avg >= 5.0f) return "Pass"  ;
		else return "Failed" ;
		
	}
	

		





}
