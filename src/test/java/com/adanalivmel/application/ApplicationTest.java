package com.adanalivmel.application;

import org.springframework.amqp.AmqpConnectException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.adanalivmel.application.queue.Runner;
import com.google.gson.JsonObject;

@SpringBootTest
public class ApplicationTest {

	@MockBean
	private Runner runner;

	
	public void test() throws Exception {
		try {
			JsonObject objeto = new JsonObject();
			objeto.addProperty("dns", "teste.com");
			objeto.addProperty("ip", "1.1.1.1");
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("mensagem", "Hello from RabbitMQ");
			jsonObject.add("objeto", objeto);
			runner.sendMessage(jsonObject.toString());
		}
		catch (AmqpConnectException e) {
			// ignore - rabbit is not running
		}
	}

}
