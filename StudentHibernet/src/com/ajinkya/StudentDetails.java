package com.ajinkya;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.text.Annotation;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@Entity
@Table(name="StudentDetails")
public class StudentDetails 
{
	@Id @GeneratedValue(generator="newGenerator")	//Name of primary key generator
	@GenericGenerator(name="newGenerator", strategy="foreign",parameters={@Parameter(value="student",name="property")})
	//Above statement generate id no based on Student(parent) table (avoid primary key violation)
	
	private int id;
	private String address;
	private String mobile;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	
	private Student student;
	
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentDetails(int id, String address, String mobile) {
		this.address = address;
		this.mobile = mobile;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
}
