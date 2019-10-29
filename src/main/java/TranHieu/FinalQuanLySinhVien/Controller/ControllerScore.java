package TranHieu.FinalQuanLySinhVien.Controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import TranHieu.FinalQuanLySinhVien.BO.Score;

@ManagedBean(name="controllerScore")
@SessionScoped
public class ControllerScore {

	public ControllerScore() {
		
	}
	
	@ManagedProperty(value="#{scoreService}")
	private ScoreService scoreService;
	
	@ManagedProperty(value="#{scoreBean}")
	private Score scoreBean;
	
	private List<Score> listScoreStudent;

	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}

	public void setScoreBean(Score scoreBean) {
		this.scoreBean = scoreBean;
	}
	

	public Score getScoreBean() {
		return scoreBean;
	}

	public List<Score> getListScoreStudent() {
		return scoreService.listScoreStudent();
	}

	public void setListScoreStudent(List<Score> listScoreStudent) {
		this.listScoreStudent = listScoreStudent;
	}
	
	public String EditScore() {
		scoreService.update(scoreBean);
		return "ListScore";
		
	}
	
	public String viewEditScore(int id) {
		scoreBean =scoreService.findScoreOfStudentById(id);
		return "EditScore";
		
	}
	
	
	public String MarkScoreForStudent() {
		scoreBean.setCourse(null);//hien 1 list course roi pick theo id
		scoreBean.setScoreStudent(0);
		scoreBean.setStudent(null);//hien 1 list student roi pick theo id
		scoreService.save(scoreBean);
		return null;
	}
	
	
}
