package com.fictions.constant;

public interface CommonCons {

	/**
	 * 分页时默认每页容量
	 */
	int PAGE_SIZE_DEFAULT = 10;
	
	/**
	 * 从Request的属性(Attribute)中取用户id时的name。请求的属性缩写为RA（Request Attribute）
	 * 例如：{@code int userId = request.getAttribute(CommonCons.RA_USER_ID);}
	 */
	String RA_USER_ID = "userId";
	
	/**
	 * 从Request的属性(Attribute)中取用户时 的name。请求的属性缩写为RA（Request Attribute）
	 * 例如：{@code UserModel user = request.getAttribute(CommonCons.RA_USER);}
	 */
	String RA_USER = "user";
	
	/**
	 * 从Request的属性(Attribute)中取错误代码时 的name。请求的属性缩写为RA（Request Attribute）
	 * 例如：{@code int code = request.getAttribute(CommonCons.RA_HTTP_CODE);}
	 */
	String RA_HTTP_CODE = "leiclass_http_code";
	
	String STU_STUDYING_KEY = "stu_studying_";//指向学生当前页面id和页面打开时间的memcached的key的前缀
}
