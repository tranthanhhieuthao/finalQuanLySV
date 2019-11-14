package TranHieu.FinalQuanLySinhVien.BO;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@ManagedBean(name ="studentBean")
@SessionScoped
@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="idStudent")
	@NotNull(message = "idStudent can't be empty")
	private String idStudent;

	@Column(name = "nameStudent")
	@NotNull(message = "Name Student can't be empty")
	@Size(min=2,message = "length must than 2")
	private String nameStudent;

	@Column(name = "village")
	@NotNull(message = "Village can't be empty")
	private String village;

	@Column(name = "phone")
	@NotNull(message = "Phone can't be empty")
	private int phone;

	@Column(name = "email")
	@NotNull(message = "Email can't be empty")
	@Pattern(regexp = "^[-a-z0-9~!$%^&*_=+}{\\'?]+(\\.[-a-z0-9~!$%^&*_=+}{\\'?]+)*@([a-z0-9_][-a-z0-9_]"
			+ "*(\\.[-a-z0-9_]+)*\\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}"
			+ "\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,5})?$",message = "No matcher format of Email")
	private String email;

	@Column(name = "note")
	private String note;

	@Column(name = "birthDay")
	@NotNull(message = "BirthDay can't be empty")
	@Temporal(TemporalType.DATE)
//	@Past(message = "birthDay can't be in the future ")
	private Date birthDay;
	
	@Column(name ="avgStudent")
	private float avgStudent;
	
	@Column(name ="password")
	@NotNull(message = "Password can't be empty")
	private String password;
	

	//nen them contructor khong tham so de khoi tao Entity
	public Student() {
		
	}
			
	public Student(String idStudent, String nameStudent, String village, int phone, String email, String note,
			Date birthDay, float avgStudent,String password) {
		this.nameStudent = nameStudent;
		this.village = village;
		this.phone = phone;
		this.email = email;
		this.note = note;
		this.birthDay = birthDay;
		this.avgStudent = avgStudent;
		this.idStudent = idStudent;
		this.password = password;
	}


	@OneToMany(fetch = FetchType.EAGER,mappedBy = "student")
	private List<Score> listScore = new ArrayList<Score>();
	
	@ManyToOne
	private User user = new User();


	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getListUser() {
		return user;
	}

	public void setListUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public List<Score> getListScore() {
		return listScore;
	}

	public void setListScore(List<Score> listScore) {
		this.listScore = listScore;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameStudent() {
		return nameStudent;
	}

	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}


	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	public float getAvgStudent() {
		return avgStudent;
	}


	public void setAvgStudent(float avgStudent) {
		this.avgStudent = avgStudent;
	}

	public String getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}
	
	

}
