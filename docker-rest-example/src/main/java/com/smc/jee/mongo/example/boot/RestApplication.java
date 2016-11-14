package com.smc.jee.mongo.example.boot;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.smc.jee.mongo.example.resources.EmployeeResource;
import com.smc.jee.mongo.example.resources.EnterpriseResource;

//@ApplicationScoped
//@ApplicationPath("rest")
public class RestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(EmployeeResource.class);
		classes.add(EnterpriseResource.class);
		return classes;
	}

}
