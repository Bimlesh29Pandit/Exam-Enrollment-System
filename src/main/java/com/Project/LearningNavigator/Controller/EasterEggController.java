package com.Project.LearningNavigator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hidden-feature")
public class EasterEggController {

    private final WebClient webClient = WebClient.create("http://numbersapi.com");

    @GetMapping("/{number}")
    public Mono<String> getNumberFact(@PathVariable int number) {
        return webClient.get()
                .uri("/" + number)
                .retrieve()
                .bodyToMono(String.class);
    }
}

