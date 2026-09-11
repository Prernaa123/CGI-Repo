package com.cgi.exception;

public class CustomerIdNotFoundException extends Exception {
	// field
		private int customerID;

		/**
		 * @param customerID
		 */
		public CustomerIdNotFoundException(int customerID) {

			super();

			this.customerID = customerID;
		}

		// custom method which returns the customer ID
		public int getCustomerID() {

			return customerID;
		}
}
