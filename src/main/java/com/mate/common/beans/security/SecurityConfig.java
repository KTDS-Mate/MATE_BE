package com.mate.common.beans.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import com.mate.common.beans.security.jwt.JsonWebTokenAuthenticationFilter;
import com.mate.common.beans.security.oauth.SecurityOAuthService;
import com.mate.user.dao.UserDao;


@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {

	@Autowired
	private UserDao userDao;

	@Autowired
	private JsonWebTokenAuthenticationFilter jsonWebTokenAuthenticationFilter;

	@Autowired
	private SecurityOAuthService securityOAuthService;

	// 1. SecurityUserDetailService를 Bean으로 등록
	@Bean
	UserDetailsService securityUserDetailsService() {
		return new SecurityUserDetailsService(this.userDao);
	}

	// 2. SecurityPasswordEncoder를 Bean으로 등록
	@Bean
	@Scope("prototype")
	PasswordEncoder securityPasswordEncoder() {
		return new SecurityPasswordEncoder();
	}

	// 3. SecurityAuthenticationProvider를 Bean으로 등록 -> 인증 절차 변경
	@Bean
	AuthenticationProvider securityAuthenticationProvider() {
		return new SecurityAuthenticationProvider(this.securityUserDetailsService(), this.securityPasswordEncoder());
	}

	@Bean
	AuthenticationFailureHandler loginFailureHandler() {
		return new LoginFailureHandler(this.userDao);
	}

	@Bean
	AuthenticationSuccessHandler loginSuccessHandler() {
		return new LoginSuccessHandler(this.userDao);
	}

	/**
	 * Security가 개입하지 않을 경로 설정
	 */
	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring()
				.requestMatchers("/WEB-INF/views/**")
				.requestMatchers("/js/**")
				.requestMatchers("/css/**")
				.requestMatchers("/favicon.ico")
				.requestMatchers("/public/**")
				.requestMatchers("/img/**");
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors(cors -> {
			CorsConfigurationSource source = request -> {
				CorsConfiguration corsConfiguration = new CorsConfiguration();
				
				// 허용할 도메인 목록
				corsConfiguration.setAllowedOrigins(List.of("http://localhost:3000"));
				// 허용할 메서드 목록 (외부에서 요청)
				corsConfiguration.setAllowedMethods(List.of("POST", "PUT", "DELETE", "GET", "OPTIONS"));
				corsConfiguration.setAllowedHeaders(List.of("*"));
				corsConfiguration.setAllowCredentials(true);
				return corsConfiguration;
			};
			cors.configurationSource(source);
		});
		
		http.oauth2Login(oauth -> oauth.loginPage("/user/login")
									   .userInfoEndpoint(endpoint -> endpoint.userService(this.securityOAuthService))
									   .defaultSuccessUrl("/usertour/list", true)
									   .defaultSuccessUrl("/guidetour/list", true)
									   .defaultSuccessUrl("/"));
		// 기본 filter 동작시키고 jsonWebTokenAuthenticationFilter 동작
		http.addFilterAfter(this.jsonWebTokenAuthenticationFilter, BasicAuthenticationFilter.class);

		// Role에 따른 접근권한 설정
		http.authorizeHttpRequests(httpRequest -> httpRequest

				.requestMatchers("/api/user/login").permitAll()
				.requestMatchers("/user/login").permitAll()
				.requestMatchers("/token").permitAll()
				.requestMatchers("/guidetour/list").permitAll()
				.requestMatchers("/guidetour/view**").permitAll()
				.requestMatchers("/api/v1/guidetour/list").permitAll()
				.requestMatchers("/api/v1/guidetour/info/**").permitAll()
				.requestMatchers("/api/v1/guidetour/imgs/**").permitAll()
				.requestMatchers("/").permitAll()
				.requestMatchers("/user/regist").permitAll()
				.requestMatchers("/usertour/list").permitAll()
				.requestMatchers("/usertour/view**").permitAll()
				.requestMatchers("/api/v1/usertour/list").permitAll()
				.requestMatchers("/api/v1/usertour/count").permitAll()
				.requestMatchers("/api/v1/usertour/view/**").permitAll()
				.requestMatchers("/api/v1/usertour/imgs/**").permitAll()
				.requestMatchers("/api/user/regist/**").permitAll()
				.requestMatchers(HttpMethod.POST, "/api/user/regist/**").permitAll()
		        .requestMatchers(HttpMethod.POST, "/api/user/send-auth-mail").permitAll()
		        .requestMatchers(HttpMethod.POST, "/api/user/verify-auth-code").permitAll()
				.requestMatchers("/api/v1/usertour/insert").permitAll()
				.requestMatchers("/api/v1/request/insert").permitAll()
				.requestMatchers("/api/v1/request/apply/insert").permitAll()
				.requestMatchers("/api/v1/favorite/**").permitAll()
				.requestMatchers("/api/v1/favorite/create").permitAll()
				.requestMatchers("/api/v1/favorite/delete/**").permitAll()
				.requestMatchers("/api/v1/tour/regions").permitAll()
				.requestMatchers("/api/v1/tour/countries/**").permitAll()
				.requestMatchers("/api/v1/tour/cities/**").permitAll()
		        .requestMatchers("/api/v1/guidetour/random").permitAll()
		        .requestMatchers("/api/v1/tour/**").permitAll()
				.anyRequest().authenticated());


		// form을 이용한 로그인 페이지의 인증 정책 설정
		http.formLogin(formLogin -> formLogin
				.loginPage("/user/login")
				.usernameParameter("usrLgnId")
				.passwordParameter("password")
				.loginProcessingUrl("/user/security/login")
				.failureHandler(new SimpleUrlAuthenticationFailureHandler("/user/login?error"))
				.successHandler(this.loginSuccessHandler()));

		// csrf 활성화 및 예외 설정
		http.csrf(csrf -> csrf.ignoringRequestMatchers("/token", "/api/**"));

		return http.build();
	}
}
