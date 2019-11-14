package TranHieu.FinalQuanLySinhVien.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import TranHieu.FinalQuanLySinhVien.BO.Student;
import TranHieu.FinalQuanLySinhVien.BO.ClassStudent;

@ManagedBean(name = "studentDAO")
@SessionScoped
public class StudentDAO {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public StudentDAO() {
	}

	public void save(Object student) {
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
	
	public Student findByEmail(String email) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Student student = (Student)session.createQuery("FROM Student WHERE email =:email").setParameter("email", email).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return student;
	}

	public List<Student> showAll() {
		Session session = sessionFactory.openSession();
		List<Student> listStudent = new ArrayList<Student>();
		try {
			session.beginTransaction();
			listStudent = session.createQuery("FROM Student").setFirstResult(0).setMaxResults(1000).list();
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

	public List<Student> SearchFillterStudent(List<Student> list, String idStudent, String nameStudent,
			String villageStudent, String emailStudent,float agvOne,float agvTwo, boolean tickId, boolean tickName, boolean tickVillage,
			boolean tickEmail,boolean tickAgv) {
		Session session = sessionFactory.openSession();
		int count = 0;
		String hql = "FROM Student WHERE" + " ";
		boolean[] valueTick = { tickId, tickName, tickVillage, tickEmail ,tickAgv };
		String[] queryText = { "idStudent LIKE :idStudent ", "nameStudent LIKE :nameStudent ",
				"village LIKE :villageStudent ", "email LIKE :emailStudent ","avgStudent BETWEEN :agvOne AND :agvTwo " };
		try {
			session.beginTransaction();
			for (int i = 0; i < valueTick.length; i++) {
				if (valueTick[i]) {
					if (count == 0) {
						hql += queryText[i];

					} else
						hql += "AND " + queryText[i];
					count++;
				}
			}
			Query query = session.createQuery(hql);
			if (tickId)
				query = query.setParameter("idStudent", "%" + idStudent + "%");
			if (tickName)
				query = query.setParameter("nameStudent", "%" + nameStudent + "%");
			if (tickVillage)
				query = query.setParameter("villageStudent", "%" + villageStudent + "%");
			if (tickEmail)
				query = query.setParameter("emailStudent", "%" + emailStudent + "%");
			if(tickAgv)
				query = query.setParameter("agvOne", agvOne).setParameter("agvTwo", agvTwo);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

		return list;
	}

	public List<Student> sortBy(List<Student> listStudent, String sortBy, String value) {
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

			if (value.equals("DESC"))
				hql = hql + "DESC";
			else
				hql = hql + "ASC";

			listStudent = session.createQuery(hql).list();

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return listStudent;
	}

}
