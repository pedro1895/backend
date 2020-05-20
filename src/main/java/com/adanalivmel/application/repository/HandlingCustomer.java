package com.adanalivmel.application.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.adanalivmel.application.model.Customer;

public interface HandlingCustomer extends MongoRepository<Customer, String> {
	
    public Customer findByCpf(String var1);

    public List<Customer> findByNome(String var1);
}
