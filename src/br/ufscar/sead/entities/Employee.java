package br.ufscar.sead.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.ufscar.sead.utils.DateUtils;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int id;

	@Column(name="first_name")
	public String firstName;
	
	@Column(name="last_name")
	public String lastName;
	
	@Column(name="company_name")	
	public String companyName;
	
	@Column(name="admission_date")
	@Temporal(TemporalType.DATE)
	public Date admissionDate;
	
	@Column(name="dismissal_date")
	@Temporal(TemporalType.DATE)
	public Date dismissalDate;
	
	public Employee (){}

	public Employee(String firstName, String lastName, String companyName, Date admissionDate,
			Date dismissalDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
		this.admissionDate = admissionDate;
		this.dismissalDate = dismissalDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public Date getDismissalDate() {
		return dismissalDate;
	}

	public void setDismissalDate(Date dismissalDate) {
		this.dismissalDate = dismissalDate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", companyName="
				+ companyName + ", admissionDate=" + DateUtils.formatDate(admissionDate)
				+ ", dismissalDate=" + ( dismissalDate == null ? "Not yet" : DateUtils.formatDate(dismissalDate) ) + "]";
	}
	
	

}
