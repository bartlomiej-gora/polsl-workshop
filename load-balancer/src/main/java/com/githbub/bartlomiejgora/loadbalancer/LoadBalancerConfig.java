package com.githbub.bartlomiejgora.loadbalancer;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.cache.DefaultLoadBalancerCacheManager;
import org.springframework.cloud.loadbalancer.cache.LoadBalancerCacheManager;
import org.springframework.cloud.loadbalancer.cache.LoadBalancerCacheProperties;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class LoadBalancerConfig {

    @Bean
    @Primary
    ServiceInstanceListSupplier serviceInstanceListSupplier(ConfigurableApplicationContext configurableApplicationContext) {
        var base = new DemoServiceInstanceListSuppler("student-service");
        return ServiceInstanceListSupplier.builder().withBase(base).build(configurableApplicationContext);
    }

    @Bean
    LoadBalancerCacheManager loadBalancerCacheManager(LoadBalancerCacheProperties loadBalancerCacheProperties){
        return new DefaultLoadBalancerCacheManager(loadBalancerCacheProperties);
    }

}

class DemoServiceInstanceListSuppler implements ServiceInstanceListSupplier {

    private final String serviceId;

    DemoServiceInstanceListSuppler(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String getServiceId() {
        return serviceId;
    }

    @Override
    public Flux<List<ServiceInstance>> get() {
        return Flux.just(Arrays
                .asList(new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 8081, false),
                        new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 8082, false)));
//                        new DefaultServiceInstance(serviceId + "3", serviceId, "localhost", 9999, false)));
    }
}
