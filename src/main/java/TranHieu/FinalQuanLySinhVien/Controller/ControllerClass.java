package TranHieu.FinalQuanLySinhVien.Controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import TranHieu.FinalQuanLySinhVien.BO.ClassStudent;

@ManagedBean(name="controllerClass")
@SessionScoped
public class ControllerClass {
	
	@ManagedProperty(value ="#{classService}")
	private ClassService classService;
	
	@ManagedProperty(value ="#{classBean}")
	private ClassStudent classStudentBean;
	
	private List<ClassStudent> listClassStudent;


	public ControllerClass() {
		
	}

	public void setClassService(ClassService classService) {
		this.classService = classService;
	}

	public List<ClassStudent> getListClassStudent() {
		listClassStudent =classService.listClassStudent();
		return listClassStudent;
	}

	public void setListClassStudent(List<ClassStudent> listClassStudent) {
		this.listClassStudent = listClassStudent;
	}
	
	public String findClassStudentById(int id) {
		classStudentBean =classService.findClassStudentById(id);
		return "StudentOfClass";
	}

	public void setClassStudentBean(ClassStudent classStudentBean) {
		this.classStudentBean = classStudentBean;
	}

	public ClassStudent getClassStudentBean() {
		return classStudentBean;
	}



	
}
