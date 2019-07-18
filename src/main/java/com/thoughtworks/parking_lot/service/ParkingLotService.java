package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotService {

    @Autowired
    ParkingLotRepository parkingLotRepository;

    public void deleteParkingLotByName(String name){
        parkingLotRepository.deleteById(name);
    }

    public void addPakingLot(ParkingLot parkingLot) {
        parkingLotRepository.save(parkingLot);
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLotRepository.findAll();
    }

    public ParkingLot getSpecificParkingLotByName(String name) {
        return parkingLotRepository.findByName(name);
    }
}
