package com.cgi.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cgi.entity.Customer;
import com.cgi.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService service;

	CustomerController(CustomerService service) {
		this.service = service;
	}

	// CREATE
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

		Customer savedCustomer = service.createCustomer(customer);

		return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
	}

	// READ ALL
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {

		return ResponseEntity.ok(service.getAllCustomers());
	}

	// READ BY ID
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {

		return service.getCustomerById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	// UPDATE
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {

		try {

			Customer updatedCustomer = service.updateCustomer(id, customer);

			return ResponseEntity.ok(updatedCustomer);

		} catch (RuntimeException e) {

			return ResponseEntity.notFound().build();
		}
	}

	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {

		try {

			service.deleteCustomer(id);

			return ResponseEntity.noContent().build();

		} catch (RuntimeException e) {

			return ResponseEntity.notFound().build();
		}
	}

}