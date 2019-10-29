package TranHieu.FinalQuanLySinhVien.Controller;

import java.util.List;
import java.util.Set;

import TranHieu.FinalQuanLySinhVien.BO.ClassStudent;

public interface ClassInterface {
	
	public List<ClassStudent> listClassStudent();

	public ClassStudent findClassStudentById(int id);
	
	public void save(ClassStudent classStudent);
	
	public void Delete(int id);
	
	public void update(ClassStudent classUpdate);

}
