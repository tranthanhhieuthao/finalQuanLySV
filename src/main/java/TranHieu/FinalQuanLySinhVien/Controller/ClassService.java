package TranHieu.FinalQuanLySinhVien.Controller;

import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import TranHieu.FinalQuanLySinhVien.BO.ClassStudent;
import TranHieu.FinalQuanLySinhVien.DAO.ClassDAO;

@ManagedBean(name = "classService")
@SessionScoped
public class ClassService implements ClassInterface{
	
	public ClassService() {
		
	}

	@ManagedProperty(value = "#{classDAO}")
	private ClassDAO classDAO;
	
	@Override
	public List<ClassStudent> listClassStudent() {	
		return classDAO.showAll();
	}

	public void setClassDAO(ClassDAO classDAO) {
		this.classDAO = classDAO;
	}

	@Override
	public ClassStudent findClassStudentById(int id) {
		return classDAO.findById(id);
	}
	
	public void save(ClassStudent classStudent) {
		classDAO.save(classStudent);
	}
	
	public void Delete(int id) {
		classDAO.Delete(id);
	}
	
	public void update(ClassStudent classUpdate) {
		classDAO.update(classUpdate);
	}

}
