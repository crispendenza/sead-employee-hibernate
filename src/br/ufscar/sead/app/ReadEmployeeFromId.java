package br.ufscar.sead.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.ufscar.sead.entities.Employee;

public class ReadEmployeeFromId {

	public static void main(String[] args) {

		// setup and bootstrap
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Employee.class).
				buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		int id = 2;
		
		try {			
						
			session.beginTransaction();

			System.out.println("Reading Employee of id: " + id);
		//	Query query = session.createQuery("FROM Employee e WHERE e.id = :id ");
		//	query.setParameter("id", id);
				
			Employee employee = session.get(Employee.class, id);
			
			if (employee != null) {
				System.out.println(employee);
			} else {
				System.out.println("Employee not found");
			}
			
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {

			e.printStackTrace();

		}

		finally {
			factory.close();

		}

	}

}
