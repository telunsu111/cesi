package com.fictions.authentication.service;

import com.fictions.authentication.model.TokenModel;
//import org.apache.commons.codec.digest.DigestUtils;
//import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {
//	@Value("${ua.token.timeout}")
//	private int expiredSeconds;

	@Override
	public TokenModel create(Integer userId) {
		// TODO Auto-generated method stub
//		TokenModel model = new TokenModel();
//		model.setUserId(userId);
//		Date now = new Date();
//		model.setCreateTime(now);
//		model.setExpireTime(new Date(now.getTime() + expiredSeconds * 1000));
//		model.setToken(generateToken(userId));
//		MemCacheHelper.bulidCache("token_" + model.getToken(), model, new Date(1000*3600*60*24));
//		return model;
		return null;
	}
	
	@Override
	public String update(String token) {
		// TODO Auto-generated method stub
//		TokenModel model = getToken(token);
//		if(model != null){
//			return null;
//		}
//
//		Date now = new Date();
//		model.setCreateTime(now);
//		model.setExpireTime(new Date(now.getTime() + expiredSeconds * 1000));
//		MemCacheHelper.bulidCache("token_" + model.getToken(), model, new Date(1000*3600*60*24));
//		return model.getToken();
		return null;
	}

	@Override
	public TokenModel getToken(String token) {
		// TODO Auto-generated method stub
//		TokenModel model = new TokenModel();
//		if(MemCacheHelper.keyExists("token_" + token)){
//			model = (TokenModel) MemCacheHelper.getCache("token_" + token);
//		}
//		return model;
		return null;
	}
	
	@Override
	public void delete(String token){
//		if(MemCacheHelper.keyExists("token_" + token)){
//			MemCacheHelper.delete("token_" + token);
//		}
	}
	
	private String generateToken(int userId) {
//		String randomStr = RandomStringUtils.random(16);
//		String input = userId + randomStr + System.currentTimeMillis();
//		return DigestUtils.md5Hex(input).toUpperCase();
		return null;
	}


}
