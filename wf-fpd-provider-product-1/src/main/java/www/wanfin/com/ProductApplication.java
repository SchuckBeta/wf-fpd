package www.wanfin.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;

/**
 * 使用@EnableFeignClients开启Feign
 * 
 * @author lzj
 */
/*@SpringBootApplication
@EnableFeignClients
// 使用@EnableFeignClients开启Feign 开启后 代理层@FeignClient即可指定到提供层
@EnableDiscoveryClient
// 通过@EnableDiscoveryClient注解，即可将服务注册到Eureka上面去
*/

@ImportResource({ "classpath:bytetcc-supports-springcloud.xml"})
@EnableDiscoveryClient
//@EnableEurekaClient
@EnableFeignClients("www.wanfin.com.feign")
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
}