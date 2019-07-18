package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.Order;
import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.repository.OrderRepository;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ParkingLotRepository parkingLotRepository;

    public void updateOrderInfo(String carNumber) {
        Order targetOrder = orderRepository.findByCarNumber(carNumber);
        targetOrder.setEndTime(new Date());
        targetOrder.setOrderStatus(false);
        orderRepository.saveAndFlush(targetOrder);
    }

    public String addOrder(Order order) {
        order.setStartTime(new Date());
//        parkingLotRepository.findByName(order.getParkingLotName()).reducePosition();
        ParkingLot parkingLot = parkingLotRepository.findByName(order.getParkingLotName());
        parkingLot.reducePosition();
        if(parkingLot.isFull()){
            return "this parkingLot is full!!!";
        }else {
            orderRepository.save(order);
            return "";
        }

    }

//    public String addOrderBeforeQuerryPosition(String name) {
//        ParkingLot parkingLot = parkingLotRepository.findByName(name);
//        if (parkingLot.isFull()){
//            return "this parkingLot is full!!!";
//        }else {
//            addOrder();
//        }
//    }
}
