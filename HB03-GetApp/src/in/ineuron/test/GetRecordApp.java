package in.ineuron.test;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class GetRecordApp {

	public static void main(String[] args) {
		
		Session session=null;
		Integer id=99;
		
		session=HibernateUtil.getSession();
		
		try {
			
			if(session != null) {
				Student student=session.get(Student.class,id);
				//System.out.println(student);
				if(student != null) {
					System.out.println(student);
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
