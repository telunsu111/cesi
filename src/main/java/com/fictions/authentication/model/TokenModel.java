package com.fictions.authentication.model;

import java.io.Serializable;
import java.util.Date;

public class TokenModel implements Serializable {
	/* serialVersionUID: serialVersionUID */
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String token;
	private Date createTime;
	private Date expireTime;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	
}
