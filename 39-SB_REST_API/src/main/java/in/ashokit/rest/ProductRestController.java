package in.ashokit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.ProductEntity;

@RestController
public class ProductRestController {
	
	@GetMapping(
			value="/product",
			produces={"Application/json","Application/xml"}
			)
	public ResponseEntity<ProductEntity> getProduct(){
		ProductEntity product=new ProductEntity(101,"Laptop",40000.00);
		return new ResponseEntity<>(product,HttpStatus.OK);
		
	}
	
	@PostMapping(
			value="/product",
			consumes= {"Application/json","Application/xml"},
			produces="text/plain"
			)
	public ResponseEntity<String> addProduct(@RequestBody ProductEntity p){
		System.out.println(p);
		return new ResponseEntity<>("Product Added",HttpStatus.CREATED);
	}

}
