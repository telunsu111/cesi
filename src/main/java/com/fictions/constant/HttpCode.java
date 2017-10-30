package com.fictions.constant;

public interface HttpCode {

	/**
	 * 缺少token
	 */
	int AUTHORIZATION_REQUIRED = 2001;
	/**
	 * token无效
	 */
	int AUTHORIZATION_INVALID = 2101;
	/**
	 * token过期
	 */
	int AUTHORIZATION_EXPIRED = 2201;
	
}
