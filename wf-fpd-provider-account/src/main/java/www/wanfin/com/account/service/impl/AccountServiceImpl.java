package www.wanfin.com.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import www.wanfin.com.account.dao.AccountDao;
import www.wanfin.com.account.entity.Account;
import www.wanfin.com.account.service.IAccountService;

/**
 * @Compensable注解最好放在service层处理，放在controller层可能有问题(例如：confirm两次)
 * @author lzj
 *
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService{
	  @Autowired
	  private AccountDao accountDao;
	    @Transactional(rollbackFor = Exception.class)
		public int increaseAmount(String acctId, double amount) {//增加---入账
	    	int value=0;
	    	try {
	    		 value = accountDao.increaseAmount(acctId, amount);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return value;
		}
	    @Transactional(rollbackFor = Exception.class)
		public int decreaseAmount(String acctId, double amount) {//减少----出账
			int value=0;
	    	try {
	    		value = accountDao.decreaseAmount(acctId,amount);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return value;
		}
		@Override
		public void insert(Long accId) {
			Account account=new Account();
			account.setAcctId(accId);
		    accountDao.insert(account);;
		}

}
