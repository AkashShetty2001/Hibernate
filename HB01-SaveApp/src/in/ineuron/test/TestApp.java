package in.ineuron.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class TestApp {

	public static void main(String[] args) {
		
		//1.inform JVM to activate Hibernate
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		
		//creating a SessionFactory object to hold other objects  that are required for hibernate
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();//l1 cache,connection object,mysql8 dialect object
		
		
		//begin transaction if non select Query is performed
		Transaction transaction=session.beginTransaction();
		
		
		//2.Create Persistence Object
		Student s1= new Student();
		s1.setSname("Akash");
		s1.setSid(400);
		s1.setSaddress("Bengaluru");
		s1.setSage(23);
		
		
		//3.perform persistence operation using Entity/Model/POJO object
		session.save(s1);
		
		//4.Generate the Query and send it to database
		transaction.commit();
		
		System.out.println("Object saved to database.....");
	}

}
