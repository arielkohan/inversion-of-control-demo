package com.arielkohan.ioc;


import com.arielkohan.ioc.shipping_client.ShippingClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        final ShippingClient shippingClient = applicationContext.getBean(ShippingClient.class);
        shippingClient.shipStuff();
    }
}

