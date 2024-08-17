package com.electra.repository;


import com.electra.model.Customer;
import com.electra.service.ConnectionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;




public class CustomerRepository {

    public static Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }
    public List<Customer> retrieveCustomers() {
        List<Customer> Customer = new ArrayList<>();
        // Use the connection to execute SQL queries and interact with the database
        try {
            this.initConnection();

            // Your database operations here...
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");

            // Iterate over the result set
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                // Do something with the data, e.g., print it
                Customer customer = new Customer(id ,name , email);
                Customer.add(customer);
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
        return Customer;
    }

    // Method to insert user data into the database
    public boolean insertCustomer(Customer customer) throws SQLException {
        this.initConnection();

        String query = "INSERT INTO customer VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getEmail());

            System.out.println("inserting customer data to table: " + customer);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to update user data into the database
    public boolean updateCustomer(Customer customer) throws SQLException {
        this.initConnection();

        String query = "UPDATE customer SET name = ?, email = ?  WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setLong(3, customer.getId());

            System.out.println("updating customer data to table: " + customer);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // Method to delete user data into the database
    public boolean deleteCustomer(long id) throws SQLException {
        this.initConnection();

        String query = "DELETE FROM customer WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1,id);

            System.out.println("deleting customer data from table: " + id);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
