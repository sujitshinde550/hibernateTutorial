package hybernateStates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hybernateDemo.Certificate;
import hybernateDemo.student;

public class StudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//practical of hybernate object state:
		//transient
		//Persistence
		//detached
		//remove
		System.out.println("Example :");
		SessionFactory f = new Configuration().configure("hybernate.cfg.xml").buildSessionFactory();
		//creat student class obj
		student std = new student();
		
		std.setId(190);
		std.setName("kunal");
		std.setCerti(new Certificate("core java","2-months"));
		std.setCity("Hydrabad");
		
		//Transient State:
		
		Session  s = f.openSession();
		Transaction tx=s.beginTransaction();
	//Persistence stage:
		s.save(std);
		std.setName("raju");
		tx.commit();
		//detach state
		s.close();
		f.close();
	}

}
