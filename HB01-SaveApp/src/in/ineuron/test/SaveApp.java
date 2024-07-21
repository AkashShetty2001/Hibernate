package in.ineuron.test;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class SaveApp {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		
		session=HibernateUtil.getSession();
		
		try {
			
			if(session != null) {
				transaction=session.beginTransaction();
			}
			
			if(transaction != null) {
				
				Student s1= new Student();
				s1.setSid(01);
				s1.setSname("ravikumar");
				s1.setSage(23);
				s1.setSaddress("bengalore, tumkuar");
				
				session.save(s1);
				flag=true;
			}
			
		}catch(HibernateException e) {
			e.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(flag==true) {
				transaction.commit();
				System.out.println("Object data saved successfully");
			}else {
				transaction.rollback();
				System.out.println("object data not saved successfully");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}
		

	}

}
