package com.smc.jee.mongo.example.business.enterprises;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.smc.jee.mongo.example.business.employees.EmployeeManager;
import com.smc.jee.mongo.example.model.Enterprise;
import com.smc.jee.mongo.example.model.HeadQuarter;

@ApplicationScoped
public class EnterpriseManager {
	@Inject
	private EnterpriseDao enterpriseDao;
	@Inject
	private EmployeeManager employeeManager;

	public Enterprise getEnterpriseWithOnlyId(String enterpriseName) {
		return enterpriseDao.getEnterpriseWithFields(enterpriseName, "_id");
	}

	public Enterprise getEnterprise(String enterpriseName) {
		Enterprise enterprise = enterpriseDao.getEnterpriseWithFields(enterpriseName);
		countEmployees(enterprise);
		return enterprise;
	}

	public String createEnterprise(String name, String country, String address) {

		Enterprise enterprise = enterpriseDao.getEnterpriseWithFields(name, "_id");
		if (enterprise != null) {
			return enterprise.getId().toString();
		}
		enterprise = new Enterprise();
		enterprise.setName(name);
		HeadQuarter headQuarter = new HeadQuarter();
		headQuarter.setAddress(address);
		headQuarter.setCountry(country);
		enterprise.setHeadQuarter(headQuarter);
		return enterpriseDao.createEnterprise(enterprise).toString();
	}

	public List<Enterprise> getAllEnterprises() {
		List<Enterprise> enterprises = enterpriseDao.getAll();
		for (Enterprise enterprise : enterprises) {
			countEmployees(enterprise);
		}
		return enterprises;
	}

	private void countEmployees(Enterprise enterprise) {
		if (enterprise != null) {
			Long numberOfEmployees = employeeManager.getNumberOfEmployees(enterprise);
			enterprise.setNumberOfemployees(numberOfEmployees.intValue());
		}
	}

}
