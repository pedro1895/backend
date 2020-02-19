package com.example.messagingrabbitmq;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DnsServicesController {

	@GetMapping("/dns-services")
	public DnsServicesConfiguration getDnsServicesConfiguration() {
		return new DnsServicesConfiguration("globo.com","186.192.90.5");
	}
	
	@GetMapping("/dns-services/list")
	public List<DnsServicesConfiguration> listDnsServicesConfiguration() {
		List<DnsServicesConfiguration> lista = new ArrayList<>();
		lista.add(new DnsServicesConfiguration("globo.com","186.192.90.5"));
		lista.add(new DnsServicesConfiguration("localhost","127.0.0.1"));
		lista.add(new DnsServicesConfiguration("google.com","8.8.8.8"));
		return lista;
	}
	
	@PostMapping("/dns-services")
	public DnsServicesConfiguration setDnsServicesConfiguration() {
		return new DnsServicesConfiguration("globo.com","186.192.90.5");
	}
}
