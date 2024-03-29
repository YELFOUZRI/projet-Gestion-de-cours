package com.doranco.projet.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
@DiscriminatorValue("INSTRUCTOR")
public class Instructor extends User{
	
	


	@NotEmpty
	private String speciality;
	@OneToMany(mappedBy = "instructor")
	private List<Course> course= new ArrayList<>();		
	@OneToMany(mappedBy = "instructor")
	private List<Document> documents = new ArrayList<>();
	@OneToMany(mappedBy = "instructor")
	private List<Message> messages = new ArrayList<>();
	@OneToMany(mappedBy = "instructor")
	private List<Notification> notification = new ArrayList<>();
	@ManyToOne
	private Establishment establishment;
	
	
	public Instructor() {
		
	}
	

	
	public String getSpeciality() {
		return speciality;
	}
	
	
	
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}


	public List<Course> getCourse() {
		return course;
	}


	public void setCourse(List<Course> course) {
		this.course = course;
	}


	public List<Document> getDocuments() {
		return documents;
	}


	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}


	public List<Message> getMessages() {
		return messages;
	}


	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}


	public List<Notification> getNotification() {
		return notification;
	}


	public void setNotification(List<Notification> notification) {
		this.notification = notification;
	}


	public Establishment getEstablishment() {
		return establishment;
	}


	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}



	public Instructor(Long id, @NotEmpty @Size(max = 30) String firstName, @NotEmpty @Size(max = 30) String lastName,
			LocalDate bDay, @NotEmpty String adress, @NotEmpty @Size(max = 5, min = 5) String postalCode,
			@NotEmpty String city, @NotEmpty String email, @NotEmpty String password, String phoneNumber, Boolean activ,
			@NotEmpty String speciality, List<Course> course, List<Document> documents, List<Message> messages,
			List<Notification> notification, Establishment establishment) {
		super(id, firstName, lastName, bDay, adress, postalCode, city, email, password, phoneNumber, activ);
		this.speciality = speciality;
		this.course = course;
		this.documents = documents;
		this.messages = messages;
		this.notification = notification;
		this.establishment = establishment;
	}


	
	
	

	
}
