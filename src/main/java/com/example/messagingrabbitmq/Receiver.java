package com.example.messagingrabbitmq;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.messagingrabbitmq.repository.CustomerRepository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Component
public class Receiver {

	@Autowired
	private Utils utils; 
	
	private CountDownLatch latch = new CountDownLatch(1);

	public void receiveMessage(String message) {
		JsonObject json = new Gson().fromJson(message, JsonObject.class);
		DnsServicesConfiguration dns = new Gson().fromJson(json.get("objeto"), DnsServicesConfiguration.class);
		if(json.get("acao") != null && json.get("acao").getAsString().equals("salvar")) {
			utils.save(dns);
		}
		System.out.println("Received <" + dns.toString() + ">");
		latch.countDown();
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}
