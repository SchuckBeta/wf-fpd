package www.wanfin.com.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import www.wanfin.com.account.dao.AccountDao;
import www.wanfin.com.account.entity.Account;
import www.wanfin.com.account.service.AccountService;

public class AccountServiceImpl implements AccountService{
    @Autowired AccountDao accountDao;

	@Override
	public Account get(String id) {
		return accountDao.get(id);
	}
}
