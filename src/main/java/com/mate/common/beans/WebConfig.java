package com.mate.common.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mate.access.dao.AccessLogDao;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Value("${app.multipart.base-dir}")
	private String baseDir;

	@Autowired
	private AccessLogDao accessLogDao; // accessLogDao를 인젝션 받는다.
	
	// addInterceptor의 url 리스트를 application.yml로 옮기면서 추가.직접적인 경로설정 사항은 뺸다.
	// pathpattern 적용 : application.yml @value들이 ,로 구분되어 있으면 List로 가져온다.
	@Value("${app.interceptors.add-access-log.path-patterns}")
	private List<String> addAcessLogPathPatterns;
	@Value("${app.interceptors.add-access-log.exclude-path-patterns}")
	private List<String> addAcessLogExcludePathPatterns;
	
	@Bean
	Sha createShaInstance() {
		Sha sha = new Sha();
		return sha;
	}

	/**
	 * JSP View Resolver 설정
	 */
//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		registry.jsp("/WEB-INF/views/", ".jsp");
//	}

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*")
            .allowCredentials(true);
    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**") // http://localhost:8080/css/common/common.css
				.addResourceLocations("classpath:/static/css/");
		registry.addResourceHandler("/js/**") // http://localhost:8080/hs/jquery/jquery-3.1.7.min.js
				.addResourceLocations("classpath:/static/js/");
		registry.addResourceHandler("/img/**")
				.addResourceLocations("classpath:/static/img/");
		registry.addResourceHandler("/public/**")
        		.addResourceLocations("classpath:/static/public/");
		registry.addResourceHandler("/uploads/**")
				.addResourceLocations("file:" + baseDir + "/");
		registry.addResourceHandler("/mypage/edit-profile/gd-profile/img/**")
				.addResourceLocations("file:/usr/local/src/tomcat/apache-tomcat-10.1.31/uploadfiles/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// third interceptor (this.accessLogDao -> bean을 주는 것 : 생성자 주입) -> 마지막에 호출.
		registry.addInterceptor(new AddAccessLogHistoryInterceptor(this.accessLogDao))
				.addPathPatterns(this.addAcessLogPathPatterns)
				.excludePathPatterns(this.addAcessLogExcludePathPatterns) // 패키지가 없으니 로그를 남기지 않음.
				.excludePathPatterns("/css/**", "/js/**", "/img/**", "/public/**");
	}

}
