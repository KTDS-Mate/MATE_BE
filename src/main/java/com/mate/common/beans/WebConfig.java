package com.mate.common.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

	@Bean
	Sha createShaInstance() {
		Sha sha = new Sha();
		return sha;
	}
	
	@Value("${app.multipart.base-dir}")
	private String baseDir;
	
	/**
    *  JSP View Resolver 설정
    */
   @Override
   public void configureViewResolvers(ViewResolverRegistry registry) {
      registry.jsp("/WEB-INF/views/",".jsp");
   }
   
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/css/**") // http://localhost:8080/css/common/common.css
            .addResourceLocations("classpath:static/css/");
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
}
