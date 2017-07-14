package www.wanfin.com.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.wanfin.com.account.dao.AccountDao;



@Service("accountServiceCancel")
public class AccountServiceCancel /*implements IAccountService*/ {
	    @Autowired
	    private AccountDao accountDao;
	   /* @Transactional
		public int increaseAmount(String acctId, double amount) {//增加---入账
	    	System.out.println("cancel=======================increaseAmount");
			int value = accountRepository.decreaseAmount(acctId, amount);
			return value;
		}
		@Transactional
		public int decreaseAmount(String acctId, double amount) {//减少----出账
			System.out.println("cancel=======================decreaseAmount");
			int value = accountRepository.increaseAmount(acctId,amount);
			return value;
		}
*/
}
