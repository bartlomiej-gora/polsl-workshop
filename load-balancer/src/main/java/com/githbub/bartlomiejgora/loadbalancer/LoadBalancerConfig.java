package com.githbub.bartlomiejgora.loadbalancer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.loadbalancer.core.DiscoveryClientServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

public class LoadBalancerConfig {

    @Autowired
    DiscoveryClient discoveryClient;

    @Bean
    @Primary
    ServiceInstanceListSupplier serviceInstanceListSupplier(Environment environment) {
        return new DiscoveryClientServiceInstanceListSupplier(discoveryClient, environment);
    }
}

