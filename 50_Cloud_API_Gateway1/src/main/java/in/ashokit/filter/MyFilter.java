package in.ashokit.filter;

import java.util.List;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

public class MyFilter implements GlobalFilter{

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		HttpHeaders headers = request.getHeaders();
		List<String> list = headers.get("secret");
		String value= list.get(0).valueOf("adi@123");
		
		if(!headers.containsKey("secret")) {
			return Mono.error(new RuntimeException("Invalid Request")); 
		}
		if(!headers.containsValue(value)) {
			return Mono.error(new RuntimeException("Invalid token"));
		}
		return chain.filter(exchange);
	}

}
