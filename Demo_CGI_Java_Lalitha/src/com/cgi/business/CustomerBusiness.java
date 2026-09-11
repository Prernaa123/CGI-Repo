/**
 * 
 */
package com.cgi.business;

import java.util.ArrayList;
import java.util.List;

import com.cgi.bean.Customer;
import com.cgi.exception.CustomerIdNotFoundException;
import com.cgi.exception.InvalidInputException;

/**
 * 
 */
public class CustomerBusiness {

	private List<Customer> customers = new ArrayList<Customer>();

	// Need to define the business needs for performing CRUD operations.

	/**
	 * Create Customer
	 */
	public void createCustomer(Customer customer)
			throws InvalidInputException {

		if (customer == null) {

			throw new InvalidInputException(
					"Customer cannot be null"
			);
		}

		if (customer.getCustomerID() <= 0) {

			throw new InvalidInputException(
					"Customer ID must be greater than 0"
			);
		}

		if (customer.getCustomerName() == null
				|| customer.getCustomerName().trim().isEmpty()) {

			throw new InvalidInputException(
					"Customer name cannot be empty"
			);
		}

		if (customer.getCustomerAddress() == null
				|| customer.getCustomerAddress().trim().isEmpty()) {

			throw new InvalidInputException(
					"Customer address cannot be empty"
			);
		}

		customers.add(customer);

		System.out.println("Customer Added Successfully.");
	}

	/**
	 * List Customers
	 */
	public void listCustomer() {

		System.out.println("\nList all the customers -->");

		if (customers.isEmpty()) {

			System.out.println("No customers available.");

			return;
		}

		for (Customer c : customers) {

			System.out.println(c);
		}
	}

	/**
	 * Update Customer by ID
	 * 
	 * @param updateAddress
	 * @param updateName
	 */
	public boolean updateCustomer(
			int customerID,
			String updateName,
			String updateAddress)
			throws CustomerIdNotFoundException,
			InvalidInputException {

		if (customerID <= 0) {

			throw new InvalidInputException(
					"Customer ID must be greater than 0"
			);
		}

		if (updateName == null
				|| updateName.trim().isEmpty()) {

			throw new InvalidInputException(
					"Customer name cannot be empty"
			);
		}

		if (updateAddress == null
				|| updateAddress.trim().isEmpty()) {

			throw new InvalidInputException(
					"Customer address cannot be empty"
			);
		}

		System.out.println(
				"\nBefore Update :: Customer details before update -> "
						+ customerID
		);

		for (Customer cust : customers) {

			if (cust.getCustomerID() == customerID) {

				System.out.println(
						"Customer details before update : "
				);

				System.out.println(cust);

				// Update with values entered by user
				cust.setCustomerName(updateName);
				cust.setCustomerAddress(updateAddress);

				System.out.println(
						"\nAfter Update :: Updated Customer details for id -> "
								+ customerID
				);

				System.out.println(cust);

				return true;
			}
		}

		// Customer ID does not exist
		throw new CustomerIdNotFoundException(customerID);
	}

	/**
	 * Delete Customer by ID
	 */
	public boolean deleteCustomer(int customerID)
			throws CustomerIdNotFoundException,
			InvalidInputException {

		if (customerID <= 0) {

			throw new InvalidInputException(
					"Customer ID must be greater than 0"
			);
		}

		for (int i = 0; i < customers.size(); i++) {

			Customer cust = customers.get(i);

			if (cust.getCustomerID() == customerID) {

				customers.remove(i);

				System.out.println(
						"\nCustomer is deleted with id -> "
								+ customerID
				);

				return true;
			}
		}

		// Customer ID does not exist
		throw new CustomerIdNotFoundException(customerID);
	}
}