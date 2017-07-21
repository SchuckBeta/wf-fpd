package www.wanfin.com.account.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import www.wanfin.com.account.service.IAccountService;

/**
 * 作用： ① 测试服务实例的相关内容 ② 为后来的服务做提供
 * 
 * @author eacdy
 *//*
@RestController
@RefreshScope
*//*** 这边的@RefreshScope注解不能少，否则即使调用/refresh，配置也不会刷新* @author eacdy*/
@RestController
public class CycleController{
	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private IAccountService accountService;
	
	 @Autowired  
	 private RestTemplate restTemplate; 
	
	
	 private String url="http://localhost:8000";  
	      
	  
	  @RequestMapping("/do2/{id}")  
	   public String hi(@PathVariable("id") String id) throws Exception {  
	        System.out.println("do2"+id);  
	        Thread.sleep(200L);  
	        String cycle = this.restTemplate.getForObject(url + "/do1/"+id, String.class);  
	        return "the "+id+" do2 in oter service - "+cycle;  
	   }  
	
	
/*	@ResponseBody
	@RequestMapping(value = "/increase", method = RequestMethod.POST)
	// 增加
	@Transactional
	public int increaseAmount(@RequestParam("acctId") String acctId,
			@RequestParam("amount") double amount) {
		int value = accountRepository.increaseAmount(acctId, amount);
		if (value != 1) {
			throw new IllegalStateException("ERROR!");
		}
		System.out.printf("exec increase: acct= %s, amount= %7.2f%n", acctId,
				amount);
		return value;
	}*/

	/*@ResponseBody
	@RequestMapping(value = "/decrease", method = RequestMethod.POST)
	// 减少
	@Transactional
	public int decreaseAmount(@RequestParam("acctId") String acctId,
			@RequestParam("amount") double amount) {
		
		int value=accountService.decreaseAmount(acctId, amount);
		return value;
		
	}*/

	/**
	 * 本地服务实例的信息
	 * 
	 * @return
	 *//*
	@GetMapping("/instance-info")
	public ServiceInstance showInfo() {
		ServiceInstance localServiceInstance = this.discoveryClient
				.getLocalServiceInstance();
		return localServiceInstance;
	}*/
}