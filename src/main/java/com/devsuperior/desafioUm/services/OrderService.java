package com.devsuperior.desafioUm.services;

import com.devsuperior.desafioUm.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    ShippingService shippingService;

    public double total (Order order) {

        double discount = (order.getBasic() * order.getDiscount() / 100);
        return (order.getBasic() - discount) + shippingService.Shippment(order);
    }

}
