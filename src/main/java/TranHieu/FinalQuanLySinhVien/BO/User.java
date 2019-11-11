package TranHieu.FinalQuanLySinhVien.BO;

import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

@ManagedBean(name ="userBean")
@SessionScoped
@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	
	@Column(name="permission")
	private String permission;

	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
	private Set<Student> listStudentLogin = new HashSet<Student>();
	

	public User() {
		
	}
	
	public User(String permission) {
		this.permission = permission;
	}
	

	public Set<Student> getListStudentLogin() {
		return listStudentLogin;
	}

	public void setListStudentLogin(Set<Student> listStudentLogin) {
		this.listStudentLogin = listStudentLogin;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}



	public String getPermission() {
		return permission;
	}



	public void setPermission(String permission) {
		this.permission = permission;
	}



}
