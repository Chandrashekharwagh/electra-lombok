package com.electra.exceptions;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(Long id) {
        super("Address not found with id: " + id);
    }
}
