package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.entity.Order;
import com.thoughtworks.parking_lot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PutMapping
    public void updateOrderInfo(String carNumber){
        orderService.updateOrderInfo(carNumber);
    }

    @PostMapping
    public String addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }

//    @PostMapping("/{parkingLotName}")
//    public String addOrderBeforeQuerryPosition( String name){
//        return orderService.addOrderBeforeQuerryPosition(name);
//    }

}
