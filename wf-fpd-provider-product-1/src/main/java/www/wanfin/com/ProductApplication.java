package www.wanfin.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

/**
 * 使用@EnableFeignClients开启Feign
 * 
 * @author lzj
 */
@SpringBootApplication
@EnableFeignClients
// 使用@EnableFeignClients开启Feign 开启后 代理层@FeignClient即可指定到提供层
@EnableDiscoveryClient
// 通过@EnableDiscoveryClient注解，即可将服务注册到Eureka上面去

public class ProductApplication {

    @Bean  
    public RestTemplate restTemplate() {  
        return new RestTemplate();  
    }  
    
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
}