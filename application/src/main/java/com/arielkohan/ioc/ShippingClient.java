package com.arielkohan.ioc;

import com.arielkohan.ioc.model.order.Address;
import com.arielkohan.ioc.model.order.Order;
import com.arielkohan.ioc.model.order.OrderItem;
import com.arielkohan.ioc.model.order.Product;
import com.arielkohan.ioc.shipping.Shipping;

import java.util.List;

class ShippingClient {

    private static final Address DEFAULT_ADDRESS = Address.parseString("Sydney P Sherman Wallaby 40 . 128");
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
        final Address fromAddress = DEFAULT_ADDRESS;
        final Address destinationAddress = orderToProcess.getAddress();
        final float price = Shipping.calculateStandardPrice(fromAddress, destinationAddress);
        if(isShippingPriceAcceptable(price)) {
            Shipping.standardShip(fromAddress, destinationAddress);
        }
    }

    private boolean isShippingPriceAcceptable(float price) {
        boolean yeap = true;
        return yeap;
    }

}
