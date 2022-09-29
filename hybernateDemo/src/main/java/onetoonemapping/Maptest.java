package onetoonemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Maptest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration sf=new Configuration();
		sf.configure("hybernate.cfg.xml");
		SessionFactory factory=sf.buildSessionFactory();
	//add que  & Ans......
		Question que1 = new Question();
		que1.setQuestionId(1010);
		que1.setQuestion("What is java?");

		Answer ans1 = new Answer();
		ans1.setAnswerId(1212);
		ans1.setAnswer("Java is object oriented, functional, reactance,rhobust,secure,multithreaded programing language.");
		ans1.setQuestion(que1);
		que1.setAnswer(ans1);
		
		Question que2 = new Question();
		que2.setQuestionId(1011);
		que2.setQuestion("What is Abstract class in java?");

		Answer ans2 = new Answer();
		ans2.setAnswerId(1211);
		ans2.setAnswer("Hiding implemented code and showing functionality to user that means abstraction.");
		ans2.setQuestion(que2);
		que2.setAnswer(ans2 );
		
		Question que3 = new Question();
		que2.setQuestionId(1013);
		que2.setQuestion("What is interface class in java?");
		
		Answer ans3 = new Answer();
		ans3.setAnswerId(1213);
		ans3.setAnswer("An interface in Java is a blueprint of a class. It has static constants and abstract methods. The interface in Java is a mechanism to achieve abstraction.");
		ans3.setQuestion(que2);
		que3.setAnswer(ans3 );
		
		
		
		//open session & transection....
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		//save data.........
		s.save(que1);
		s.save(que2);
		s.save(que3);
		s.save(ans1);
		s.save(ans2);
		s.save(ans3);
		
		tx.commit();
		//show or featch data.......
		
	Question ques =(Question)s.get(Question.class, 1010);
	System.out.println(ques.getQuestion());
	System.out.println(ques.getAnswer().getAnswer());
		s.close();
		factory.close();
	}

}
