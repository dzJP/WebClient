package com.example.jakobrestclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");
        WebClient client = WebClient.create("http://localhost:8080");

        Mono<String> m = client
                .get()
                .uri("rest/products/showallproducts")
                .retrieve()
                .bodyToMono(String.class);
        String i = m.block();
        System.out.println("Svar: " + i);

        Mono<String> m2 = client
                .post()
                .uri("rest/create/product/testproduct/2500/FOOD")
                .bodyValue(new MyProduct("testproduct",2500.0))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);

        System.out.println("Svar: " + m2.block());
    }
}

class MyProduct {
    String name;
    Double price;

    public MyProduct(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}