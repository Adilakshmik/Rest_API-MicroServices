package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import in.ashokit.binding.Product;
import in.ashokit.service.ProductService;
import reactor.core.publisher.Mono;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/p")
	public ResponseEntity<Mono<String>> getProduct() {
		Mono<String> productData = service.getProduct();
		return new ResponseEntity<>(productData ,HttpStatus.OK);
	}
	
	@GetMapping("/product")
	public ResponseEntity<Mono<Product>> getProducts() {
		Mono<Product> productData = service.getProducts();
		return new ResponseEntity<>(productData ,HttpStatus.OK);
	}

}
