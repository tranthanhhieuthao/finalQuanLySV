package TranHieu.FinalQuanLySinhVien;

import java.util.Date;

import org.primefaces.component.calendar.Calendar;

import TranHieu.FinalQuanLySinhVien.BO.ClassStudent;
import TranHieu.FinalQuanLySinhVien.BO.Score;
import TranHieu.FinalQuanLySinhVien.BO.Student;
import TranHieu.FinalQuanLySinhVien.DAO.StudentDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StudentDAO studentDAO = new StudentDAO();
    
        String[] nameStudent= {"Hieu","Thao","Linh Chi","Minh","Thao Tran","Tran Hieu","Nam","Tuan Anh","Thanh Quang","Xuan Hai","Sang","Thu Sang","Trang","Giang","Tran Son",
        		"Quang Nam","Dinh Vu","Hao Ngoc","Vinh Tran","Quoc Anh","Tran Thien","Bao Ngoc","Lam","Dat","Tung","Chung","Gia","Thanh Thien","Quoc Bao"};
        String[] provide = {"Nghe An","Cao Bang","Lang son","Ha Noi","Ha Tinh","Thanh Hoa","Ha Nam","Vinh Phuc","Son La","Hai Duong","Nam Dinh","Thai Binh",
        		"Ho Chi Minh","Da Nang","Can Tho","Ba Ria Vung Tau","Binh Dinh"};
        String[] email = {"hieu@gmail.com","nam@gmail.com","chien@gmail.com","sang@gmail.com","tien@gmail.com","hai@gmail.com","dinh@gmail.com","dat@gmail.com","chung@gmail.com","tung@gmail.com","gia@gmail.com"};
        float[] agv = {5.0f,6.5f,6.8f,4.0f,9.0f,10.0f,4.5f,5.0f,8.5f,7.5f,7.0f,9.5f,5.4f,8.4f,7.3f,9.2f,4.6f,9.2f};
        int[] age = {25,18,16,20,23,21,24,28,34,35,26,28,27,35,31,36,14,16,19,18,17,15,11,10,32,24,25,26,25};
        int[] phone = {0234,0125,0236,01223,0145,0235,01256,2856};
        String[] note = {"haha","khong co gi","dang chan doi","dang yeu đoi","fall in love"};
        Date[] birthDay = {new Date(1992, 06, 15),new Date(1993, 12, 21),new Date(1988, 02, 15),new Date(1996, 04, 15),new Date(1997, 04, 14),new Date(1995, 06, 15),new Date(1998, 07, 15)
        		,new Date(1996, 05, 15)};
        for(int i=1;i<=100;i++) {
      	
        	   Student student = new Student(nameStudent[(int)Math.round(Math.random()*(nameStudent.length-1))],
        			age[(int)Math.round(Math.random()*(age.length-1))],
        			provide[(int)Math.round(Math.random()*(provide.length-1))],
        			phone[(int)Math.round(Math.random()*(phone.length-1))],
        			email[(int)Math.round(Math.random()*(email.length-1))],      			       	        			
        			note[(int)Math.round(Math.random()*(note.length-1))],
        			birthDay[(int)Math.round(Math.random()*(birthDay.length-1))],
        			agv[(int)Math.round(Math.random()*(agv.length-1))]
        			);
        	studentDAO.save(student);

        }
        

        
        
//        String[] nameClass = {"A1-Chuyen toan","A2-Chuyen Hoa","A3-Chuyen Ly","A4-Chuyen Sinh","A5-Chuyen Van","A6-Chuyen Su"};
//        String[] noteStudent = {"Khong co gi"};
//        

        
//        int[] student_id = new  int[250];
//        int[] course_id = new  int[16];
//        float[] score = new float[20];
//        for(int i=1;i<=250;i++) {
//        	student_id[i]=(int)(Math.round(Math.random()*250)+1);
//        }
//        for(int i=1;i<=16;i++) {  
//        	course_id[i] =(int)(Math.round(Math.random()*16)+1);
//        }
//        for(int i=1;i<=20;i++) {  
//        	score[i] =(float)(Math.round(Math.random()*10.0)+4.0);
//        }
        
//        Score scoreStudent = new Score();
      
        
     
        
    }
}