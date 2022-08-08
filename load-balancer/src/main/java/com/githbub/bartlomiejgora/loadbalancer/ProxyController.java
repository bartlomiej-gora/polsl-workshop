package com.githbub.bartlomiejgora.loadbalancer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class ProxyController {

    private final WebClient.Builder loadBalancedWebClientBuilder;

    public ProxyController(WebClient.Builder loadBalancedWebClientBuilder) {
        this.loadBalancedWebClientBuilder = loadBalancedWebClientBuilder;
    }

    @PostMapping("/workshops")
    public Mono<Void> post(Map<String, String> body) {
        return loadBalancedWebClientBuilder.build().post().uri("http://student-service/")
                .body(body, Map.class).exchangeToMono(ClientResponse::releaseBody);
    }

    @GetMapping("/workshops/{suffix}")
    public Mono<String> get(@PathVariable String suffix) {
        return loadBalancedWebClientBuilder.build().get().uri("http://student-service/" + suffix)
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(String.class));
    }
}
