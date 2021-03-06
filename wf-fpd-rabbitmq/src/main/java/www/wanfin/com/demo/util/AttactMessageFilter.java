package www.wanfin.com.demo.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import www.wanfin.com.demo.AmqpConfig;

public class AttactMessageFilter {
	
	private static final Logger logger = LoggerFactory.getLogger(AttactMessageFilter.class);

	private List<String> routingKeys;
	
	private static class AttactMessageFilterSingleton{
		private static final AttactMessageFilter instance=new AttactMessageFilter();
	}

	private AttactMessageFilter(){
		
	}
	
	public static AttactMessageFilter instance(){
		return AttactMessageFilterSingleton.instance;
	}
	
	public static void init(List<String> routingKeys){
		if(AttactMessageFilterSingleton.instance.routingKeys==null)
			AttactMessageFilterSingleton.instance.routingKeys=routingKeys;
	}
	
	public boolean isAttact(String routingKey){
		if(AttactMessageFilterSingleton.instance.routingKeys==null){
			logger.debug("没有初始化路右键集合！");
			return true;
		}
		
		return !AttactMessageFilterSingleton.instance.routingKeys.stream()
														 		.filter(key->{
														 			return (AmqpConfig.ROUNTING_KEY_PREFIX+"."+key).equals(routingKey);
														 		})
														 		.findFirst()
														 		.isPresent();
	}
	
}
