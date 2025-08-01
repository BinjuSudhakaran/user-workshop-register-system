package com.example.workshopsystem.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.workshopsystem.model.User;
import com.example.workshopsystem.service.CustomUserDetailService;
import com.example.workshopsystem.util.JWTUtil;


@Component
public class JWTAuthFilter extends OncePerRequestFilter
{
	@Autowired
	JWTUtil jwtUtil;
	
	@Autowired
	CustomUserDetailService customUserDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException 
	{
		
		String token=null;
		Long userId=null;
		String authHeader=request.getHeader("Authorization");
		if(authHeader!=null && authHeader.startsWith("Bearer"))
		{
			token=authHeader.substring(7);
			userId=jwtUtil.extractUserId(token);
		}
		
		if(userId!=null && SecurityContextHolder.getContext().getAuthentication()==null )
		{
			User user=(User) customUserDetailService.loadUserById(userId);
			if(jwtUtil.validateToken(userId,user,token))
			{
				UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	            SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		
		filterChain.doFilter(request,response);
		
			
	}

}