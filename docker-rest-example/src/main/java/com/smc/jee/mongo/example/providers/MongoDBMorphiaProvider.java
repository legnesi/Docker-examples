package com.smc.jee.mongo.example.providers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class MongoDBMorphiaProvider {

	// private Datastore datastore;

	@Produces
	@ApplicationScoped
	public Datastore getDataStore() {
		final Morphia morphia = new Morphia();
		morphia.mapPackage("com.smc.jee.tomcat.example.model");
		String mongoHost = System.getenv("MONGO_HOST");
		Integer mongoPort = Integer.valueOf(System.getenv("MONGO_PORT"));
		System.out.println("Host" + mongoHost + "Port" + mongoPort);
		MongoClient mongoClient = new MongoClient(mongoHost, mongoPort);
		Datastore datastore = morphia.createDatastore(mongoClient, "emp_db");
		datastore.ensureIndexes();

		return datastore;
	}

}
