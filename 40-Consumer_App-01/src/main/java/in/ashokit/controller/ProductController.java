package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.bindings.Product;
import in.ashokit.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/")
	public String product() {
		service.getProducts();
		return "index";
	}
	
	@GetMapping("/product")
	public String product1(Model model, @RequestParam("pid") String pid) {
		Product product = service.getProduct(pid);
		model.addAttribute("p", product);
		return "index";
	}
	

}
