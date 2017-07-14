package www.wanfin.com.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import www.wanfin.com.account.dao.AccountDao;



@Service("accountServiceConfirm")
public class AccountServiceConfirm /*implements IAccountService*/ {
	  @Autowired
	  private AccountDao accountDao;
	 
	  @Autowired
	  private JdbcTemplate jdbcTemplate;
		
	/*  @Transactional
		public int increaseAmount(String acctId, double amount) {//增加---入账
		    System.out.println("confirm=======================increaseAmount");
			int value = accountRepository.increaseAmount(acctId, amount);
			return value;
		}
		@Transactional
		public int decreaseAmount(String acctId, double amount) {//减少----出账
			int value = this.jdbcTemplate.update(
					"update Account set amount = amount - ? where acct_id = ?", amount, acctId);
			if (value != 1) {
				throw new IllegalStateException("ERROR!");
			}
			System.out.printf("exec decrease: acct= %s, amount= %7.2f%n", acctId, amount);
			return value;
			System.out.println("confirm=======================decreaseAmount");
			int value = accountRepository.decreaseAmount(acctId,amount);
			return value;
		}
*/
}
