package com.doranco.projet.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;


@Entity
@DiscriminatorValue("STUDENT")
public class Student extends User{
	
	@NotEmpty
	private String grade;
	
	@ManyToMany
	private List<Course> courses = new ArrayList<>();
	@OneToMany(mappedBy = "student")
	private List<Notification> notifications = new ArrayList<>();
	@OneToMany(mappedBy = "student")
	private List<Document> documents = new ArrayList<>();
	@OneToMany(mappedBy = "student")
	private List<Message> messages = new ArrayList<>();
	@ManyToOne
	private Establishment establishment;
	
	public Student() {
		
	}

	public String getGrade() {
		return grade;
	}



	public void setGrade(String grade) {
		this.grade = grade;
	}



	public List<Course> getCourses() {
		return courses;
	}



	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}



	public List<Notification> getNotifications() {
		return notifications;
	}



	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
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



	public Establishment getEstablishment() {
		return establishment;
	}



	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}



	public Student(Long id, String firstName, String lastName, LocalDate bDay, String adress, String postalCode,
			String city, String email, String password, String role, String phoneNumber, @NotEmpty String grade,
			List<Course> courses, List<Notification> notifications, List<Document> documents, List<Message> messages,
			Establishment establishment) {
		super(id, firstName, lastName, bDay, adress, postalCode, city, email, password, role);
		this.grade = grade;
		this.courses = courses;
		this.notifications = notifications;
		this.documents = documents;
		this.messages = messages;
		this.establishment = establishment;
	}
	
	

}
