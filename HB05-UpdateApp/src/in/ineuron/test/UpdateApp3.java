package in.ineuron.test;
import javax.persistence.EntityTransaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class UpdateApp3 {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		
		session=HibernateUtil.getSession();
		
		try {
			
			if(session != null) {
			
				transaction=session.beginTransaction();
				if(transaction != null) {
					Student student = new Student();
					student.setSid(99);
					student.setSname("Gayle");
					student.setSage(41);
					student.setSaddress("Kolkata");
					
					session.saveOrUpdate(student);
					flag=true;
				}
				 	
				else {
					System.out.println("record not found");
				}
				
			}
		}catch(HibernateException e) {
			e.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				
				transaction.commit();
				System.out.println("updated successfully");
			}else {
				transaction.rollback();
				System.out.println("not updated...");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}
		

	}

}
