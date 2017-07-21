package www.wanfin.com.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
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
@EnableAutoConfiguration
//@EnableAutoConfiguration  spring会自动实现相关的ORM映射

public class AccountApplication {


    @Bean  
    public RestTemplate restTemplate() {  
        return new RestTemplate();  
    }  
    
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}
}