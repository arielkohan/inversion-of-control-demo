package com.arielkohan.ioc;


import com.arielkohan.ioc.shipping.UpsShippingImpl;
import com.arielkohan.ioc.shipping_client.ShippingClient;
import com.arielkohan.ioc.shipping_interface.Shipping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        final ShippingClient shippingClient = applicationContext.getBean(ShippingClient.class);
        shippingClient.shipStuff();
    }

    @Bean
    public Shipping shipping() {
        return new UpsShippingImpl();
    }
}

