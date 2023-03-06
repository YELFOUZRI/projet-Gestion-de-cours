package com.doranco.projet.model;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "NOTIFICATIONS")
public class Notification {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
	@ManyToOne
	private Student student;
	@ManyToOne
	private Instructor instructor;
	@OneToOne(mappedBy = "notification")
	
	private Course course;
	public Notification() {
		super();
	}
	public Notification(Long id, String content, Date dateTime, Student student, Instructor instructor, Course course) {
		super();
		this.id = id;
		this.content = content;
		this.dateTime = dateTime;
		this.student = student;
		this.instructor = instructor;
		this.course = course;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Notification [id=" + id + ", content=" + content + ", dateTime=" + dateTime + ", student=" + student
				+ ", instructor=" + instructor + ", course=" + course + "]";
	}
	
	

}
