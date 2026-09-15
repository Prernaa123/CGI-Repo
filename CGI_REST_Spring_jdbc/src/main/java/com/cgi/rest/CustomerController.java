	package com.cgi.rest;
	
	import com.cgi.bean.Customer;
	import com.cgi.service.CustomerService;
	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;
	
	@RestController
	@RequestMapping("/customers")
	public class CustomerController {
	
	    @Autowired
	    private CustomerService customerService;
	
	    // Create
	    @PostMapping
	    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
	        int rows = customerService.addCustomer(customer);
	        if (rows > 0) {
	            return ResponseEntity.status(HttpStatus.CREATED).body("Customer created successfully");
	        }
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer not created");
	    }
	
	    // Read all
	    @GetMapping
	    public ResponseEntity<List<Customer>> getAllCustomers() {
	        return ResponseEntity.ok(customerService.getAllCustomers());
	    }
	
	    // Read by id
	    @GetMapping("/{id}")
	    public ResponseEntity<?> getCustomerById(@PathVariable int id) {
	        Customer customer = customerService.getCustomerById(id);
	        if (customer == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
	        }
	        return ResponseEntity.ok(customer);
	    }
	
	    // Update
	    @PutMapping("/{id}")
	    public ResponseEntity<String> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
	        int rows = customerService.updateCustomer(id, customer);
	        if (rows > 0) {
	            return ResponseEntity.ok("Customer updated successfully");
	        }
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
	    }
	
	    // Delete
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
	        int rows = customerService.deleteCustomer(id);
	        if (rows > 0) {
	            return ResponseEntity.ok("Customer deleted successfully");
	        }
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
	    }
	}