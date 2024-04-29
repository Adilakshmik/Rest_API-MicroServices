package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Passenger;
import in.ashokit.entity.Ticket;
import in.ashokit.service.TicketService;

@RestController
public class TicketRestController {
	
	@Autowired
	private TicketService service;
	
//	@PostMapping(value="/passenger",consumes="Application/json",produces="text/plain")
//	public ResponseEntity<String> save(@RequestBody Passenger passengerEntity,Ticket ticketEntity ) {
//		 service.savePassenger(ticketEntity,passengerEntity);
//		return new ResponseEntity<>("passenger saved",HttpStatus.CREATED);
//		}
	
	@PostMapping(value="/ticket")
	public ResponseEntity<Ticket> save(@RequestBody Passenger passengerEntity,Ticket ticketEntity ) {
		 Ticket ticket = service.savePassenger(ticketEntity,passengerEntity);
		 return new ResponseEntity<>(ticket,HttpStatus.OK);
		}
	
	@GetMapping(value="/ticket/{id}",produces="Application/json")
	public ResponseEntity <Ticket> getTicket(@PathVariable ("id") Integer id ) {
		Ticket ticket = service.getTicket( id);
		return new  ResponseEntity<>(ticket,HttpStatus.OK);
	}
	
//	@GetMapping(value="/tickets",produces="Application/json")
//	public  ResponseEntity <List<Ticket>> getTickets(){
//		List<Ticket> tickets = service.getTickets();
//		return new  ResponseEntity<>(tickets,HttpStatus.OK);
//	}
	
	@PostMapping(value="/tickets")
	public  ResponseEntity <List<Ticket>> getTickets(){
		List<Ticket> tickets = service.getTickets();
		return new  ResponseEntity<>(tickets,HttpStatus.OK);
	}
	
	

}
