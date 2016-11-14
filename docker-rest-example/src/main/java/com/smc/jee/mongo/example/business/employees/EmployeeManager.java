package com.smc.jee.mongo.example.business.employees;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.smc.jee.mongo.example.business.enterprises.EnterpriseManager;
import com.smc.jee.mongo.example.model.Employee;
import com.smc.jee.mongo.example.model.Enterprise;

@ApplicationScoped
public class EmployeeManager {

	@Inject
	private EmployeeDao employeeDao;

	@Inject
	private EnterpriseManager enterpriseManager;

	public String createEmployee(String firstName, String lastName, String position, String enterpriseName) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setPosition(position);
		employee.setEnterprise(enterpriseManager.getEnterpriseWithOnlyId(enterpriseName));
		return employeeDao.createEmployee(employee).toString();
	}

	public List<Employee> getEmployeeByEnterprise(String enterpriseName) {
		List<Employee> employees = new ArrayList<>();
		Enterprise enterprise = enterpriseManager.getEnterpriseWithOnlyId(enterpriseName);
		if (enterprise != null) {
			employees = employeeDao.getEmployeesByEnterprise(enterprise);
		}

		return employees;
	}

	public Long getNumberOfEmployees(Enterprise enterprise) {
		return employeeDao.countEmployees(enterprise);
	}

}
