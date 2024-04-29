package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {
	
	@Autowired
	private Environment env;
	
	@GetMapping("/customer")
	public String getCustomer() {
		String port = env.getProperty("server.port");
		return "Dear sir/madam("+port+")";
	}

}
