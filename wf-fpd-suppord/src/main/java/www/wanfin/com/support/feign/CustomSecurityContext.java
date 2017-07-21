package www.wanfin.com.support.feign;

import www.wanfin.com.core.domain.ErrorResult;

import lombok.Data;

@Data
public class CustomSecurityContext {
	public ErrorResult errorResult;

	public static CustomSecurityContext getInterface() {
		CustomSecurityContext cmySecurityContext = new CustomSecurityContext();
		return cmySecurityContext;
	}

	public ErrorResult getErrorResult() {
		return errorResult;
	}

	public void setErrorResult(ErrorResult errorResult) {
		this.errorResult = errorResult;
	}

	
}