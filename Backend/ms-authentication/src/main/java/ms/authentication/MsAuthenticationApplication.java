package ms.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
@EnableFeignClients
public class MsAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAuthenticationApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	// TODO move the below code to a config file
	@Bean
	public HystrixCommandAspect hystrixAspect() {
		return new HystrixCommandAspect();
	}

}
