package TranHieu.FinalQuanLySinhVien.Authentication;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import TranHieu.FinalQuanLySinhVien.BO.Student;
import TranHieu.FinalQuanLySinhVien.BO.User;
import TranHieu.FinalQuanLySinhVien.Controller.StudentService;
import TranHieu.FinalQuanLySinhVien.DAO.LoginDAO;


@ManagedBean(name="loginBean")
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value ="#{loginDAO}")
	private LoginDAO loginDAO;
	
	@ManagedProperty(value ="#{studentBean}")
	private Student studentBean ;
	


	public Student getStudentBean() {
		return studentBean;
	}

	public void setStudentBean(Student studentBean) {
		this.studentBean = studentBean;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	
	public Login() {
		
	}
	

	
	public String validateUserNamePassword() {
		boolean valid =loginDAO.validate(studentBean.getEmail(), studentBean.getPassword());
		System.out.println(studentBean.getEmail());
		System.out.println(valid);
		if(valid) {
			HttpSession session =SessionUtils.getSession();
			session.setAttribute("user",studentBean.getEmail());
			return "ListStudent?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Incorrect Username and Passowrd","Please enter correct username and Password"));
			return "Login";
		}
	}
	
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "Login?faces-redirect=true";
	}
	
	
}
