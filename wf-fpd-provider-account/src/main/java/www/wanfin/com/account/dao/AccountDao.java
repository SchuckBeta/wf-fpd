package www.wanfin.com.account.dao;

import org.apache.ibatis.annotations.Param;

import www.wanfin.com.account.entity.Account;

public interface AccountDao {

	public Account get(@Param("id")String id);

} 
