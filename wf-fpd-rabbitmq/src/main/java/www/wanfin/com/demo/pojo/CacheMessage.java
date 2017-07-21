package www.wanfin.com.demo.pojo;

import www.wanfin.com.demo.util.CacheCorrelationData;

public class CacheMessage {

	private Object payload;
	private CacheCorrelationData cacheCorrelationData;
	
	public Object getPayload() {
		return payload;
	}
	public void setPayload(Object payload) {
		this.payload = payload;
	}
	public CacheCorrelationData getCacheCorrelationData() {
		return cacheCorrelationData;
	}
	public void setCacheCorrelationData(CacheCorrelationData cacheCorrelationData) {
		this.cacheCorrelationData = cacheCorrelationData;
	}
	
}
