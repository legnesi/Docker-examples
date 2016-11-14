package com.smc.jee.mongo.example.model;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Transient;

@Entity("enterprises")
@JsonRootName("enterprise")
@JsonIgnoreProperties({ "id" })
public class Enterprise implements Serializable {
	private static final long serialVersionUID = 5115660865685734517L;

	@Id
	private ObjectId id;
	@Property("name")
	@JsonProperty("name")
	private String name;
	@Embedded("head_quarter")
	@JsonProperty("head_quarter")
	private HeadQuarter headQuarter;
	@Transient
	@JsonProperty("employees")
	private int numberOfemployees = 0;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeadQuarter getHeadQuarter() {
		return headQuarter;
	}

	public void setHeadQuarter(HeadQuarter headQuarter) {
		this.headQuarter = headQuarter;
	}

	public int getNumberOfemployees() {
		return numberOfemployees;
	}

	public void setNumberOfemployees(int numberOfemployees) {
		this.numberOfemployees = numberOfemployees;
	}

}
