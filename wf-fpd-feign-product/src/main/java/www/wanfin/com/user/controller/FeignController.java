package www.wanfin.com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import www.wanfin.com.user.entity.User;
import www.wanfin.com.user.feign.UserFeignClient;
import www.wanfin.com.user.feign.UserFeignHystrixClient;

@RestController
@RefreshScope
public class FeignController {
  @Autowired
  private UserFeignClient userFeignClient;
  @Autowired
  private UserFeignHystrixClient userFeignHystrixClient;
  
/*  @Value("${profile}")
  private String profile;

  @GetMapping("/hello")
  public String hello() {
    return this.profile;
  }*/
  
  
  @GetMapping("feign/{id}")
  public User findByIdFeign(@PathVariable Long id) {
   // User user = this.userFeignClient.findByIdFeign(id);
    User user = this.userFeignHystrixClient.findByIdFeign(id);//熔断器方式
    return user;
  }
}
