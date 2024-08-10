package com.electra.service;

import com.electra.model.Address;
import com.electra.repository.AddressRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AddressService {

    private static final AddressRepository ADDRESS_REPO = new AddressRepository();

    // Method to retrieve user Address of the database
    public List<Address> retrieveAddresses() {
        return ADDRESS_REPO.retrieveAddresses();
    }

    // Method to insert user Address into the database
    public boolean insertAddress() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pls enter Address id:");
        Long id = Long.valueOf(scanner.nextLine());

        System.out.println("Pls enter street:");
        String street = scanner.nextLine();

        System.out.println("Pls enter city:");
        String city = scanner.nextLine();

        System.out.println("Pls enter state:");
        String state = scanner.nextLine();

        System.out.println("Pls enter country:");
        String country = scanner.nextLine();

        System.out.println("Pls enter postal_code:");
        long postalCode = Long.parseLong(scanner.nextLine());

        Address address = new Address(id,street,city,state,country,postalCode);

        if (ADDRESS_REPO.insertAddress(address)) {
            System.out.println("Customer inserted successfully!");
        } else {
            System.out.println("Failed to insert Customer.");
        }
        return false;
    }

    // Method to update user Address into the database
    public boolean updateAddress() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pls enter Address id:");
        Long id = Long.valueOf(scanner.nextLine());

        System.out.println("Pls enter street:");
        String street = scanner.nextLine();

        System.out.println("Pls enter city:");
        String city = scanner.nextLine();

        System.out.println("Pls enter state:");
        String state = scanner.nextLine();

        System.out.println("Pls enter country:");
        String country = scanner.nextLine();

        System.out.println("Pls enter postal_code:");
        long postalCode = Long.parseLong(scanner.nextLine());

        Address address = new Address(id,street,city,state,country,postalCode);

        if (ADDRESS_REPO.updateAddress(address)) {
            System.out.println("Customer address inserted successfully!");
        } else {
            System.out.println("Failed to update Customer address.");
        }
        return false;
    }


    // Method to delete user Address of the database
    public boolean deleteAddress() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pls enter Address id:");
        Long id = Long.valueOf(scanner.nextLine());


        if (ADDRESS_REPO.deleteAddress(id)) {
            System.out.println("Customer address deleted successfully!");
        } else {
            System.out.println("Failed to delete Customer address.");
        }
        return false;
    }
}
