package manytomanymaping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class manymapingtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration sf=new Configuration();
		sf.configure("hybernate.cfg.xml");
		SessionFactory factory=sf.buildSessionFactory();
	
		employee emp1=new employee();
		employee emp2=new employee();
		employee emp3=new employee();
		
		emp1.seteId(201);
		emp1.setEmployeeName("Sagar");
		
		emp2.seteId(202);
		emp2.setEmployeeName("Akshay");
		
		emp3.seteId(203);
		emp3.setEmployeeName("Sujit");
		
		Project pro1=new Project();
		Project pro2=new Project();
		Project pro3=new Project();
		
		pro1.setpId(121);
		pro1.setProjectName("Bank Of Iadia");
		
		pro2.setpId(122);
		pro2.setProjectName("Bank Of American");
		
		pro3.setpId(123);
		pro3.setProjectName("Bamk Of UAE");
		
		
		List<employee> list1 = new ArrayList<employee>();
		List<Project> list2 = new ArrayList<Project>();
		
		list1.add(emp1);
		list1.add(emp2);
		list1.add(emp3);
		
		
		list2.add(pro1);
		list2.add(pro2);
		list2.add(pro3);
		
		emp1.setProject(list2);
		pro2.setEmps(list1);
		emp2.setProject(list2);
		pro2.setEmps(list1);
		emp3.setProject(list2);
		pro3.setEmps(list1);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(emp1);
		s.save(emp2);
		s.save(emp3);
		s.save(pro1);
		s.save(pro2);
		s.save(pro3);
		
		
		tx.commit();
		s.close();
		
		
		
		
		factory.close();
	}

}
