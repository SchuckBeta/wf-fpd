package www.wanfin.com.user.service;

import www.wanfin.com.user.entity.OrderInfo;



public interface IOrderService {

	public void placeOrder(OrderInfo order, double money);
	
}
