package TranHieu.FinalQuanLySinhVien.Controller;

import java.util.List;

import TranHieu.FinalQuanLySinhVien.BO.Score;


public interface ScoreInterface {

	public List<Score> listScoreStudent();

	public Score findScoreOfStudentById(int id);
	
	public void save(Score scoreStudent);
	
	public void Delete(int id);
	
	public void update(Score scoreUpdate);
	
//	public List<Score> showAllNoDuplicate();
}
