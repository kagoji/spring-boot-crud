package com.kagoji.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Biodata {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="bio_name")
	private String name;
	
	@Column(name="bio_age")
	private int age;
	
	public Biodata() {
		super();
	}
	
	public Biodata(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Biodata [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
