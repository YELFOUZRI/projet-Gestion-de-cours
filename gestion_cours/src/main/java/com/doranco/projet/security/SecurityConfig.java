package com.doranco.projet.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private DataSource ds;
	
		
	@Bean
	UserDetailsService jdbcUserDetailsService() {
	    String usersByUsernameQuery = "select email as principal, password as credentials, activ from users where email = ?";
	    String authsByUserQuery = "select email as principal, type as role from users where email = ?";
	    
//	    String usersByUsernameQuery = "select email as principal, password as credentials, 'true' as enabled from users where email = ?";
//	    String authsByUserQuery = "select email as principal, type as role, true from users where email = ?";
	      
	    JdbcUserDetailsManager users = new JdbcUserDetailsManager();

	    users.setUsersByUsernameQuery(usersByUsernameQuery);
	    users.setAuthoritiesByUsernameQuery(authsByUserQuery);
	    users.setDataSource(ds);

	    return users;
	}
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	    auth.userDetailsService(jdbcUserDetailsService())
//	        .passwordEncoder(passwordEncoder());
//	}
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	    auth.userDetailsService(jdbcUserDetailsService())
//	        .passwordEncoder(NoOpPasswordEncoder.getInstance());
//	}
	

	
//	@Bean
//	InMemoryUserDetailsManager userDetailsService() {
//		
//		PasswordEncoder passwordEncoder = passwordEncoder();
//
//		
//		String crypt = passwordEncoder.encode("1234");
//		
//		UserDetails user = User
//				.withUsername("admin") 
//				.password(crypt)
//				.authorities("ADMIN")
//				.build();
//		
//		UserDetails user2 = User
//				.withUsername("student") 
//				.password(crypt)
//				.authorities("STUDENT")
//				.build();		
//		
//		return new InMemoryUserDetailsManager(user, user2); 
//		
//	}
	
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		return http
				.authorizeHttpRequests((auth)->{
					auth.requestMatchers("/").permitAll();
					auth.requestMatchers("/contact").permitAll();
					auth.requestMatchers("/home").permitAll();
					auth.requestMatchers("/admin/create-course").hasAnyAuthority("ADMIN","INSTRUCTOR");					
					auth.requestMatchers("/admin/**").hasAuthority("ADMIN");
					auth.requestMatchers("/student/**").hasAuthority("STUDENT");
					auth.requestMatchers("/instructor/**").hasAuthority("INSTRUCTOR");
					auth.requestMatchers("/course-management").hasAnyAuthority("ADMIN","INSTRUCTOR");
										
					auth.anyRequest().authenticated();
					
				})
				
				.formLogin(Customizer.withDefaults())
				.exceptionHandling().accessDeniedPage("/403").and()
				.build();                  
    }
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
}
