package com.parkit.parkingsystem.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.dao.ParkingSpotDAO;
import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.model.Ticket;

public class FareCalculatorService {
	
	 public void calculateFare(Ticket ticket){
		 calculateFare(ticket, "");
		 //calculateFare(ticket);
	 }

    public void calculateFare(Ticket ticket, String vehicleRegNumber){
    	System.out.println(ticket.getOutTime() + "$$$$$$$$$$$$" + ticket.getInTime());
        if( (ticket.getOutTime() == null) || (ticket.getOutTime().before(ticket.getInTime())) ){
            throw new IllegalArgumentException("Out time provided is incorrect:"+ticket.getOutTime().toString());
        }

        //int inHour = ticket.getInTime().getHours();
        //int outHour = ticket.getOutTime().getHours();
        
        long inHour = ticket.getInTime().getTime();
        long outHour = ticket.getOutTime().getTime();

        //TODO: Some tests are failing here. Need to check if this logic is correct
        long duration_0 = outHour - inHour;
        float duration = (float)duration_0/(1000*60*60);//+ duree en plus;
        //System.out.println(inHour+"         "+outHour);
        //System.out.println("#########"+duration_0+"      "+duration);
        //System.out.println("********************"+"inHour"+ inHour +"," + ticket.getInTime());
        //System.out.println("********************"+"outHour"+ outHour +"," + ticket.getOutTime());
       // System.out.println("####################"+duration);
        
        TicketDAO ticketDAO = new TicketDAO();
        
        
        
        int nombre = ticketDAO.countTickets(vehicleRegNumber);
        
        float pourcentage = 0;
        
        //System.out.println("???????????????????????"+nombre);
        
        if(nombre > 1) {
        	pourcentage = (float) 0.05;
        }
        
        if(duration <= 0.5) {
        	duration = 0;
        }
       // if(ticket.getVehicleRegNumber())

        switch (ticket.getParkingSpot().getParkingType()){
            case CAR: {
                ticket.setPrice(duration * Fare.CAR_RATE_PER_HOUR-(duration * Fare.CAR_RATE_PER_HOUR*pourcentage));
                break;
            }
            case BIKE: {
                ticket.setPrice(duration * Fare.BIKE_RATE_PER_HOUR*(1-pourcentage));//1-0.05 = 0.95
                break;
            }
            default: throw new IllegalArgumentException("Unkown Parking Type");
        }
    }
}