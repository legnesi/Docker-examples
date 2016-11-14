package com.smc.jee.mongo.example.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.smc.jee.mongo.example.business.employees.EmployeeManager;

@Path("employee")
@Produces({ MediaType.APPLICATION_JSON })
public class EmployeeResource {
	@Inject
	private EmployeeManager employeeManager;

	@PUT
	@Path("add/{firstName}/{lastName}/{position}/{enterpriseName}")
	public Response createEmployee(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName,
			@PathParam("position") String position, @PathParam("enterpriseName") String enterpriseName) {
		return Response.status(200)
				.entity(employeeManager.createEmployee(firstName, lastName, position, enterpriseName)).build();
	}

	@GET
	@Path("all/{enterpriseName}")
	public Response getAllEmployeesByEnterprise(@PathParam("enterpriseName") String enterpriseName) {
		return Response.status(200).entity(employeeManager.getEmployeeByEnterprise(enterpriseName)).build();

	}

}
