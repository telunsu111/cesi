package com.fictions.authentication.service;


import com.fictions.authentication.model.TokenModel;

public interface TokenService {
	TokenModel create(Integer userId);
	
	TokenModel getToken(String token);
	
	
	String update(String token);
	
	void delete(String token);

}
