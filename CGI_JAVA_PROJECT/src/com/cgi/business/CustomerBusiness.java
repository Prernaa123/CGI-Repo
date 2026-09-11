package com.cgi.business;

import java.util.List;
import java.util.logging.Logger;

import com.cgi.bean.Customer;
import com.cgi.dao.CustomerDAO;

public class CustomerBusiness {

    private static final Logger logger =
            Logger.getLogger(CustomerBusiness.class.getName());

    CustomerDAO dao = new CustomerDAO();


    // =========================
    // CREATE
    // =========================

    public void createCustomer(Customer cust) throws Exception {

        logger.info(
                "Starting createCustomer for customer ID: "
                + cust.getId()
        );

        try {

            dao.createCustomer(cust);

            logger.info(
                    "Customer created successfully through business layer. "
                    + "ID: "
                    + cust.getId()
            );

        } catch (Exception e) {

            logger.warning(
                    "Error while creating customer with ID: "
                    + cust.getId()
                    + ". "
                    + e.getMessage()
            );

            throw e;
        }
    }


    // =========================
    // UPDATE
    // =========================

    public boolean updateCustomer(
            int id,
            String name,
            String address) throws Exception {

        logger.info(
                "Starting updateCustomer for customer ID: "
                + id
        );

        try {

            boolean result = dao.updateCustomer(
                    id,
                    name,
                    address
            );

            logger.info(
                    "Customer update operation completed. "
                    + "ID: "
                    + id
                    + ", success: "
                    + result
            );

            return result;

        } catch (Exception e) {

            logger.warning(
                    "Error while updating customer with ID: "
                    + id
                    + ". "
                    + e.getMessage()
            );

            throw e;
        }
    }


    // =========================
    // DELETE
    // =========================

    public boolean deleteCustomer(int id) throws Exception {

        logger.info(
                "Starting deleteCustomer for customer ID: "
                + id
        );

        try {

            boolean result = dao.deleteCustomer(id);

            logger.info(
                    "Customer delete operation completed. "
                    + "ID: "
                    + id
                    + ", success: "
                    + result
            );

            return result;

        } catch (Exception e) {

            logger.warning(
                    "Error while deleting customer with ID: "
                    + id
                    + ". "
                    + e.getMessage()
            );

            throw e;
        }
    }


    // =========================
    // LIST
    // =========================

    public List<Customer> listCustomer() throws Exception {

        logger.info(
                "Starting listCustomer operation."
        );

        try {

            List<Customer> custList =
                    dao.listCustomer();

            logger.info(
                    "Customer list retrieved successfully through "
                    + "business layer. Total customers: "
                    + custList.size()
            );

            return custList;

        } catch (Exception e) {

            logger.warning(
                    "Error while retrieving customer list. "
                    + e.getMessage()
            );

            throw e;
        }
         
    }
    
    
    public List<Customer> getDetailsByAddress(String commonAddress) throws Exception {

        logger.info(
                "Starting getDetailsByAddress operation."
        );

        try {

            List<Customer> custList =
                    dao.getDetailsByAddress(commonAddress);

            logger.info(
                    "Customer list for common address is retrieved successfully through "
                    + "business layer. Total customers: "
                    + custList.size()
            );

            return custList;

        } catch (Exception e) {

            logger.warning(
                    "Error while retrieving customer list. "
                    + e.getMessage()
            );

            throw e;
        }
         
    }
    
    
}
