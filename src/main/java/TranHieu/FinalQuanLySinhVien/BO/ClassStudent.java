package TranHieu.FinalQuanLySinhVien.BO;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean(name="classBean")
@SessionScoped
@Entity
@Table(name = "classStudent")
public class ClassStudent {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@Column(name = "nameClass")
	@NotNull(message = "can't be empty")
	private String nameClass;

	@Column(name = "note")
	private String note;
	
	public ClassStudent() {
		
	}
	

	public ClassStudent(String nameClass, String note) {
		this.nameClass = nameClass;
		this.note = note;
	}


	public String getNameClass() {
		return nameClass;
	}


	public void setNameClass(String nameClass) {
		this.nameClass = nameClass;
	}

	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "classStudent")
	private Set<Score> scoreStudent ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}


	public Set<Score> getScoreStudent() {
		return scoreStudent;
	}

	public void setScoreStudent(Set<Score> scoreStudent) {
		this.scoreStudent = scoreStudent;
	}
	

}
