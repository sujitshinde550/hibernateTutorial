package Caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hybernateDemo.student;

public class Caching {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hybernate.cfg.xml").buildSessionFactory();
		 Session s= factory.openSession();
		 //by default enable
		 student student = s.get(student.class,190);;
		  System.out.println(student);
		 hybernateDemo.student student2 = s.get(student.class, 190);
		 System.out.println(student2);
		 s.close();

	}

}
