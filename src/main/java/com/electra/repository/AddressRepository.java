package com.electra.repository;


import com.electra.model.Address;
import com.electra.service.ConnectionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressRepository {

    private static Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }
    public List<Address> retrieveAddresses() {
        List<Address> addresses = new ArrayList<>();
        // Use the connection to execute SQL queries and interact with the database
        try {
            this.initConnection();

            // Your database operations here...
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM address");

            // Iterate over the result set
            while (resultSet.next()) {
                long id = resultSet.getLong("id"); // Replace "id" with your actual column name
                String city = resultSet.getString("city"); // Replace "city" with your actual column name
                String street = resultSet.getString("street");
                String state = resultSet.getString("state");
                String country = resultSet.getString("country");
                long postal_code = resultSet.getLong("postal_code");

                // Do something with the data, e.g., print it
                Address address = new Address(id, street, city,  state,  country, postal_code);
                addresses.add(address);
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
        return addresses;
    }

    // Method to insert user data into the database
    public boolean insertAddress(Address address) throws SQLException {
        this.initConnection();

        String query = "INSERT INTO address VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, address.getId());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getState());
            preparedStatement.setString(5, address.getCountry());
            preparedStatement.setLong(6, address.getPostalCode());

            System.out.println("inserting address of customer to Address table: " + address);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to update user data into the database
    public boolean updateAddress(Address address) throws SQLException {
        this.initConnection();

        String query = "UPDATE address SET  street = ?, street = ? , state = ?, country = ?, postal_code = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, address.getStreet());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getState());
            preparedStatement.setString(4, address.getCountry());
            preparedStatement.setLong(5, address.getPostalCode());
            preparedStatement.setLong(6, address.getId());

            System.out.println("updating address of customer to Address table: " + address);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // Method to update user data into the database
    public boolean deleteAddress(Long id) throws SQLException {
        this.initConnection();

        String query = "DELETE FROM address WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1,id);

            System.out.println("deleting address of customer to Address table: " + id);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
