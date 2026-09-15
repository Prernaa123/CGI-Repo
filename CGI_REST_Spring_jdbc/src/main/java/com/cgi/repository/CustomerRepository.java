package com.cgi.repository;

import com.cgi.bean.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addCustomer(Customer customer) {
        String sql = "INSERT INTO customer (name, address) VALUES (?, ?)";
        return jdbcTemplate.update(sql, customer.getName(), customer.getAddress());
    }

    public List<Customer> getAllCustomers() {
        String sql = "SELECT id, name, address FROM customer";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class));
    }

    public Customer getCustomerById(int id) {
        String sql = "SELECT id, name, address FROM customer WHERE id = ?";
        List<Customer> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class), id);
        return list.isEmpty() ? null : list.get(0);
    }

    public int updateCustomer(int id, Customer customer) {
        String sql = "UPDATE customer SET name = ?, address = ? WHERE id = ?";
        return jdbcTemplate.update(sql, customer.getName(), customer.getAddress(), id);
    }

    public int deleteCustomer(int id) {
        String sql = "DELETE FROM customer WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}