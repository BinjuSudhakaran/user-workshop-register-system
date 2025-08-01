package com.example.workshopsystem.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.workshopsystem.filter.JWTAuthFilter;
import com.example.workshopsystem.service.CustomUserDetailService;
@Configuration
@EnableWebSecurity
public class SecurityConfig
{
	@Autowired
	private JWTAuthFilter jwtAuthFilter;
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf().disable()
	        
	        .authorizeRequests()
	        
	            .antMatchers("/api/auth/**").permitAll()
	            
	            .antMatchers("/api/admin/**").hasRole("ADMIN")
	            
	            .anyRequest().authenticated()
	            
	            .and()
	            
	            .exceptionHandling()
	            
	                .accessDeniedHandler((request, response, ex) -> {
	                	
	                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	                    
	                    response.setContentType("application/json");
	                    
	                    response.getWriter().write("You don’t have permission to access this resource");
	                })
	            
	            
	        .and()
	        
	        .sessionManagement()
	        
	            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	    http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

	    return http.build();
	}

	
	
	@Bean
    public UserDetailsService userDetailsService()
	{
        return new CustomUserDetailService();
    }
    @Bean
     public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
     }
    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService,
                                                       PasswordEncoder passwordEncoder)
    {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(daoAuthenticationProvider);
    }

}
