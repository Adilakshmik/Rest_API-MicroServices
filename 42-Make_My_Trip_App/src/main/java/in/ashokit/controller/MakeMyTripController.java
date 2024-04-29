package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.bindings.Passenger;
import in.ashokit.bindings.Ticket;
import in.ashokit.service.MakeMyTripService;
import reactor.core.publisher.Mono;

@Controller
public class MakeMyTripController {
	
	@Autowired
	private MakeMyTripService service;
	
	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("passenger", new Passenger());
		return "registerPage";
	}
	
	@PostMapping("/bookTicket")
	public String bookTicket(Model model,Passenger passenger) {
		model.addAttribute("passenger",  passenger);
		Mono<Ticket> ticket = service.bookTicket(passenger);
		model.addAttribute("ticket",ticket );
		return "ticket";
	}
	
	@GetMapping("/tickets")
	public String  getTickets(Model model,Ticket ticket) {
		//model.addAttribute("ticket", ticket);
		 Mono<Ticket[]> tickets = service.getTickets();
		 model.addAttribute("tickets", tickets);
		return "ticketsViewPage";
	}
	
}
