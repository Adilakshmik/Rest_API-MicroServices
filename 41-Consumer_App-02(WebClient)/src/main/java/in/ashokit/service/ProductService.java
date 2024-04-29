package in.ashokit.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;

import in.ashokit.binding.Product;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
	
	String apiUrl="https://api.restful-api.dev/objects/1";
	
	public Mono<String> getProduct() {
		WebClient webClient = WebClient.create();
	Mono<String> bodyToMono = webClient.get()
		                               .uri(apiUrl)
		                               .retrieve()
		                               .bodyToMono(String.class);
		             
		   return bodyToMono;
		     }
	
	public Mono<Product> getProducts() {
		WebClient webClient = WebClient.create();
	Mono<Product> bodyToMono = webClient.get()
		                               .uri(apiUrl)
		                               .retrieve()
		                               .bodyToMono(Product.class);
		             
		   return bodyToMono;
		     }

}
