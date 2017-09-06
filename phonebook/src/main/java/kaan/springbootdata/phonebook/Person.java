package kaan.springbootdata.phonebook;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

	private String name;
	private String lastName;
	@Id
	private String phone;
	
	public Person() {}
	
	public Person(String name, String lastName, String phone) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
