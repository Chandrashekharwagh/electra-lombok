package com.electra.repository;


import com.electra.model.Orders;
import com.electra.service.ConnectionService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderRepository {
    private static Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }
    public List<Orders> retrieveOrders() {
        List<Orders> Orders = new ArrayList<>();
        // Use the connection to execute SQL queries and interact with the database
        try {
            this.initConnection();

            // Your database operations here...
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");

            // Iterate over the result set
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                int productId = resultSet.getInt("product_id");
                int customerId= resultSet.getInt("customer_id");
                Date orderDate = resultSet.getDate("order_Date");

                // Do something with the data, e.g., print it
                Orders orders = new Orders(id , productId, customerId, orderDate);
                Orders.add(orders);
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            // Close the connection when done
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return Orders;
    }
}
