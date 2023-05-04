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
                .uri("rest/product/name/tv")
                .retrieve()
                .bodyToMono(String.class);
        String i = m.block();
        System.out.println("Svar: " + i);
    }

//        Mono<Integer> m = client
//                        .get()
//                        .uri("http://localhost:8080/rs/add/78/89")
//                        .retrieve()
//                        .bodyToMono(Integer.class);
//
//        int i = m.block();
//        System.out.println("Svar: " + i);
//
//        Mono<Integer> m2 = client
//                .post()
//                .uri("http://localhost:8080/rs/addpair")
//                .bodyValue(new MittEgnaPar(56,34))
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(Integer.class);
//        System.out.println("Svar: " + m2.block());
//    }
//}
//
//class MittEgnaPar {
//    int first;
//    int second;
//
//    public MittEgnaPar(int first, int second) {
//        this.first = first;
//        this.second = second;
//    }
//
//    public int getFirst() {
//        return first;
//    }
//
//    public void setFirst(int first) {
//        this.first = first;
//    }
//
//    public int getSecond() {
//        return second;
//    }
//
//    public void setSecond(int second) {
//        this.second = second;
//    }
}
class Product {
    String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}