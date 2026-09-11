
package com.cgi.constant;


public final class SQLConstant {

    private SQLConstant() {
        // Prevent object creation
    }

    public static final String CHECK_CUSTOMER =
            "SELECT id FROM customer WHERE id = ?";

    public static final String INSERT_CUSTOMER =
            "INSERT INTO customer(id, name, address) VALUES (?, ?, ?)";

    public static final String UPDATE_CUSTOMER =
            "UPDATE customer SET name = ?, address = ? WHERE id = ?";

    public static final String DELETE_CUSTOMER =
            "DELETE FROM customer WHERE id = ?";

    public static final String LIST_CUSTOMERS =
            "SELECT id, name, address FROM customer";
}