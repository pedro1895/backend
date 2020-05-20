package com.adanalivmel.application.queue;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adanalivmel.application.model.Customer;
import com.adanalivmel.application.repository.HandlingCustomer;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Component
public class Receiver {

    @Autowired
    private HandlingCustomer handlingCustomer;
    
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        JsonObject json = (JsonObject)new Gson().fromJson(message, JsonObject.class);
        Customer customer = (Customer)new Gson().fromJson(json.get("objeto"), Customer.class);
        if (json.get("acao") != null && json.get("acao").getAsString().equals("salvar")) {
            this.handlingCustomer.save(customer);
        }
        System.out.println("Received <" + customer.toString() + ">");
        this.latch.countDown();
    }

    public CountDownLatch getLatch() {
        return this.latch;
    }

}
