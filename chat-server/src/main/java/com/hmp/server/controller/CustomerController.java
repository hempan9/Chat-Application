package com.hmp.server.controller;

import com.hmp.server.service.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Mono<String> test() {
        return Mono.just("Hello Working.");
    }


    @RequestMapping("/customers")
    public ResponseEntity getALlCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
    @RequestMapping(value = "/customers/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity getALlCustomersStream() {
        return ResponseEntity.ok(customerService.getAllCustomersStream());
    }
}
