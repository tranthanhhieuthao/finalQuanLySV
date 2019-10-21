package TranHieu.FinalQuanLySinhVien.DAO;

import java.util.ArrayList;
import java.util.List;

import TranHieu.FinalQuanLySinhVien.BO.Student;

public class TestDAO {
	public static void main(String[] args) {
	StudentDAO studentDAO = new StudentDAO();
		
		System.out.println(studentDAO.findById(0).getAge());
	}

}
