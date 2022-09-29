package pagenation;

import org.hibernate.query.*;

import hybernateDemo.student;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hqlpagination {
public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure("hy bernate.cfg.xml").buildSessionFactory();
  Session s =factory.openSession();
  
  Query  query=s.createQuery("from student");
  //implementing pegination
  query.setFirstResult(0);
  query.setMaxResults(5);
  List<student> list=query.list();
  
  for(student std: list) {
	  System.out.println(std.getId()+" : "+std.getName()+" : "+std.getCity());
  }
	 
s.close();
factory.close();
}
}
