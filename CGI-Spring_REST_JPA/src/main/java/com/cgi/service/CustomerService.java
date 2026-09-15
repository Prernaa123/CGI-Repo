package com.cgi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.entity.Customer;
import com.cgi.repo.CustomerRepository;

@Service
public class CustomerService {
	

	@Autowired
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    // READ ALL
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    // READ BY ID
    public Optional<Customer> getCustomerById(Long id) {
        return repository.findById(id);
    }

    // UPDATE
    public Customer updateCustomer(Long id, Customer customer) {

        Customer existingCustomer =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Customer not found: " + id));

        existingCustomer.setName(customer.getName());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());

        return repository.save(existingCustomer);
    }

    // DELETE
    public void deleteCustomer(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException(
                    "Customer not found: " + id);
        }

        repository.deleteById(id);
    }
}


