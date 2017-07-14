package www.wanfin.com.user.service.impl;

import java.util.Random;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import www.wanfin.com.feign.service.IAccountService;
import www.wanfin.com.user.entity.OrderInfo;
import www.wanfin.com.user.entity.User;
import www.wanfin.com.user.repository.OrderRepository;
import www.wanfin.com.user.repository.UserRepository;
import www.wanfin.com.user.service.IOrderService;

@Service("orderService")
//@Compensable(interfaceClass = IOrderService.class, confirmableKey = "orderServiceConfirm",cancellableKey = "orderServiceCancel")
public class OrderServiceImpl implements IOrderService {
    @Autowired 
    OrderRepository orderRepository;
    @Autowired
	private IAccountService acctService;
    @Autowired 
    UserRepository userRepository;
    @Autowired
	private JdbcTemplate jdbcTemplate;

    
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
	
}
