package com.example.messagingrabbitmq;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.messagingrabbitmq.repository.CustomerRepository;

@Component
public class Utils {

	@Autowired
	private CustomerRepository repository;

	public List<DnsServicesConfiguration> listAll() {
		return repository.findAll();
	}

	public void save(DnsServicesConfiguration dns) {
		dns.setId(UUID.randomUUID().toString());
		repository.save(dns);
	}

}
