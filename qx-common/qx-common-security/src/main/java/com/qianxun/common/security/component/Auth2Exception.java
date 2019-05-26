package com.qianxun.common.security.component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.qianxun.common.core.constant.CommonConstants;
import com.qianxun.common.security.exception.QxOAuth2Exception;
import lombok.SneakyThrows;

/**
 * OAuth2 异常格式化
 */
public class Auth2Exception extends StdSerializer<QxOAuth2Exception> {
	public Auth2Exception() {
		super(QxOAuth2Exception.class);
	}

	@Override
	@SneakyThrows
	public void serialize(QxOAuth2Exception value, JsonGenerator gen, SerializerProvider provider) {
		gen.writeStartObject();
		gen.writeObjectField("code", CommonConstants.FAIL);
		gen.writeStringField("msg", value.getMessage());
		gen.writeStringField("data", value.getErrorCode());
		gen.writeEndObject();
	}
}
