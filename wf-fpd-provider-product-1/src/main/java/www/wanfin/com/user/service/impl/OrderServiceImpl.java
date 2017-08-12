package www.wanfin.com.user.service.impl;

import java.util.Random;

import org.hibernate.service.spi.ServiceException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;

import www.wanfin.com.demo.AmqpConfig;
import www.wanfin.com.demo.annotation.MessageCache;
import www.wanfin.com.demo.util.CacheCorrelationData;
import www.wanfin.com.feign.service.IAccountService;
import www.wanfin.com.user.entity.OrderInfo;
import www.wanfin.com.user.entity.User;
import www.wanfin.com.user.repository.OrderRepository;
import www.wanfin.com.user.repository.UserRepository;
import www.wanfin.com.user.service.IOrderService;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {
    @Autowired 
    OrderRepository orderRepository;
    @Autowired
	private IAccountService acctService;
    @Autowired 
    UserRepository userRepository;
    @Autowired
	private JdbcTemplate jdbcTemplate;

    
	private String orderSaveKey=AmqpConfig.ROUNTING_KEY_PREFIX+"."+AmqpConfig.ORDER_SAVE_ROUTING_KEY;
	
	private String testExchange="";
	
	@Value("${rabbitmq.exchange}")
	private String orderExchange;

	@Autowired
	private RabbitTemplate rabbitTemplate;
    
    
    
	@Override
	//@Transactional(rollbackFor = Exception.class)
	@Transactional(rollbackFor = ServiceException.class)
	public void placeOrder(OrderInfo order, double money) throws ServiceException{
			int value=acctService.decreaseAmount(order.getAccId(), money);
			User user=new User();
			long rangeLong = 1 + (((long) (new Random().nextDouble() * (100000 - 1))));
			user.setId(rangeLong);
			user.setUsername("yyyyy");
			userRepository.save(user);
			orderRepository.insert(order.getOrderId(), order.getAccId());
			if(value==1){
				throw new ServiceException("ERROR!");
			}
    	
	}


	//@MessageCache为自定义注释，用来设置缓存和原交换机、路由键等相关信息
		//@MessageCache(cacheName="order",cacheKey="${arg.correlationId}",messageArgMapper="order",exchange="${field.testExchange}",routingKey="${field.orderSaveKey}")
		@MessageCache(cacheName="order",cacheKey="${arg.correlationId}",messageArgMapper="order",exchange="${field.testExchange}",routingKey="${field.orderSaveKey}")
		public void sendOrderMessage(String correlationId,Object order) throws Exception{
			//扩展CorrelationData，使其包含缓存信息，方便确认机制返回失败后重发
			CacheCorrelationData correlation = new CacheCorrelationData(correlationId,"order");
			Message msg=new Message(JSONObject.toJSONString(order).getBytes(),MessagePropertiesBuilder.newInstance().setContentType("text/x-json").build());//.setExpiration("10000").build());
			rabbitTemplate.send(orderExchange, orderSaveKey, msg, correlation);
		}


		
		
	
}
