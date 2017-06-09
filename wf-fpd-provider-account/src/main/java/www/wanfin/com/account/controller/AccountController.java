package www.wanfin.com.account.controller;

import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import www.wanfin.com.account.entity.Account;
import www.wanfin.com.account.service.AccountService;



@Compensable(interfaceClass = AccountService.class, confirmableKey = "transferServiceConfirm", cancellableKey = "transferServiceCancel")
@RestController
public class AccountController {
  @Autowired
  private DiscoveryClient discoveryClient;
  @Autowired
  private AccountService accountService;
  
  
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
  }
  
  /**
   * 注：@GetMapping("/{id}")是spring 4.3的新注解等价于：
   * @RequestMapping(value = "/id", method = RequestMethod.GET)
   * 类似的注解还有@PostMapping等等
   * @param id
 * @return 
   * @return user信息
   */                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
  @ResponseBody
  @RequestMapping(value = "/get", method = RequestMethod.POST)//----------扣钱
  @Transactional
  public Account increaseAmount(@RequestParam String id) {
    // User findOne = this.userRepository.findOne(id);
	//User findOne = this.userRepository.getOne(id);
	Account account=accountService.get(id);;
    return account;
  }

  /**
   * 本地服务实例的信息
   * @return
   */
  @GetMapping("/instance-info")
  public ServiceInstance showInfo() {
    ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
    return localServiceInstance;
  }
}