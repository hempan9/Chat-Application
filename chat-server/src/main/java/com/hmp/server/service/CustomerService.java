package com.hmp.server.service;

import com.hmp.server.dao.CustomerDAO;
import com.hmp.server.dto.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }


    public List<Customer> getAllCustomers(){
        long start = System.currentTimeMillis();
        List<Customer> customers = customerDAO.getCustomer();
        long end = System.currentTimeMillis();
        System.out.println("Time elapsed: "+(end-start));
        return customers;
    }
    public Flux<Customer> getAllCustomersStream(){
        long start = System.currentTimeMillis();
        Flux<Customer> customers = customerDAO.getCustomerStream();
        long end = System.currentTimeMillis();
        System.out.println("Time elapsed: "+(end-start));
        return customers;
    }
}
