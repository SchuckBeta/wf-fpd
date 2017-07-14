package www.wanfin.com.user.service.impl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import www.wanfin.com.user.entity.OrderInfo;
import www.wanfin.com.user.repository.OrderRepository;
import www.wanfin.com.user.service.IOrderService;
@Service("orderServiceCancel")

public class OrderServiceCancel implements IOrderService {
    @Autowired 
    OrderRepository orderRepository;

	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public void placeOrder(OrderInfo order, double money) throws ServiceException {
		//long min = 1;
		//long max = 100000;
		//long rangeLong = min + (((long) (new Random().nextDouble() * (max - min))));
		//order.setOrderId(1L);
		System.out.println("1111111111111111111111");
		orderRepository.update(order.getOrderId(),"0");
	}
	
	


}
