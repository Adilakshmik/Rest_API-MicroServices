package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import in.ashokit.feignclient.CustomerFeignClient;
//import in.ashokit.feignclient.GreetApiFeignClient;


@RestController
public class WelcomeRestController {
	
//	@Autowired
//	private Environment env;
	
//	@Autowired
//	private GreetApiFeignClient client;
//	
//	@Autowired
//	private CustomerFeignClient client1;
	
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		//String port = env.getProperty("server.port");
		String welcomeMsg= "Welcome to Ashok IT!,";
//		String greetMsg = client.revokeGreetMsg();
//		String customerMsg = client1.revokeCustomer();
		return welcomeMsg;
	}

}
