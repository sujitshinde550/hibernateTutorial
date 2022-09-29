package onetomanymapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class mapingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration sf=new Configuration();
		sf.configure("hybernate.cfg.xml");
		SessionFactory factory=sf.buildSessionFactory();
	
		//add que  & Ans......
		Questions que1 = new Questions();
		que1.setQuestionId(1234);
		que1.setQuestion("What is java?"); 

		Answers ans1 = new Answers();
		ans1.setAnswerId(123);
		ans1.setAnswer("Java is object oriented, functional programming language.");
		ans1.setQuestion(que1);
		
		

		Answers ans2 = new Answers();
		ans2.setAnswerId(321);
		ans2.setAnswer("reactance,robust,secure programming language. ");
		ans2.setQuestion(que1);
		
		
		Answers ans3 = new Answers();
		ans3.setAnswerId(543);
		ans3.setAnswer("multithreaded programming language.");
		ans3.setQuestion(que1);
		
		
		List<Answers> list = new ArrayList<Answers>();
		list.add(ans1);
		list.add(ans2);
		list.add(ans3);
		que1.setAnswers(list);
		
			//open session & transaction....
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		//save data.........
		s.save(que1);
		
		s.save(ans1);
		s.save(ans2);
		s.save(ans3);
		
		
		//show or featch data.......
	
//	Questions ques =(Questions)s.get(Questions.class, 1234);
//	System.out.println(ques.getQuestion());
//	System.out.println(ques.getQuestionId());
	
	
//		 for( Answers a : ques.getAnswers())
//		 {
//			 System.out.println(a.getAnswer());
//		 }
//			 
//		
		
		
		
		tx.commit();
		
		s.close();
		factory.close();
	}

}
