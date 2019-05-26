package com.qianxun.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.qianxun.common.security.component.Auth2Exception;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * 自定义OAuth2Exception
 */
@JsonSerialize(using = Auth2Exception.class)
public class QxOAuth2Exception extends OAuth2Exception {
	@Getter
	private String errorCode;

	public QxOAuth2Exception(String msg) {
		super(msg);
	}

	public QxOAuth2Exception(String msg, String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}
}
