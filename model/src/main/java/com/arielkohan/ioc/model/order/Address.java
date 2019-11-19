package com.arielkohan.ioc.model.order;

import lombok.NonNull;

public class Address {
    private String addressRepresentation;

    private Address(String addressRepresentation) {
        this.addressRepresentation = addressRepresentation;
    }

    public static Address parseString(@NonNull String addressString) {
        // were you expecting more complexity? Nope, not this time :P
        return new Address(addressString);
    }

    @Override
    public String toString() {
        return addressRepresentation;
    }
}
