package com.arielkohan.ioc;

import com.arielkohan.ioc.model.order.Address;
import com.arielkohan.ioc.model.order.Order;
import com.arielkohan.ioc.model.order.OrderItem;
import com.arielkohan.ioc.model.order.Product;
import com.arielkohan.ioc.shipping.sdks.UpsLibrary;

import java.util.List;

class ShippingClient {

    private static final String DEFAULT_ADDRESS = "Sydney P Sherman Wallaby 40 . 128";
    private Order orderToProcess;

    public ShippingClient() {
        generateOrderToProcess();
    }

    private void generateOrderToProcess() {
        Address address = Address.parseString("Sydney P Sherman Wallaby 42 . 815");
        final Product product1 = new Product("p1");
        final Product product2 = new Product("p2");
        List<OrderItem> items = List.of(
                OrderItem.fromProductAndQuantity(product1, 1),
                OrderItem.fromProductAndQuantity(product2, 3)
        );
        orderToProcess = Order.fromItemsAndAddress(items, address);
    }

    public void shipStuff() {
        UpsLibrary.UpsShipmentRequest shippingRequest = generateUpsShippingRequest(orderToProcess);
        final float price = UpsLibrary.calculatePrice(shippingRequest);
        if(isShippingPriceAcceptable(price)) {
            UpsLibrary.ship(shippingRequest);
        }
    }

    private boolean isShippingPriceAcceptable(float price) {
        boolean yeap = true;
        return yeap;
    }

    private UpsLibrary.UpsShipmentRequest generateUpsShippingRequest(Order orderToProcess) {
        final Address destinationAddress = orderToProcess.getAddress();
        return new UpsLibrary.UpsShipmentRequest(
                DEFAULT_ADDRESS,
                destinationAddress.toString(),
                UpsLibrary.STANDARD_SHIPPING_TYPE
        );
    }
}
