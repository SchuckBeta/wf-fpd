package www.wanfin.com.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import www.wanfin.com.feign.utils.FeginConfig;

@FeignClient(value = "wf-fpd-provider-account",configuration = FeginConfig.class)
public interface IAccountService {

	@RequestMapping(method = RequestMethod.POST, value = "/increase")
	public int increaseAmount(@RequestParam("acctId") String accountId, @RequestParam("amount") double amount);

	@RequestMapping(method = RequestMethod.POST, value = "/decrease")
	public int decreaseAmount(@RequestParam("acctId") String accountId, @RequestParam("amount") double amount);

}
