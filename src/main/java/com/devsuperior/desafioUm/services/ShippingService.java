package com.devsuperior.desafioUm.services;

import com.devsuperior.desafioUm.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    public ShippingService() {
    }

    public double Shippment (Order order){

        double shippment = 0.0;
        
        if (order.getBasic() < 100)
            shippment = 20;

        else if (order.getBasic() >= 100 && order.getBasic() < 200) {
            shippment = 12;
        }

        else {
            shippment = 0.0;
        }

        return shippment;

    }
}
