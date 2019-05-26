package com.qianxun.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.qianxun.common.security.component.Auth2Exception;
import org.springframework.http.HttpStatus;

@JsonSerialize(using = Auth2Exception.class)
public class MethodNotAllowed extends QxOAuth2Exception {

	public MethodNotAllowed(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "method_not_allowed";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.METHOD_NOT_ALLOWED.value();
	}

}
