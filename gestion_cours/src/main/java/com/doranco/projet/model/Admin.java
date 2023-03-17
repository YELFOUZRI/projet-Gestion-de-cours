package com.doranco.projet.model;

import java.time.LocalDate;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.ToString;

@Entity
@ToString
@DiscriminatorValue("ADMIN")
public class Admin extends User{public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

public Admin(Long id, @NotEmpty @Size(max = 30) String firstName, @NotEmpty @Size(max = 30) String lastName,
		LocalDate bDay, @NotEmpty String adress, @NotEmpty @Size(max = 5, min = 5) String postalCode,
		@NotEmpty String city, @NotEmpty String email, @NotEmpty String password, String phoneNumber, Boolean activ) {
	super(id, firstName, lastName, bDay, adress, postalCode, city, email, password, phoneNumber, activ);
	// TODO Auto-generated constructor stub
}



	
	

}
