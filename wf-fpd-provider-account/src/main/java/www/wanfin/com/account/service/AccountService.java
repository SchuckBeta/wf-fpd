package www.wanfin.com.account.service;

import org.springframework.stereotype.Service;

import www.wanfin.com.account.entity.Account;

@Service("accountService")
public interface AccountService {

	Account get(String id);

}
