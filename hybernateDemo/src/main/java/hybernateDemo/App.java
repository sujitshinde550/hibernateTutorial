package hybernateDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("Hallo project..");
		Configuration sf=new Configuration();
		sf.configure("hybernate.cfg.xml");
		SessionFactory factory=sf.buildSessionFactory();
	
		//student class object
//		student st=new student();
//		st.setId(100);
//		st.setName("Samir");
//		st.setCity("Nashik");
//		System.out.println(st);
		
		//address class object
		Address add=new Address();
		add.setAddressId(101);
		add.setStreet("Street1");
		add.setCity("Pune");
		add.setOpen(true);
		add.setAddedDate(new Date());
		add.setX(123.321);
		
		//read img
		FileInputStream  file=new FileInputStream("src/main/java/sc.png");;
		byte[] data=new byte[file.available()];
		
		add.setImage(data);
		
		Session session=factory.openSession();
		//System.out.println(factory);
		//System.out.println(factory.isClosed());
		Transaction tx=session.beginTransaction();
		//session.save(st);
		session.save(add);
		tx.commit();

		session.close();
		System.out.println("Done");
	}
}
