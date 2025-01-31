package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    Order findByCarNumber(String carNumber);
}
