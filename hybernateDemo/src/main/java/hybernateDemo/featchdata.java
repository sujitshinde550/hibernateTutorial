package hybernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class featchdata {
	public static void main(String[] args) {
        // using get ,load method
		Configuration sf=new Configuration();
		sf.configure("hybernate.cfg.xml");
		SessionFactory factory=sf.buildSessionFactory();
		
		Session session=factory.openSession();
		//get method student=101
		
		 student Student=(student)session.load(student.class, 100);
		 System.out.println(Student);
		System.out.println(Student.getName());
	//	Address addre=(Address)session.load(Address.class, 101);
		//System.out.println(addre);
		factory.close();
		
		
	
	}
}
