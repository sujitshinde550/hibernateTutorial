package SQLExample;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import hybernateDemo.student;

public class SQLExample {

	public static void main(String[] args) {
 SessionFactory factory=new Configuration().configure("hybernate.cfg.xml").buildSessionFactory();
 Session s= factory.openSession();
 //SQL Query
 String q="select * From student";
 NativeQuery  nq=s.createSQLQuery(q);
 List<Object[]> list =nq.list();
 for(Object[] stu : list) {
	// System.out.println(Arrays.toString(stu));
	 System.out.println(stu[4]+" : "+stu[3]);
 
 }
 
 s.close();
	factory.close();
	}

}
