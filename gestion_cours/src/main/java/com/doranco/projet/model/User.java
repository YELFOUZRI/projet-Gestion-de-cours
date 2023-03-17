package com.doranco.projet.model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import java.time.LocalDate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="USERS")

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public abstract class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@Size(max = 30)
	private String firstName;
	@NotEmpty
	@Size(max = 30)
	private String lastName;
	@Temporal(TemporalType.DATE)
	private LocalDate bDay;
	@NotEmpty
	private String adress;
	@NotEmpty
	@Size(max = 5,min = 5)
	private String postalCode;
	@NotEmpty
	private String city;
	@NotEmpty
	private String email;
	@NotEmpty
	private String password;
	private String phoneNumber;	
	private Boolean activ;
	
	public User() {
		
	}
	
	
	
		public User(Long id, @NotEmpty @Size(max = 30) String firstName, @NotEmpty @Size(max = 30) String lastName,
		LocalDate bDay, @NotEmpty String adress, @NotEmpty @Size(max = 5, min = 5) String postalCode,
		@NotEmpty String city, @NotEmpty String email, @NotEmpty String password, String phoneNumber, Boolean activ) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.bDay = bDay;
	this.adress = adress;
	this.postalCode = postalCode;
	this.city = city;
	this.email = email;
	this.password = password;
	this.phoneNumber = phoneNumber;
	this.activ = activ;
}
	



	public Boolean getActiv() {
		return activ;
	}





	public void setActiv(Boolean activ) {
		this.activ = activ;
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
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



	public LocalDate getbDay() {
		return bDay;
	}



	public void setbDay(LocalDate bDay) {
		this.bDay = bDay;
	}



	public String getAdress() {
		return adress;
	}



	public void setAdress(String adress) {
		this.adress = adress;
	}



	public String getPostalCode() {
		return postalCode;
	}



	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", bDay=" + bDay + ", adress="
				+ adress + ", postalCode=" + postalCode + ", city=" + city + ", email=" + email + ", password="
				+ password + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	
}
