package com.mate.common.beans.security.jwt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.gson.Gson;
import com.mate.common.vo.ApiResponse;
import com.mate.user.vo.UserVO;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Security Filter 진행 중 JWT가 전달 되었을 경우 JWT 검증 & Security 인증
 */
@Component
public class JsonWebTokenAuthenticationFilter extends OncePerRequestFilter{

	@Value("${app.security.permit-all-urls:[]}")
	private List<String> permitAllUrls;
	
	@Autowired
	private JsonWebTokenProvider jsonWebTokenProvider;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	        throws ServletException, IOException {

	    String url = request.getServletPath();
	    
	    if (url.startsWith("/api/")) {
	        boolean isPermitAllUrl = this.permitAllUrls.contains(url);
	        String jwt = request.getHeader("Authorization");
	        
	        if (!isPermitAllUrl && (jwt == null || jwt.trim().length() == 0)) {
	            response.sendError(HttpStatus.FORBIDDEN.value());
	            return;
	        }
	        
	        UserVO userVO = null;
	        
	        try {
	            userVO = jsonWebTokenProvider.getUserFromJwt(jwt);
	        } catch (ExpiredJwtException eje) {
	            sendErrorResponse(response, HttpStatus.UNAUTHORIZED, "인증 토큰이 만료되었습니다. 다시 시도해 주세요.");
	            return;
	        } catch (MalformedJwtException | SignatureException mje) {
	            sendErrorResponse(response, HttpStatus.UNAUTHORIZED, "인증 토큰이 변조되었습니다. 다시 로그인해주세요.");
	            return;
	        }
	        
//	        if (userVO != null) {
//                // SecurityContext에 인증 정보 설정
//                List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER")); // 역할에 따라 수정
//                UsernamePasswordAuthenticationToken authToken =
//                    new UsernamePasswordAuthenticationToken(userVO, null, authorities);
//                SecurityContextHolder.getContext().setAuthentication(authToken);
//            }
	    }
	    
	    // 토큰 검증을 하지 않는 경우에도 filterChain 진행이 필요
	    filterChain.doFilter(request, response);
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
}
