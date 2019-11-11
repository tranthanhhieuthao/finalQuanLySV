package TranHieu.FinalQuanLySinhVien.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import TranHieu.FinalQuanLySinhVien.BO.Student;
import TranHieu.FinalQuanLySinhVien.BO.User;

@ManagedBean(name="loginDAO")
@SessionScoped
public class LoginDAO {
	
	public LoginDAO() {
		
	}
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	public boolean validate(String user,String password) {
		Session session =sessionFactory.openSession();
		List<Student> studentLogin = new ArrayList<Student>();
		try {
			session.beginTransaction();
			Query query = session.createQuery("FROM Student WHERE email =:user AND password =:password").setParameter("user", user ).setParameter("password", password);
			studentLogin = query.list();
			System.out.println(studentLogin+"123");
			System.out.println(user);
			System.out.println(password);
			System.out.println(studentLogin != null);
			if(studentLogin != null) {
				return true;
			}		
		} catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}
	

}
