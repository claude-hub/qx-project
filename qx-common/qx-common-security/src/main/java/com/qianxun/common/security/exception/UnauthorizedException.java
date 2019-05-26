package com.qianxun.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.qianxun.common.security.component.Auth2Exception;
import org.springframework.http.HttpStatus;

@JsonSerialize(using = Auth2Exception.class)
public class UnauthorizedException extends QxOAuth2Exception {

	public UnauthorizedException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "unauthorized";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.UNAUTHORIZED.value();
	}

}
