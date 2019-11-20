package com.arielkohan.ioc.shipping;


import com.arielkohan.ioc.model.order.Address;
import com.arielkohan.ioc.shipping.sdks.UpsLibrary;

public class Shipping {

    public static float calculateStandardPrice(Address fromAddress, Address destinationAddress) {
        UpsLibrary.UpsShipmentRequest request = generateStandardShippingRequest(fromAddress, destinationAddress);
        return UpsLibrary.calculatePrice(request);
    }

    private static UpsLibrary.UpsShipmentRequest generateStandardShippingRequest(Address fromAddress, Address destinationAddress) {
        return new UpsLibrary.UpsShipmentRequest(fromAddress.toString(), destinationAddress.toString(), UpsLibrary.STANDARD_SHIPPING_TYPE);
    }

    public static void standardShip(Address fromAddress, Address destinationAddress) {
        UpsLibrary.UpsShipmentRequest request = generateStandardShippingRequest(fromAddress, destinationAddress);
        UpsLibrary.ship(request);
    }

    public static float calculateFastestPrice(Address fromAddress, Address destinationAddress) {
        UpsLibrary.UpsShipmentRequest request = generateFastestShippingRequest(fromAddress, destinationAddress);
        return UpsLibrary.calculatePrice(request);
    }

    private static UpsLibrary.UpsShipmentRequest generateFastestShippingRequest(Address fromAddress, Address destinationAddress) {
        return new UpsLibrary.UpsShipmentRequest(fromAddress.toString(), destinationAddress.toString(), UpsLibrary.FASTEST_SHIPPING_TYPE);
    }

    public static void fastestShip(Address fromAddress, Address destinationAddress) {
        UpsLibrary.UpsShipmentRequest request = generateFastestShippingRequest(fromAddress, destinationAddress);
        UpsLibrary.ship(request);
    }


}
