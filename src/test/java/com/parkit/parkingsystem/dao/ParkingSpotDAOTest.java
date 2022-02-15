package com.parkit.parkingsystem.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.model.ParkingSpot;

public class ParkingSpotDAOTest {

	@Test
	public void getNextAvailableSlot(){
	
		ParkingSpotDAO p = new ParkingSpotDAO();
        
        assertEquals( p.getNextAvailableSlot( ParkingType.CAR), 0);
    }
	
	@Test
	public void updateParking() {
		
		ParkingSpotDAO n = new ParkingSpotDAO();
		ParkingSpot ps = new ParkingSpot(1, ParkingType.CAR, false);
		
		
		assertEquals(n.updateParking(ps), true);
	}
	
	
	
}
