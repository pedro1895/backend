package com.example.messagingrabbitmq;

public class DnsServicesConfiguration {

	private String dns;
	private String ip;
	
	public DnsServicesConfiguration(String dns, String ip) {
		super();
		this.dns = dns;
		this.ip = ip;
	}
	
	public DnsServicesConfiguration() {
		super();
	}
	
	public String getDns() {
		return dns;
	}
	public void setDns(String dns) {
		this.dns = dns;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dns == null) ? 0 : dns.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DnsServicesConfiguration other = (DnsServicesConfiguration) obj;
		if (dns == null) {
			if (other.dns != null)
				return false;
		} else if (!dns.equals(other.dns))
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		return true;
	}

	
	
}
