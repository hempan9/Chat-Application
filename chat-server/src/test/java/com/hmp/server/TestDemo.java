package com.hmp.server;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TestDemo {
@Test
    public void testDemo(){
        Mono<?> mono = Mono.just("hmp").then(Mono.error(new RuntimeException("Error occurred; ")))
                .log();
        mono.subscribe(System.out::println, (e)-> System.out.println(e.getMessage()));

    }


    @Test
    public void testFLux(){

        Flux<String> flux = Flux.just("spring", "hibernate", "java", "noJava")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Errorrrr occurred!")))
                .concatWithValues("Azure")
                .log();
        flux.subscribe(System.out::println);
    }
}
