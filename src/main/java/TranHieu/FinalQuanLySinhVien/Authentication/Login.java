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
	
	@ManagedProperty(value ="#{userBean}")
	private User userBean = new User();
	
	private List<User> listUser;
	
	
	public List<User> getListUser() {
		listUser = loginDAO.showAll();
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}
	
	

	public User getUserBean() {
		return userBean;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	
	public Login() {
		
	}
	

	
	public String validateUserNamePassword() {
		boolean valid =loginDAO.validate(userBean.getUser(), userBean.getPwd());
		if(valid) {
			HttpSession session =SessionUtils.getSession();
			session.setAttribute("user",userBean.getUser());
			System.out.println(SessionUtils.getUserId());
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
