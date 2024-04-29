package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Passenger;
import in.ashokit.entity.Ticket;

public interface TicketService {
	
	
	public Ticket savePassenger(Ticket ticketEntity, Passenger passengerEntity);
	public Ticket getTicket(Integer id);
	public List<Ticket> getTickets();
	

}
