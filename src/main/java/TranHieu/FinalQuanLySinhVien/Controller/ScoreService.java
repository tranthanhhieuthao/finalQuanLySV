package TranHieu.FinalQuanLySinhVien.Controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import TranHieu.FinalQuanLySinhVien.BO.Score;
import TranHieu.FinalQuanLySinhVien.DAO.ScoreDAO;

@ManagedBean(name="scoreService")
@SessionScoped
public class ScoreService implements ScoreInterface {

	public ScoreService() {
		
	}
	
	@ManagedProperty(value="#{scoreDAO}")
	private ScoreDAO scoreDAO;

	public void setScoreDAO(ScoreDAO scoreDAO) {
		this.scoreDAO = scoreDAO;
	}

	@Override
	public List<Score> listScoreStudent() {
		return scoreDAO.showAll();
	}

	@Override
	public Score findScoreOfStudentById(int id) {
		return scoreDAO.findById(id);
	}

	@Override
	public void save(Score scoreStudent) {
		scoreDAO.save(scoreStudent);
		
	}

	@Override
	public void Delete(int id) {
		scoreDAO.Delete(id);
		
	}

	@Override
	public void update(Score scoreUpdate) {
		scoreDAO.update(scoreUpdate);
		
	}

	
	
}
