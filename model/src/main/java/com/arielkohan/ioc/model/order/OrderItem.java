package com.arielkohan.ioc.model.order;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderItem {
    private Product product;
    private int quantity;

    public static OrderItem fromProductAndQuantity(Product product, int quantity) {
        return new OrderItem(product, quantity);
    }
}
