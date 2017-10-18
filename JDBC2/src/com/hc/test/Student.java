package com.hc.test;

public class Student {

	public Student(int id, String name, int age, String sex, int dept_id) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.dept_id = dept_id;
	}

	public Student(String name, int age, String sex, int dept_id) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.dept_id = dept_id;
	}
	
	public Student() {
		super();
	}

	private int id;
	private String name;
	private int age;
	private String sex;
	private int dept_id;

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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", dept_id=" + dept_id + "]";
	}

}
