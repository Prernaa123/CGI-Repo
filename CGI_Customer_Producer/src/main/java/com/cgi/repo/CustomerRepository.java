package com.cgi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
