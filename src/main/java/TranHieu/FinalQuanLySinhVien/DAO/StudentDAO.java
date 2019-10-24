package TranHieu.FinalQuanLySinhVien.DAO;

import java.util.ArrayList;
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
		session.beginTransaction();
		Student student = (Student) session.get(Student.class, id);
		session.getTransaction().commit();
		session.close();
		return student;
	}

	public List<Student> showAll() {
		Session session = sessionFactory.openSession();
		List<Student> listStudent = new ArrayList<Student>();
		try {
			session.beginTransaction();
			listStudent = session.createQuery("FROM Student").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
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

	public List<Student> searchByName(List<Student> list, String name) {

		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			list = session.createQuery("FROM Student WHERE nameStudent LIKE:name")
					.setParameter("name", "%" + name + "%").list();
			session.getTransaction().commit();
			for (Student customer : list) {
				System.out.println(customer.getNameStudent());

			}
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Student> sortBy(List<Student> listStudent, String sortBy ,String value) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			String hql = null;
			if (sortBy.equals("Id")) {
				hql = "FROM Student S ORDER BY S.id ";
			} else if (sortBy.equals("nameStudent")) {
				hql = "FROM Student S ORDER BY S.nameStudent  ";
			} else if (sortBy.equals("Age")) {
				hql = "FROM Student S ORDER BY S.age ";
			}
			
			if(value.equals("DESC")) hql = hql + "DESC";
			else hql = hql +"ASC";

			listStudent = session.createQuery(hql).list();
			for (Student customer : listStudent) {
				System.out.println(customer.getNameStudent());

			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return listStudent;
	}

	public List<Class> findListClassByStudentId(List<Class> listClass, int id) {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			String hql = "FROM Class c JOIN Student s ON s.id =:id";
			listClass = session.createQuery(hql).setParameter("id", id).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return listClass;
	}

}
