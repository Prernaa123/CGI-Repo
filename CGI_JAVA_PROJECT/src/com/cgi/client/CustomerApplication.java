package com.cgi.client;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.cgi.bean.Customer;
import com.cgi.business.CustomerBusiness;

public class CustomerApplication {

	private static final Logger logger = Logger.getLogger(CustomerApplication.class.getName());

	public static void main(String[] args) {

		logger.info("Customer Application started.");

		int choice = 0;

		Scanner sc = new Scanner(System.in);

		CustomerBusiness cb = new CustomerBusiness();

		// List of customers
		List<Customer> custList = new ArrayList<>();
		LocalDateTime localDateTime = LocalDateTime.now();
		do {

			System.out.println();
			System.out.println("----------------------------------------");
			System.out.println("*******  Welcome to Customer Application  " + "*******");
			System.out.println("*******  Date & Time: " + localDateTime + "  *******");
			System.out.println("----------------------------------------");
			System.out.println("| 1 | Create a New Customer            |");
			System.out.println("| 2 | Update an existing Customer      |");
			System.out.println("| 3 | Delete an existing Customer      |");
			System.out.println("| 4 | List all the Customers           |");
			System.out.println("| 5 | Get Details By CommonAdress      |");
			System.out.println("----------------------------------------");

			System.out.print("Please enter your choice : ");

			try {

				choice = sc.nextInt();

				logger.info("User selected menu option: " + choice);

				switch (choice) {

				// ==================================
				// CREATE CUSTOMER
				// ==================================

				case 1: {

					logger.info("Create customer operation started.");

					try {

						System.out.println();
						System.out.println("----------------------------------------");
						System.out.println("           CREATE CUSTOMER");
						System.out.println("----------------------------------------");

						System.out.print("Enter Customer ID      : ");
						int id = sc.nextInt();

						sc.nextLine();

						System.out.print("Enter Customer Name    : ");
						String name = sc.nextLine();

						System.out.print("Enter Customer Address : ");
						String address = sc.nextLine();

						logger.info("Customer details received. ID: " + id);

						Customer cust = new Customer(id, name, address);

						// Add customer to List
						custList.add(cust);

						// Add customer to database
						cb.createCustomer(cust);

						logger.info("Customer created successfully. ID: " + id);

						System.out.println("----------------------------------------");
						System.out.println("A new customer has been created successfully.....");
						System.out.println("----------------------------------------");

					} catch (InputMismatchException e) {

						logger.warning("Invalid input entered while creating customer. " + e.getMessage());

						logger.warning("Invalid Customer ID! " + "Please enter a number.");

						sc.nextLine();

					} catch (Exception e) {

						logger.warning("Error while creating customer. " + e.getMessage());

					}

					break;
				}

				// ==================================
				// UPDATE CUSTOMER
				// ==================================

				case 2: {

					logger.info("Update customer operation started.");

					try {

						System.out.println();
						System.out.println("----------------------------------------");
						System.out.println("           UPDATE CUSTOMER");
						System.out.println("----------------------------------------");

						System.out.print("Enter Customer ID : ");

						int id = sc.nextInt();

						sc.nextLine();

						System.out.print("Enter New Customer Name : ");

						String name = sc.nextLine();

						System.out.print("Enter New Customer Address : ");

						String address = sc.nextLine();

						logger.info("Update details received. Customer ID: " + id);

						boolean result = cb.updateCustomer(id, name, address);

						if (result) {

							logger.info("Customer updated successfully. ID: " + id);


						} else {

							logger.warning("Customer update failed. " + "Customer ID not found: " + id);

						}

					} catch (InputMismatchException e) {

						logger.warning("Invalid input entered while updating customer. " + e.getMessage());


						sc.nextLine();

					} catch (Exception e) {

						logger.warning("Error while updating customer. " + e.getMessage());

					}

					break;
				}

				// ==================================
				// DELETE CUSTOMER
				// ==================================

				case 3: {

					logger.info("Delete customer operation started.");

					try {

						System.out.println();
						System.out.println("----------------------------------------");
						System.out.println("           DELETE CUSTOMER");
						System.out.println("----------------------------------------");

						System.out.print("Enter Customer ID to delete : ");

						int id = sc.nextInt();

						logger.info("Delete request received for customer ID: " + id);

						boolean result = cb.deleteCustomer(id);

						if (result) {

							// Remove from List
							custList.removeIf(cust -> cust.getId() == id);

							logger.info("Customer deleted successfully. ID: " + id);


						} else {

							logger.warning("Customer delete failed. " + "Customer ID not found: " + id);

						}

					} catch (InputMismatchException e) {

						logger.warning("Invalid input entered while deleting customer. " + e.getMessage());


						sc.nextLine();

					} catch (Exception e) {

						logger.warning("Error while deleting customer. " + e.getMessage());

					}

					break;
				}

				// ==================================
				// LIST CUSTOMERS
				// ==================================

				case 4: {
				    logger.info("List customers operation started.");
				    try {
				        // Get customers from database
				        custList = cb.listCustomer();
				        logger.info("Customer list retrieved. Total customers: " + custList.size());
				        
				        System.out.println();
				        System.out.println("==================================================================");
				        System.out.println("                        LIST OF CUSTOMERS                         ");
				        System.out.println("==================================================================");
				        
				        if (custList.isEmpty()) {
				            System.out.println("|                      No customers found.                       |");
				            logger.info("No customers found in the database.");
				        } else {
				          
				            System.out.printf("| %-10s | %-20s | %-25s |%n", "Cust ID", "Name", "Address");
				            System.out.println("------------------------------------------------------------------");
				            
				           
				            custList.forEach(cust -> {
				                System.out.printf("| %-10d | %-20s | %-25s |%n", cust.getId(), cust.getName(), cust.getAddress());
				            });
				        }
				        System.out.println("==================================================================");
				    } catch (Exception e) {
				        logger.warning("Error while listing customers. " + e.getMessage());
				    }
				    break;
				}
				
				case 5: {
				    logger.info("Get Details By Address");
				    try {
				        // Get customers from database
				    	
				    	System.out.print("Enter the common address : ");
				    	sc.nextLine();
						String commonAddress = sc.nextLine();
				    	
				    	
				        custList = cb.getDetailsByAddress(commonAddress);
				        logger.info("Customer list retrieved. Total customers: " + custList.size());
				        
				        System.out.println();
				        System.out.println("===============================================================================");
				        System.out.println("                       GET DETAILS By ADDRESS FOR :: "+commonAddress.toUpperCase()+"    ");
				        System.out.println("================================================================================");
				        
				        if (custList.isEmpty()) {
				            System.out.println("|                      No customers found.                       |");
				            logger.info("No customers found in the database.");
				        } else {
				          
				            System.out.printf("| %-10s | %-20s | %-25s |%n", "Cust ID", "Name", "Address");
				            System.out.println("------------------------------------------------------------------");
				            
				           
				            custList.forEach(cust -> {
				                System.out.printf("| %-10d | %-20s | %-25s |%n", cust.getId(), cust.getName(), cust.getAddress());
				            });
				        }
				        System.out.println("==================================================================");
				    } catch (Exception e) {
				        logger.warning("Error while listing customers. " + e.getMessage());
				    }
				    break;
				}

				default: {

					logger.warning("Invalid choice. " + "Please enter 1 to 4.");
				}

				}

			} catch (InputMismatchException e) {


				logger.warning("Invalid choice! " + "Please enter a number.");

				sc.nextLine();

				choice = 0;
			}

		} while (choice <= 5);

		sc.close();

		//logger.info("Customer Application End.");

		logger.info("\n--------------------------------");
	}
}
