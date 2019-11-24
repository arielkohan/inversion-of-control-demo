package com.arielkohan.ioc.shipping;


import com.arielkohan.ioc.model.order.Address;
import com.arielkohan.ioc.model.order.Order;
import com.arielkohan.ioc.shipping.sdks.UpsLibrary;
import com.arielkohan.ioc.shipping_interface.Shipping;
import com.arielkohan.ioc.shipping_interface.ShippingRequest;
import com.arielkohan.ioc.shipping_interface.ShippingTypeNotAvailableException;
import org.springframework.stereotype.Component;

@Component
public class UpsShippingImpl implements Shipping {

    @Override
    public float calculatePrice(ShippingRequest request) {
        UpsLibrary.UpsShipmentRequest upsRequest = transformShippingRequestToUpsFormat(request);
        return UpsLibrary.calculatePrice(upsRequest);
    }

    private UpsLibrary.UpsShipmentRequest transformShippingRequestToUpsFormat(ShippingRequest request) {
        Order order = request.getOrder();
        final Address fromAddress = request.getFromAddress();
        String fromAddressString = fromAddress.toString();
        String destinationAddressString = extractStringAddressRepresentationFromOrder(order);
        String upsShippingType = mapShippingTypeToUpsOptions(request);
        return new UpsLibrary.UpsShipmentRequest(fromAddressString, destinationAddressString, upsShippingType);
    }

    private String extractStringAddressRepresentationFromOrder(Order order) {
        final Address destinationAddress = order.getAddress();
        return destinationAddress.toString();
    }

    private String mapShippingTypeToUpsOptions(ShippingRequest request) {
        String upsShippingType;
        switch (request.getShippingType()) {
            case CHEAPEST:
                upsShippingType = UpsLibrary.STANDARD_SHIPPING_TYPE;
                break;
            case FASTEST:
                upsShippingType = UpsLibrary.FASTEST_SHIPPING_TYPE;
                break;
            default:
                throw new ShippingTypeNotAvailableException();
        }
        return upsShippingType;
    }

    @Override
    public void ship(ShippingRequest request) {
        UpsLibrary.UpsShipmentRequest upsRequest = transformShippingRequestToUpsFormat(request);
        UpsLibrary.ship(upsRequest);
    }
}
