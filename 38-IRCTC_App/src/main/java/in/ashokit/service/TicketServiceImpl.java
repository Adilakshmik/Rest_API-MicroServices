package in.ashokit.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Passenger;
import in.ashokit.entity.Ticket;

import in.ashokit.repo.TicketRepo;

@Service
public class TicketServiceImpl implements TicketService{
	
	
	@Autowired
	private TicketRepo ticketRepo;

	@Override
	public Ticket savePassenger(Ticket ticketEntity, Passenger passengerEntity) {
		BeanUtils.copyProperties(passengerEntity, ticketEntity);
		ticketEntity.setTicketStatus("CONFIRMED");
		Ticket ticket = ticketRepo.save(ticketEntity);
		return ticket;
	}
	@Override
	public Ticket getTicket(Integer id) {
		Ticket ticketEntity2 = ticketRepo.findById(id).orElseThrow();
		return ticketEntity2;
	}

	@Override
	public List<Ticket> getTickets() {
		List<Ticket> all = ticketRepo.findAll();
		return all;
	}


	

	
}
