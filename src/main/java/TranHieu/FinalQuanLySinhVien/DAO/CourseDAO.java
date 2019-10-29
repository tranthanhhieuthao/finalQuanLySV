package TranHieu.FinalQuanLySinhVien.DAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@ManagedBean(name = "courseDAO")
@SessionScoped
public class CourseDAO {
 
	public CourseDAO() {
		
	}
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	
}
