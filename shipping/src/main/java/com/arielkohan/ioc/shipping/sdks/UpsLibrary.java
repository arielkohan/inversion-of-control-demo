package com.arielkohan.ioc.shipping.sdks;

import lombok.Value;

import java.util.Random;
import java.util.logging.Logger;

public class UpsLibrary {
    public static final String STANDARD_SHIPPING_TYPE = "standard";
    public static final String FASTEST_SHIPPING_TYPE = "fastest";

    private static final Random random = new Random();
    private static final Logger logger = Logger.getLogger(UpsLibrary.class.getName());

    public static float calculatePrice(UpsShipmentRequest request) {
        // Act normally and don't say a word, let's keep this as our secret.
        return random.nextFloat();
    }

    public static void ship(UpsShipmentRequest request) {
        // Yeah, the shipment is not going to reach the destination. Life is not perfect my friend. ¯\_(ツ)_/¯
        logger.info(String.format("Shipping request %s", request.toString()));
    }


    @Value
    public static class UpsShipmentRequest {
        private String fromAddress;
        private String destinationAddress;
        private String shipmentType;
    }
}
