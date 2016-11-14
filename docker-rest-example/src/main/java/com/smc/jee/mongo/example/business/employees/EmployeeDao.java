package com.smc.jee.mongo.example.business.employees;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import com.smc.jee.mongo.example.model.Employee;
import com.smc.jee.mongo.example.model.Enterprise;

@ApplicationScoped
class EmployeeDao {
	@Inject
	private Datastore datastore;

	public String createEmployee(Employee employee) {
		return datastore.save(employee).getId().toString();
	}

	public List<Employee> getEmployeesByEnterprise(Enterprise enterprise) {
		Query<Employee> query = datastore.createQuery(Employee.class);
		return query.field("enterprise").equal(enterprise).asList();

	}

	public Long countEmployees(Enterprise enterprise) {
		return datastore.getCount(datastore.createQuery(Employee.class).field("enterprise").equal(enterprise));

	}

}
