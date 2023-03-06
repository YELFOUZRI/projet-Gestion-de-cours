package com.doranco.projet.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "DOCUMENTS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Document {
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String type;
	private String urlDownload;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
	@ManyToOne
	private Student student;
	@ManyToOne
	private Instructor instructor;
	
	public Document() {
		
	}

	public Document(Long id, String title, String type, String urlDownload, Date dateTime, Student student,
			Instructor instructor) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.urlDownload = urlDownload;
		this.dateTime = dateTime;
		this.student = student;
		this.instructor = instructor;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrlDownload() {
		return urlDownload;
	}

	public void setUrlDownload(String urlDownload) {
		this.urlDownload = urlDownload;
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

	@Override
	public String toString() {
		return "Document [id=" + id + ", title=" + title + ", type=" + type + ", urlDownload=" + urlDownload
				+ ", dateTime=" + dateTime + ", student=" + student + ", instructor=" + instructor + "]";
	}
	
	
	

}
