package TranHieu.FinalQuanLySinhVien.BO;

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
	
	@Column(name="password")
	private String pwd;
	
	@Column(name="user")
	private String user;
	
	@Column(name="massage")
	private String msg;
	
	public User(String pwd,String user) {
		this.user = user;
		this.pwd = pwd;
	}

	public User() {
		
	}
	
	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
