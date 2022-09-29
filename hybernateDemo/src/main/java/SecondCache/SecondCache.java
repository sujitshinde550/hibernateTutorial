package SecondCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hybernateDemo.student;
import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;
import net.sf.ehcache.hibernate.EhCacheRegionFactory;

public class SecondCache {

	public static void main(String[] args) {
	SessionFactory	factory=new Configuration().configure("hybernate.cfg.xml").buildSessionFactory();
	Session s=factory.openSession();
	
	student student = s.get(student.class, 190);
	System.out.println(student);
	s.close();
	
	Session s2=factory.openSession();
	hybernateDemo.student student2 = s2.get(student.class, 190);
	
	System.out.println(student2);
	
	s2.close();
	
	
	
	
	}

}
