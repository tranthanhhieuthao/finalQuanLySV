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
			Query query = session.createQuery("FROM User WHERE user =:user AND pwd =:password").setParameter("user", user ).setParameter("password", password);
			studentLogin = query.list();
			System.out.println(studentLogin.get(0));
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
	
	public List<User> showAll() {
		Session session = sessionFactory.openSession();
		List<User> listUser = new ArrayList<User>();
		try {
			session.beginTransaction();
			listUser = session.createQuery("FROM User").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return listUser;
	}

}
