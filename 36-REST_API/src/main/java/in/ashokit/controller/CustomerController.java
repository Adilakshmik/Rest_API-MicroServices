package in.ashokit.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.Customer;

@RestController
public class CustomerController {
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<String> updateCustomer(@PathVariable ("id") Integer id,@RequestBody Customer c){
		//update into db
		System.out.println(c);
		return new ResponseEntity<>("Customer Updated",HttpStatus.OK); 
	}
	
	@DeleteMapping("/customer")
	public ResponseEntity<String> deleteCustomer(@RequestBody Customer c){
		//delete from db
		return new ResponseEntity<>("Customer Deleted",HttpStatus.OK);
		
	}
	
	@PostMapping(value="/customer",consumes="Application/json",produces="text/plain")
	public ResponseEntity<String> createCustomer(@RequestBody Customer c){
		System.out.println(c);
		//insert into db
		return new ResponseEntity<>("Customer Saved",HttpStatus.CREATED);
	}
	
	@GetMapping(value="/customers",produces="Application/json")
	public ResponseEntity<List<Customer>> getCustomers(){
		Customer c1=new Customer(1,"Ashwini","aswh@gmail.com");
		Customer c2=new Customer(2,"Aaru","aaru@gmail.com");
		Customer c3=new Customer(3,"Akshaya","akshaya@gmail.com");
		List<Customer> list = Arrays.asList(c1,c2,c3);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping(value="/customer",produces="Application/json")
	public ResponseEntity<Customer> getCustomer() {
		Customer c=new Customer(1,"Mani","mani@gmail.com");
		return new ResponseEntity<>(c,HttpStatus.OK);
	}

}
