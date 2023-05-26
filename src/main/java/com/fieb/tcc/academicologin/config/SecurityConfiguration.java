package com.fieb.tcc.academicologin.config;

import static org.springframework.http.HttpMethod.GET;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fieb.tcc.academicologin.filter.CustomAuthenticationFilter;
import com.fieb.tcc.academicologin.filter.CustomAuthorizationFilter;
import com.fieb.tcc.academicologin.service.UserService;
import static org.springframework.http.HttpMethod.POST;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//### API ####
		
		 CustomAuthenticationFilter customAuthenticationFilter = 
				 new CustomAuthenticationFilter(authenticationManager(), userService);
		 customAuthenticationFilter.setFilterProcessesUrl("/api/v1/login");
	   
		 //### FIM ###	
		
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/registration**", "/registration/**",/*"/api/**"*/ "/js/**", "/css/**", "/img/**")
				.permitAll().and().authorizeRequests()
				.antMatchers(GET, "/users/**").hasAnyAuthority("ROLE_USER")
				.antMatchers(GET, "/api/v1/instrutor/courses**").hasAnyAuthority("ROLE_INSTRUCTOR")
				.antMatchers(POST, "/api/v1/instrutor/courses**").hasAnyAuthority("ROLE_INSTRUCTOR")				
				.anyRequest().authenticated().and().formLogin().defaultSuccessUrl("/users/home", true)
				.loginPage("/login").permitAll().and().logout().invalidateHttpSession(true).clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
				.permitAll();
		
		//### API ###
		
		http.addFilter(customAuthenticationFilter);
		http.addFilterBefore( new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		
		//### FIM ###
		
	}
	
	//### API ###
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	//### FIM ###

}