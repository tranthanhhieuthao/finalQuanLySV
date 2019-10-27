package TranHieu.FinalQuanLySinhVien.Controller;

import java.util.List;

import TranHieu.FinalQuanLySinhVien.BO.ClassStudent;

public interface ClassInterface {
	
	public List<ClassStudent> listClassStudent();

	public ClassStudent findClassStudentById(int id);

}
