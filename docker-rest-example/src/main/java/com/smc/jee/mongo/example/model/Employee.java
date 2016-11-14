package com.smc.jee.mongo.example.model;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

@Entity("employees")
@JsonIgnoreProperties({ "id", "enterprise" })
public class Employee implements Serializable {

	private static final long serialVersionUID = 6911125693930152071L;
	@Id
	private ObjectId id;
	@Property("first_name")
	private String firstName;
	@Property("last_name")
	private String lastName;
	@Property("position")
	private String position;
	@Reference(value = "enterprise")
	private Enterprise enterprise;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

}
