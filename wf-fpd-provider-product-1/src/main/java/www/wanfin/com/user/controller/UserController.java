package www.wanfin.com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.wanfin.com.user.entity.User;
import www.wanfin.com.user.repository.UserRepository;


/**
 * 作用：
 * ① 测试服务实例的相关内容
 * ② 为后来的服务做提供
 * @author eacdy
 */
@RestController
@RefreshScope/*** 这边的@RefreshScope注解不能少，否则即使调用/refresh，配置也不会刷新* @author eacdy*/
public class UserController {
  @Autowired
  private DiscoveryClient discoveryClient;
  @Autowired
  private UserRepository userRepository;
  
/*  
  @Value("${foo}")
  String foo;
  @RequestMapping(value = "/hi")
  public String hi(){
      return foo;
  }
  @Value("${foo}")
  private String profile;

  @GetMapping("/hello")
  public String hello() {
    return this.profile;
  }*/
  
  /**
   * 注：@GetMapping("/{id}")是spring 4.3的新注解等价于：
   * @RequestMapping(value = "/id", method = RequestMethod.GET)
   * 类似的注解还有@PostMapping等等
   * @param id
   * @return user信息
   */                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
  @GetMapping("/{id}")
  public User findById(@PathVariable Long id) {
   // User findOne = this.userRepository.findOne(id);
	User findOne = this.userRepository.getOne(id);
    return findOne;
  }

  /**
   * 本地服务实例的信息
   * @return
   */
 /* @GetMapping("/instance-info")
  public ServiceInstance showInfo() {
    ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
    return localServiceInstance;
  }*/
  
  @RequestMapping("/do1/{id}")  
  public String hi(@PathVariable("id") String id) throws Exception {  
      System.out.println("do1"+id);  
      Thread.sleep(50L);  
        
      return "the "+id+" cycle in order  do1";  
  }  
  
}