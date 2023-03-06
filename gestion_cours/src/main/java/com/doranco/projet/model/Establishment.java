package com.doranco.projet.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name = "ESTABLISHMENTS")
public class Establishment {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String adress;
	@NotEmpty
	private String postalCode;
	@NotEmpty
	private String city;
	@NotEmpty
	private String type;
	@OneToMany(mappedBy = "establishment")
	private List<ClassRoom> classRooms = new ArrayList<>();
	@OneToMany(mappedBy = "establishment")
	private List<Student> students = new ArrayList<>();
	@OneToMany(mappedBy = "establishment")
	private List<Instructor> instructors = new ArrayList<>();
	
	public Establishment() {
		
	}
	
	public Establishment(Long id, @NotEmpty String name, @NotEmpty String adress, @NotEmpty String postalCode,
			@NotEmpty String city, @NotEmpty String type, List<ClassRoom> classRooms, List<Student> students,
			List<Instructor> instructors) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.postalCode = postalCode;
		this.city = city;
		this.type = type;
		this.classRooms = classRooms;
		this.students = students;
		this.instructors = instructors;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ClassRoom> getClassRooms() {
		return classRooms;
	}

	public void setClassRooms(List<ClassRoom> classRooms) {
		this.classRooms = classRooms;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}

	@Override
	public String toString() {
		return "Establishment [id=" + id + ", name=" + name + ", adress=" + adress + ", postalCode=" + postalCode
				+ ", city=" + city + ", type=" + type + ", classRooms=" + classRooms + ", students=" + students
				+ ", instructors=" + instructors + "]";
	}
	
	
	
	

}
