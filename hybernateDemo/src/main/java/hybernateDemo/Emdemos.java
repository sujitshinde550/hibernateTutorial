package hybernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Emdemos { public static void main(String[] args) {
	

	Configuration sf=new Configuration();
	sf.configure("hybernate.cfg.xml");
	SessionFactory factory=sf.buildSessionFactory();
 
	student std1=new student();
	std1.setId(1234);
	std1.setName("sagari");
	std1.setCity("nagpuri");   
	
	
	Certificate certificate1=new Certificate();
	certificate1.setCourse("java Developer");
	certificate1.setDuration("3 Months");
	std1.setCerti(certificate1);
	
	student std2=new student();
	std2.setId(1224);
	std2.setName("raj");
	std2.setCity("jaypuri");   
	
	
	Certificate certificate2=new Certificate();
	certificate2.setCourse("java Developer");
	certificate2.setDuration("3 Months");
    std2.setCerti(certificate2);
    
    Session session=factory.openSession();
    Transaction trx=session.beginTransaction();
    
    //save obj
    session.save(std1);
    session.save(std2);
    trx.commit();
    
    
    
    session.close();
    factory.close();
    
}
} 