package com.mate.common.beans.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.firewall.StrictHttpFirewall;
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
	// StrictHttpFirewall 설정
	    StrictHttpFirewall firewall = new StrictHttpFirewall();
	    firewall.setAllowSemicolon(true);
	    firewall.setAllowBackSlash(true);
	    firewall.setAllowUrlEncodedPercent(true);
	    http.setSharedObject(StrictHttpFirewall.class, firewall);

	    http
	        // CORS 설정
	        .cors(cors -> cors.configurationSource(request -> {
	            CorsConfiguration corsConfiguration = new CorsConfiguration();
	            corsConfiguration.setAllowedOrigins(List.of("http://localhost:3000"));
	            corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
	            corsConfiguration.setAllowedHeaders(List.of("*"));
	            corsConfiguration.setExposedHeaders(List.of("Authorization"));
	            corsConfiguration.setAllowCredentials(true);
	            return corsConfiguration;
	        }))
	        // URL 기반 보안 설정
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers(
	                "/api/v1/s3/**"  // S3 관련 엔드포인트는 인증 필요
	            ).authenticated()
	            .requestMatchers(
	                "/api/user/login",
	                "/api/user/regist/**",
	                "/api/user/send-auth-mail",
	                "/api/user/verify-auth-code",
	                "/api/user/getAllCountries",
	                "/api/user/countries",
	                "/api/user/getCities/**",
	                "/api/user/reissue-password",
	                "/api/user/find-id",
	                "/api/v1/guidetour/**",
	                "/api/v1/usertour/**",
	                "/api/v1/tour/**",
	                "/api/v1/payment/**",
	                "/api/v1/notice/**",
	                "/ws/**"
	            ).permitAll()
	            .anyRequest().authenticated()
	        )
	        // CSRF 설정
	        .csrf(csrf -> csrf
	            .ignoringRequestMatchers(
	                "/api/**"
	            )
	            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
	        )
	        // JWT 필터 추가
	        .addFilterAfter(jsonWebTokenAuthenticationFilter, BasicAuthenticationFilter.class);

	    return http.build();
   }
   
   @Bean
   public CorsConfigurationSource corsConfigurationSource() {
	   CorsConfiguration configuration = new CorsConfiguration();
       configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
       configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
       configuration.setAllowedHeaders(Arrays.asList(
           "Authorization",
           "Content-Type",
           "Access-Control-Allow-Origin",
           "Access-Control-Allow-Credentials"
       ));
       configuration.setExposedHeaders(Arrays.asList("*"));
       configuration.setMaxAge(3600L);
       configuration.setAllowCredentials(true);

       UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
       source.registerCorsConfiguration("/**", configuration);
       return source;
   }

   @Bean 
   public StrictHttpFirewall httpFirewall() {
       StrictHttpFirewall firewall = new StrictHttpFirewall();
       firewall.setAllowSemicolon(true);
       firewall.setAllowBackSlash(true);
       firewall.setAllowUrlEncodedPercent(true);
       return firewall;
   }
}