package in.ashokit.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.ashokit.bindings.Passenger;
import in.ashokit.bindings.Ticket;
import reactor.core.publisher.Mono;

@Service
public class MakeMyTripService {
	
	String bookTicketUrl="http://localhost:8081/ticket";
	String getTicketUrl="http://localhost:8081/tickets";
	
	public Mono<Ticket> bookTicket(Passenger p){
		WebClient webClient = WebClient.create();
				return webClient.post()
				         .uri(bookTicketUrl)
				         .body(BodyInserters.fromValue(p))
				         .retrieve()
				         .bodyToMono(Ticket.class);
	}
	
	
	public Mono<Ticket[]> getTickets(){
		WebClient webClient = WebClient.create();
				return webClient.post()
				         .uri(getTicketUrl)
				         .retrieve()
				         .bodyToMono(Ticket[].class);
	}
}
