package com.smc.jee.mongo.example.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.smc.jee.mongo.example.business.enterprises.EnterpriseManager;

@Path("enterprise")
@Produces({ MediaType.APPLICATION_JSON })
public class EnterpriseResource {
	@Inject
	private EnterpriseManager enterpriseManager;

	@GET
	@Path("get/{enterpriseName}")
	public Response getEnterprise(@PathParam("enterpriseName") String enterpriseName) {
		return Response.status(200).entity(enterpriseManager.getEnterprise(enterpriseName)).build();
	}

	@GET
	@Path("all")
	public Response getAllEnterprises() {
		return Response.status(200).entity(enterpriseManager.getAllEnterprises()).build();
	}

	@PUT
	@Path("add/{enterpriseName}/{country}/{address}")
	public Response createEnterprise(@PathParam("enterpriseName") String enterpriseName,
			@PathParam("country") String country, @PathParam("address") String address) {
		return Response.status(200).entity(enterpriseManager.createEnterprise(enterpriseName, country, address))
				.build();
	}

}
