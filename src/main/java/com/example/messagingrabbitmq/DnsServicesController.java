package com.example.messagingrabbitmq;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DnsServicesController {

	@GetMapping("/dns-services")
	public DnsServicesConfiguration getDnsServicesConfiguration() {
		return new DnsServicesConfiguration("globo.com","186.192.90.5");
	}
}
