package com.thoughtworks.parking_lot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class ParkingLot {
    @Id
    private String name;
    @Column
    @Min(0)
    private int capacity;
    @Column
    private int position;

    public ParkingLot() {
    }

    public ParkingLot(String name, @Min(0) int capacity, int position) {
        this.name = name;
        this.capacity = capacity;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isFull(){
        return position<0;
    }

    public int reducePosition(){
        return position--;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", position=" + position +
                '}';
    }
}
