package com.parkit.parkingsystem.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.model.ParkingSpot;
import com.parkit.parkingsystem.model.Ticket;

public class TicketDAOTest {
	
	@Test
	public void saveTicketTest(){
		
		Ticket ticket = new Ticket();
		
		ParkingSpot ps = new ParkingSpot(1, ParkingType.CAR, false);
		
		ticket.setParkingSpot(ps);
		ticket.setPrice(1.5);
		ticket.setVehicleRegNumber("ABC");
		ticket.setInTime(new Date());
		ticket.setOutTime(new Date());
		
		TicketDAO ticketDao = new TicketDAO();
		
		ParkingSpotDAO p = new ParkingSpotDAO();
        
        assertEquals( ticketDao.saveTicket(ticket), false);
	
	
	}
	
	@Test
	public void saveTicketTestError(){
		
		Ticket ticket = new Ticket();
		
		ParkingSpot ps = new ParkingSpot(1, ParkingType.CAR, false);
		
		ticket.setParkingSpot(ps);
		ticket.setPrice(1.5);
		ticket.setVehicleRegNumber("ABC");
		
		TicketDAO ticketDao = new TicketDAO();
		
		ParkingSpotDAO p = new ParkingSpotDAO();
        
        assertEquals( ticketDao.saveTicket(ticket), false);
	
	
	}
	
	
	@Test
	public void updateTicketTestError(){
		
		Ticket ticket = new Ticket();
		
		ParkingSpot ps = new ParkingSpot(1, ParkingType.CAR, false);
		
		ticket.setParkingSpot(ps);
		ticket.setPrice(1.5);
		ticket.setVehicleRegNumber("ABC");
		
		TicketDAO ticketDao = new TicketDAO();
		
		ParkingSpotDAO p = new ParkingSpotDAO();
        
        assertEquals( ticketDao.updateTicket(ticket), false);
	
	
	}
	
	
	@Test
	public void getTicketTest(){
		
		
		TicketDAO ticketDao = new TicketDAO();
		

        
        assertEquals( ticketDao.getTicket("ABC").getVehicleRegNumber(), "ABC");
	
	
	}
	
	@Test
	public void getTicketTestErreur(){
		
		
		TicketDAO ticketDao = new TicketDAO();
		

        
        assertEquals( ticketDao.getTicket("ABCOOO"),null);
	
	
	}
	
}
