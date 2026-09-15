package com.cgi.client;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cgi.bean.Customer;
import com.cgi.business.CustomerBusiness;
import com.cgi.exception.CustomerIdNotFoundException;
import com.cgi.exception.InvalidInputException;

public class CustomerApplication {

	public static void main(String[] args) {

		int choice = 0;

		Scanner scanner = new Scanner(System.in);
		CustomerBusiness business = new CustomerBusiness();

		do {

			// ==============================
			// MAIN MENU
			// ==============================

			System.out.println();
			System.out.println("----------------------------------------");
			System.out.println("       CUSTOMER MANAGEMENT SYSTEM");
			System.out.println("-----------------------------------------");
			System.out.println("| 1 | Create a New Customer            |");
			System.out.println("| 2 | Update an existing Customer      |");
			System.out.println("| 3 | Delete an existing Customer      |");
			System.out.println("| 4 | List all the Customers           |");
			System.out.println("========================================");
			System.out.print("Enter your choice : ");

			try {

				choice = scanner.nextInt();

				switch (choice) {


				case 1: {

					try {

						System.out.println();
						System.out.println("----------------------------------------");
						System.out.println("           CREATE CUSTOMER");
						System.out.println("----------------------------------------");

						System.out.print("Enter Customer ID      : ");
						int custID = scanner.nextInt();

						scanner.nextLine();

						System.out.print("Enter Customer Name    : ");
						String custName = scanner.nextLine();

						System.out.print("Enter Customer Address : ");
						String custAddress = scanner.nextLine();

						Customer customer = new Customer(
								custID,
								custName,
								custAddress
						);

						business.createCustomer(customer);

						System.out.println("----------------------------------------");
						System.out.println("Customer created successfully.");
						System.out.println("----------------------------------------");

					} catch (InputMismatchException e) {

						System.out.println(
								"Invalid Customer ID! Please enter a number."
						);

						scanner.nextLine();

					} catch (InvalidInputException e) {

						System.out.println(
								"Invalid Input : " + e.getInput()
						);
					}

					break;
				}

				// ==================================
				// UPDATE CUSTOMER
				// ==================================

				case 2: {

					int updateChoice = 0;

					do {

						System.out.println();
						System.out.println("----------------------------------------");
						System.out.println("           UPDATE CUSTOMER");
						System.out.println("----------------------------------------");
						System.out.println("| 1 | Update Customer                  |");
						System.out.println("| 2 | Back to Main Menu               |");
						System.out.println("----------------------------------------");
						System.out.print("Enter your choice : ");

						try {

							updateChoice = scanner.nextInt();

							scanner.nextLine();

							switch (updateChoice) {

							case 1: {

								try {

									System.out.println();
									System.out.println("----------------------------------------");
									System.out.println("         ENTER UPDATED DETAILS");
									System.out.println("----------------------------------------");

									System.out.print(
											"Enter Customer ID      : "
									);

									int updateID =
											scanner.nextInt();

									scanner.nextLine();

									System.out.print(
											"Enter New Customer Name    : "
									);

									String updateName =
											scanner.nextLine();

									System.out.print(
											"Enter New Customer Address : "
									);

									String updateAddress =
											scanner.nextLine();

									boolean result =
											business.updateCustomer(
													updateID,
													updateName,
													updateAddress
											);

									System.out.println("----------------------------------------");
									System.out.println(
											"Update Customer result : " + result
									);
									System.out.println("----------------------------------------");

								} catch (InputMismatchException e) {

									System.out.println(
											"Invalid Customer ID! "
											+ "Please enter a number."
									);

									scanner.nextLine();

								} catch (CustomerIdNotFoundException e) {

									System.out.println(
											"Customer ID not found : "
											+ e.getCustomerID()
									);

								} catch (InvalidInputException e) {

									System.out.println(
											"Invalid Input : "
											+ e.getInput()
									);
								}

								break;
							}

							case 2: {

								System.out.println(
										"\nReturning to Main Menu..."
								);

								break;
							}

							default: {

								System.out.println(
										"Invalid choice! Please enter 1 or 2."
								);
							}

							}

						} catch (InputMismatchException e) {

							System.out.println(
									"Invalid choice! "
									+ "Please enter a number."
							);

							scanner.nextLine();

							updateChoice = 0;
						}

					} while (updateChoice != 2);

					break;
				}

				// ==================================
				// DELETE CUSTOMER
				// ==================================

				case 3: {

					try {

						System.out.println();
						System.out.println("----------------------------------------");
						System.out.println("           DELETE CUSTOMER");
						System.out.println("----------------------------------------");

						System.out.print(
								"Enter Customer ID to delete : "
						);

						int deleteID = scanner.nextInt();

						boolean result =
								business.deleteCustomer(deleteID);

						System.out.println("----------------------------------------");
						System.out.println(
								"Delete Customer result : " + result
						);
						System.out.println("----------------------------------------");

					} catch (InputMismatchException e) {

						System.out.println(
								"Invalid Customer ID! "
								+ "Please enter a number."
						);

						scanner.nextLine();

					} catch (CustomerIdNotFoundException e) {

						System.out.println(
								"Customer ID not found : "
								+ e.getCustomerID()
						);

					} catch (InvalidInputException e) {

						System.out.println(
								"Invalid Input : "
								+ e.getInput()
						);
					}

					break;
				}

				// ==================================
				// LIST CUSTOMERS
				// ==================================

				case 4: {

					System.out.println();
					System.out.println("          LIST OF CUSTOMERS");
					System.out.println("========================================");

					business.listCustomer();


					break;
				}

			

				default: {

					System.out.println(
							"Invalid choice. Please enter 1 to 4."
					);
				}

				}

			} catch (InputMismatchException e) {

				System.out.println(
						"Invalid choice! Please enter a number."
				);

				scanner.nextLine();

				choice = 0;
			}

		} while (choice != 5);

		scanner.close();

		System.out.println("\nThank you!");
	}
}