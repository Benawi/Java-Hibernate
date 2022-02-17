

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

private static final SessionFactory sessionFactory;
	
	static{
		try{
			Configuration configuration = new Configuration();//step 1
			configuration.configure("hibernate_3.cfg.xml");//step 2
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
			applySettings(configuration.getProperties());//step 3
			sessionFactory = configuration.buildSessionFactory(builder.build());//step 4
			
		}catch(Throwable exception){
			System.out.println("Session Creation Error : "+exception);
			throw new ExceptionInInitializerError(exception);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutDown(){
		sessionFactory.close();
	}
}


