package com.mate.common.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Value("${app.multipart.base-dir}")
	private String baseDir;

	@Value("${app.interceptors.check-session.path-patterns}")
	private List<String> checkSessionPathPatterns;
	@Value("${app.interceptors.check-session.exclude-path-patterns}")
	private List<String> checkSessionExcludePathPatterns;
	@Value("${app.interceptors.check-dup-login.path-patterns}")
	private List<String> checkDupLoginPathPatterns;
	@Value("${app.interceptors.check-dup-login.exclude-path-patterns}")
	private List<String> checkDupLoginExcludePathPatterns;
	@Value("${app.interceptors.add-access-log.path-patterns}")
	private List<String> addAccessLogPathPatterns;
	@Value("${app.interceptors.add-access-log.exclude-path-patterns}")
	private List<String> addAccessLogExcludePathPatterns;

	@Bean
	Sha createShaInstance() {
		Sha sha = new Sha();
		return sha;
	}

	/**
	 * JSP View Resolver 설정
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**") // http://localhost:8080/css/common/common.css
				.addResourceLocations("classpath:static/css/");
		registry.addResourceHandler("/js/**") // http://localhost:8080/hs/jquery/jquery-3.1.7.min.js
				.addResourceLocations("classpath:/static/js/");
		registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
		registry.addResourceHandler("/public/**").addResourceLocations("classpath:/static/public/");
		registry.addResourceHandler("/uploads/**").addResourceLocations("file:" + baseDir + "/");
		registry.addResourceHandler("/mypage/edit-profile/gd-profile/img/**")
				.addResourceLocations("file:/usr/local/src/tomcat/apache-tomcat-10.1.31/uploadfiles/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// First Interceptor
		registry.addInterceptor(new CheckSessionInterceptor())
				.addPathPatterns(this.checkSessionPathPatterns)
				.excludePathPatterns(this.checkSessionExcludePathPatterns);
				
//				// Second Interceptor
//				registry.addInterceptor( new CheckDuplicateLoginInterceptor() )
//				.addPathPatterns(this.checkDupLoginPathPatterns)
//				.excludePathPatterns(this.checkDupLoginExcludePathPatterns);
//				
//				// Third Interceptor
//				registry.addInterceptor( new AddAccessLogHistoryInterceptor(this.accessLogDao))
//				.addPathPatterns(this.addAccessLogPathPatterns)
//				.excludePathPatterns(this.addAccessLogExcludePathPatterns);
	}

}
