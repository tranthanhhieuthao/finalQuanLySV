package TranHieu.FinalQuanLySinhVien.Authentication;

import java.io.Serializable;

public class Login implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String pwd;
	
	private String user;
	
	private String msg;

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
	
	public String validateUserNamePassword() {
		return null;
	}
	
	
}
