package com.electra.repository;


import com.electra.model.Payment;
import com.electra.service.ConnectionService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaymentRepository {
    private static Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }
    public List<Payment> retrievePayments() {
        List<Payment> Payment = new ArrayList<>();
        // Use the connection to execute SQL queries and interact with the database
        try {
            this.initConnection();

            // Your database operations here...
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM payment");

            // Iterate over the result set
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                Double amount = resultSet.getDouble("amount");
                Date paymentDate = resultSet.getDate("payment_daTe");
                int customerId= resultSet.getInt("customer_id");
                int orderId = resultSet.getInt("order_id");

                // Do something with the data, e.g., print it
                Payment payment= new Payment(id , amount ,paymentDate, customerId, orderId);
                Payment.add(payment);
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
        return Payment;
}
}
