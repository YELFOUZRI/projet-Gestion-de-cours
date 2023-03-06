package com.doranco.projet.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "CLASSROOMS")
public class ClassRoom {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String number;
	private String capacity;
	@ManyToOne
	private Establishment establishment;
	@OneToMany(mappedBy = "classRoom")
	private List<Course> course;
	
	public ClassRoom() {
		
	}
	
	public ClassRoom(Long id, String number, String capacity, Establishment establishment, List<Course> course) {
		super();
		this.id = id;
		this.number = number;
		this.capacity = capacity;
		this.establishment = establishment;
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "ClassRoom [id=" + id + ", number=" + number + ", capacity=" + capacity + ", establishment="
				+ establishment + ", course=" + course + "]";
	}	
	
	
	
	
	
	
}
