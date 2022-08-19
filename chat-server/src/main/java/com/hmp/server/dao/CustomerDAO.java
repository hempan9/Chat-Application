package com.hmp.server.dao;

import com.hmp.server.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
@Component
public class CustomerDAO {

    /**
     * Synchronous Code
     * Only show results once it completes processing
     * all the records
     * @return
     */
    public List<Customer> getCustomer(){
      return   IntStream.rangeClosed(1, 10)
              .peek(CustomerDAO::sleepExe)
              .peek(i-> System.out.println("processing count: "+i))
              .mapToObj(i->new Customer(i, "customer_"+i)).collect(Collectors.toList());
    }


    public static void sleepExe(int i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Flux<Customer> getCustomerStream(){
        return   Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Processing count stream: "+i))
                .map(i->new Customer(i, "customer_"+i));
    }

}
