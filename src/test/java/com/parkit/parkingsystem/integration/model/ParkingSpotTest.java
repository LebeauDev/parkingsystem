package com.parkit.parkingsystem.integration.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.parkit.parkingsystem.App;
import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.model.ParkingSpot;
import com.parkit.parkingsystem.model.Ticket;
import com.parkit.parkingsystem.service.InteractiveShell;
import com.parkit.parkingsystem.service.ParkingService;


@ExtendWith(MockitoExtension.class)
public class ParkingSpotTest {
	
	@Mock
	private ParkingSpot parkingSpot;
	
	@Mock
	private App app;
	
	@Mock
	InteractiveShell interactiveShell;

	 @Test
	    public void setIDTest(){
		 
		 	parkingSpot.setId(0);
	        
	        verify(parkingSpot, Mockito.times(1)).setId(anyInt());
	    }
	 
	 @Test
	    public void setParkingTypeTest(){
		 
		 	parkingSpot.setParkingType(ParkingType.CAR);
	        
	        verify(parkingSpot, Mockito.times(1)).setParkingType(ParkingType.CAR);
	    }
	 
	 @Test
	 public void equalsTest() {
		 
		 
		assertTrue(parkingSpot.equals(parkingSpot));
	 }
	 
	 @Test
	 public void getIdTest() {
		 Ticket ticket = new Ticket();
		 ticket.setId(0);
		 
		assertEquals(0, ticket.getId());
	 }
	 
	 
	 
	 
}
