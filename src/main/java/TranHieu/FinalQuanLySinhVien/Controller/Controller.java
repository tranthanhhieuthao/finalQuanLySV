package TranHieu.FinalQuanLySinhVien.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.validation.Valid;

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
	private boolean tickId;
	private boolean tickName;
	private boolean tickVillage;
	private boolean tickEmail;

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



	public boolean isTickId() {
		return tickId;
	}

	public void setTickId(boolean tickId) {
		this.tickId = tickId;
	}

	public boolean isTickName() {
		return tickName;
	}

	public void setTickName(boolean tickName) {
		this.tickName = tickName;
	}

	public boolean isTickVillage() {
		return tickVillage;
	}

	public void setTickVillage(boolean tickVillage) {
		this.tickVillage = tickVillage;
	}

	public boolean isTickEmail() {
		return tickEmail;
	}

	public void setTickEmail(boolean tickEmail) {
		this.tickEmail = tickEmail;
	}

	public List<Student> getStudents() {
		if (tickId == true || tickName == true || tickVillage == true || tickEmail == true) {		
			students = studentService.SearchFillterStudent(students, idStudent, nameStudent, villageStudent,
					emailStudent, tickId, tickName, tickVillage, tickEmail);
			
		}
		else if (sort != null && tickId == false) {
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

	public Student viewEditStudent(int id) {
		student = studentService.findStudentById(id);
		return student;

	}

	public String AddStudent() {
		student.setIdStudent("2019M04" + students.size() + 1);
		student.setId(students.size() + 1);
		student.setAvgStudent(0);
		studentService.SaveStudent(student);
//		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Add Succsess!!"));
		student = new Student();
		return "ListStudent?faces-redirect=true";
	}

	public String Reset() {
		idStudent = null;
		nameStudent = null;
		villageStudent = null;
		emailStudent = null;
		tickId = false;
		tickName = false;
		tickVillage = false;
		tickEmail = false;
		column = null;
		students = studentService.listStudent();
		return "ListStudent?faces-redirect=true";
	}

	public float Avg(int id) {
		float sum = 0;
		float sumCoefficient = 0;
		student = studentService.findStudentById(id);
		for (Score list : this.maxPointStudent(id)) {
			sum += list.getScoreStudent() * list.getCourse().getCoefficient();
			sumCoefficient += list.getCourse().getCoefficient();
		}
		if (sum == 0)
			sumCoefficient = 1;
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

	public List<Score> maxPointStudent(int id) {
		student = studentService.findStudentById(id);
		List<Score> scMax = student.getListScore();
		for (int i = 0; i < student.getListScore().size(); i++) {
			for (int j = 0; j < student.getListScore().size(); j++) {
				if (student.getListScore().get(i).getCourse().getNameCourse()
						.equals(student.getListScore().get(j).getCourse().getNameCourse())) {
					if (student.getListScore().get(i).getScoreStudent() > student.getListScore().get(j)
							.getScoreStudent()) {
						scMax.remove(j);
					}
				}
			}
		}
		return scMax;
	}
	
	public void validateEmailNoDuplicate(FacesContext context,UIComponent comp ,Object value) throws ValidatorException
	{ 
		FacesMessage message = new FacesMessage();
		String email =(String) value;
		if(email != null) {
		for(Student st: students) {
			if(email.equals(st.getEmail())) { message = new FacesMessage(
					"can't add Student due to duplicate email");
			throw new ValidatorException( message);	
			}
		}
		
		}

	}

}
