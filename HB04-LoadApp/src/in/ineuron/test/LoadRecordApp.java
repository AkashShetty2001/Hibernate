package in.ineuron.test;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class LoadRecordApp {

	public static void main(String[] args) {
		
		Session session=null;
		Integer id=1;
		
		session=HibernateUtil.getSession();
		
		try {
			
			if(session != null) {
				Student student=session.load(Student.class,id);
				if(student != null) {
					System.out.println("Stuident Id is: "+student.getSid());
					
					System.in.read();
					
					
					System.out.println("Stuident name is: "+student.getSname());
					System.out.println("Stuident age is: "+student.getSage());
					System.out.println("Stuident address is: "+student.getSaddress());
				}else {
					System.out.println("record not found for given id.."+ id);
				}
				
			}
		}catch(HibernateException e) {
			e.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}
		

	}

}
