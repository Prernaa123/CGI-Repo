package com.cgi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.cgi.bean.Customer;
import com.cgi.constant.SQLConstant;
import com.cgi.utils.DBConnection;

public class CustomerDAO {

    private static final Logger logger =
            Logger.getLogger(CustomerDAO.class.getName());


    // =========================
    // CREATE
    // =========================

    public void createCustomer(Customer cust) throws Exception {

        logger.info(
                "Starting createCustomer for customer ID: "
                + cust.getId()
        );

        // Check whether customer ID already exists
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(SQLConstant.CHECK_CUSTOMER)) {

            ps.setInt(1, cust.getId());

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    logger.warning(
                            "Customer ID already exists: "
                            + cust.getId()
                    );

                    throw new Exception(
                            "Customer ID already exists: "
                            + cust.getId()
                    );
                }
            }

        } catch (SQLException e) {

            logger.warning(
                    "Error while checking customer with ID: "
                    + cust.getId()
                    + ". "
                    + e.getMessage()
            );

            throw new Exception(
                    "Error while checking customer with ID: "
                    + cust.getId(),
                    e
            );
        }


        // Insert customer
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(SQLConstant.INSERT_CUSTOMER)) {

            ps.setInt(1, cust.getId());
            ps.setString(2, cust.getName());
            ps.setString(3, cust.getAddress());

            int rows = ps.executeUpdate();

            logger.info(
                    "Customer created successfully. ID: "
                    + cust.getId()
                    + ", rows affected: "
                    + rows
            );

        } catch (SQLException e) {

            logger.warning(
                    "Error while creating customer with ID: "
                    + cust.getId()
                    + ". "
                    + e.getMessage()
            );

            throw new Exception(
                    "Error while creating customer with ID: "
                    + cust.getId(),
                    e
            );
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

        // Check whether customer ID exists
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(SQLConstant.CHECK_CUSTOMER)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (!rs.next()) {

                    logger.warning(
                            "Update failed. Customer ID does not exist: "
                            + id
                    );

                    throw new Exception(
                            "Error! Cannot perform update. "
                            + "Customer ID: "
                            + id
                            + " does not exist. "
                            + "Please check the list and then perform "
                            + "the update operation."
                    );
                }
            }

        } catch (SQLException e) {

            logger.warning(
                    "Error while checking customer with ID: "
                    + id
                    + ". "
                    + e.getMessage()
            );

            throw new Exception(
                    "Error while checking customer with ID: "
                    + id,
                    e
            );
        }


        // Update customer
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(SQLConstant.UPDATE_CUSTOMER)) {

            ps.setString(1, name);
            ps.setString(2, address);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            logger.info(
                    "Customer updated successfully. ID: "
                    + id
                    + ", rows affected: "
                    + rows
            );

            return rows > 0;

        } catch (SQLException e) {

            logger.warning(
                    "Error while updating customer with ID: "
                    + id
                    + ". "
                    + e.getMessage()
            );

            throw new Exception(
                    "Error while updating customer with ID: "
                    + id,
                    e
            );
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

        // Check whether customer ID exists
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(SQLConstant.CHECK_CUSTOMER)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (!rs.next()) {

                    logger.warning(
                            "Delete failed. Customer ID does not exist: "
                            + id
                    );

                    throw new Exception(
                            "Error! Cannot perform delete. "
                            + "Customer ID: "
                            + id
                            + " does not exist. "
                            + "Please check the list and then perform "
                            + "the delete operation."
                    );
                }
            }

        } catch (SQLException e) {

            logger.warning(
                    "Error while checking customer with ID: "
                    + id
                    + ". "
                    + e.getMessage()
            );

            throw new Exception(
                    "Error while checking customer with ID: "
                    + id,
                    e
            );
        }


        // Delete customer
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(SQLConstant.DELETE_CUSTOMER)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            logger.info(
                    "Customer deleted successfully. ID: "
                    + id
                    + ", rows affected: "
                    + rows
            );

            return rows > 0;

        } catch (SQLException e) {

            logger.warning(
                    "Error while deleting customer with ID: "
                    + id
                    + ". "
                    + e.getMessage()
            );

            throw new Exception(
                    "Error while deleting customer with ID: "
                    + id,
                    e
            );
        }
    }


    // =========================
    // LIST
    // =========================

    public List<Customer> listCustomer() throws Exception {

        logger.info("Starting listCustomer operation.");

        List<Customer> custList = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(SQLConstant.LIST_CUSTOMERS);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Customer cust = new Customer();

                cust.setId(rs.getInt("id"));
                cust.setName(rs.getString("name"));
                cust.setAddress(rs.getString("address"));

                custList.add(cust);
            }

            logger.info(
                    "Customer list retrieved successfully. "
                    + "Total customers: "
                    + custList.size()
            );

        } catch (SQLException e) {

            logger.warning(
                    "Error while listing customers. "
                    + e.getMessage()
            );

            throw new Exception(
                    "Error while listing customers",
                    e
            );
        }

        return custList;
    }
    
    public List<Customer> getDetailsByAddress(String commonAddress) throws Exception {
        
        logger.info("Starting getDetailsByAddress operation for address: " + commonAddress);

        if (commonAddress == null || commonAddress.isEmpty()) {
            logger.warning("Given address is null/empty.");
            return new ArrayList<>();
        }

        List<Customer> allCustomers = listCustomer();

        List<Customer> resultCustomers = allCustomers.stream()
                .filter(cust -> commonAddress.equalsIgnoreCase(cust.getAddress()))
                .collect(Collectors.toList());

        logger.info("Filtering complete. Found " + resultCustomers.size() + " customers for address: " + commonAddress);

        return resultCustomers;
    }
}
