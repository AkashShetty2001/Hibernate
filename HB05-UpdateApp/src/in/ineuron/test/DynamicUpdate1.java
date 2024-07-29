package in.ineuron.test;
import javax.persistence.EntityTransaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class DynamicUpdate1 {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		
		session=HibernateUtil.getSession();
		
		try {
			
			if(session != null) {
			
				Student student=session.get(Student.class, 1);
				transaction=session.beginTransaction();
				if(transaction != null) {
					if(student!=null) {
						student.setSage(55);
						session.update(student);
						flag=true;
					}
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
