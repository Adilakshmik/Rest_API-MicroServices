package in.ashokit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.CustomerEntity;
import in.ashokit.service.CustomerService;

@RestController
public class CustomerRestController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping(value="/customer",consumes="Application/json",produces="text/plain")
	public ResponseEntity<String> save(@RequestBody CustomerEntity entity) {
		service.saveCustomer(entity);
		System.out.println(entity);
		return new  ResponseEntity<>("Record Saved",HttpStatus.CREATED);
		}
	
	@PutMapping(value="/customer",produces="text/plain")
	public ResponseEntity<String> update(@RequestBody CustomerEntity entity){
		CustomerEntity updateCustomer = service.updateCustomer(entity);
		return new ResponseEntity<>("Record Updated",HttpStatus.OK);
	}
	
	@DeleteMapping(value="/customer/{id}",produces="text/plain")
	public ResponseEntity<String> delete(@PathVariable ("id") Integer id){
		service.deleteCustomer(id);
		return new ResponseEntity<>("Record Deleted",HttpStatus.OK);
	}
	
	@GetMapping(value="/get",produces="Application/json")
	public ResponseEntity<List<CustomerEntity>> getCustomers(){
		List<CustomerEntity> customers = service.retrieveCustomers();
		return new ResponseEntity<>(customers,HttpStatus.OK);
	}

}
