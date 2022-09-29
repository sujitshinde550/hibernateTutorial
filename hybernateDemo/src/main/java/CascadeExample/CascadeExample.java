package CascadeExample;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import onetomanymapping.Answers;
import onetomanymapping.Questions;
import onetoonemapping.Answer;

public class CascadeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hybernate.cfg.xml").buildSessionFactory();
		 Session s= factory.openSession();
		 
		Questions q1= new Questions();
		 q1.setQuestionId(5555);
		 q1.setQuestion("what is interface in java?");
		 
		 Answers a1=new Answers(4356,"interface means fully abstract class", q1);
		 Answers a2=new Answers(435,"interface means fully abstract class", q1);
		 Answers a3=new Answers(43,"interface means fully abstract class", q1);
  List<Answers>list=new ArrayList();
  list.add(a1);
  list.add(a2);
  list.add(a3);
  
  q1.setAnswers(list);
  Transaction tx=s.beginTransaction();
  s.save(q1);
 
  
  tx.commit();
		 s.close();
			factory.close();
	}

}
