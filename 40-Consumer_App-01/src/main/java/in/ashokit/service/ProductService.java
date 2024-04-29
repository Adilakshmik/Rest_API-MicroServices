package in.ashokit.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.ashokit.bindings.Product;

@Service
public class ProductService {
	
	public void getProducts() {
		String url="https://api.restful-api.dev/objects";
		RestTemplate rt=new RestTemplate();
		ResponseEntity<String> responseEntity = rt.getForEntity(url,String.class );
		int value = responseEntity.getStatusCode().value();
		if(value==200) {
			String body = responseEntity.getBody();
			System.out.println(body);
		}
		}
	
	
	
	public Product getProduct(String id) {
		String url="https://api.restful-api.dev/objects/" + id;
		RestTemplate rt=new RestTemplate();
		 ResponseEntity<Product> responseEntity = rt.getForEntity(url,Product.class);
		int value = responseEntity.getStatusCode().value();
		if(value==200) {
			return responseEntity.getBody();
			 
			 }
		return null;
			}
		
	}

