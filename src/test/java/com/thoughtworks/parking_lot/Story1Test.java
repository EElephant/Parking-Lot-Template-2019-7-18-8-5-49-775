package com.thoughtworks.parking_lot;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Story1Test {
    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Test
    public void should_return_specific_parking_lot_when_call_get_specific_parking_lot_by_name_given_name(){
        //given
        ParkingLot parkingLot1 = new ParkingLot("1",1,1);
        ParkingLot parkingLot2 = new ParkingLot("2",1,1);
        //when
        parkingLotRepository.save(parkingLot1);
        parkingLotRepository.save(parkingLot2);
        ParkingLot parkingLot = parkingLotRepository.findByName("1");
        //then
        assertEquals(parkingLot1.toString(),parkingLot.toString());
    }
}
