package com.fictions.assist.interceptor;

import com.fictions.constant.CommonCons;
import com.fictions.user.model.UserModel;
import com.fictions.user.service.UserService;
import org.springframework.data.annotation.Reference;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TokenInterceptor implements HandlerInterceptor {

	@Reference
	private UserService userService;
//	@Reference
//	private TokenService tokenService;

	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response, Object handler) throws Exception {
		/*if (test) {
		setCurrUser(request, userService.getUser(1));//测试环境直接用userid=1的用户作为登录用户
		return true;
		}*/
//		if ("OPTIONS".equals(request.getMethod())) {//浏览器会发送options请求，临时处理方案
//			return true;
//		}
//		String token = request.getHeader("UA_AUTHORIZATION");
//		if (StringUtils.isBlank(token)) {
//			// 401:2001 缺少Authorization头部
//			print(request, response, HttpCode.AUTHORIZATION_REQUIRED, "缺少访问token");
//			return false;
//		}
//
//		TokenModel tokenModel = tokenService.getToken(token);
//		if (tokenModel == null) {
//			// 401:2101 头部格式不正确
//			print(request, response, HttpCode.AUTHORIZATION_INVALID, "无效的token");
//			return false;
//		}
//
//		long now = System.currentTimeMillis();
//		if (tokenModel.getExpireTime().getTime() < now) {
//			// 401:2201 token过期
//			print(request, response, HttpCode.AUTHORIZATION_EXPIRED, "token已过期");
//			return false;
//		}
//
//		UserModel user = userService.findByUserid(tokenModel.getUserId());
//		if (user == null) {
//			// 401:2101 头部格式不正确
//			print(request, response, HttpCode.AUTHORIZATION_INVALID, "无效的token");
//			return false;
//		}
//
//		setCurrUser(request, user);
//		return true;
		return true;
	}

	private void setCurrUser(HttpServletRequest request, UserModel user) {
//		request.setAttribute(LMSConstants.USER_KEY, user);
//		request.setAttribute(LMSConstants.USERID_KEY, user.getUserid());
//		request.setAttribute(LMSConstants.USER_ORGID_KEY, user.getCatalogid());
//		request.setAttribute(LMSConstants.USERNAME_KEY, user.getName());
	}

	private void print(HttpServletRequest request, HttpServletResponse response, int code, String message) throws IOException {
		request.setAttribute(CommonCons.RA_HTTP_CODE, code);
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, message);
	}

	@Override
	public void postHandle(HttpServletRequest request,
						   HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
								HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
