package com.qianxun.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.qianxun.common.security.component.Auth2Exception;

@JsonSerialize(using = Auth2Exception.class)
public class InvalidException extends QxOAuth2Exception {

	public InvalidException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "invalid_exception";
	}

	@Override
	public int getHttpErrorCode() {
		return 426;
	}

}
