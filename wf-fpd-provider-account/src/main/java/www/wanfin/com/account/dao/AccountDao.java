package www.wanfin.com.account.dao;

import www.wanfin.com.account.entity.Account;


public interface AccountDao {

	int decreaseAmount(String acctId, double amount);

	int increaseAmount(String acctId, double amount);

	void insert(Account account);

}
