package com.cgi.exception;

public class InvalidInputException extends Exception {
	// field
		private String input;

		/**
		 * @param input
		 */
		public InvalidInputException(String input) {

			super();

			this.input = input;
		}

		// custom method which returns the invalid input
		public String getInput() {

			return input;
		}
}
