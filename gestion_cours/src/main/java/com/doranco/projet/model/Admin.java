package com.doranco.projet.model;

import java.time.LocalDate;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.ToString;

@Entity
@ToString
@DiscriminatorValue("ADMIN")
public class Admin extends User{public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Long id, String firstName, String lastName, LocalDate bDay, String adress, String postalCode,
			String city, String email, String password, String phoneNumber) {
		super(id, firstName, lastName, bDay, adress, postalCode, city, email, password, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	
	

}
