package com.arielkohan.ioc.shipping_client;

import com.arielkohan.ioc.model.order.Address;
import com.arielkohan.ioc.model.order.Order;
import com.arielkohan.ioc.model.order.OrderItem;
import com.arielkohan.ioc.model.order.Product;
import com.arielkohan.ioc.shipping_interface.Shipping;
import com.arielkohan.ioc.shipping_interface.ShippingRequest;
import com.arielkohan.ioc.shipping_interface.ShippingType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShippingClient {

    private static final Address DEFAULT_ADDRESS = Address.parseString("Sydney P Sherman Wallaby 40 . 128");

    private final Shipping shipping;
    private Order orderToProcess;

    public ShippingClient(Shipping shipping) {
        this.shipping = shipping;
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
        final ShippingRequest shippingRequest = new ShippingRequest(fromAddress, orderToProcess, ShippingType.CHEAPEST);
        final float price = shipping.calculatePrice(shippingRequest);
        if(isShippingPriceAcceptable(price)) {
            shipping.ship(shippingRequest);
        }
    }

    private boolean isShippingPriceAcceptable(float price) {
        boolean yeap = true;
        return yeap;
    }
}
