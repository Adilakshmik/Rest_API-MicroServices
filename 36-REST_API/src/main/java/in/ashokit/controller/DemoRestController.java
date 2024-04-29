package in.ashokit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	
	@GetMapping("/msg")
	public ResponseEntity<String> getMsg() {
		String msg="Hello Hyderabad";
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	
	@GetMapping("/greet/{name}")
	public String getGreet(@PathVariable("name") String name) {
		String msg=name+",Good Morning..!";
		return msg;
	}
	
	@GetMapping("/welcome")
	public String getWelcomeMsg(@RequestParam ("name") String name) {
		String msg=name+", Welcome to REST API";
		return msg;
	}

}
