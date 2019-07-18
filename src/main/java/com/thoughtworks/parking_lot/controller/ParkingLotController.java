package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking-lot")
public class ParkingLotController {
    @Autowired
    ParkingLotService parkingLotService;

    @DeleteMapping("/{name}")
    public void deleteParkingLotByName(@PathVariable String name){
        parkingLotService.deleteParkingLotByName(name);
    }

    @PostMapping
    public void addPakingLot(@RequestBody ParkingLot parkingLot){
        parkingLotService.addPakingLot(parkingLot);
    }

    @GetMapping
    public List<ParkingLot> getParkingLots(@RequestParam(value = "page",defaultValue = "1")int page,@RequestParam(value = "pageSize",defaultValue = "15")int pageSize){
        return parkingLotService.getParkingLots().subList(page-1,pageSize);
    }

    @GetMapping("/{name}")
    public ParkingLot getSpecificParkingLotByName(@PathVariable String name){
        return parkingLotService.getSpecificParkingLotByName(name);
    }
}
