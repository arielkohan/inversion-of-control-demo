package com.arielkohan.ioc.model.order;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {
    private List<OrderItem> items;
    private Address address;

    public static Order fromItemsAndAddress(List<OrderItem> items, Address address) {
        return new Order(items, address);
    }

    public List<OrderItem> getItems() {
        return List.copyOf(items);
    }

    public Address getAddress() {
        return address;
    }
}
