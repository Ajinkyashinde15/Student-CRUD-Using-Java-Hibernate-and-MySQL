package com.ajinkya;

import javax.persistence.*;

@Entity
@Table(name="studentt")
public class Student 
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) //Automatically Generate value
 	private int id;
	
	@Column(name="name",nullable=false)
	private String name;
		
	private String school;
	private int year;
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", school=" + school + ", year=" + year + ", marks=" + marks
				+ "]";
	}
	private int marks;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
	
}
