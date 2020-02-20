package com.example.messagingrabbitmq;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Component
public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1);

	public void receiveMessage(String message) {
		JsonObject json = new Gson().fromJson(message, JsonObject.class);
		DnsServicesConfiguration dns = new Gson().fromJson(json.get("objeto"), DnsServicesConfiguration.class);
		if(json.get("acao").getAsString().equals("salvar")) {
			Utils.save(dns);
		}
		System.out.println("Received <" + dns.toString() + ">");
		latch.countDown();
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}
