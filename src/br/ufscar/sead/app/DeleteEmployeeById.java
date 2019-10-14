package br.ufscar.sead.app;

import java.text.ParseException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import br.ufscar.sead.entities.Employee;

public class DeleteEmployeeById {

	public static void main(String[] args) throws ParseException {

		// setup and bootstrap
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Employee.class).
				buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		int id = 1;
		
		try {			

			session.beginTransaction();

			Employee employee = session.get(Employee.class, id);
			
			System.out.println("Deleting from database...");
			session.delete(employee);				
			
			System.out.println("Committing updates to database...");
			session.getTransaction().commit();

			System.out.println("Success!");

		} catch (Exception e) {

			e.printStackTrace();

		}

		finally {

			factory.close();

		}


	}

}
