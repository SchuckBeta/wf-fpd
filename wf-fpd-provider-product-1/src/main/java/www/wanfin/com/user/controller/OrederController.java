package www.wanfin.com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import www.wanfin.com.user.entity.OrderInfo;
import www.wanfin.com.user.repository.OrderRepository;
import www.wanfin.com.user.service.IOrderService;

/**
 * 作用： ① 测试服务实例的相关内容 ② 为后来的服务做提供
 * 
 * @author eacdy
 */


@RestController
//@RefreshScope
/*** 这边的@RefreshScope注解不能少，否则即使调用/refresh，配置也不会刷新* @author
*/
public class OrederController{
	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	private IOrderService orderService;

	@RequestMapping(value = "/placeOrder", method = RequestMethod.GET)
	public void placeOrder(@RequestParam String accId,
			@RequestParam double money){
		System.out.println("1111111111111111");
		OrderInfo order = new OrderInfo();
		order.setOrderId(1L);
		order.setAccId(accId);
		orderService.placeOrder(order, money);

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