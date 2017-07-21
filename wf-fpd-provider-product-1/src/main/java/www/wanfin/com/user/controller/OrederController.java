package www.wanfin.com.user.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mysql.jdbc.log.Log;
import com.mysql.jdbc.log.LogFactory;

import www.wanfin.com.user.entity.OrderInfo;
import www.wanfin.com.user.repository.OrderRepository;
import www.wanfin.com.user.service.IOrderService;

/**
 * 作用： ① 测试服务实例的相关内容 ② 为后来的服务做提供
 * 
 * @author eacdy
 */


@RestController
@RefreshScope
/*** 这边的@RefreshScope注解不能少，否则即使调用/refresh，配置也不会刷新* @author
*/
public class OrederController{
	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired  
	 private RestTemplate restTemplate;  
	      
     private String url="http://127.0.0.1:8010"; 
     
     
     @Autowired 
     private AmqpTemplate amqpTemplate;

     public void send(String key,String content) {
         amqpTemplate.convertAndSend(key, content); 
     }
     
     @RequestMapping(value = "/order-info/{id}", method = RequestMethod.GET)
     public String service1(@PathVariable("id") String id,ModelMap model) throws Exception {  
         System.out.println("fetch order info ");  
         model.addAttribute("order", id+"订单信息。。。。");  
         Thread.sleep(200L);  
           
         String coupon = this.restTemplate.getForObject(url + "/coupon/"+id, String.class);  
         model.addAttribute("coupon", coupon);  
           
         String point = this.restTemplate.getForObject(url + "/point/"+id, String.class);  
         model.addAttribute("point", point);  
           
         return model.toString();  
     }     
	
 	@RequestMapping(value = "/order-info-cycle/{id}", method = RequestMethod.GET)
     public String cycle(@PathVariable("id") String id,ModelMap model) throws Exception {  
    	 System.out.println("fetch order info ");  
         model.addAttribute("order", id+"订单信息。。。。");  
         Thread.sleep(200L);  
           
         String coupon = this.restTemplate.getForObject(url + "/coupon/"+id, String.class);  
         model.addAttribute("coupon", coupon);  
           
         String point = this.restTemplate.getForObject(url + "/point/"+id, String.class);  
         model.addAttribute("point", point);  
           
         String cycle = this.restTemplate.getForObject(url + "/do2/"+id, String.class);  
         model.addAttribute("cycle", cycle);  
           
         return model.toString();  
     }     

	/**
	 * 本地服务实例的信息
	 * 
	 * @return
	 */
	@GetMapping("/instance-info")
	public ServiceInstance showInfo() {
		ServiceInstance localServiceInstance = this.discoveryClient
				.getLocalServiceInstance();
		return localServiceInstance;
	}
}