package com.arielkohan.ioc;


public class Application {

    public static void main(String[] args) {
        final ShippingClient shippingClient = new ShippingClient();
        shippingClient.shipStuff();
    }
}

