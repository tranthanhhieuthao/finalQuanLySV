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
	
	@ManagedProperty(value="#{studentService}")
	private StudentService studentService;
	
	private List<Student> listStudent;
	
	private String emailLogin ;
	
	private String passwordLogin;
	
	
	public String getEmailLogin() {
		return emailLogin;
	}

	public void setEmailLogin(String emailLogin) {
		this.emailLogin = emailLogin;
	}

	public String getPasswordLogin() {
		return passwordLogin;
	}

	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public List<Student> getListStudent() {
		return listStudent;
	}

	public void setListStudent(List<Student> listStudent) {
		this.listStudent = listStudent;
	}

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
		boolean valid =loginDAO.validate(emailLogin, passwordLogin);
		for(Student st: studentService.listStudent()) {
			if(emailLogin.equals(st.getEmail())) {
				studentBean =st;
			}
		}
		if(valid && studentBean.getNameStudent() !=null) {
			HttpSession session =SessionUtils.getSession();
			session.setAttribute("user",studentBean.getEmail());
			session.setAttribute("permission", studentBean.getListUser().getPermission());
			if(session.getAttribute("permission").equals("Admin")) return "DetailStudent?faces-redirect=true";
			else return "ListStudent?faces-redirect=true";
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
