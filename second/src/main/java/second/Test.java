package second;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Test {
	public static void main(String args[]) {
		 Configuration config= new Configuration();
		   config.configure();
		   config.addAnnotatedClass(User.class);
		   
		   SessionFactory factory= config.buildSessionFactory();
		   Session session=factory.openSession();
		   Transaction trans=session.beginTransaction();
		   
		   User u=new User(1,"Raghu","Raghu1818");
		   session.persist(u);
		   trans.commit();
	}

}
