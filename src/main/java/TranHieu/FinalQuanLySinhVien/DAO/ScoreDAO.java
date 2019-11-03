package TranHieu.FinalQuanLySinhVien.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import TranHieu.FinalQuanLySinhVien.BO.ClassStudent;
import TranHieu.FinalQuanLySinhVien.BO.Score;

@ManagedBean(name="scoreDAO")
@SessionScoped
public class ScoreDAO {

	public ScoreDAO() {
		
	}
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	

	public void save(Score score) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(score);
			session.getTransaction().commit();
			System.out.println("insert success!!");
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		
			session.close();
		}
	}
	
	public void update(Score scoreUpdate) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(scoreUpdate);
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
			Score scoreRemove = this.findById(id);
			session.delete(scoreRemove);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

		public Score findById(int id) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Score scoreStudent = (Score) session.get(Score.class, id);
			session.getTransaction().commit();
			session.close();
			return scoreStudent;
		}

		public List<Score> showAll() {
			Session session = sessionFactory.openSession();
			List<Score> listScoreStudent = new ArrayList<Score>();
			try {
				session.beginTransaction();
				listScoreStudent = session.createQuery("FROM Score").list();
				session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return listScoreStudent;
		}
		

}
