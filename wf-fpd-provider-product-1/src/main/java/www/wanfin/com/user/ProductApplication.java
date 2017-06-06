package www.wanfin.com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
/**
 * 使用@EnableFeignClients开启Feign
 * @author lzj
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ProductApplication {
  public static void main(String[] args) {
    SpringApplication.run(ProductApplication.class, args);
  }
}