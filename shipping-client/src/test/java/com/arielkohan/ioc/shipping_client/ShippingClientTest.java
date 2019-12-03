package com.arielkohan.ioc.shipping_client;

import com.arielkohan.ioc.shipping_interface.Shipping;
import com.arielkohan.ioc.shipping_interface.ShippingRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShippingClientTest {

    private boolean calculateCalled;
    private boolean shipCalled;
    
    // Plain Anonymous Class Mock Implementation
    private Shipping shipping = new Shipping() {
        @Override
        public float calculatePrice(ShippingRequest request) {
            calculateCalled = true;
            return 0;
        }

        @Override
        public void ship(ShippingRequest request) {
            shipCalled = true;
        }
    };


    @BeforeEach
    void setup() {
        calculateCalled = false;
        shipCalled = false;
    }

    @Test
    void bestTestEver() {
        final ShippingClient shippingClient = new ShippingClient(shipping);
        shippingClient.shipStuff();
        assertTrue(calculateCalled);
        assertTrue(shipCalled);
    }

}