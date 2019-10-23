package TranHieu.FinalQuanLySinhVien.DAO;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import TranHieu.FinalQuanLySinhVien.BO.Student;

@ManagedBean(name = "studentDAO")
@SessionScoped
public class StudentDAO {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public StudentDAO() {
	}

	public void save(Student student) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(student);
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

	public Student findById(int id) {
		Session session = sessionFactory.openSession();
		Student student = (Student) session.get(Student.class, id);
		session.close();
		return student;
	}

	public List<Student> showAll() {
		Session session = sessionFactory.openSession();
		List<Student> listStudent = session.createQuery("FROM Student").list();
		return listStudent;
	}

	public void Delete(int id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Student studentRemove = this.findById(id);
			session.delete(studentRemove);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			session.close();
		}
	}

	public void Edit(Student studentEdit) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(studentEdit);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	

}
