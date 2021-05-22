package com.kosta.day10;

import java.util.Arrays;

public class Person implements Cloneable{
	private String name;
	private int age;
	private Car car;
	private String[] phone;
	
	public Person(String name, int age, Car car, String[] phone) {
		super();
		this.name = name;
		this.age = age;
		this.car = car;
		this.phone = phone;
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
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String[] getPhone() {
		return phone;
	}
	public void setPhone(String[] phone) {	// phone의 주소가 들어옴
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=").append(name).append(", age=").append(age).append(", car=").append(car)
				.append(", phone=").append(Arrays.toString(phone)).append("]");
		return builder.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Person))	return false;
		Person otherPerson = (Person) obj;
		return name.equals(otherPerson.name) && 
				age == otherPerson.age &&
				car.equals(otherPerson.car) &&
				Arrays.equals(phone, otherPerson.phone);
	}
	
	

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Person p = (Person)super.clone();	// 얕은복제, 구현x
		// 깊은복제 car, phone
		p.car = new Car(car.getModel(), car.getPrice());
		p.phone = Arrays.copyOf(phone, phone.length);
		return p;
	}
	
	
	
	
}
