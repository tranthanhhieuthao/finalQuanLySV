package TranHieu.FinalQuanLySinhVien;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name ="viewBean")
@SessionScoped
public class ViewBean implements Serializable  {
	
	public ViewBean() {
		page ="ListStudent.xhtml";
	}
	private String page ;
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	
	

}
