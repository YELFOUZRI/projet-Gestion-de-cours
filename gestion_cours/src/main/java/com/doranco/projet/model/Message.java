package com.doranco.projet.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "MESSAGES")
public class Message {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
	private Boolean stateRead;
	@ManyToOne
	private Student student;
	@ManyToOne
	private Instructor instructor;
	
	public Message() {
		super();
	}

	public Message(Long id, String content, Date dateTime, Boolean stateRead, Student student, Instructor instructor) {
		super();
		this.id = id;
		this.content = content;
		this.dateTime = dateTime;
		this.stateRead = stateRead;
		this.student = student;
		this.instructor = instructor;
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

	public Boolean getStateRead() {
		return stateRead;
	}

	public void setStateRead(Boolean stateRead) {
		this.stateRead = stateRead;
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

	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", dateTime=" + dateTime + ", stateRead=" + stateRead
				+ ", student=" + student + ", instructor=" + instructor + "]";
	}
	
	

}
