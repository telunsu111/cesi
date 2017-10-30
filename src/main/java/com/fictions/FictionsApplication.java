package com.fictions;

import com.fictions.assist.interceptor.TokenInterceptor;
import com.fictions.constant.CommonCons;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.*;
import java.util.EnumSet;
import java.util.Map;

@SpringBootApplication
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan(basePackages = "com.fictions")
public class FictionsApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FictionsApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(FictionsApplication.class);
	}

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {

		super.onStartup(servletContext);

//	addDruidStat(servletContext);
//	addDruidWebStatFilter(servletContext);
	}

	/**
	 * 方法描述：添加druid SQL监控
	 *
	 * @param:
	 * @return:
	 * @author: Huyihui
	 * @version: 2016-6-13 下午05:01:46
	 */
	@SuppressWarnings("unused")
	private void addDruidStat(ServletContext servletContext) {
		ServletRegistration.Dynamic sd = servletContext.addServlet("druidStat",
				com.alibaba.druid.support.http.StatViewServlet.class);
		sd.setInitParameter("loginUsername", "wenhua");
		sd.setInitParameter("loginPassword", "ulearning");
		sd.addMapping("/druid/*");
	}

	/**
	 * 方法描述：添加druid Web监控
	 *
	 * @param:
	 * @return:
	 * @author: Huyihui
	 * @version: 2016-6-13 下午05:02:28
	 */
	@SuppressWarnings("unused")
	private void addDruidWebStatFilter(ServletContext servletContext) {
		FilterRegistration.Dynamic fd = servletContext.addFilter(
				"druidWebStatFilter",
				com.alibaba.druid.support.http.WebStatFilter.class);
		fd.setInitParameter("exclusions",
				"*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		fd.setInitParameter("sessionStatEnable", "false");
		fd.setInitParameter("profileEnable", "true");
		EnumSet<DispatcherType> dispatcherTypes = EnumSet
				.of(DispatcherType.REQUEST);
		fd.addMappingForUrlPatterns(dispatcherTypes, false, "/*");
	}

	@Bean
	public ErrorAttributes errorAttributes() {
		return new DefaultErrorAttributes() {
			@Override
			public Map<String, Object> getErrorAttributes(
					RequestAttributes requestAttributes,
					boolean includeStackTrace) {
				Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
				Number code = (Number) requestAttributes.getAttribute(CommonCons.RA_HTTP_CODE, RequestAttributes.SCOPE_REQUEST);
				if (code != null) {
					map.put("code", code);
				}
				return map;
			}
		};
	}

	@Bean
	public WebMvcConfigurer mvcConfig(TokenInterceptor tokenInterceptor) {
		return new WebMvcConfig(tokenInterceptor);
	}

	private static class WebMvcConfig extends WebMvcConfigurerAdapter {
		private TokenInterceptor tokenInterceptor;

		private WebMvcConfig(TokenInterceptor tokenInterceptor) {
			this.tokenInterceptor = tokenInterceptor;
		}

		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			InterceptorRegistration ir = registry.addInterceptor(tokenInterceptor);
			ir.addPathPatterns("/**")
					.excludePathPatterns(//不需要token校验的接口
							"/sms/register/**",
							"/register/**",
							"/webthumb/**",
							"/checkurl",
							"/login"
					);
		}


		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
					.allowedHeaders("*")
					.allowedMethods("*")
					.allowedOrigins("*")
					.maxAge(31536000);//一年
		}

	}
}
