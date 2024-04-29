package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import in.ashokit.feignclient.WelcomeApiFeignClient;

@RestController
public class GreetRestController {
	
	@Autowired
	private Environment env;
	
//	@Autowired
//	private WelcomeApiFeignClient client;
	
	
	@GetMapping("/greet")
	public String getGreetMsg() {
		String port = env.getProperty("server.port");
		String greetMsg="Good Afternoon( "+port+"),";
		//String welcomeMsg = client.revokeWelcomeMsg();
		
		return greetMsg;
		}
	}
