package com.example.messagingrabbitmq;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@RestController
public class DnsServicesController {
	private static final Log logger = LogFactory.getLog(DnsServicesController.class);
	
	@Autowired
	private Runner runner;
	
	@GetMapping("/dns-services")
	public DnsServicesConfiguration getDnsServicesConfiguration() {
		return new DnsServicesConfiguration("globo.com","186.192.90.5");
	}
	
	@GetMapping("/dns-services/list")
	public List<DnsServicesConfiguration> listDnsServicesConfiguration() {
		 return Utils.listAll();
	}
	
	@PostMapping("/dns-services")
	public DnsServicesConfiguration setDnsServicesConfiguration(@RequestBody DnsServicesConfiguration dns) {
		try {
			JsonObject objeto = new JsonObject();
			objeto.addProperty("dns", dns.getDns());
			objeto.addProperty("ip", dns.getIp());
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("acao", "salvar");
			jsonObject.add("objeto", objeto);
			runner.sendMessage(jsonObject.toString());
		} catch (InterruptedException e) {
			logger.error(e);
		}
		//Utils.save(dns);
		return dns;
	}
	
	
}
