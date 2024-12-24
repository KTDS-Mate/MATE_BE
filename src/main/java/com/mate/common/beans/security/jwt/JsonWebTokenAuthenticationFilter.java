package com.mate.common.beans.security.jwt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mate.common.vo.ApiResponse;
import com.mate.user.vo.UserVO;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Security Filter 진행 중 JWT가 전달 되었을 경우 JWT 검증 & Security 인증
 */
@Component
public class JsonWebTokenAuthenticationFilter extends OncePerRequestFilter{

	private static final Logger log = LoggerFactory.getLogger(JsonWebTokenAuthenticationFilter.class);
	
	@Value("${app.security.permit-all-urls:[]}")
	private List<String> permitAllUrls;
	
	@Autowired
	private JsonWebTokenProvider jsonWebTokenProvider;

	public JsonWebTokenAuthenticationFilter(JsonWebTokenProvider jsonWebTokenProvider) {
        this.jsonWebTokenProvider = jsonWebTokenProvider;
    }
	
	private AntPathMatcher pathMatcher = new AntPathMatcher();
	
	@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String token = this.getJwtFromRequest(request);
            log.info("Received token: {}", token);

            if (StringUtils.hasText(token)) {
                try {
                    // 기존 JsonWebTokenProvider 사용
                    UserVO userVO = jsonWebTokenProvider.getUserFromJwt(token);
                    if (userVO != null) {
                        Authentication authentication = new UsernamePasswordAuthenticationToken(
                                userVO,
                                null,
                                Collections.emptyList()
                        );
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                        log.info("Set authentication successful for user: {}", userVO.getUsrLgnId());
                    }
                } catch (Exception e) {
                    log.error("Failed to process JWT token", e);
                }
            }
            
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            log.error("JWT Authentication failed", e);
            handleAuthenticationFailure(response, e);
        }
    }
	
	private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    private void handleAuthenticationFailure(HttpServletResponse response, Exception e) throws IOException {
        SecurityContextHolder.clearContext();
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("status", 401);
        errorResponse.put("statusMessage", "Unauthorized");
        errorResponse.put("errors", Arrays.asList("인증 토큰이 변조되었습니다. 다시 로그인해주세요."));
        errorResponse.put("errorsCount", 1);
        errorResponse.put("count", 0);
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), errorResponse);
    }
	
	private void sendErrorResponse(HttpServletResponse response, HttpStatus status, String message) throws IOException {
	    ApiResponse errorResponse = new ApiResponse(status);
	    errorResponse.setErrors(List.of(message));
	    
	    Gson gson = new Gson();
	    String errorJson = gson.toJson(errorResponse);
	    
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType(MediaType.APPLICATION_JSON.toString());
	    
	    PrintWriter out = response.getWriter();
	    out.write(errorJson);
	}
	

    private String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }
}
