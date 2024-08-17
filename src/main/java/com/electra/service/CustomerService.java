package com.electra.service;


import com.electra.model.Customer;
import com.electra.repository.CustomerRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class CustomerService {
    public static final CustomerRepository CUSTOMER_REPO = new CustomerRepository();

    // Method to retrieve customers of the database
    public List<Customer> retrieveCustomers() {
        return CUSTOMER_REPO.retrieveCustomers();
    }

    // Method to insert user data into the database
    public boolean insertCustomer() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pls enter Customer id:");
        Long id = Long.valueOf(scanner.nextLine());

        System.out.println("Pls enter name:");
        String name = scanner.nextLine();

        System.out.println("Pls enter email:");
        String email =scanner.nextLine();

        Customer customer = new Customer(id, name, email);

        if (CUSTOMER_REPO.insertCustomer(customer)) {
            System.out.println("Customer inserted successfully!");
        } else {
            System.out.println("Failed to insert Customer.");
        }
        return false;
    }

    // Method to update user data into the database
    public boolean updateCustomer() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pls enter Customer id:");
        Long id = Long.valueOf(scanner.nextLine());

        System.out.println("Pls enter name:");
        String name = scanner.nextLine();

        System.out.println("Pls enter email:");
        String email =scanner.nextLine();

        Customer customer = new Customer(id, name, email);

        if (CUSTOMER_REPO.updateCustomer(customer)) {
            System.out.println("Customer inserted successfully!");
        } else {
            System.out.println("Failed to insert Customer.");
        }
        return false;
    }

    // Method to delete user data of the database
    public boolean deleteCustomer() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pls enter Customer id:");
        long id = Long.parseLong(scanner.nextLine());

        if (CUSTOMER_REPO.deleteCustomer(id)) {
            System.out.println("Customer deleted successfully!");
        } else {
            System.out.println("Failed to delete Customer.");
        }
        return false;
    }
}

