/**
 * 
 */
package com.example.Service2.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author user
 *
 */
public class Resource {

	/**
	 * @param id
	 * @param name
	 * @param age
	 * @param address
	 */
	public Resource(Long id, String name, Integer age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	private Long id;

	@NotNull(message = "Name cannot be empty.")
	private String name;

	@Min(value = 1, message = "Age should be greater than 0")
	private Integer age;

	private String address;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}

}
