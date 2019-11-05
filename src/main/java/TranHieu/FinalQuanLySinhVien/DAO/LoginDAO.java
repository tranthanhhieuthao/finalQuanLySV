//package TranHieu.FinalQuanLySinhVien.DAO;
//
//import java.sql.ResultSet;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
//
//public class LoginDAO {
//	
//	public LoginDAO() {
//		
//	}
//	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//	public boolean validate(String user,String password) {
//		Session session =sessionFactory.openSession();
//		try {
//			session.beginTransaction();
//			ResultSet rs = session.createQuery("SELECT Student WHERE userName =:user AND password =:password")
//		
//		}
//	}
//
//}
