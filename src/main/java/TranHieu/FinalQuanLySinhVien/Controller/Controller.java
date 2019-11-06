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

	@ManagedProperty(value = "#{studentBean}")
	private Student student;

	@ManagedProperty(value = "#{studentService}")
	private StudentService studentService;

	private List<Student> students;
	private List<Class> listClass;

	private String sort;
	private String value;
	private String column;
	private float avg = 0;

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

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

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

	private String idStudent;
	private String nameStudent;
	private String villageStudent;
	private String emailStudent;
	private String tickId;
	private String tickName;
	private String tickVillage;
	private String tickEmail;

	public String getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}

	public String getNameStudent() {
		return nameStudent;
	}

	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	public String getVillageStudent() {
		return villageStudent;
	}

	public void setVillageStudent(String villageStudent) {
		this.villageStudent = villageStudent;
	}

	public String getEmailStudent() {
		return emailStudent;
	}

	public void setEmailStudent(String emailStudent) {
		this.emailStudent = emailStudent;
	}

	public String getTickId() {
		return tickId;
	}

	public void setTickId(String tickId) {
		this.tickId = tickId;
	}

	public String getTickName() {
		return tickName;
	}

	public void setTickName(String tickName) {
		this.tickName = tickName;
	}

	public String getTickVillage() {
		return tickVillage;
	}

	public void setTickVillage(String tickVillage) {
		this.tickVillage = tickVillage;
	}

	public String getTickEmail() {
		return tickEmail;
	}

	public void setTickEmail(String tickEmail) {
		this.tickEmail = tickEmail;
	}

	public List<Student> getStudents() {
		if (tickId != null || tickName != null || tickVillage != null || tickEmail != null)
			students = studentService.SearchFillterStudent(students, idStudent, nameStudent, villageStudent,
					emailStudent, tickId, tickName, tickVillage, tickEmail);
		else if (sort != null && tickId == null) {
			students = studentService.sortBy(students, sort, value);
		} else
			students = studentService.listStudent();
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
		return "DetailStudent?faces-redirect=true";
	}

	public String Back() {
		student = new Student();
		return "ListStudent?faces-redirect=true";
	}

	public String EditStudent() {
		studentService.EditStudent(student);
		return "ListStudent?faces-redirect=true";

	}

	public String viewEditStudent(int id) {
		student = studentService.findStudentById(id);
		return "EditStudent?faces-redirect=true";

	}

	public String AddStudent() {
		student.setIdStudent("2019M04" + students.size() + 1);
		student.setId(students.size() + 1);
		student.setAvgStudent(0);
		studentService.SaveStudent(student);
		student = new Student();
		return "ListStudent?faces-redirect=true";
	}

	public String Reset() {
		idStudent = null;
		nameStudent = null;
		villageStudent = null;
		emailStudent = null;
		tickId = null;
		tickName = null;
		tickVillage = null;
		tickEmail = null;
		column = null;
		students = studentService.listStudent();
		return "ListStudent?faces-redirect=true";
	}

	public float Avg(int id) {
		float sum = 0;
		float sumCoefficient = 0;
		student = studentService.findStudentById(id);
		for (Score list : student.getListScore()) {
			sum += list.getScoreStudent() * list.getCourse().getCoefficient();
			sumCoefficient += list.getCourse().getCoefficient();
		}
		avg = ((float) sum / sumCoefficient);

		student.setAvgStudent((float) avg);
		studentService.EditStudent(student);
		return avg;
	}

	public String pass_Failed() {
		if (avg >= 5.0f)
			return "Pass";
		else
			return "Failed";

	}

}
