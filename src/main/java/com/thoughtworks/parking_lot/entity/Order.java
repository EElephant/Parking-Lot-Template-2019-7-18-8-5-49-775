package com.thoughtworks.parking_lot.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PARKING_ORDER")
public class Order {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "PARKING_LOG_NAME")
    private String parkingLotName;
    @Column
    private String carNumber;
    @Column(nullable = true)
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = true)
    private Date endTime;
    @Column
    private Boolean orderStatus;

    public Order() {
    }

    public Order(String parkingLotName, String carNumber, Date startTime, Date endTime, Boolean orderStatus) {
        this.parkingLotName = parkingLotName;
        this.carNumber = carNumber;
        this.startTime = startTime;
        this.endTime = endTime;
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Boolean getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Boolean orderStatus) {
        this.orderStatus = orderStatus;
    }
}
