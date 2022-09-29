package DemoHQL;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hybernateDemo.student;

public class HQLExample {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hybernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session s= factory.openSession();
		//HQL
		
		String query = "from student as s where s.city=:x and s.name=:n";
		Query q = s.createQuery(query);
		
		q.setParameter("x", "nagpur");
		q.setParameter("n", "sagar");
		
		//single - unique   & multiple - List
		
		List<student> list = q.list();
		
		for(student  stud:list) {
			System.out.println(stud.getName()+ " : "+stud.getCerti().getCourse());
			
		}
		System.out.println("----------------------------------------------------");
		Transaction tx=s.beginTransaction();
		//delete query
//		Query q2=s.createQuery("delete from student s where s.city=:c");
//		 
//		q2.setParameter("c", "nagpuri");
//		int r=q2.executeUpdate();
//		System.out.println("Deleted");
//		System.out.println(r);
		
		//update
		Query q2=s.createQuery("update from student set city=:c where name=:n");
		
		q2.setParameter("c", "nagpur");
		q2.setParameter("n", "mayur");
		int r=q2.executeUpdate();
		System.out.println(r+ "object updated ");
		
		tx.commit();
		//join table
		Query q3=s.createQuery("select q.question ,q.questionId,a.answer from Question as q INNER JOIN q.answers as a");
		
		List<Object[]> list3=q3.getResultList();
		for(Object[] arr:list3) {
			System.out.println(Arrays.toString(arr));
		}
		s.close();
		factory.close();
	}

}
