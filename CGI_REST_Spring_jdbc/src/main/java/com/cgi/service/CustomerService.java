package com.cgi.service;

import com.cgi.bean.Customer;
import com.cgi.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public int addCustomer(Customer customer) {
        return customerRepository.addCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }

    public int updateCustomer(int id, Customer customer) {
        return customerRepository.updateCustomer(id, customer);
    }

    public int deleteCustomer(int id) {
        return customerRepository.deleteCustomer(id);
    }
}