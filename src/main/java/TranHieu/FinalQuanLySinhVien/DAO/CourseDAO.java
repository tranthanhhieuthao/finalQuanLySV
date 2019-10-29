package TranHieu.FinalQuanLySinhVien.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import TranHieu.FinalQuanLySinhVien.BO.ClassStudent;
import TranHieu.FinalQuanLySinhVien.BO.Course;

@ManagedBean(name = "courseDAO")
@SessionScoped
public class CourseDAO {
 
	public CourseDAO() {
		
	}
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	public void save(Course course) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(course);
			session.getTransaction().commit();
			System.out.println("insert success!!");
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}
	
	public void update(Course course) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(course);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	
	public void Delete(int id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Course courseRemove = this.findById(id);
			session.delete(courseRemove);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

		public Course findById(int id) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Course courseStudent = (Course) session.get(Course.class, id);
			session.getTransaction().commit();
			session.close();
			return courseStudent;
		}

		public List<Course> showAll() {
			Session session = sessionFactory.openSession();
			List<Course> listCourseStudent = new ArrayList<Course>();
			try {
				session.beginTransaction();
				listCourseStudent = session.createQuery("FROM Course").list();
				session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return listCourseStudent;
		}
	
}
