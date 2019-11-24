package com.arielkohan.ioc.shipping_interface;

import com.arielkohan.ioc.model.order.Address;
import com.arielkohan.ioc.model.order.Order;
import lombok.Value;

@Value
public class ShippingRequest {
    private Address fromAddress;
    private Order order;
    private ShippingType shippingType;
}
