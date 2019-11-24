package com.arielkohan.ioc.shipping_interface;

public interface Shipping {

    float calculatePrice(ShippingRequest request);
    void ship(ShippingRequest request);

}
