package www.wanfin.com.account.service;

public interface IAccountService {
	
	public int increaseAmount(String accountId, double amount);

	public int decreaseAmount(String accountId, double amount);
	
	public void insert(Long accId);
}
