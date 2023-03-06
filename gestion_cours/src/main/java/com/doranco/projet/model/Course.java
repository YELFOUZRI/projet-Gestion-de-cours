package com.doranco.projet.model;


import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "COURSES")
public class Course {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;
	private String duration;
	@ManyToOne 
	private Instructor instructor;
	@ManyToMany(mappedBy = "courses")
	private List<Student> students = new ArrayList<>();
	@ManyToOne
	private ClassRoom classRoom;
	@OneToOne
	private Notification notification;
	
	public Course() {
		
	}
	
	public Course(Long id, String title, String description, String duration, Instructor instructor,
			List<Student> students, ClassRoom classRoom, Notification notification) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.duration = duration;
		this.instructor = instructor;
		this.students = students;
		this.classRoom = classRoom;
		this.notification = notification;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public ClassRoom getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", description=" + description + ", duration=" + duration
				+ ", instructor=" + instructor + ", students=" + students + ", classRoom=" + classRoom
				+ ", notification=" + notification + "]";
	}
	
	
	
	

}
