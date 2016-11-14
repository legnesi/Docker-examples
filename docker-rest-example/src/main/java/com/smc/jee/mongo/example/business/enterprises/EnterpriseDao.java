package com.smc.jee.mongo.example.business.enterprises;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import com.smc.jee.mongo.example.model.Enterprise;

@ApplicationScoped
public class EnterpriseDao {

	@Inject
	private Datastore dataStore;

	ObjectId createEnterprise(Enterprise enterprise) {
		return (ObjectId) dataStore.save(enterprise).getId();
	}

	// Enterprise getEnterprise(String name) {
	// Query<Enterprise> query = dataStore.createQuery(Enterprise.class);
	// return query.field("name").equalIgnoreCase(name).get();
	// }

	List<Enterprise> getAll() {
		Query<Enterprise> query = dataStore.createQuery(Enterprise.class);
		return query.asList();
	}

	Enterprise getEnterpriseWithFields(String name, String... fields) {
		Query<Enterprise> query = dataStore.createQuery(Enterprise.class);
		return query.field("name").equalIgnoreCase(name).retrievedFields(true, fields).get();
	}

}
