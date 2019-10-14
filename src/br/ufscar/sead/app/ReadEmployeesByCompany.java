package br.ufscar.sead.app;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import br.ufscar.sead.entities.Employee;

public class ReadEmployeesByCompany {

	public static void main(String[] args) {
		// setup and bootstrap
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Employee.class).
				buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		String company = "SEaD";
		
		try {			

			session.beginTransaction();

			System.out.println("Reading Employees of company " + company);

//			works too
//			@SuppressWarnings("unchecked")
//			List<Employee> employees = session
//					.createQuery("from Employee e where e.companyName='" + company + "'")
//					.getResultList();
						
			
			@SuppressWarnings("unchecked")
			List<Employee> employees = session
					.createQuery("from Employee e where e.companyName = :company ")
					.setParameter("company", company)
					.getResultList();
			
			displayAll(employees);
			
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {

			e.printStackTrace();

		}

		finally {
			factory.close();

		}

	}

	protected static void displayAll(List<Employee> employees) {
		for ( Employee e : employees ) {
			System.out.println(e);
		}
	}

}
