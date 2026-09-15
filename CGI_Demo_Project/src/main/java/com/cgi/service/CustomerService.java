package com.cgi.service;

import com.cgi.bean.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CustomerService {

    private final List<Customer> customers = new ArrayList<>();
    private final AtomicInteger idGenerator = new AtomicInteger(100);

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerById(int id) {
        return customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Customer addCustomer(Customer customer) {
        customer.setId(idGenerator.incrementAndGet());
        customers.add(customer);
        return customer;
    }

    public Customer updateCustomer(int id, Customer updatedCustomer) {
        Optional<Customer> existing = customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst();

        if (existing.isEmpty()) {
            return null;
        }

        Customer customer = existing.get();
        customer.setName(updatedCustomer.getName());
        customer.setAddress(updatedCustomer.getAddress());
        return customer;
    }

    public boolean deleteCustomer(int id) {
        return customers.removeIf(c -> c.getId() == id);
    }
}



