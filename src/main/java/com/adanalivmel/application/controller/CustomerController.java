package com.adanalivmel.application.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adanalivmel.application.model.Customer;
import com.adanalivmel.application.queue.Runner;
import com.adanalivmel.application.repository.HandlingCustomer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@RestController
public class CustomerController {
    private static final Log logger = LogFactory.getLog(CustomerController.class);
    
    @Autowired
    private Runner runner;
    
    @Autowired
    private HandlingCustomer handlingCustomer;

    @GetMapping(value={"/customer/{id}"})
    public Customer getCustomer(@PathVariable String id) {
        return this.handlingCustomer.findById(id).orElse(null);
    }

    @GetMapping(value={"/customer"})
    public List<Customer> listDnsServicesConfiguration() {
        return this.handlingCustomer.findAll();
    }

    @PutMapping(value={"/customer"})
    public void updateCustomer(@RequestBody Customer customer) {
        this.handlingCustomer.save(customer);
    }

    @PostMapping(value={"/customer"})
    public Customer setDnsServicesConfiguration(@RequestBody Customer customer) {
        try {
            JsonObject objeto = new JsonObject();
            objeto.addProperty("nome", customer.getNome());
            objeto.addProperty("cpf", customer.getCpf());
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("acao", "salvar");
            jsonObject.add("objeto", (JsonElement)objeto);
            this.runner.sendMessage(jsonObject.toString());
        }
        catch (InterruptedException e) {
            logger.error((Object)e);
        }
        return customer;
    }
}
