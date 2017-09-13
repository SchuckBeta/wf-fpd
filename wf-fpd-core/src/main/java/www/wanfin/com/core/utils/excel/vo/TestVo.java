package www.wanfin.com.core.utils.excel.vo;

import www.wanfin.com.core.utils.excel.annotation.ExcelField;

public class TestVo{

	@ExcelField(title="客户id", align=2, sort=1)
	private String customerId;		// 客户id
	
	@ExcelField(title="客户姓名", align=2, sort=2)
	private String customerName;		// 客户姓名

	
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
	
	
}
