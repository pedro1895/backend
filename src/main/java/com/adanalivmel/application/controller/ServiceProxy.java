package com.adanalivmel.application.controller;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.adanalivmel.application.model.Customer;

//@FeignClient(name="currency-exchange-service", url="localhost:8000")
//@FeignClient(name="currency-exchange-service")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="service")
public interface ServiceProxy {
	 @GetMapping(value={"/customer"})
	 public List<Customer> list();
}
