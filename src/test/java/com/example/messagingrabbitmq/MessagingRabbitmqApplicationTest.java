/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.messagingrabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.AmqpConnectException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.google.gson.JsonObject;

@SpringBootTest
public class MessagingRabbitmqApplicationTest {

	@MockBean
	private Runner runner;

	@Test
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
