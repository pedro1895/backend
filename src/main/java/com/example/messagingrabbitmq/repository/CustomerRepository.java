package com.example.messagingrabbitmq.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.messagingrabbitmq.DnsServicesConfiguration;

public interface CustomerRepository extends MongoRepository<DnsServicesConfiguration, String> {

  public DnsServicesConfiguration findByDns(String dns);
  public List<DnsServicesConfiguration> findByIp(String ip);

}
