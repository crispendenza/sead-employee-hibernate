package br.ufscar.sead.app;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.ufscar.sead.entities.Employee;
import br.ufscar.sead.utils.DateUtils;

public class CreateEmployee {

	public static void main(String[] args) throws ParseException {

		// setup and bootstrap
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Employee.class).
				buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		// hard coded go horse for tests 
		System.out.println("Creating employees");
		Employee firstEmployee = new Employee(
				"Cristian",
				"Kawakami",
				"SEaD",
				DateUtils.parseDate("10/08/2007"),
				null
				);

		Employee secondEmployee = new Employee(
				"Cristian",
				"Pendenza",
				"SEaD",
				DateUtils.parseDate("09/11/2009"),
				null
				);

		Employee thirdEmployee = new Employee(
				"Rodrigo",
				"Sucomine",
				"SEaD",
				DateUtils.parseDate("15/03/2012"),
				DateUtils.parseDate("11/11/2019")
				);	

		Employee fourthEmployee = new Employee(
				"Paulo",
				"Montanaro",
				"SEaD",
				DateUtils.parseDate("10/03/2010"),
				null
				);

		try {			

			session.beginTransaction();

			System.out.println("Saving employees (making them persistents objects)...");
			session.save(firstEmployee);
			session.save(secondEmployee);
			session.save(thirdEmployee);
			session.save(fourthEmployee);

			System.out.println("Committing to database...");
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
