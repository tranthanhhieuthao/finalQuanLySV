package TranHieu.FinalQuanLySinhVien.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import TranHieu.FinalQuanLySinhVien.BO.ClassStudent;
import TranHieu.FinalQuanLySinhVien.BO.Student;

@ManagedBean(name = "classDAO")
@SessionScoped
public class ClassDAO {
SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
 public ClassDAO() {
	 
 }

 
	public void save(ClassStudent classStudent) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(classStudent);
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
	
	public void update(ClassStudent classUpdate) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(classUpdate);
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
			ClassStudent classRemove = this.findById(id);
			session.delete(classRemove);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

		public ClassStudent findById(int id) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			ClassStudent classStudent = (ClassStudent) session.get(ClassStudent.class, id);
			session.getTransaction().commit();
			session.close();
			return classStudent;
		}

		public List<ClassStudent> showAll() {
			Session session = sessionFactory.openSession();
			List<ClassStudent> listClassStudent = new ArrayList<ClassStudent>();
			try {
				session.beginTransaction();
				listClassStudent = session.createQuery("FROM ClassStudent").list();
				session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return listClassStudent;
		}
 }

